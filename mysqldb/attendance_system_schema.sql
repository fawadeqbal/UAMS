CREATE DATABASE  IF NOT EXISTS `attendance` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `attendance`;
-- MySQL dump 10.13  Distrib 8.0.33, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: attendance
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
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `at_id` int NOT NULL,
  `present` tinyint(1) DEFAULT NULL,
  `student_sid` varchar(12) NOT NULL,
  `Lessons_l_id` int NOT NULL,
  `Lessons_faculty_t_id` int NOT NULL,
  PRIMARY KEY (`at_id`,`student_sid`,`Lessons_l_id`,`Lessons_faculty_t_id`),
  KEY `fk_attendance_student1_idx` (`student_sid`),
  KEY `fk_attendance_Lessons1_idx` (`Lessons_l_id`,`Lessons_faculty_t_id`),
  CONSTRAINT `fk_attendance_Lessons1` FOREIGN KEY (`Lessons_l_id`, `Lessons_faculty_t_id`) REFERENCES `lessons` (`l_id`, `faculty_t_id`),
  CONSTRAINT `fk_attendance_student1` FOREIGN KEY (`student_sid`) REFERENCES `student` (`sid`)
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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `cid` int NOT NULL,
  `c_name` varchar(45) DEFAULT NULL,
  `faculty_t_id` int NOT NULL,
  PRIMARY KEY (`cid`,`faculty_t_id`),
  KEY `fk_course_faculty_idx` (`faculty_t_id`),
  CONSTRAINT `fk_course_faculty` FOREIGN KEY (`faculty_t_id`) REFERENCES `faculty` (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty` (
  `t_id` int NOT NULL,
  `t_name` varchar(30) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_no` int DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES (1,'ws','ssa',12);
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lessons`
--

DROP TABLE IF EXISTS `lessons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lessons` (
  `l_id` int NOT NULL,
  `l_name` varchar(30) DEFAULT NULL,
  `l_date` date DEFAULT NULL,
  `faculty_t_id` int NOT NULL,
  `course_cid` int NOT NULL,
  `course_faculty_t_id` int NOT NULL,
  PRIMARY KEY (`l_id`,`faculty_t_id`,`course_cid`,`course_faculty_t_id`),
  KEY `fk_Lessons_faculty1_idx` (`faculty_t_id`),
  KEY `fk_Lessons_course1_idx` (`course_cid`,`course_faculty_t_id`),
  CONSTRAINT `fk_Lessons_course1` FOREIGN KEY (`course_cid`, `course_faculty_t_id`) REFERENCES `course` (`cid`, `faculty_t_id`),
  CONSTRAINT `fk_Lessons_faculty1` FOREIGN KEY (`faculty_t_id`) REFERENCES `faculty` (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lessons`
--

LOCK TABLES `lessons` WRITE;
/*!40000 ALTER TABLE `lessons` DISABLE KEYS */;
/*!40000 ALTER TABLE `lessons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `sid` varchar(12) NOT NULL,
  `f_name` varchar(20) DEFAULT NULL,
  `l_name` varchar(20) DEFAULT NULL,
  `contact` int DEFAULT NULL,
  `cnic` int DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentenroll`
--

DROP TABLE IF EXISTS `studentenroll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentenroll` (
  `student_sid` varchar(12) NOT NULL,
  `course_cid` int NOT NULL,
  `course_faculty_t_id` int NOT NULL,
  PRIMARY KEY (`student_sid`,`course_cid`,`course_faculty_t_id`),
  KEY `fk_student_has_course_course1_idx` (`course_cid`,`course_faculty_t_id`),
  KEY `fk_student_has_course_student1_idx` (`student_sid`),
  CONSTRAINT `fk_student_has_course_course1` FOREIGN KEY (`course_cid`, `course_faculty_t_id`) REFERENCES `course` (`cid`, `faculty_t_id`),
  CONSTRAINT `fk_student_has_course_student1` FOREIGN KEY (`student_sid`) REFERENCES `student` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentenroll`
--

LOCK TABLES `studentenroll` WRITE;
/*!40000 ALTER TABLE `studentenroll` DISABLE KEYS */;
/*!40000 ALTER TABLE `studentenroll` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(16) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('basit','basit@yahoo.com','root','2023-07-07 09:54:32','faculty'),('faizan','faizanswabi95@gmail.com','root','2023-06-06 18:17:14','student'),('fawad','fawadeqbal@yahoo.com','root','2023-06-06 18:32:01','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-07 20:43:24
