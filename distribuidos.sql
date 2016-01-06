-- MySQL Script generated by MySQL Workbench
-- Wed Jan  6 02:37:40 2016
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema distribuidos
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `distribuidos` ;

-- -----------------------------------------------------
-- Schema distribuidos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `distribuidos` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `distribuidos` ;

-- -----------------------------------------------------
-- Table `distribuidos`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `distribuidos`.`usuario` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `nom_user` VARCHAR(45) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `role` INT NOT NULL,
  `app_user` VARCHAR(45) NULL,
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `distribuidos`.`estatus_compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `distribuidos`.`estatus_compra` (
  `idEstatus` INT NOT NULL,
  `nb_estatus` VARCHAR(50) NULL,
  `ds_estatus` VARCHAR(250) NULL,
  PRIMARY KEY (`idEstatus`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `distribuidos`.`compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `distribuidos`.`compra` (
  `idCompra` INT NOT NULL AUTO_INCREMENT,
  `usuario` INT NOT NULL,
  `estatus` INT NOT NULL,
  `fh_inicio` DATETIME NULL,
  `fh_fin` DATETIME NULL,
  PRIMARY KEY (`idCompra`),
  INDEX `fk_compra_usuario_idx` (`usuario` ASC),
  INDEX `fk_compra_estatus_compra1_idx` (`estatus` ASC),
  CONSTRAINT `fk_compra_usuario`
    FOREIGN KEY (`usuario`)
    REFERENCES `distribuidos`.`usuario` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_estatus_compra1`
    FOREIGN KEY (`estatus`)
    REFERENCES `distribuidos`.`estatus_compra` (`idEstatus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `distribuidos`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `distribuidos`.`producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `nom_prod` VARCHAR(50) NULL,
  `des_prod` VARCHAR(250) NULL,
  `nu_existencia` INT NULL,
  `nu_costo` FLOAT NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `distribuidos`.`detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `distribuidos`.`detalle` (
  `idDetalle` INT NOT NULL AUTO_INCREMENT,
  `compra` INT NOT NULL,
  `cantidad` INT NULL,
  `producto_idProducto` INT NOT NULL,
  PRIMARY KEY (`idDetalle`, `compra`),
  INDEX `fk_detalle_compra1_idx` (`compra` ASC),
  INDEX `fk_detalle_producto1_idx` (`producto_idProducto` ASC),
  CONSTRAINT `fk_detalle_compra1`
    FOREIGN KEY (`compra`)
    REFERENCES `distribuidos`.`compra` (`idCompra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_producto1`
    FOREIGN KEY (`producto_idProducto`)
    REFERENCES `distribuidos`.`producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `distribuidos`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `distribuidos`.`categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `nom_cat` VARCHAR(50) NULL,
  `des_cat` VARCHAR(250) NULL,
  `idPadre` INT NOT NULL,
  PRIMARY KEY (`idCategoria`),
  INDEX `fk_categoria_categoria1_idx` (`idPadre` ASC),
  CONSTRAINT `fk_categoria_categoria1`
    FOREIGN KEY (`idPadre`)
    REFERENCES `distribuidos`.`categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `distribuidos`.`tipo_unidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `distribuidos`.`tipo_unidad` (
  `idTipo` INT NOT NULL AUTO_INCREMENT,
  `nom_tipo` VARCHAR(50) NULL,
  `des_tipo` VARCHAR(250) NULL,
  PRIMARY KEY (`idTipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `distribuidos`.`unidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `distribuidos`.`unidad` (
  `idUnidad` INT NOT NULL AUTO_INCREMENT,
  `nom_uni` VARCHAR(50) NULL,
  `tx_siglas` VARCHAR(10) NULL,
  `idTipo` INT NOT NULL,
  PRIMARY KEY (`idUnidad`, `idTipo`),
  INDEX `fk_unidad_tipo_unidad1_idx` (`idTipo` ASC),
  CONSTRAINT `fk_unidad_tipo_unidad1`
    FOREIGN KEY (`idTipo`)
    REFERENCES `distribuidos`.`tipo_unidad` (`idTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `distribuidos`.`atributo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `distribuidos`.`atributo` (
  `idAtributo` INT NOT NULL AUTO_INCREMENT,
  `nom_atri` VARCHAR(50) NULL,
  `des_atri` VARCHAR(250) NULL,
  `idUnidad` INT NOT NULL,
  `idTipo` INT NOT NULL,
  PRIMARY KEY (`idAtributo`),
  INDEX `fk_atributo_unidad1_idx` (`idUnidad` ASC, `idTipo` ASC),
  CONSTRAINT `fk_atributo_unidad1`
    FOREIGN KEY (`idUnidad` , `idTipo`)
    REFERENCES `distribuidos`.`unidad` (`idUnidad` , `idTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `distribuidos`.`producto_atributo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `distribuidos`.`producto_atributo` (
  `tx_valor` VARCHAR(50) NULL,
  `idAtributo` INT NOT NULL,
  `idProducto` INT NOT NULL,
  PRIMARY KEY (`idAtributo`, `idProducto`),
  INDEX `fk_producto_atributo_producto1_idx` (`idProducto` ASC),
  CONSTRAINT `fk_producto_atributo_atributo1`
    FOREIGN KEY (`idAtributo`)
    REFERENCES `distribuidos`.`atributo` (`idAtributo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_atributo_producto1`
    FOREIGN KEY (`idProducto`)
    REFERENCES `distribuidos`.`producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `distribuidos`.`categoria_atributo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `distribuidos`.`categoria_atributo` (
  `idCategoria` INT NOT NULL,
  `idAtributo` INT NOT NULL,
  PRIMARY KEY (`idCategoria`, `idAtributo`),
  INDEX `fk_categoria_atributo_categoria1_idx` (`idCategoria` ASC),
  INDEX `fk_categoria_atributo_atributo1_idx` (`idAtributo` ASC),
  CONSTRAINT `fk_categoria_atributo_categoria1`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `distribuidos`.`categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_categoria_atributo_atributo1`
    FOREIGN KEY (`idAtributo`)
    REFERENCES `distribuidos`.`atributo` (`idAtributo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `distribuidos`.`categoria_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `distribuidos`.`categoria_producto` (
  `idCategoria` INT NOT NULL,
  `idProducto` INT NOT NULL,
  PRIMARY KEY (`idCategoria`, `idProducto`),
  INDEX `fk_categoria_producto_producto2_idx` (`idProducto` ASC),
  CONSTRAINT `fk_categoria_producto_categoria2`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `distribuidos`.`categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_categoria_producto_producto2`
    FOREIGN KEY (`idProducto`)
    REFERENCES `distribuidos`.`producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;