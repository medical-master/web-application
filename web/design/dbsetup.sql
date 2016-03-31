-- MySQL Script generated by MySQL Workbench
-- 03/29/16 09:45:08
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

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
-- Table `medical_master`.`clinical_research`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`clinical_research` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`clinical_research` (
  `clinicalResearchId` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(128) CHARACTER SET 'utf8' NOT NULL,
  `description` VARCHAR(1024) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `applicationLocation` VARCHAR(512) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT 'id list separated by ,',
  `assignmentContractLocation` VARCHAR(512) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `createTime` DATETIME NULL DEFAULT NULL,
  `lastUpdateTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userId` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`clinicalResearchId`),
  INDEX `title` (`title` ASC),
  INDEX `user` (`userId` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `medical_master`.`comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`comment` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`comment` (
  `commentId` INT(11) NOT NULL AUTO_INCREMENT,
  `userId` INT(11) NULL DEFAULT NULL,
  `commenterName` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `contactInfo` VARCHAR(128) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `commentTime` DATETIME NULL DEFAULT NULL,
  `feedback` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `feedbackTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`commentId`),
  INDEX `user` (`userId` ASC),
  INDEX `name` (`commenterName` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `medical_master`.`diagnostic_plan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`diagnostic_plan` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`diagnostic_plan` (
  `diagnosticPlanId` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128) CHARACTER SET 'utf8' NOT NULL,
  `category` INT(11) NULL DEFAULT NULL,
  `detail` VARCHAR(4096) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `createTime` DATETIME NULL DEFAULT NULL,
  `lastUpdateTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userId` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`diagnosticPlanId`),
  INDEX `name` (`name` ASC),
  INDEX `user` (`userId` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `medical_master`.`hospital`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`hospital` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`hospital` (
  `hospitalId` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(256) CHARACTER SET 'utf8' NOT NULL,
  `level` INT(11) NULL DEFAULT NULL,
  `proviceId` INT(11) NULL DEFAULT NULL,
  `cityId` INT(11) NULL DEFAULT NULL,
  `districtId` INT(11) NULL DEFAULT NULL,
  `address` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`hospitalId`),
  INDEX `name` (`name` ASC),
  INDEX `address` (`address` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `medical_master`.`system_property`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`system_property` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`system_property` (
  `propertyId` INT(11) NOT NULL COMMENT '数据字典代码ID',
  `categoryId` INT(11) NOT NULL COMMENT '数据字典分类代码ID',
  `name` VARCHAR(128) CHARACTER SET 'utf8' NOT NULL COMMENT '名称',
  `description` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '描述',
  `alias` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '别名',
  `parentId` INT(11) NULL DEFAULT NULL COMMENT '上级数据字典代码ID',
  `extend` VARCHAR(255) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '扩展字段',
  `createTime` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `lastUpdateTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`propertyId`, `categoryId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `medical_master`.`system_property_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`system_property_category` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`system_property_category` (
  `categoryId` INT(11) NOT NULL COMMENT '数据字典分类代码',
  `name` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL COMMENT '名称',
  `description` VARCHAR(128) CHARACTER SET 'utf8' NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`categoryId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `medical_master`.`training_material`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`training_material` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`training_material` (
  `materialId` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(256) CHARACTER SET 'utf8' NOT NULL,
  `description` VARCHAR(1024) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `location` VARCHAR(1024) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `createTime` DATETIME NULL DEFAULT NULL,
  `lastUpdateTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userId` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`materialId`),
  INDEX `title` (`title` ASC),
  INDEX `user` (`userId` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `medical_master`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`user` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`user` (
  `userId` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128) CHARACTER SET 'utf8' NOT NULL,
  `email` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `authentication` VARCHAR(128) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `type` INT(11) NULL DEFAULT NULL,
  `hosptialId` INT(11) NULL DEFAULT NULL,
  `nickName` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `createTime` DATETIME NULL DEFAULT NULL,
  `sex` TINYINT(1) NULL DEFAULT NULL,
  `department` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `educationLevel` INT(11) NULL DEFAULT NULL,
  `professionalRank` INT(11) NULL DEFAULT NULL,
  `title` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `identityNumber` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `doctorNumber` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `mobilePhoneNumber` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `status` INT(11) NULL DEFAULT NULL,
  `inviteCode` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `lastUpdateTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`),
  INDEX `user_name` (`name` ASC),
  INDEX `phone_number` (`mobilePhoneNumber` ASC),
  INDEX `doctor_number` (`doctorNumber` ASC),
  INDEX `hospital` (`hosptialId` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `medical_master`.`workstation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medical_master`.`workstation` ;

CREATE TABLE IF NOT EXISTS `medical_master`.`workstation` (
  `workstationId` INT(11) NOT NULL AUTO_INCREMENT,
  `userId` INT(11) NOT NULL,
  `name` VARCHAR(128) CHARACTER SET 'utf8' NOT NULL,
  `description` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `domains` VARCHAR(512) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `keywords` VARCHAR(256) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `allowDownload` TINYINT(1) NULL DEFAULT NULL,
  `status` INT(11) NULL DEFAULT NULL,
  `createTime` DATETIME NULL DEFAULT NULL,
  `lastUpdateTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`workstationId`),
  INDEX `keywords` (`keywords` ASC),
  INDEX `name` (`name` ASC),
  INDEX `user` (`userId` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
