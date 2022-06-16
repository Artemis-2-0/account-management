drop table if exists `acctmgmtdb`.`account`;
drop table if exists `acctmgmtdb`.`customer`;
CREATE TABLE IF NOT EXISTS `acctmgmtdb`.`customer` (
  `customer_sk` VARCHAR(36) NOT NULL,
  `customer_number` VARCHAR(100) NOT NULL,
  `user_id` VARCHAR(36) NOT NULL,
  `first_name` VARCHAR(100) NOT NULL,
  `middle_name` VARCHAR(100) NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `created_date` DATETIME NULL,
  `updated_date` DATETIME NULL,
  PRIMARY KEY (`customer_sk`),
  UNIQUE INDEX `customer_number_UNIQUE` (`customer_number` ASC) VISIBLE,
  INDEX `customer_user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `customer_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `acctmgmtdb`.`security_user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'The table that contains the customer information';

CREATE TABLE IF NOT EXISTS `acctmgmtdb`.`account` (
  `account_sk` VARCHAR(36) NOT NULL,
  `customer_sk` VARCHAR(36) NOT NULL,
  `account_type` VARCHAR(50) NOT NULL,
  `account_number` VARCHAR(100) NOT NULL,
  `account_name` VARCHAR(100) NOT NULL,
  `account_balance` DECIMAL(15,2) NOT NULL DEFAULT 0.00,
  `created_date` DATETIME NULL,
  `updated_date` DATETIME NULL,
  PRIMARY KEY (`account_sk`),
  INDEX `account_customer_sk_idx` (`customer_sk` ASC) VISIBLE,
  CONSTRAINT `account_customer_sk`
    FOREIGN KEY (`customer_sk`)
    REFERENCES `acctmgmtdb`.`customer` (`customer_sk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB