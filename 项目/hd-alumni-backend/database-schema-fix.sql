USE hd;

-- 修复管理员用户插入错误，明确提供created_at和updated_at字段的值
INSERT INTO users (name, phone, email, password, student_id, graduation_year, major, role, email_verified, phone_verified, created_at, updated_at) 
VALUES ('系统管理员', '13039811650', 'admin@hd.edu.cn', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iKXYLFSaZWOvPqHJxsIBDoyxop5K', 'ADMIN001', 2020, '系统管理', 'ADMIN', TRUE, TRUE, NOW(), NOW())
ON DUPLICATE KEY UPDATE name=name;

-- 修复系统配置表插入错误，明确提供created_at和updated_at字段的值
INSERT INTO system_config (config_key, config_value, description, created_at, updated_at) VALUES
    ('system.name', '哈尔滨华德学院校友会进校园申请系统', '系统名称', NOW(), NOW()),
    ('system.version', '1.0.0', '系统版本', NOW(), NOW()),
    ('file.upload.max.size', '5242880', '文件上传最大大小（5MB）', NOW(), NOW()),
    ('file.upload.allowed.types', 'jpg,jpeg,png,pdf', '允许上传的文件类型', NOW(), NOW())
    ON DUPLICATE KEY UPDATE config_value=VALUES(config_value);