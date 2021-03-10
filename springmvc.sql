
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema springmvc
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema springmvc
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `springmvc` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `springmvc` ;

-- -----------------------------------------------------
-- Table `springmvc`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springmvc`.`user` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `isDeleted` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springmvc`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springmvc`.`orders` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `userID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_orders_user1_idx` (`userID` ASC) VISIBLE,
  CONSTRAINT `fk_orders_user1`
    FOREIGN KEY (`userID`)
    REFERENCES `springmvc`.`user` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springmvc`.`orderItem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springmvc`.`orderItem` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `ordersItemID` INT NOT NULL,
  `items` VARCHAR(45) NULL,
  `quantity` INT(45) NULL,
  `price` INT NULL,
  `isDeleted` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`ID`),
  INDEX `fk_orderItem_orders_idx` (`ordersItemID` ASC) VISIBLE,
  CONSTRAINT `fk_orderItem_orders`
    FOREIGN KEY (`ordersItemID`)
    REFERENCES `springmvc`.`orders` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
