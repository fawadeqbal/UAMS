CREATE DATABASE  IF NOT EXISTS `UAS` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `UAS`;
-- MySQL dump 10.13  Distrib 8.0.33, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: UAS
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
-- Table structure for table `Admins`
--

DROP TABLE IF EXISTS `Admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Admins` (
  `admin_name` varchar(255) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `Users_email` varchar(50) NOT NULL,
  KEY `fk_Admins_Users1_idx` (`Users_email`),
  CONSTRAINT `fk_Admins_Users1` FOREIGN KEY (`Users_email`) REFERENCES `Users` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Admins`
--

LOCK TABLES `Admins` WRITE;
/*!40000 ALTER TABLE `Admins` DISABLE KEYS */;
INSERT INTO `Admins` VALUES ('Fawad Iqbal','03149972883','fawadeqbal@yahoo.com');
/*!40000 ALTER TABLE `Admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Courses`
--

DROP TABLE IF EXISTS `Courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Courses` (
  `course_code` varchar(10) NOT NULL,
  `course_name` varchar(255) NOT NULL,
  `credit_hours` varchar(45) NOT NULL,
  PRIMARY KEY (`course_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Courses`
--

LOCK TABLES `Courses` WRITE;
/*!40000 ALTER TABLE `Courses` DISABLE KEYS */;
INSERT INTO `Courses` VALUES ('CS207','Database','4'),('CSC103','Programming Fundamentals','4'),('CSC207','Data Structures','4'),('CSC209','Object Oriented Software Engineering','4'),('CSC215','HCI','3'),('CSC218','Object Oriented Programming','4'),('CSC308','Operating System','2'),('EEE121','Electric Circuits Analysis I','4'),('EEE241','Digital Logic Design','4'),('MGT112','Marketing','3'),('MTH108','Calculus 1','3');
/*!40000 ALTER TABLE `Courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Students`
--

DROP TABLE IF EXISTS `Students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Students` (
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
  CONSTRAINT `fk_Students_Users1` FOREIGN KEY (`Users_email`) REFERENCES `Users` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Students`
--

LOCK TABLES `Students` WRITE;
/*!40000 ALTER TABLE `Students` DISABLE KEYS */;
INSERT INTO `Students` VALUES ('FA23-BSE-001','Idrees Khan','Khush Khawas','2006-08-01','','03479554528','idrees447701@gmail.com');
/*!40000 ALTER TABLE `Students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Teachers`
--

DROP TABLE IF EXISTS `Teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Teachers` (
  `teacher_id` int NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `Users_email` varchar(50) NOT NULL,
  PRIMARY KEY (`teacher_id`),
  KEY `fk_Teachers_Users_idx` (`Users_email`),
  CONSTRAINT `fk_Teachers_Users` FOREIGN KEY (`Users_email`) REFERENCES `Users` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5005 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Teachers`
--

LOCK TABLES `Teachers` WRITE;
/*!40000 ALTER TABLE `Teachers` DISABLE KEYS */;
INSERT INTO `Teachers` VALUES (5000,'Sana Malik','1234567890','sana_malik@cuiatd.edu.pk'),(5001,'Muhktiar Zamin','0987654321','mukhtiarzamin@cuiatd.edu.pk'),(5002,'Zia Ul Wahid','0987654321','ziaulwahid@cuiatd.edu.pk'),(5003,'Saira Bhatti','1234567890','sairabhatti@cuiatd.edu.pk'),(5004,'Waqas Jadoon','1234554321','waqasjadoon@cuiatd.edu.pk');
/*!40000 ALTER TABLE `Teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Timetable`
--

DROP TABLE IF EXISTS `Timetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Timetable` (
  `slot_slot_id` int NOT NULL,
  `class_room_class_room_id` varchar(10) NOT NULL,
  `class_class_id` varchar(45) NOT NULL,
  `class_teacher_course_Courses_course_code` varchar(10) NOT NULL,
  `class_teacher_course_Teachers_teacher_id` int NOT NULL,
  PRIMARY KEY (`slot_slot_id`,`class_room_class_room_id`),
  KEY `fk_schedual_slot1_idx` (`slot_slot_id`),
  KEY `fk_schedual_class_room1_idx` (`class_room_class_room_id`),
  KEY `fk_schedual_class1_idx` (`class_class_id`,`class_teacher_course_Courses_course_code`,`class_teacher_course_Teachers_teacher_id`),
  CONSTRAINT `fk_schedual_class1` FOREIGN KEY (`class_class_id`, `class_teacher_course_Courses_course_code`, `class_teacher_course_Teachers_teacher_id`) REFERENCES `class` (`class_id`, `teacher_course_Courses_course_code`, `teacher_course_Teachers_teacher_id`),
  CONSTRAINT `fk_schedual_class_room1` FOREIGN KEY (`class_room_class_room_id`) REFERENCES `class_room` (`class_room_id`),
  CONSTRAINT `fk_schedual_slot1` FOREIGN KEY (`slot_slot_id`) REFERENCES `slot` (`slot_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Timetable`
--

LOCK TABLES `Timetable` WRITE;
/*!40000 ALTER TABLE `Timetable` DISABLE KEYS */;
/*!40000 ALTER TABLE `Timetable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Users` (
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` enum('admin','faculty','student') NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES ('faizanswabi95@gmail.com','root','student'),('fawadeqbal@yahoo.com','root','admin'),('idrees447701@gmail.com','root','student'),('mansoor@yahoo.com','root','student'),('mukhtiarzamin@cuiatd.edu.pk','root','faculty'),('sairabhatti@cuiatd.edu.pk','root','faculty'),('sana_malik@cuiatd.edu.pk','root','faculty'),('waqasjadoon@cuiatd.edu.pk','root','faculty'),('ziaulwahid@cuiatd.edu.pk','root','faculty');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;

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
  CONSTRAINT `fk_attendance_Students1` FOREIGN KEY (`Students_regno`) REFERENCES `Students` (`regno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES ('CSC103',5000,'bse-4b');
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `class_room`
--

LOCK TABLES `class_room` WRITE;
/*!40000 ALTER TABLE `class_room` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_room` ENABLE KEYS */;
UNLOCK TABLES;

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
  `schedual_slot_slot_id` int NOT NULL,
  `schedual_class_room_class_room_id` varchar(10) NOT NULL,
  PRIMARY KEY (`lecture_id`),
  KEY `fk_lecture_schedual1_idx` (`schedual_slot_slot_id`,`schedual_class_room_class_room_id`),
  CONSTRAINT `fk_lecture_schedual1` FOREIGN KEY (`schedual_slot_slot_id`, `schedual_class_room_class_room_id`) REFERENCES `Timetable` (`slot_slot_id`, `class_room_class_room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecture`
--

LOCK TABLES `lecture` WRITE;
/*!40000 ALTER TABLE `lecture` DISABLE KEYS */;
/*!40000 ALTER TABLE `lecture` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `slot`
--

LOCK TABLES `slot` WRITE;
/*!40000 ALTER TABLE `slot` DISABLE KEYS */;
/*!40000 ALTER TABLE `slot` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`Students_regno`),
  KEY `fk_student_class_Students1_idx` (`Students_regno`),
  KEY `fk_student_class_class1_idx` (`class_class_id`,`class_teacher_course_Courses_course_code`,`class_teacher_course_Teachers_teacher_id`),
  CONSTRAINT `fk_student_class_class1` FOREIGN KEY (`class_class_id`, `class_teacher_course_Courses_course_code`, `class_teacher_course_Teachers_teacher_id`) REFERENCES `class` (`class_id`, `teacher_course_Courses_course_code`, `teacher_course_Teachers_teacher_id`),
  CONSTRAINT `fk_student_class_Students1` FOREIGN KEY (`Students_regno`) REFERENCES `Students` (`regno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_class`
--

LOCK TABLES `student_class` WRITE;
/*!40000 ALTER TABLE `student_class` DISABLE KEYS */;
INSERT INTO `student_class` VALUES ('FA23-BSE-001','bse-4b','CSC103',0);
/*!40000 ALTER TABLE `student_class` ENABLE KEYS */;
UNLOCK TABLES;

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
  CONSTRAINT `fk_teacher_course_Courses1` FOREIGN KEY (`Courses_course_code`) REFERENCES `Courses` (`course_code`),
  CONSTRAINT `fk_teacher_course_Teachers1` FOREIGN KEY (`Teachers_teacher_id`) REFERENCES `Teachers` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_course`
--

LOCK TABLES `teacher_course` WRITE;
/*!40000 ALTER TABLE `teacher_course` DISABLE KEYS */;
INSERT INTO `teacher_course` VALUES ('CSC103',5000),('CSC207',5000),('CSC209',5000),('CSC103',5001),('CSC207',5001),('CSC209',5001),('EEE121',5002),('EEE241',5002),('MGT112',5002),('MTH108',5003),('CSC218',5004),('CSC308',5004);
/*!40000 ALTER TABLE `teacher_course` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-21  2:34:58
