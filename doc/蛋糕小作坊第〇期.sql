-- 上传记录表
DROP TABLE IF EXISTS `attendance_upload_record`;
CREATE TABLE `attendance_upload_record` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `clz_name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名',
    `ip` varchar(32) NOT NULL DEFAULT '' COMMENT '请求ip',
    `success` TINYINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否成功',
    `upload_time` TIMESTAMP NOT NULL DEFAULT 0 COMMENT '上传时间',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '请求时间',
    PRIMARY KEY ( `id` )
) ENGINE = MYISAM AUTO_INCREMENT=1000000001 DEFAULT CHARSET = utf8mb4 COMMENT = '上传记录表';