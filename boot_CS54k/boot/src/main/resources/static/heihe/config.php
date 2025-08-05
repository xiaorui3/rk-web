<?php
// config.php - 数据库配置
define('DB_HOST', '117.72.119.212:3306');
define('DB_USER', 'rk');
define('DB_PASS', 'rk');
define('DB_NAME', 'vote_system');

// 连接数据库
function getDBConnection() {
    $conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }
    $conn->set_charset("utf8mb4");
    return $conn;
}

// 获取客户端真实IP
function getClientIP() {
    if (!empty($_SERVER['HTTP_CLIENT_IP'])) {
        return $_SERVER['HTTP_CLIENT_IP'];
    } elseif (!empty($_SERVER['HTTP_X_FORWARDED_FOR'])) {
        return $_SERVER['HTTP_X_FORWARDED_FOR'];
    } else {
        return $_SERVER['REMOTE_ADDR'];
    }
}

// API响应格式
function jsonResponse($success, $data = null, $message = '') {
    header('Content-Type: application/json');
    echo json_encode([
        'success' => $success,
        'data' => $data,
        'message' => $message
    ]);
    exit;
}

// 获取当前活跃的投票主题
if ($_SERVER['REQUEST_METHOD'] === 'GET' && isset($_GET['action']) && $_GET['action'] === 'get_active_topics') {
    $conn = getDBConnection();
    $current_time = date('Y-m-d H:i:s');

    $sql = "SELECT * FROM vote_topics
            WHERE start_time <= ? AND end_time >= ? AND is_active = TRUE
            ORDER BY start_time DESC";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("ss", $current_time, $current_time);
    $stmt->execute();
    $result = $stmt->get_result();

    $topics = [];
    while ($row = $result->fetch_assoc()) {
        $topics[] = $row;
    }

    // 获取每个主题的选项
    foreach ($topics as &$topic) {
        $sql = "SELECT * FROM vote_options WHERE topic_id = ?";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("i", $topic['id']);
        $stmt->execute();
        $result = $stmt->get_result();

        $options = [];
        while ($row = $result->fetch_assoc()) {
            $options[] = $row;
        }
        $topic['options'] = $options;

        // 获取统计信息
        $sql = "SELECT view_count, vote_count FROM vote_stats WHERE topic_id = ?";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("i", $topic['id']);
        $stmt->execute();
        $result = $stmt->get_result();
        $stats = $result->fetch_assoc();
        $topic['stats'] = $stats ?: ['view_count' => 0, 'vote_count' => 0];
    }

    $conn->close();
    jsonResponse(true, $topics);
}

// 提交投票
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['action']) && $_POST['action'] === 'submit_vote') {
    $conn = getDBConnection();

    $topic_id = intval($_POST['topic_id']);
    $option_id = intval($_POST['option_id']);
    $user_ip = getClientIP();
    $user_agent = $_SERVER['HTTP_USER_AGENT'];

    // 验证投票主题和选项
    $sql = "SELECT id, max_choices FROM vote_topics
            WHERE id = ? AND is_active = TRUE
            AND start_time <= NOW() AND end_time >= NOW()";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("i", $topic_id);
    $stmt->execute();
    $result = $stmt->get_result();
    $topic = $result->fetch_assoc();

    if (!$topic) {
        jsonResponse(false, null, '投票主题不存在或已结束');
    }

    $sql = "SELECT id FROM vote_options WHERE id = ? AND topic_id = ?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("ii", $option_id, $topic_id);
    $stmt->execute();
    $result = $stmt->get_result();
    $option = $result->fetch_assoc();

    if (!$option) {
        jsonResponse(false, null, '无效的投票选项');
    }

    // 检查是否已经投票
    $sql = "SELECT COUNT(*) as count FROM vote_records
            WHERE topic_id = ? AND user_ip = ?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("is", $topic_id, $user_ip);
    $stmt->execute();
    $result = $stmt->get_result();
    $count = $result->fetch_assoc()['count'];

    if ($count >= $topic['max_choices']) {
        jsonResponse(false, null, '您已经投过票了');
    }

    // 记录投票
    $sql = "INSERT INTO vote_records (topic_id, option_id, user_ip, user_agent)
            VALUES (?, ?, ?, ?)";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("iiss", $topic_id, $option_id, $user_ip, $user_agent);

    if ($stmt->execute()) {
        // 更新统计
        $sql = "INSERT INTO vote_stats (topic_id, vote_count)
                VALUES (?, 1)
                ON DUPLICATE KEY UPDATE vote_count = vote_count + 1";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("i", $topic_id);
        $stmt->execute();

        jsonResponse(true, null, '投票成功');
    } else {
        jsonResponse(false, null, '投票失败');
    }

    $conn->close();
}

