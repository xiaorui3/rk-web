-- 黑河学院校友会进校园申请系统数据库设计
-- 数据库：hd
create database hd;
USE hd;

-- 1. 用户表 (users)
CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
    name VARCHAR(50) NOT NULL COMMENT '真实姓名',
    phone VARCHAR(20) UNIQUE NOT NULL COMMENT '手机号',
    email VARCHAR(100) UNIQUE NOT NULL COMMENT '邮箱地址',
    password VARCHAR(255) NOT NULL COMMENT '密码（加密）',
    student_id VARCHAR(20) UNIQUE NOT NULL COMMENT '学号',
    graduation_year INT NOT NULL COMMENT '毕业年份',
    major VARCHAR(100) NOT NULL COMMENT '专业',
    current_job VARCHAR(100) COMMENT '当前职业',
    company VARCHAR(200) COMMENT '工作单位',
    address VARCHAR(500) COMMENT '现居地址',
    bio TEXT COMMENT '个人简介',
    avatar_url VARCHAR(500) COMMENT '头像URL',
    role ENUM('USER', 'ADMIN') DEFAULT 'USER' COMMENT '用户角色',
    status ENUM('ACTIVE', 'INACTIVE', 'BANNED') DEFAULT 'ACTIVE' COMMENT '账户状态',
    email_verified BOOLEAN DEFAULT FALSE COMMENT '邮箱是否验证',
    phone_verified BOOLEAN DEFAULT FALSE COMMENT '手机是否验证',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

-- 2. 申请表 (applications)
CREATE TABLE IF NOT EXISTS applications (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '申请ID',
    user_id BIGINT NOT NULL COMMENT '申请人ID',
    purpose VARCHAR(100) NOT NULL COMMENT '访问目的',
    visit_date DATE NOT NULL COMMENT '访问日期',
    visit_time TIME NOT NULL COMMENT '访问时间',
    duration VARCHAR(50) NOT NULL COMMENT '预计停留时长',
    location VARCHAR(200) NOT NULL COMMENT '主要访问地点',
    contact_person VARCHAR(50) COMMENT '校内联系人',
    contact_phone VARCHAR(20) COMMENT '联系人电话',
    description TEXT COMMENT '详细说明',
    emergency_contact VARCHAR(50) NOT NULL COMMENT '紧急联系人',
    emergency_phone VARCHAR(20) NOT NULL COMMENT '紧急联系电话',
    status ENUM('PENDING', 'APPROVED', 'REJECTED', 'CANCELLED') DEFAULT 'PENDING' COMMENT '申请状态',
    submit_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
    review_date TIMESTAMP NULL COMMENT '审核时间',
    reviewer_id BIGINT NULL COMMENT '审核人ID',
    feedback TEXT COMMENT '审核意见',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (reviewer_id) REFERENCES users(id) ON DELETE SET NULL,
    INDEX idx_user_id (user_id),
    INDEX idx_status (status),
    INDEX idx_visit_date (visit_date)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='申请表';

-- 3. 申请文件表 (application_files)
CREATE TABLE IF NOT EXISTS application_files (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '文件ID',
    application_id BIGINT NOT NULL COMMENT '申请ID',
    file_name VARCHAR(255) NOT NULL COMMENT '文件名',
    file_path VARCHAR(500) NOT NULL COMMENT '文件路径',
    file_size BIGINT NOT NULL COMMENT '文件大小（字节）',
    file_type VARCHAR(50) NOT NULL COMMENT '文件类型',
    upload_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
    FOREIGN KEY (application_id) REFERENCES applications(id) ON DELETE CASCADE,
    INDEX idx_application_id (application_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='申请文件表';

-- 4. 系统通知表 (notifications)
CREATE TABLE IF NOT EXISTS notifications (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '通知ID',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    title VARCHAR(200) NOT NULL COMMENT '通知标题',
    content TEXT NOT NULL COMMENT '通知内容',
    type ENUM('SYSTEM', 'APPLICATION', 'REVIEW') DEFAULT 'SYSTEM' COMMENT '通知类型',
    is_read BOOLEAN DEFAULT FALSE COMMENT '是否已读',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    INDEX idx_user_id (user_id),
    INDEX idx_is_read (is_read)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统通知表';

-- 5. 系统配置表 (system_config)
CREATE TABLE IF NOT EXISTS system_config (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '配置ID',
    config_key VARCHAR(100) UNIQUE NOT NULL COMMENT '配置键',
    config_value TEXT NOT NULL COMMENT '配置值',
    description VARCHAR(500) COMMENT '配置描述',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统配置表';

-- 修复管理员用户插入语句
INSERT INTO users (name, phone, email, password, student_id, graduation_year, major, role, email_verified, phone_verified, created_at, updated_at)
VALUES ('系统管理员', '13039811650', 'admin@hd.edu.cn', '$2a$10$xBLsawbY/2OMc90SQ/U7ruVkb6Cw5QZwi2YdNwbZiaFhzXqrZ2WB.', 'ADMIN001', 2020, '系统管理', 'ADMIN', TRUE, TRUE, NOW(), NOW())
ON DUPLICATE KEY UPDATE name=name;

-- 修复系统配置表插入错误，明确提供created_at和updated_at字段的值
INSERT INTO system_config (config_key, config_value, description, created_at, updated_at) VALUES
     ('system.name', '黑河学院校友会进校园申请系统', '系统名称', NOW(), NOW()),
     ('system.version', '1.0.0', '系统版本', NOW(), NOW()),
     ('file.upload.max.size', '5242880', '文件上传最大大小（5MB）', NOW(), NOW()),
     ('file.upload.allowed.types', 'jpg,jpeg,png,pdf', '允许上传的文件类型', NOW(), NOW())
ON DUPLICATE KEY UPDATE config_value=VALUES(config_value);