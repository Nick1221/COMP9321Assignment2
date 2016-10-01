-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema 9321DB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema 9321DB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `9321DB` DEFAULT CHARACTER SET utf8 ;
USE `9321DB` ;

-- -----------------------------------------------------
-- Table `9321DB`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DB`.`user` (
  `uID` INT NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(10) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `confirmedEmail` TINYINT(1) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `bDate` DATE NOT NULL,
  `isAdmin` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`uID`),
  UNIQUE INDEX `Uid_UNIQUE` (`uID` ASC),
  UNIQUE INDEX `Username_UNIQUE` (`Username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DB`.`userCreditCard`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DB`.`userCreditCard` (
  `uID` INT NOT NULL,
  `cardNumber` INT NOT NULL,
  UNIQUE INDEX `cardNumber_UNIQUE` (`cardNumber` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DB`.`emailConfirmation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DB`.`emailConfirmation` (
  `uID` INT NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `attempts` INT NOT NULL DEFAULT 0,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DB`.`publications`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DB`.`publications` (
  `pID` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `year` INT(4) NOT NULL,
  `volume` INT NOT NULL,
  `price` FLOAT NOT NULL,
  `picture` VARCHAR(100) NULL,
  PRIMARY KEY (`pID`),
  UNIQUE INDEX `pID_UNIQUE` (`pID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DB`.`userBoughtPublication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DB`.`userBoughtPublication` (
  `uID` INT NOT NULL,
  `pID` INT NOT NULL,
  `timeStamp` DATE NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DB`.`userRegisteredPublication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DB`.`userRegisteredPublication` (
  `uID` INT NOT NULL,
  `pID` INT NOT NULL,
  `timeStamp` DATE NOT NULL,
  `isVisible` TINYINT(1) NOT NULL DEFAULT 0)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DB`.`authorPublication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DB`.`authorPublication` (
  `pID` INT NOT NULL,
  `aID` INT NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DB`.`authors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DB`.`authors` (
  `aID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`aID`),
  UNIQUE INDEX `aID_UNIQUE` (`aID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DB`.`editors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DB`.`editors` (
  `eID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`eID`),
  UNIQUE INDEX `eID_UNIQUE` (`eID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DB`.`editorPublication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DB`.`editorPublication` (
  `eID` INT NOT NULL,
  `pID` INT NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DB`.`userActivity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DB`.`userActivity` (
  `uID` INT NOT NULL,
  `pID` INT NOT NULL,
  `aID` INT NOT NULL,
  `timeStamp` DATE NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DB`.`activity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DB`.`activity` (
  `actID` INT NOT NULL AUTO_INCREMENT,
  `actName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`actID`),
  UNIQUE INDEX `actID_UNIQUE` (`actID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DB`.`userBan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DB`.`userBan` (
  `uID` INT NOT NULL,
  `banUID` INT NOT NULL,
  `reason` VARCHAR(100) NOT NULL,
  `timeStamp` DATE NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `9321DB`.`banPublication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `9321DB`.`banPublication` (
  `uID` INT NOT NULL,
  `banPID` INT NOT NULL,
  `reason` VARCHAR(100) NOT NULL,
  `timeStamp` DATE NOT NULL)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