// 获取投票结果
if ($_SERVER['REQUEST_METHOD'] === 'GET' && isset($_GET['action']) && $_GET['action'] === 'get_results') {
    $conn = getDBConnection();
    $topic_id = intval($_GET['topic_id']);

    $sql = "SELECT vo.id, vo.option_text, vo.image_url, COUNT(vr.id) as vote_count
            FROM vote_options vo
            LEFT JOIN vote_records vr ON vo.id = vr.option_id
            WHERE vo.topic_id = ?
            GROUP BY vo.id
            ORDER BY vote_count DESC";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("i", $topic_id);
    $stmt->execute();
    $result = $stmt->get_result();

    $options = [];
    while ($row = $result->fetch_assoc()) {
        $options[] = $row;
    }

    // 获取总票数
    $total_votes = 0;
    foreach ($options as $option) {
        $total_votes += $option['vote_count'];
    }

    // 计算百分比
    foreach ($options as &$option) {
        $option['percentage'] = $total_votes > 0 ? round(($option['vote_count'] / $total_votes) * 100, 2) : 0;
    }

    // 获取主题信息
    $sql = "SELECT title, description FROM vote_topics WHERE id = ?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("i", $topic_id);
    $stmt->execute();
    $result = $stmt->get_result();
    $topic = $result->fetch_assoc();

    $conn->close();

    jsonResponse(true, [
        'topic' => $topic,
        'options' => $options,
        'total_votes' => $total_votes
    ]);
}

