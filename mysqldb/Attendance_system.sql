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
INSERT INTO `Courses` VALUES ('CS207','Database','4'),('CSC103','Programming Fundamentals','4'),('CSC207','Data Structures','4'),('CSC209','Object Oriented Software Engineering','4'),('CSC215','HCI','3'),('EEE121','Electric Circuits Analysis I','4'),('EEE241','Digital Logic Design','4'),('MGT112','Marketing','3');
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
) ENGINE=InnoDB AUTO_INCREMENT=801 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Teachers`
--

LOCK TABLES `Teachers` WRITE;
/*!40000 ALTER TABLE `Teachers` DISABLE KEYS */;
/*!40000 ALTER TABLE `Teachers` ENABLE KEYS */;
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
INSERT INTO `Users` VALUES ('faizan','2546','student'),('fawad','9257','admin'),('sana_malik','1234','faculty');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `class_id` varchar(10) NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registration` (
  `Students_regno` varchar(15) NOT NULL,
  `teacher_course_Courses_course_code` varchar(10) NOT NULL,
  `teacher_course_Teachers_teacher_id` int NOT NULL,
  `class_class_id` varchar(10) NOT NULL,
  PRIMARY KEY (`Students_regno`,`teacher_course_Courses_course_code`,`teacher_course_Teachers_teacher_id`),
  KEY `fk_registration_Students1_idx` (`Students_regno`),
  KEY `fk_registration_teacher_course1_idx` (`teacher_course_Courses_course_code`,`teacher_course_Teachers_teacher_id`),
  KEY `fk_registration_class1_idx` (`class_class_id`),
  CONSTRAINT `fk_registration_class1` FOREIGN KEY (`class_class_id`) REFERENCES `class` (`class_id`),
  CONSTRAINT `fk_registration_Students1` FOREIGN KEY (`Students_regno`) REFERENCES `Students` (`regno`),
  CONSTRAINT `fk_registration_teacher_course1` FOREIGN KEY (`teacher_course_Courses_course_code`, `teacher_course_Teachers_teacher_id`) REFERENCES `teacher_course` (`Courses_course_code`, `Teachers_teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
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

-- Dump completed on 2023-07-19  5:23:12
