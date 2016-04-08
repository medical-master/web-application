-- MySQL Script generated by MySQL Workbench
-- 04/08/16 17:39:00
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema medical_master
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `medical_master` ;

-- -----------------------------------------------------
-- Schema medical_master
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `medical_master` DEFAULT CHARACTER SET utf8 ;
USE `medical_master` ;

-- -----------------------------------------------------
-- Table `medical_master`.`sys_resource`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`sys_resource` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`sys_resource` (
  `id` INT(11) NOT NULL COMMENT '递增ID',
  `resourceType` INT(11) NOT NULL COMMENT '文件类型',
  `resourceName` VARCHAR(255) CHARACTER SET 'utf8' NOT NULL COMMENT '文件名',
  `desc` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '描述',
  `fileUrl` VARCHAR(255) CHARACTER SET 'utf8' NOT NULL COMMENT '文件地址',
  `status` INT(11) NULL DEFAULT NULL COMMENT '状态',
  `allowDownload` TINYINT(4) NULL DEFAULT NULL COMMENT '是否允许下载，默认不可以',
  `downloadCnt` INT(11) NULL DEFAULT NULL COMMENT '下载次数',
  `createTime` DATETIME NULL DEFAULT NULL COMMENT '创建日期',
  `createUser` INT(11) NULL DEFAULT NULL COMMENT '创建人',
  `lastUpdateTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `lastUpdateUser` INT(11) NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '上传文件'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `medical_master`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`user` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`user` (
  `userId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` VARCHAR(128) CHARACTER SET 'utf8' NOT NULL COMMENT '登录用户名',
  `nickName` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '昵称',
  `sex` TINYINT(1) NULL DEFAULT NULL COMMENT '性别',
  `iconResourceId` INT(11) NULL DEFAULT NULL COMMENT '头像图片文件Id',
  `mobilePhoneNumber` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '手机号码',
  `email` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '邮箱',
  `authentication` VARCHAR(128) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '密码',
  `type` INT(11) NULL DEFAULT NULL COMMENT '类型',
  `educationLevel` INT(11) NULL DEFAULT NULL COMMENT '学历',
  `identityNumber` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '身份证号',
  `status` INT(11) NULL DEFAULT NULL COMMENT '状态',
  `hosptialId` INT(11) NULL DEFAULT NULL COMMENT '所属医院',
  `department` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '部门/科室',
  `professionalRank` INT(11) NULL DEFAULT NULL COMMENT '职务',
  `title` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '职称',
  `doctorNumber` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '执业医师资格证',
  `createTime` DATETIME NULL DEFAULT NULL,
  `lastUpdateTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`),
  INDEX `user_name` USING BTREE (`name` ASC),
  INDEX `phone_number` USING BTREE (`mobilePhoneNumber` ASC),
  INDEX `doctor_number` USING BTREE (`doctorNumber` ASC),
  INDEX `hospital` USING BTREE (`hosptialId` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '用户'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `medical_master`.`expert`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`expert` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`expert` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userId` INT(11) NOT NULL COMMENT '用户Id',
  `expertType` INT(11) NOT NULL COMMENT '专家资源类型-个人、协会',
  `inviteCode` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '邀请码',
  `expertArea` VARCHAR(1200) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '专家领域',
  `summaryHtml` INT(11) NULL DEFAULT NULL COMMENT '简介页面',
  `academicHtml` INT(11) NULL DEFAULT NULL COMMENT '学术研究页面',
  `honorHtml` INT(11) NULL DEFAULT NULL COMMENT '成就荣誉',
  PRIMARY KEY (`id`),
  INDEX `fk_yds_expert_01` USING BTREE (`userId` ASC),
  INDEX `fk_yds_expert_02` USING BTREE (`summaryHtml` ASC),
  INDEX `fk_yds_expert_03` USING BTREE (`academicHtml` ASC),
  INDEX `fk_yds_expert_04` USING BTREE (`honorHtml` ASC),
  CONSTRAINT `expert_ibfk_1`
    FOREIGN KEY (`userId`)
    REFERENCES `medical_master`.`user` (`userId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `expert_ibfk_2`
    FOREIGN KEY (`summaryHtml`)
    REFERENCES `medical_master`.`sys_resource` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `expert_ibfk_3`
    FOREIGN KEY (`academicHtml`)
    REFERENCES `medical_master`.`sys_resource` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `expert_ibfk_4`
    FOREIGN KEY (`honorHtml`)
    REFERENCES `medical_master`.`sys_resource` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '专家资源表'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `medical_master`.`workstation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`workstation` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`workstation` (
  `workstationId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '递增主键',
  `expertId` INT(11) NOT NULL COMMENT '专家资源Id',
  `name` VARCHAR(128) CHARACTER SET 'utf8' NOT NULL COMMENT '名称',
  `subLink` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '子链接域名',
  `description` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '介绍',
  `domains` VARCHAR(512) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '擅长领域',
  `keywords` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '关键字',
  `illCode` INT(11) NULL DEFAULT NULL COMMENT '疾病代码',
  `members` INT(11) NULL DEFAULT NULL COMMENT '成员总数',
  `attends` INT(11) NULL DEFAULT NULL COMMENT '关注总数',
  `status` INT(11) NULL DEFAULT NULL COMMENT '状态',
  `rank` INT(11) NULL DEFAULT '0' COMMENT '排名，用于是否显示在首页',
  `createTime` DATETIME NULL DEFAULT NULL COMMENT '创建日期',
  `createUser` INT(11) NULL DEFAULT NULL COMMENT '创建人',
  `activateTime` DATETIME NULL DEFAULT NULL COMMENT '激活日期',
  `publishTime` DATETIME NULL DEFAULT NULL COMMENT '发布日期',
  `lastUpdateTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `lastUpdateUser` INT(11) NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`workstationId`),
  INDEX `keywords` USING BTREE (`keywords` ASC),
  INDEX `name` USING BTREE (`name` ASC),
  INDEX `user` USING BTREE (`expertId` ASC),
  CONSTRAINT `workstation_ibfk_1`
    FOREIGN KEY (`expertId`)
    REFERENCES `medical_master`.`expert` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '工作站'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `medical_master`.`clinical_research`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`clinical_research` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`clinical_research` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `workstationId` INT(11) NOT NULL COMMENT '工作站id',
  `title` VARCHAR(128) CHARACTER SET 'utf8' NOT NULL COMMENT '标题',
  `description` VARCHAR(1024) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '内容描述',
  `resourceId` INT(11) NULL DEFAULT NULL COMMENT '材料文件Id',
  `viewStatus` TINYINT(4) NULL DEFAULT NULL COMMENT '是否显示在首页',
  `currentStatus` INT(11) NULL DEFAULT NULL COMMENT '当前状态',
  `publishTime` DATETIME NULL DEFAULT NULL COMMENT '发布日期',
  `createTime` DATETIME NULL DEFAULT NULL COMMENT '创建日期',
  `createUser` INT(11) NULL DEFAULT NULL COMMENT '创建人',
  `lastUpdateTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `lastUpdateUser` INT(11) NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  INDEX `title` USING BTREE (`title` ASC),
  INDEX `fk_clinical_research_workstationid` USING BTREE (`workstationId` ASC),
  INDEX `fk_clinical_research_resourceId` USING BTREE (`resourceId` ASC),
  CONSTRAINT `clinical_research_ibfk_1`
    FOREIGN KEY (`resourceId`)
    REFERENCES `medical_master`.`sys_resource` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `clinical_research_ibfk_2`
    FOREIGN KEY (`workstationId`)
    REFERENCES `medical_master`.`workstation` (`workstationId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '临床研究'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `medical_master`.`clinical_research_stage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`clinical_research_stage` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`clinical_research_stage` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `clinicalResearchId` INT(11) NOT NULL,
  `title` VARCHAR(128) CHARACTER SET 'utf8' NOT NULL COMMENT '标题',
  `description` VARCHAR(1024) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '内容描述',
  `resourceId` INT(11) NULL DEFAULT NULL COMMENT '材料文件Id',
  `viewStatus` TINYINT(4) NULL DEFAULT NULL COMMENT '是否显示在首页',
  `status` INT(11) NULL DEFAULT NULL COMMENT '状态',
  `publishTime` DATETIME NULL DEFAULT NULL COMMENT '发布日期',
  `createTime` DATETIME NULL DEFAULT NULL COMMENT '创建日期',
  `createUser` INT(11) NULL DEFAULT NULL COMMENT '创建人',
  `lastUpdateTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `lastUpdateUser` INT(11) NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  INDEX `fk_clinical_research_stage_01` USING BTREE (`clinicalResearchId` ASC),
  INDEX `fk_clinical_research_stage_02` USING BTREE (`resourceId` ASC),
  CONSTRAINT `clinical_research_stage_ibfk_1`
    FOREIGN KEY (`clinicalResearchId`)
    REFERENCES `medical_master`.`clinical_research` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `clinical_research_stage_ibfk_2`
    FOREIGN KEY (`resourceId`)
    REFERENCES `medical_master`.`sys_resource` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '临床研究阶段'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `medical_master`.`comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`comment` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`comment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` VARCHAR(60) CHARACTER SET 'utf8' NOT NULL COMMENT '标题',
  `comment` VARCHAR(600) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '留言内容',
  `commentUser` INT(11) NULL DEFAULT NULL COMMENT '留言用户',
  `commentTime` DATETIME NULL DEFAULT NULL COMMENT '留言日期',
  `phone` VARCHAR(100) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '联系电话',
  `email` VARCHAR(100) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '联系邮箱',
  `feedback` VARCHAR(600) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '回复内容',
  `feedbackUser` INT(11) NULL DEFAULT NULL COMMENT '回复人',
  `feedbackTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '回复日期',
  `status` INT(11) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  INDEX `user` USING BTREE (`commentUser` ASC),
  INDEX `name` USING BTREE (`title` ASC),
  INDEX `fk_eds_comment_02` USING BTREE (`feedbackUser` ASC),
  CONSTRAINT `comment_ibfk_1`
    FOREIGN KEY (`commentUser`)
    REFERENCES `medical_master`.`user` (`userId`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_2`
    FOREIGN KEY (`feedbackUser`)
    REFERENCES `medical_master`.`user` (`userId`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '留言反馈'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `medical_master`.`diagnostic_plan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`diagnostic_plan` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`diagnostic_plan` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `workstationId` INT(11) NOT NULL COMMENT '所属工作站',
  `title` VARCHAR(128) CHARACTER SET 'utf8' NOT NULL COMMENT '标题',
  `category` INT(11) NULL DEFAULT NULL COMMENT '分类',
  `brief` VARCHAR(600) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '摘要',
  `resourceId` INT(11) NULL DEFAULT NULL COMMENT '内容文件',
  `visitCnt` INT(11) NULL DEFAULT NULL COMMENT '访问次数',
  `publishStatus` INT(11) NULL DEFAULT NULL COMMENT '发布状态',
  `publishTime` DATETIME NULL DEFAULT NULL COMMENT '发布日期',
  `createTime` DATETIME NULL DEFAULT NULL COMMENT '创建日期',
  `createUser` INT(11) NULL DEFAULT NULL COMMENT '创建人',
  `lastUpdateTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `lastUpdateUser` INT(11) NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  INDEX `name` USING BTREE (`title` ASC),
  INDEX `fk_eds_diagnostic_plan_01` USING BTREE (`workstationId` ASC),
  INDEX `fk_eds_diagnostic_plan_02` USING BTREE (`resourceId` ASC),
  CONSTRAINT `diagnostic_plan_ibfk_1`
    FOREIGN KEY (`workstationId`)
    REFERENCES `medical_master`.`workstation` (`workstationId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `diagnostic_plan_ibfk_2`
    FOREIGN KEY (`resourceId`)
    REFERENCES `medical_master`.`sys_resource` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '诊疗方案'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `medical_master`.`notice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`notice` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`notice` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '标题',
  `content` VARCHAR(1200) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '内容',
  `publishStatus` INT(11) NULL DEFAULT NULL COMMENT '发布状态（29）',
  `createTime` DATETIME NULL DEFAULT NULL COMMENT '创建日期',
  `createUser` INT(11) NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '事件告知'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `medical_master`.`search_statics`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`search_statics` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`search_statics` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `keyWord` VARCHAR(255) CHARACTER SET 'utf8' NOT NULL COMMENT '关键字',
  `searchCnt` INT(11) NULL DEFAULT '0' COMMENT '搜索次数',
  PRIMARY KEY (`id`),
  INDEX `idx_search_statics_01` (`keyWord` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '搜索统计'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `medical_master`.`sys_hospital`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`sys_hospital` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`sys_hospital` (
  `hospitalId` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(256) CHARACTER SET 'utf8' NOT NULL COMMENT '名称',
  `level` INT(11) NULL DEFAULT NULL COMMENT '等级',
  `proviceId` INT(11) NULL DEFAULT NULL COMMENT '省',
  `cityId` INT(11) NULL DEFAULT NULL COMMENT '市',
  `districtId` INT(11) NULL DEFAULT NULL COMMENT '区',
  `address` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '具体地址',
  PRIMARY KEY (`hospitalId`),
  INDEX `name` USING BTREE (`name` ASC),
  INDEX `address` USING BTREE (`address` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '医院'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `medical_master`.`sys_operation_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`sys_operation_log` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`sys_operation_log` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '递增ID',
  `logType` INT(11) NOT NULL COMMENT '日志类型',
  `operator` INT(11) NOT NULL COMMENT '操作人',
  `visitor` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '访问者',
  `target` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '目标对象',
  `result` INT(11) NULL DEFAULT NULL COMMENT '结果',
  `operatorTime` DATETIME NULL DEFAULT NULL COMMENT '操作日期',
  `clientIp` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '客户端IP',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '操作日志'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `medical_master`.`sys_property_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`sys_property_category` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`sys_property_category` (
  `categoryId` INT(11) NOT NULL COMMENT '数据字典分类代码',
  `name` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL COMMENT '名称',
  `description` VARCHAR(128) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`categoryId`),
  INDEX `idx_sys_property_category_01` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '系统属性分类'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `medical_master`.`sys_property`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`sys_property` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`sys_property` (
  `categoryId` INT(11) NOT NULL COMMENT '数据字典分类代码ID',
  `propertyId` INT(11) NOT NULL COMMENT '数据字典代码ID',
  `name` VARCHAR(128) CHARACTER SET 'utf8' NOT NULL COMMENT '名称',
  `description` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '描述',
  `alias` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '别名',
  `parentId` INT(11) NULL DEFAULT NULL COMMENT '上级数据字典代码ID',
  `extend` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '扩展字段',
  `sortNo` INT(11) NULL DEFAULT NULL COMMENT '排序',
  `createTime` DATETIME NULL DEFAULT NULL,
  `lastUpdateTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`propertyId`, `categoryId`),
  INDEX `idx_sys_property_01` (`categoryId` ASC, `propertyId` ASC),
  INDEX `idx_sys_property_02` (`name` ASC),
  CONSTRAINT `fk_sys_property_01`
    FOREIGN KEY (`categoryId`)
    REFERENCES `medical_master`.`sys_property_category` (`categoryId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '系统属性'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `medical_master`.`sys_resource_relate`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`sys_resource_relate` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`sys_resource_relate` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `relateType` INT(11) NOT NULL COMMENT '关联类型',
  `relateId` INT(11) NOT NULL COMMENT '关联ID',
  `resourceId` INT(11) NOT NULL COMMENT '文件Id',
  `status` INT(11) NOT NULL COMMENT '状态',
  `createTime` DATETIME NULL DEFAULT NULL COMMENT '创建日期',
  `createUser` INT(11) NULL DEFAULT NULL COMMENT '创建人',
  `lastUpdateTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `lastUpdateUser` INT(11) NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  INDEX `fk_sys_resource_relate_01` (`resourceId` ASC),
  CONSTRAINT `fk_sys_resource_relate_01`
    FOREIGN KEY (`resourceId`)
    REFERENCES `medical_master`.`sys_resource` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '文件关联\r\n譬如用户与工作照、证件照等上传文件的关联'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `medical_master`.`train_material`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`train_material` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`train_material` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(256) CHARACTER SET 'utf8' NOT NULL COMMENT '标题',
  `workstationId` INT(11) NULL DEFAULT NULL COMMENT '工作站id',
  `description` VARCHAR(1024) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '内容描述',
  `materialFile` INT(11) NULL DEFAULT NULL COMMENT '资料文件',
  `publishTime` DATETIME NULL DEFAULT NULL COMMENT '发布日期',
  `visitCnt` INT(11) NULL DEFAULT NULL COMMENT '访问次数',
  `publishStatus` INT(11) NULL DEFAULT NULL COMMENT '发布状态（29）',
  `createTime` DATETIME NULL DEFAULT NULL COMMENT '创建日期',
  `createUser` INT(11) NULL DEFAULT NULL COMMENT '创建人',
  `lastUpdateTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `lastUpdateUser` INT(11) NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  INDEX `title` USING BTREE (`title` ASC),
  INDEX `fk_eds_train_material_01` USING BTREE (`workstationId` ASC),
  INDEX `fk_eds_train_material_02` USING BTREE (`materialFile` ASC),
  CONSTRAINT `train_material_ibfk_1`
    FOREIGN KEY (`workstationId`)
    REFERENCES `medical_master`.`workstation` (`workstationId`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `train_material_ibfk_2`
    FOREIGN KEY (`materialFile`)
    REFERENCES `medical_master`.`sys_resource` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '培训资料'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `medical_master`.`train_meeting`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`train_meeting` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`train_meeting` (
  `id` INT(11) NOT NULL,
  `title` VARCHAR(255) CHARACTER SET 'utf8' NOT NULL COMMENT '标题',
  `workstationId` INT(11) NULL DEFAULT NULL COMMENT '工作站id',
  `content` VARCHAR(600) CHARACTER SET 'utf8' NOT NULL COMMENT '会议内容',
  `meetingTime` DATETIME NULL DEFAULT NULL COMMENT '会议时间',
  `meetingAddr` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '会议地址',
  `publishStatus` INT(11) NULL DEFAULT NULL COMMENT '发布状态（29）',
  `createTime` DATETIME NULL DEFAULT NULL COMMENT '创建日期',
  `createUser` INT(11) NULL DEFAULT NULL COMMENT '创建人',
  `lastUpdateTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `lastUpdateUser` INT(11) NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  INDEX `fk_eds_train_meeting` USING BTREE (`workstationId` ASC),
  CONSTRAINT `train_meeting_ibfk_1`
    FOREIGN KEY (`workstationId`)
    REFERENCES `medical_master`.`workstation` (`workstationId`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '培训会议通知'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `medical_master`.`user_preference`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`user_preference` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`user_preference` (
  `id` INT(11) NOT NULL,
  `userId` INT(11) NOT NULL COMMENT '用户ID',
  `hiddenName` INT(11) NULL DEFAULT NULL COMMENT '是否隐藏姓名',
  PRIMARY KEY (`id`),
  INDEX `fk_eds_user_preference` USING BTREE (`userId` ASC),
  CONSTRAINT `user_preference_ibfk_1`
    FOREIGN KEY (`userId`)
    REFERENCES `medical_master`.`user` (`userId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '用户配置信息'
ROW_FORMAT = DYNAMIC;


-- -----------------------------------------------------
-- Table `medical_master`.`workstation_follower`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`workstation_follower` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`workstation_follower` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '递增主键',
  `workstationId` INT(11) NOT NULL COMMENT '工作站ID',
  `userId` INT(11) NOT NULL COMMENT '用户ID',
  `followType` INT(11) NULL DEFAULT NULL COMMENT '追随类型-关注、加入',
  `status` INT(11) NULL DEFAULT NULL COMMENT '状态-申请中、审核不通过、生效',
  `createTime` DATETIME NULL DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`),
  INDEX `fk_eds_workstation_follower_01` USING BTREE (`workstationId` ASC),
  INDEX `fk_eds_workstation_follower_02` USING BTREE (`userId` ASC),
  CONSTRAINT `workstation_follower_ibfk_1`
    FOREIGN KEY (`workstationId`)
    REFERENCES `medical_master`.`workstation` (`workstationId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `workstation_follower_ibfk_2`
    FOREIGN KEY (`userId`)
    REFERENCES `medical_master`.`user` (`userId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci
COMMENT = '工作站追随者信息'
ROW_FORMAT = DYNAMIC;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