// 记录访问量
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['action']) && $_POST['action'] === 'record_view') {
    $conn = getDBConnection();
    $topic_id = intval($_POST['topic_id']);

    $sql = "INSERT INTO vote_stats (topic_id, view_count)
            VALUES (?, 1)
            ON DUPLICATE KEY UPDATE view_count = view_count + 1";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("i", $topic_id);

    if ($stmt->execute()) {
        jsonResponse(true);
    } else {
        jsonResponse(false);
    }

    $conn->close();
}
?><?php
  // config.php - 数据库配置
  define('DB_HOST', '117.72.119.212:3306');
  define('DB_USER', 'rk');
  define('DB_PASS', 'rk');
  define('DB_NAME', 'vote_system');

  // 连接数据库
  function getDBConnection() {
      $conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
      if ($conn->connect_error) {
          die("Connection failed: " . $conn->connect_error);
      }
      $conn->set_charset("utf8mb4");
      return $conn;
  }

  // 获取客户端真实IP
  function getClientIP() {
      if (!empty($_SERVER['HTTP_CLIENT_IP'])) {
          return $_SERVER['HTTP_CLIENT_IP'];
      } elseif (!empty($_SERVER['HTTP_X_FORWARDED_FOR'])) {
          return $_SERVER['HTTP_X_FORWARDED_FOR'];
      } else {
          return $_SERVER['REMOTE_ADDR'];
      }
  }

  // API响应格式
  function jsonResponse($success, $data = null, $message = '') {
      header('Content-Type: application/json');
      echo json_encode([
          'success' => $success,
          'data' => $data,
          'message' => $message
      ]);
      exit;
  }

  // 获取当前活跃的投票主题
  if ($_SERVER['REQUEST_METHOD'] === 'GET' && isset($_GET['action']) && $_GET['action'] === 'get_active_topics') {
      $conn = getDBConnection();
      $current_time = date('Y-m-d H:i:s');

      $sql = "SELECT * FROM vote_topics
              WHERE start_time <= ? AND end_time >= ? AND is_active = TRUE
              ORDER BY start_time DESC";
      $stmt = $conn->prepare($sql);
      $stmt->bind_param("ss", $current_time, $current_time);
      $stmt->execute();
      $result = $stmt->get_result();

      $topics = [];
      while ($row = $result->fetch_assoc()) {
          $topics[] = $row;
      }

      // 获取每个主题的选项
      foreach ($topics as &$topic) {
          $sql = "SELECT * FROM vote_options WHERE topic_id = ?";
          $stmt = $conn->prepare($sql);
          $stmt->bind_param("i", $topic['id']);
          $stmt->execute();
          $result = $stmt->get_result();

          $options = [];
          while ($row = $result->fetch_assoc()) {
              $options[] = $row;
          }
          $topic['options'] = $options;

          // 获取统计信息
          $sql = "SELECT view_count, vote_count FROM vote_stats WHERE topic_id = ?";
          $stmt = $conn->prepare($sql);
          $stmt->bind_param("i", $topic['id']);
          $stmt->execute();
          $result = $stmt->get_result();
          $stats = $result->fetch_assoc();
          $topic['stats'] = $stats ?: ['view_count' => 0, 'vote_count' => 0];
      }

      $conn->close();
      jsonResponse(true, $topics);
  }

  // 提交投票
  if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['action']) && $_POST['action'] === 'submit_vote') {
      $conn = getDBConnection();

      $topic_id = intval($_POST['topic_id']);
      $option_id = intval($_POST['option_id']);
      $user_ip = getClientIP();
      $user_agent = $_SERVER['HTTP_USER_AGENT'];

      // 验证投票主题和选项
      $sql = "SELECT id, max_choices FROM vote_topics
              WHERE id = ? AND is_active = TRUE
              AND start_time <= NOW() AND end_time >= NOW()";
      $stmt = $conn->prepare($sql);
      $stmt->bind_param("i", $topic_id);
      $stmt->execute();
      $result = $stmt->get_result();
      $topic = $result->fetch_assoc();

      if (!$topic) {
          jsonResponse(false, null, '投票主题不存在或已结束');
      }

      $sql = "SELECT id FROM vote_options WHERE id = ? AND topic_id = ?";
      $stmt = $conn->prepare($sql);
      $stmt->bind_param("ii", $option_id, $topic_id);
      $stmt->execute();
      $result = $stmt->get_result();
      $option = $result->fetch_assoc();

      if (!$option) {
          jsonResponse(false, null, '无效的投票选项');
      }

      // 检查是否已经投票
      $sql = "SELECT COUNT(*) as count FROM vote_records
              WHERE topic_id = ? AND user_ip = ?";
      $stmt = $conn->prepare($sql);
      $stmt->bind_param("is", $topic_id, $user_ip);
      $stmt->execute();
      $result = $stmt->get_result();
      $count = $result->fetch_assoc()['count'];

      if ($count >= $topic['max_choices']) {
          jsonResponse(false, null, '您已经投过票了');
      }

      // 记录投票
      $sql = "INSERT INTO vote_records (topic_id, option_id, user_ip, user_agent)
              VALUES (?, ?, ?, ?)";
      $stmt = $conn->prepare($sql);
      $stmt->bind_param("iiss", $topic_id, $option_id, $user_ip, $user_agent);

      if ($stmt->execute()) {
          // 更新统计
          $sql = "INSERT INTO vote_stats (topic_id, vote_count)
                  VALUES (?, 1)
                  ON DUPLICATE KEY UPDATE vote_count = vote_count + 1";
          $stmt = $conn->prepare($sql);
          $stmt->bind_param("i", $topic_id);
          $stmt->execute();

          jsonResponse(true, null, '投票成功');
      } else {
          jsonResponse(false, null, '投票失败');
      }

      $conn->close();
  }

  // 获取投票结果
  if ($_SERVER['REQUEST_METHOD'] === 'GET' && isset($_GET['action']) && $_GET['action'] === 'get_results') {
      $conn = getDBConnection();
      $topic_id = intval($_GET['topic_id']);

      $sql = "SELECT vo.id, vo.option_text, vo.image_url, COUNT(vr.id) as vote_count
              FROM vote_options vo
              LEFT JOIN vote_records vr ON vo.id = vr.option_id
              WHERE vo.topic_id = ?
              GROUP BY vo.id
              ORDER BY vote_count DESC";
      $stmt = $conn->prepare($sql);
      $stmt->bind_param("i", $topic_id);
      $stmt->execute();
      $result = $stmt->get_result();

      $options = [];
      while ($row = $result->fetch_assoc()) {
          $options[] = $row;
      }

      // 获取总票数
      $total_votes = 0;
      foreach ($options as $option) {
          $total_votes += $option['vote_count'];
      }

      // 计算百分比
      foreach ($options as &$option) {
          $option['percentage'] = $total_votes > 0 ? round(($option['vote_count'] / $total_votes) * 100, 2) : 0;
      }

      // 获取主题信息
      $sql = "SELECT title, description FROM vote_topics WHERE id = ?";
      $stmt = $conn->prepare($sql);
      $stmt->bind_param("i", $topic_id);
      $stmt->execute();
      $result = $stmt->get_result();
      $topic = $result->fetch_assoc();

      $conn->close();

      jsonResponse(true, [
          'topic' => $topic,
          'options' => $options,
          'total_votes' => $total_votes
      ]);
  }

  // 记录访问量
  if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['action']) && $_POST['action'] === 'record_view') {
      $conn = getDBConnection();
      $topic_id = intval($_POST['topic_id']);

      $sql = "INSERT INTO vote_stats (topic_id, view_count)
              VALUES (?, 1)
              ON DUPLICATE KEY UPDATE view_count = view_count + 1";
      $stmt = $conn->prepare($sql);
      $stmt->bind_param("i", $topic_id);

      if ($stmt->execute()) {
          jsonResponse(true);
      } else {
          jsonResponse(false);
      }

      $conn->close();
  }
  ?>