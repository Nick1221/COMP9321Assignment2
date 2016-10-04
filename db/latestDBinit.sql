-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema 9321DataBase
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema 9321DataBase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `9321DataBase` DEFAULT CHARACTER SET utf8 ;
USE `9321DataBase` ;

-- -----------------------------------------------------
-- Table `9321DataBase`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DataBase`.`user` (
  `uID` INT NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(10) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `confirmedEmail` TINYINT(1) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `bDate` DATE NOT NULL,
  `isAdmin` TINYINT(1) NOT NULL DEFAULT 0,
  `nickname` VARCHAR(45) NOT NULL,
  `fullAddress` VARCHAR(100) NOT NULL,
  `cardNumber` INT NOT NULL,
  `code` VARCHAR(45) NULL,
  PRIMARY KEY (`uID`),
  UNIQUE INDEX `Uid_UNIQUE` (`uID` ASC),
  UNIQUE INDEX `Username_UNIQUE` (`Username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DataBase`.`publications`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DataBase`.`publications` (
  `pID` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `year` INT(4) NOT NULL,
  `volume` INT NOT NULL,
  `price` FLOAT NOT NULL,
  `picture` VARCHAR(100) NULL,
  `author` VARCHAR(100) NOT NULL,
  `editor` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`pID`),
  UNIQUE INDEX `pID_UNIQUE` (`pID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DataBase`.`userBoughtPublication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DataBase`.`userBoughtPublication` (
  `uID` INT NOT NULL,
  `pID` INT NOT NULL,
  `timeStamp` DATE NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DataBase`.`userRegisteredPublication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DataBase`.`userRegisteredPublication` (
  `uID` INT NOT NULL,
  `pID` INT NOT NULL,
  `timeStamp` DATE NOT NULL,
  `isVisible` TINYINT(1) NOT NULL DEFAULT 0)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DataBase`.`userActivity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DataBase`.`userActivity` (
  `uID` INT NOT NULL,
  `pID` INT NOT NULL,
  `activity` VARCHAR(45) NOT NULL,
  `timeStamp` DATE NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DataBase`.`userBan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DataBase`.`userBan` (
  `uID` INT NOT NULL,
  `banUID` INT NOT NULL,
  `reason` VARCHAR(100) NOT NULL,
  `timeStamp` DATE NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DataBase`.`banPublication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DataBase`.`banPublication` (
  `uID` INT NOT NULL,
  `banPID` INT NOT NULL,
  `reason` VARCHAR(100) NOT NULL,
  `timeStamp` DATE NOT NULL)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
