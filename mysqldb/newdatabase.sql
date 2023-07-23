CREATE DATABASE  IF NOT EXISTS `uas` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `uas`;
-- MySQL dump 10.13  Distrib 8.0.33, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: uas
-- ------------------------------------------------------
-- Server version	8.0.33-0ubuntu0.22.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Temporary view structure for view `CourseView`
--

DROP TABLE IF EXISTS `CourseView`;
/*!50001 DROP VIEW IF EXISTS `CourseView`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `CourseView` AS SELECT 
 1 AS `course_code`,
 1 AS `course_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `TeacherClassView`
--

DROP TABLE IF EXISTS `TeacherClassView`;
/*!50001 DROP VIEW IF EXISTS `TeacherClassView`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `TeacherClassView` AS SELECT 
 1 AS `teacher_id`,
 1 AS `teacher_name`,
 1 AS `class_id`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `TeacherCourseView`
--

DROP TABLE IF EXISTS `TeacherCourseView`;
/*!50001 DROP VIEW IF EXISTS `TeacherCourseView`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `TeacherCourseView` AS SELECT 
 1 AS `teacher_id`,
 1 AS `teacher_name`,
 1 AS `Courses_course_code`,
 1 AS `course_name`,
 1 AS `credit_hours`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admins` (
  `admin_name` varchar(255) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `Users_email` varchar(50) NOT NULL,
  KEY `fk_Admins_Users1_idx` (`Users_email`),
  CONSTRAINT `fk_Admins_Users1` FOREIGN KEY (`Users_email`) REFERENCES `users` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `attedance_id` int NOT NULL,
  `lecture_lecture_id` int NOT NULL,
  `Students_regno` varchar(15) NOT NULL,
  `status` tinyint NOT NULL,
  PRIMARY KEY (`attedance_id`),
  KEY `fk_attendance_lecture1_idx` (`lecture_lecture_id`),
  KEY `fk_attendance_Students1_idx` (`Students_regno`),
  CONSTRAINT `fk_attendance_lecture1` FOREIGN KEY (`lecture_lecture_id`) REFERENCES `lecture` (`lecture_id`),
  CONSTRAINT `fk_attendance_Students1` FOREIGN KEY (`Students_regno`) REFERENCES `students` (`regno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `teacher_course_Courses_course_code` varchar(10) NOT NULL,
  `teacher_course_Teachers_teacher_id` int NOT NULL,
  `class_id` varchar(45) NOT NULL,
  PRIMARY KEY (`class_id`,`teacher_course_Courses_course_code`,`teacher_course_Teachers_teacher_id`),
  KEY `fk_registration_teacher_course1_idx` (`teacher_course_Courses_course_code`,`teacher_course_Teachers_teacher_id`),
  CONSTRAINT `fk_registration_teacher_course1` FOREIGN KEY (`teacher_course_Courses_course_code`, `teacher_course_Teachers_teacher_id`) REFERENCES `teacher_course` (`Courses_course_code`, `Teachers_teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `class_room`
--

DROP TABLE IF EXISTS `class_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_room` (
  `class_room_id` varchar(10) NOT NULL,
  `capacity` int NOT NULL,
  `facilities` varchar(45) NOT NULL,
  PRIMARY KEY (`class_room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `course_details_view`
--

DROP TABLE IF EXISTS `course_details_view`;
/*!50001 DROP VIEW IF EXISTS `course_details_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `course_details_view` AS SELECT 
 1 AS `course_name`,
 1 AS `course_code`,
 1 AS `faculty_id`,
 1 AS `class_id`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `course_code` varchar(10) NOT NULL,
  `course_name` varchar(255) NOT NULL,
  `credit_hours` varchar(45) NOT NULL,
  PRIMARY KEY (`course_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lecture`
--

DROP TABLE IF EXISTS `lecture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lecture` (
  `lecture_id` int NOT NULL,
  `lecture_date` date NOT NULL,
  `lecture_topic` varchar(45) NOT NULL,
  `student_class_Students_regno` varchar(15) NOT NULL,
  `student_class_class_class_id` varchar(45) NOT NULL,
  `student_class_class_teacher_course_Courses_course_code` varchar(10) NOT NULL,
  `student_class_class_teacher_course_Teachers_teacher_id` int NOT NULL,
  PRIMARY KEY (`lecture_id`),
  KEY `fk_lecture_student_class1_idx` (`student_class_Students_regno`,`student_class_class_class_id`,`student_class_class_teacher_course_Courses_course_code`,`student_class_class_teacher_course_Teachers_teacher_id`),
  CONSTRAINT `fk_lecture_student_class1` FOREIGN KEY (`student_class_Students_regno`, `student_class_class_class_id`, `student_class_class_teacher_course_Courses_course_code`, `student_class_class_teacher_course_Teachers_teacher_id`) REFERENCES `student_class` (`Students_regno`, `class_class_id`, `class_teacher_course_Courses_course_code`, `class_teacher_course_Teachers_teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `slot`
--

DROP TABLE IF EXISTS `slot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `slot` (
  `slot_id` int NOT NULL,
  `day_of_week` enum('monday','tuesday','wednesday','thursday','friday') DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  PRIMARY KEY (`slot_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_class`
--

DROP TABLE IF EXISTS `student_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_class` (
  `Students_regno` varchar(15) NOT NULL,
  `class_class_id` varchar(45) NOT NULL,
  `class_teacher_course_Courses_course_code` varchar(10) NOT NULL,
  `class_teacher_course_Teachers_teacher_id` int NOT NULL,
  PRIMARY KEY (`Students_regno`,`class_class_id`,`class_teacher_course_Courses_course_code`,`class_teacher_course_Teachers_teacher_id`),
  KEY `fk_student_class_Students1_idx` (`Students_regno`),
  KEY `fk_student_class_class1_idx` (`class_class_id`,`class_teacher_course_Courses_course_code`,`class_teacher_course_Teachers_teacher_id`),
  CONSTRAINT `fk_student_class_class1` FOREIGN KEY (`class_class_id`, `class_teacher_course_Courses_course_code`, `class_teacher_course_Teachers_teacher_id`) REFERENCES `class` (`class_id`, `teacher_course_Courses_course_code`, `teacher_course_Teachers_teacher_id`),
  CONSTRAINT `fk_student_class_Students1` FOREIGN KEY (`Students_regno`) REFERENCES `students` (`regno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `regno` varchar(15) NOT NULL,
  `student_name` varchar(30) NOT NULL,
  `father_name` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `cnic` varchar(45) NOT NULL,
  `phone_number` varchar(45) NOT NULL,
  `Users_email` varchar(50) NOT NULL,
  PRIMARY KEY (`regno`),
  UNIQUE KEY `cnic_UNIQUE` (`cnic`),
  UNIQUE KEY `regno_UNIQUE` (`regno`),
  KEY `fk_Students_Users1_idx` (`Users_email`),
  CONSTRAINT `fk_Students_Users1` FOREIGN KEY (`Users_email`) REFERENCES `users` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `teacher_course`
--

DROP TABLE IF EXISTS `teacher_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_course` (
  `Courses_course_code` varchar(10) NOT NULL,
  `Teachers_teacher_id` int NOT NULL,
  PRIMARY KEY (`Courses_course_code`,`Teachers_teacher_id`),
  KEY `fk_teacher_course_Courses1_idx` (`Courses_course_code`),
  KEY `fk_teacher_course_Teachers1_idx` (`Teachers_teacher_id`),
  CONSTRAINT `fk_teacher_course_Courses1` FOREIGN KEY (`Courses_course_code`) REFERENCES `courses` (`course_code`),
  CONSTRAINT `fk_teacher_course_Teachers1` FOREIGN KEY (`Teachers_teacher_id`) REFERENCES `teachers` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teachers` (
  `teacher_id` int NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `Users_email` varchar(50) NOT NULL,
  PRIMARY KEY (`teacher_id`),
  KEY `fk_Teachers_Users_idx` (`Users_email`),
  CONSTRAINT `fk_Teachers_Users` FOREIGN KEY (`Users_email`) REFERENCES `users` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5009 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` enum('admin','faculty','student') NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `view_students_by_class_and_course`
--

DROP TABLE IF EXISTS `view_students_by_class_and_course`;
/*!50001 DROP VIEW IF EXISTS `view_students_by_class_and_course`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_students_by_class_and_course` AS SELECT 
 1 AS `class_id`,
 1 AS `course_code`,
 1 AS `student_regno`,
 1 AS `student_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `CourseView`
--

/*!50001 DROP VIEW IF EXISTS `CourseView`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `CourseView` AS select `co`.`course_code` AS `course_code`,`co`.`course_name` AS `course_name` from (((`class` `c` join `teacher_course` `tc` on(((`c`.`teacher_course_Courses_course_code` = `tc`.`Courses_course_code`) and (`c`.`teacher_course_Teachers_teacher_id` = `tc`.`Teachers_teacher_id`)))) join `teachers` `t` on((`tc`.`Teachers_teacher_id` = `t`.`teacher_id`))) join `courses` `co` on((`tc`.`Courses_course_code` = `co`.`course_code`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `TeacherClassView`
--

/*!50001 DROP VIEW IF EXISTS `TeacherClassView`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `TeacherClassView` AS select `tc`.`Teachers_teacher_id` AS `teacher_id`,`t`.`teacher_name` AS `teacher_name`,`c`.`class_id` AS `class_id` from ((`teacher_course` `tc` join `teachers` `t` on((`tc`.`Teachers_teacher_id` = `t`.`teacher_id`))) join `class` `c` on(((`tc`.`Courses_course_code` = `c`.`teacher_course_Courses_course_code`) and (`tc`.`Teachers_teacher_id` = `c`.`teacher_course_Teachers_teacher_id`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `TeacherCourseView`
--

/*!50001 DROP VIEW IF EXISTS `TeacherCourseView`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `TeacherCourseView` AS select `t`.`teacher_id` AS `teacher_id`,`t`.`teacher_name` AS `teacher_name`,`c`.`course_code` AS `Courses_course_code`,`c`.`course_name` AS `course_name`,`c`.`credit_hours` AS `credit_hours` from ((`teacher_course` `tc` join `teachers` `t` on((`tc`.`Teachers_teacher_id` = `t`.`teacher_id`))) join `courses` `c` on((`tc`.`Courses_course_code` = `c`.`course_code`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `course_details_view`
--

/*!50001 DROP VIEW IF EXISTS `course_details_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `course_details_view` AS select `c`.`course_name` AS `course_name`,`c`.`course_code` AS `course_code`,`tc`.`Teachers_teacher_id` AS `faculty_id`,`cl`.`class_id` AS `class_id` from ((`courses` `c` join `teacher_course` `tc` on((`c`.`course_code` = `tc`.`Courses_course_code`))) join `class` `cl` on(((`tc`.`Courses_course_code` = `cl`.`teacher_course_Courses_course_code`) and (`tc`.`Teachers_teacher_id` = `cl`.`teacher_course_Teachers_teacher_id`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_students_by_class_and_course`
--

/*!50001 DROP VIEW IF EXISTS `view_students_by_class_and_course`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_students_by_class_and_course` AS select `sc`.`class_class_id` AS `class_id`,`sc`.`class_teacher_course_Courses_course_code` AS `course_code`,`s`.`regno` AS `student_regno`,`s`.`student_name` AS `student_name` from (`student_class` `sc` join `students` `s` on((`sc`.`Students_regno` = `s`.`regno`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-23  7:04:33
