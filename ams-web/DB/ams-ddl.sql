--------------------------------------------------------
-- create user `ams` with password `ams`
--------------------------------------------------------
CREATE USER 'ams'@'localhost' IDENTIFIED BY 'ams';
GRANT ALL PRIVILEGES ON * . * TO 'ams'@'localhost';
FLUSH PRIVILEGES;

-- -----------------------------------------------------
-- Schema amsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `amsdb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema amsdb
-- -----------------------------------------------------
USE `amsdb` ;

-- -----------------------------------------------------
-- Table `amsdb`.`patients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amsdb`.`patient` (
    `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC))
    ENGINE = InnoDB
    AUTO_INCREMENT = 19
    DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `amsdb`.`appointments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amsdb`.`appointment` (
    `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `appointment_date` date NOT NULL,
    `is_canceled` tinyint(1),
    `cancel_reason` VARCHAR(200) ,
    `patient_id` INT(10) UNSIGNED NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_appointment_patient_idx` (`patient_id` ASC),
    CONSTRAINT `fk_appointment_patient`
    FOREIGN KEY (`patient_id`)
    REFERENCES `amsdb`.`patient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    AUTO_INCREMENT = 2
    DEFAULT CHARACTER SET = latin1;

