-- MySQL Workbench Synchronization
-- Generated: 2023-06-06 15:03
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Faizan

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

ALTER TABLE `attendance_system`.`course` 
DROP FOREIGN KEY `teacher_id`;

ALTER TABLE `attendance_system`.`course` 
DROP COLUMN `course_id`,
ADD COLUMN `c_name` VARCHAR(45) NULL DEFAULT NULL AFTER `cid`,
ADD COLUMN `faculty_t_id` INT(11) NOT NULL AFTER `c_name`,
CHANGE COLUMN `name` `cid` INT(11) NOT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`cid`, `faculty_t_id`),
ADD INDEX `fk_course_faculty_idx` (`faculty_t_id` ASC) VISIBLE;
;

ALTER TABLE `attendance_system`.`faculty` 
ADD COLUMN `phone_no` INT(11) NULL DEFAULT NULL AFTER `email`,
CHANGE COLUMN `teacher_id` `t_id` INT(11) NOT NULL ,
CHANGE COLUMN `name` `t_name` VARCHAR(30) NULL DEFAULT NULL ;

ALTER TABLE `attendance_system`.`students` 
ADD COLUMN `cnic` INT(15) NULL DEFAULT NULL AFTER `contact`,
CHANGE COLUMN `reg_no` `sid` VARCHAR(12) NOT NULL ,
CHANGE COLUMN `name` `f_name` VARCHAR(20) NULL DEFAULT NULL ,
CHANGE COLUMN `dob` `l_name` VARCHAR(20) NULL DEFAULT NULL , RENAME TO  `attendance_system`.`student` ;

CREATE TABLE IF NOT EXISTS `attendance_system`.`attendance` (
  `at_id` INT(11) NOT NULL,
  `present` TINYINT(1) NULL DEFAULT NULL,
  `student_sid` VARCHAR(12) NOT NULL,
  `Lessons_l_id` INT(11) NOT NULL,
  `Lessons_faculty_t_id` INT(11) NOT NULL,
  PRIMARY KEY (`at_id`, `student_sid`, `Lessons_l_id`, `Lessons_faculty_t_id`),
  INDEX `fk_attendance_student1_idx` (`student_sid` ASC) VISIBLE,
  INDEX `fk_attendance_Lessons1_idx` (`Lessons_l_id` ASC, `Lessons_faculty_t_id` ASC) VISIBLE,
  CONSTRAINT `fk_attendance_student1`
    FOREIGN KEY (`student_sid`)
    REFERENCES `attendance_system`.`student` (`sid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_attendance_Lessons1`
    FOREIGN KEY (`Lessons_l_id` , `Lessons_faculty_t_id`)
    REFERENCES `attendance_system`.`Lessons` (`l_id` , `faculty_t_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `attendance_system`.`Lessons` (
  `l_id` INT(11) NOT NULL,
  `l_name` VARCHAR(30) NULL DEFAULT NULL,
  `l_date` DATE NULL DEFAULT NULL,
  `faculty_t_id` INT(11) NOT NULL,
  `course_cid` INT(11) NOT NULL,
  `course_faculty_t_id` INT(11) NOT NULL,
  PRIMARY KEY (`l_id`, `faculty_t_id`, `course_cid`, `course_faculty_t_id`),
  INDEX `fk_Lessons_faculty1_idx` (`faculty_t_id` ASC) VISIBLE,
  INDEX `fk_Lessons_course1_idx` (`course_cid` ASC, `course_faculty_t_id` ASC) VISIBLE,
  CONSTRAINT `fk_Lessons_faculty1`
    FOREIGN KEY (`faculty_t_id`)
    REFERENCES `attendance_system`.`faculty` (`t_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Lessons_course1`
    FOREIGN KEY (`course_cid` , `course_faculty_t_id`)
    REFERENCES `attendance_system`.`course` (`cid` , `faculty_t_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `attendance_system`.`student_has_course` (
  `student_sid` VARCHAR(12) NOT NULL,
  `course_cid` INT(11) NOT NULL,
  `course_faculty_t_id` INT(11) NOT NULL,
  PRIMARY KEY (`student_sid`, `course_cid`, `course_faculty_t_id`),
  INDEX `fk_student_has_course_course1_idx` (`course_cid` ASC, `course_faculty_t_id` ASC) VISIBLE,
  INDEX `fk_student_has_course_student1_idx` (`student_sid` ASC) VISIBLE,
  CONSTRAINT `fk_student_has_course_student1`
    FOREIGN KEY (`student_sid`)
    REFERENCES `attendance_system`.`student` (`sid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_has_course_course1`
    FOREIGN KEY (`course_cid` , `course_faculty_t_id`)
    REFERENCES `attendance_system`.`course` (`cid` , `faculty_t_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

ALTER TABLE `attendance_system`.`course` 
ADD CONSTRAINT `fk_course_faculty`
  FOREIGN KEY (`faculty_t_id`)
  REFERENCES `attendance_system`.`faculty` (`t_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
