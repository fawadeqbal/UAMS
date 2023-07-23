CREATE DATABASE  IF NOT EXISTS `uas` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `uas`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: uas
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` VALUES ('Fawad Iqbal','03149972883','fawadeqbal@yahoo.com');
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
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
  CONSTRAINT `fk_attendance_Students1` FOREIGN KEY (`Students_regno`) REFERENCES `students` (`regno`)
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
INSERT INTO `class` VALUES ('CSC103',5000,'bse-4a'),('CSC103',5000,'bse-4b'),('CSC209',5001,'bse-4b'),('PHM118',5008,'phm-4b');
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
INSERT INTO `class_room` VALUES ('A210',40,'AC, projector'),('Z220',40,'AC, projector');
/*!40000 ALTER TABLE `class_room` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES ('CS207','Database','4'),('CSC103','Data Structures','4'),('CSC209','Object Oriented Software Engineering','3'),('CSC215','HCI','3'),('CSC218','Object Oriented Programming','4'),('CSC219','Web Technology','3'),('CSC308','Operating System','2'),('EEE121','Electric Circuits Analysis I','4'),('EEE241','Digital Logic Design','4'),('MGT112','Marketing','3'),('MTH108','Calculus 1','3'),('MTH205','Statistics','3'),('PHM118','Pharmacology','4');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `courseview`
--

DROP TABLE IF EXISTS `courseview`;
/*!50001 DROP VIEW IF EXISTS `courseview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `courseview` AS SELECT 
 1 AS `course_code`,
 1 AS `course_name`*/;
SET character_set_client = @saved_cs_client;

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
  CONSTRAINT `fk_lecture_schedual1` FOREIGN KEY (`schedual_slot_slot_id`, `schedual_class_room_class_room_id`) REFERENCES `timetable` (`slot_slot_id`, `class_room_class_room_id`)
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
INSERT INTO `slot` VALUES (1,'monday','08:00:00','09:30:00'),(2,'monday','09:40:00','11:10:00'),(3,'monday','11:20:00','12:50:00'),(4,'monday','13:40:00','15:10:00'),(5,'monday','15:20:00','16:50:00'),(6,'monday','17:00:00','18:30:00'),(7,'monday','18:30:00','20:00:00'),(8,'monday','20:00:00','21:30:00'),(9,'tuesday','08:00:00','09:30:00'),(10,'tuesday','09:40:00','11:10:00'),(11,'tuesday','11:20:00','12:50:00'),(12,'tuesday','13:40:00','15:10:00'),(13,'tuesday','15:20:00','16:50:00'),(14,'tuesday','17:00:00','18:30:00'),(15,'tuesday','18:30:00','20:00:00'),(16,'tuesday','20:00:00','21:30:00'),(17,'wednesday','08:00:00','09:30:00'),(18,'wednesday','09:40:00','11:10:00'),(19,'wednesday','11:20:00','12:50:00'),(20,'wednesday','13:40:00','15:10:00'),(21,'wednesday','15:20:00','16:50:00'),(22,'wednesday','17:00:00','18:30:00'),(23,'wednesday','18:30:00','20:00:00'),(24,'wednesday','20:00:00','21:30:00'),(25,'thursday','08:00:00','09:30:00'),(26,'thursday','09:40:00','11:10:00'),(27,'thursday','11:20:00','12:50:00'),(28,'thursday','13:40:00','15:10:00'),(29,'thursday','15:20:00','16:50:00'),(30,'thursday','17:00:00','18:30:00'),(31,'thursday','18:30:00','20:00:00'),(32,'thursday','20:00:00','21:30:00'),(33,'friday','08:00:00','09:30:00'),(34,'friday','09:40:00','11:10:00'),(35,'friday','11:20:00','12:50:00'),(36,'friday','13:40:00','15:10:00'),(37,'friday','15:20:00','16:50:00'),(38,'friday','17:00:00','18:30:00'),(39,'friday','18:30:00','20:00:00'),(40,'friday','20:00:00','21:30:00');
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
  PRIMARY KEY (`Students_regno`,`class_class_id`,`class_teacher_course_Courses_course_code`,`class_teacher_course_Teachers_teacher_id`),
  KEY `fk_student_class_Students1_idx` (`Students_regno`),
  KEY `fk_student_class_class1_idx` (`class_class_id`,`class_teacher_course_Courses_course_code`,`class_teacher_course_Teachers_teacher_id`),
  CONSTRAINT `fk_student_class_class1` FOREIGN KEY (`class_class_id`, `class_teacher_course_Courses_course_code`, `class_teacher_course_Teachers_teacher_id`) REFERENCES `class` (`class_id`, `teacher_course_Courses_course_code`, `teacher_course_Teachers_teacher_id`),
  CONSTRAINT `fk_student_class_Students1` FOREIGN KEY (`Students_regno`) REFERENCES `students` (`regno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_class`
--

LOCK TABLES `student_class` WRITE;
/*!40000 ALTER TABLE `student_class` DISABLE KEYS */;
INSERT INTO `student_class` VALUES ('FA21-BSE-001','bse-4b','CSC103',5000),('FA21-BSE-002','bse-4b','CSC103',5000),('FA21-BSE-004','bse-4b','CSC103',5000),('FA21-BSE-006','bse-4b','CSC103',5000),('FA21-BSE-007','bse-4b','CSC103',5000),('FA21-BSE-008','bse-4b','CSC103',5000),('FA21-BSE-009','bse-4b','CSC103',5000),('FA21-BSE-010','bse-4b','CSC103',5000),('FA21-BSE-011','bse-4b','CSC103',5000),('FA21-BSE-012','bse-4a','CSC103',5000),('FA21-BSE-012','bse-4b','CSC103',5000),('FA21-BSE-012','bse-4b','CSC209',5001),('FA21-PHM-098','phm-4b','PHM118',5008);
/*!40000 ALTER TABLE `student_class` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES ('FA21-BSE-001','Aashan Khan Swati','Ashiq Hussain','2002-07-21','13503-4884164-1','3229209300','aashan@gmail.com'),('FA21-BSE-002','Abdul Moeed','Muhammad Jamil','2002-07-22','17301-0392400-5','3124262378','moeed@gmail.com'),('FA21-BSE-004','Abdullah','Habib ur Rehman','2002-07-22','13503-0371711-1','3460011412','abdullah@gmail.com'),('FA21-BSE-006','Adnan Ahmad','Zulfiqar Ali','2002-07-21','61101-0313784-9','3482220851','adnan@gmail.com'),('FA21-BSE-007','Aizaz Ullah','Jamal Khalid','2002-07-21','13101-0429138-9','3488972921','aizazullah@gmail.com'),('FA21-BSE-008','Aleena Farooq','Muhammad Farooq','2002-07-21','37405-4470637-6','3184041138','aleena@gmail.com'),('FA21-BSE-009','Arbab Arif','Muhammad Arif','2002-07-21','13503-7913325-9','3449526544','arbab@gmail.com'),('FA21-BSE-010','Ehtasham Anwar','Muhammad Anwar','2002-07-21','13101-7658061-5','3489851338','ehtasham@gmail.com'),('FA21-BSE-011','Faizan','Murad Ali','2002-07-21','16202-6378857-3','3118108409','faizanswabi95@gmail.com'),('FA21-BSE-012','Fawad Iqbal','Saleem Akbar','2002-07-21','15101-4926678-7','3149972883','fawad@gmail.com'),('FA21-BSE-013','Hanif-Ud-Din','Anees-Ud-Din','2002-07-23','17101-5754694-1','3118263453','hanif@gmail.com'),('FA21-BSE-014','Haseeb Ahmad','Shahid Aziz','2003-07-23','13101-6829150-5','3115417754','haseebahmad@gmail.com'),('FA21-BSE-015','Hazla Nouman','Muhammad Nazir','2003-07-23','13101-8477046-9','3410488166','hanzlanouman@gmail.com'),('FA21-BSE-017','Izma Waheed','Abdul Waheed','2002-07-23','37101-2918482-0','3043620150','izmawaheed@gmail.com'),('FA21-BSE-018','Khurram Shehzad','Shahzada Khan','2002-07-23','71502-4272067-1','3495626512','khurramshehzad@gmail.com'),('FA21-BSE-019','Laiba Binta Tahir','Tahir Majeed','2002-07-23','37401-6976899-0','3365613777','laibabintatahir@gmail.com'),('FA21-BSE-020','Mahnoor Qazi','Qazi Imtiaz Khan','2002-07-23','13101-7458350-6','3108866810','mahnoorqazi@gmail.com'),('FA21-BSE-021','Mudassir Ahmed','Sarfraz Khan','2002-07-23','13101-9010788-9','3335052025','mudassirahmad@gmail.com'),('FA21-BSE-022','Muhammad Akram khan','Muhammad Asghar khan','2002-07-23','17301-5336450-7','3335884432','muhammadakram@gmail.com'),('FA21-BSE-024','Osman Ghani Granday','Aziz-U-Rehman Safi','2002-07-23','16528-1234568-5','788173891','osmanghani@gmail.com'),('FA21-BSE-025','Muhammad Asim','Anwar Bahadar','2002-07-23','16202-5816453-7','3448385773','masim@gmail.com'),('FA21-BSE-026','Muhammad Haris Ali','Riyasat Ali','2002-07-23','34202-1392193-9','3135849574','harisali@gmail.com'),('FA21-BSE-027','Muhammad Irfan','Ali Noor','2002-07-23','14301-5652377-5','3358419837','mirfan@gmail.com'),('FA21-BSE-028','Muhammad Masood Khan','Muhammad Mustajab Khan','2002-07-23','17201-6533140-7','3110365141','masoodkhan@gmail.com'),('FA21-BSE-030','Muhammad Saif','Imran Iqbal','2002-07-23','13101-8022513-9','3049575551','msaif@gmail.com'),('FA21-BSE-031','Muhammad Salar Khan','Ihsan Ullah','2002-07-23','11201-0419378-5','3138689890','salarkhan@gmail.com'),('FA21-BSE-032','Muhammad Sami khan','Muhammad Atif khan','2023-07-23','16101-4785923-7','3133003503','samikhan@gmail.com'),('FA21-BSE-033','Saud Khan','Ghani Rehman Bacha','2002-06-23','15402-8060501-3','3498883988','saudkhan@gmail.com'),('FA21-BSE-034','Shahzaib','Sher Akhtar','2002-06-23','38101-8322175-7','3401707501','shahzaib@gmail.com'),('FA21-BSE-035','ADAN SAJJAD','SAJJAD KASHIF','2002-06-23','31303-4990715-3','3136661158','adansajjad@gmail.com'),('FA21-BSE-036','Sofia Aamir','Muhammad Aamir','2002-06-23','17101-5679540-2','3316488177','sofiaamir@gmail.com'),('FA21-BSE-037','Taha Zaman','Muhammad Rizwan Uz Zaman','2002-06-23','42101-0282733-7','3340546342','tahazaman@gmail.com'),('FA21-BSE-038','Um-e-Aimen','Nisar Ahmed Anjum','2002-06-23','37404-9592469-6','3429840779','umeaiman@gmail.com'),('FA21-BSE-039','Uzair Ahmed','Sakhi Ur Rehman','2002-06-23','13101-8897527-5','3175760126','uzairahmed@gmail.com'),('FA21-BSE-040','Waqas','Raja Abdul Ghaffar','2002-06-23','13101-7327181-9','3184105568','waqas@gmail.com'),('FA21-BSE-041','Muhammad Yaman Hussain','Iftikhar Hussain Hashmi','2002-06-23','16202-8922015-7','3149213060','yamanhusain@gmail.com'),('FA21-PHM-098','Mansoor Ahmad','Sher Wali Khan','2002-09-10','15103-0371408-7','0310-8695145','mansoor@yahoo.com');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
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
  CONSTRAINT `fk_teacher_course_Courses1` FOREIGN KEY (`Courses_course_code`) REFERENCES `courses` (`course_code`),
  CONSTRAINT `fk_teacher_course_Teachers1` FOREIGN KEY (`Teachers_teacher_id`) REFERENCES `teachers` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_course`
--

LOCK TABLES `teacher_course` WRITE;
/*!40000 ALTER TABLE `teacher_course` DISABLE KEYS */;
INSERT INTO `teacher_course` VALUES ('CS207',5000),('CSC103',5000),('CSC209',5001),('CS207',5005),('MTH205',5006),('CSC219',5007),('PHM118',5008);
/*!40000 ALTER TABLE `teacher_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `teacherclassview`
--

DROP TABLE IF EXISTS `teacherclassview`;
/*!50001 DROP VIEW IF EXISTS `teacherclassview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `teacherclassview` AS SELECT 
 1 AS `teacher_id`,
 1 AS `teacher_name`,
 1 AS `class_id`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `teachercourseview`
--

DROP TABLE IF EXISTS `teachercourseview`;
/*!50001 DROP VIEW IF EXISTS `teachercourseview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `teachercourseview` AS SELECT 
 1 AS `teacher_id`,
 1 AS `teacher_name`,
 1 AS `Courses_course_code`,
 1 AS `course_name`,
 1 AS `credit_hours`*/;
SET character_set_client = @saved_cs_client;

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
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES (5000,'Sana Malik','1234567890','sana_malik@cuiatd.edu.pk'),(5001,'Muhktiar Zamin','0987654321','mukhtiarzamin@cuiatd.edu.pk'),(5002,'Zia Ul Wahid','0987654321','ziaulwahid@cuiatd.edu.pk'),(5003,'Saira Bhatti','1234567890','sairabhatti@cuiatd.edu.pk'),(5004,'Waqas Jadoon','1234554321','waqasjadoon@cuiatd.edu.pk'),(5005,'Dr. Rab Nawaz Jadoon','01112225558','rabnawazjadoon@cuiatd.edu.pk'),(5006,'Usman Ashraf','123456789','usmanashraf@cuiatd.edu.pk'),(5007,'Muhammad Ali','1234567890','muhammadali@cuiatd.edu.pk'),(5008,'Dr. Nabi Shah','123456789','nabishah@cuiatd.edu.pk');
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timetable`
--

DROP TABLE IF EXISTS `timetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timetable` (
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
-- Dumping data for table `timetable`
--

LOCK TABLES `timetable` WRITE;
/*!40000 ALTER TABLE `timetable` DISABLE KEYS */;
/*!40000 ALTER TABLE `timetable` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('aashan@gmail.com','root','student'),('abdullah@gmail.com','root','student'),('abdullahludin@gmail.com','root','student'),('adansajjad@gmail.com','root','student'),('adnan@gmail.com','root','student'),('aizazullah@gmail.com','root','student'),('aleena@gmail.com','root','student'),('arbab@gmail.com','root','student'),('asadrauf@gmail.com','root','student'),('ehtasham@gmail.com','root','student'),('faizan@gmail.com','root','student'),('faizanswabi95@gmail.com','root','student'),('fawad@gmail.com','root','student'),('fawadeqbal@yahoo.com','root','admin'),('hanif@gmail.com','root','student'),('hanzlanouman@gmail.com','root','student'),('harisali@gmail.com','root','student'),('haseebahmad@gmail.com','root','student'),('idrees447701@gmail.com','root','student'),('izmawaheed@gmail.com','root','student'),('khurramshehzad@gmail.com','root','student'),('laibabintatahir@gmail.com','root','student'),('mahnoorqazi@gmail.com','root','student'),('mansoor@yahoo.com','1234','student'),('masim@gmail.com','root','student'),('masoodkhan@gmail.com','root','student'),('mirfan@gmail.com','root','student'),('moeed@gmail.com','root','student'),('msaif@gmail.com','root','student'),('mudassirahmad@gmail.com','root','student'),('muhammadakram@gmail.com','root','student'),('muhammadali@cuiatd.edu.pk','root','faculty'),('mukhtiarzamin@cuiatd.edu.pk','root','faculty'),('nabishah@cuiatd.edu.pk','root','faculty'),('osmanghani@gmail.com','root','student'),('rabnawazjadoon@cuiatd.edu.pk','root','faculty'),('rahmanali@gmail.com','root','student'),('saadhaidri@gmail.com','root','student'),('sairabhatti@cuiatd.edu.pk','root','faculty'),('salarkhan@gmail.com','root','student'),('samikhan@gmail.com','root','student'),('sana_malik@cuiatd.edu.pk','root','faculty'),('saudkhan@gmail.com','root','student'),('shahzaib@gmail.com','root','student'),('sofiaamir@gmail.com','root','student'),('tahazaman@gmail.com','root','student'),('umeaiman@gmail.com','root','student'),('usmanashraf@cuiatd.edu.pk','root','faculty'),('uzairahmed@gmail.com','root','student'),('waqas@gmail.com','root','student'),('waqasjadoon@cuiatd.edu.pk','root','faculty'),('yamanhusain@gmail.com','root','student'),('ziaulwahid@cuiatd.edu.pk','root','faculty');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Final view structure for view `courseview`
--

/*!50001 DROP VIEW IF EXISTS `courseview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `courseview` AS select `co`.`course_code` AS `course_code`,`co`.`course_name` AS `course_name` from (((`class` `c` join `teacher_course` `tc` on(((`c`.`teacher_course_Courses_course_code` = `tc`.`Courses_course_code`) and (`c`.`teacher_course_Teachers_teacher_id` = `tc`.`Teachers_teacher_id`)))) join `teachers` `t` on((`tc`.`Teachers_teacher_id` = `t`.`teacher_id`))) join `courses` `co` on((`tc`.`Courses_course_code` = `co`.`course_code`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `teacherclassview`
--

/*!50001 DROP VIEW IF EXISTS `teacherclassview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `teacherclassview` AS select `tc`.`Teachers_teacher_id` AS `teacher_id`,`t`.`teacher_name` AS `teacher_name`,`c`.`class_id` AS `class_id` from ((`teacher_course` `tc` join `teachers` `t` on((`tc`.`Teachers_teacher_id` = `t`.`teacher_id`))) join `class` `c` on(((`tc`.`Courses_course_code` = `c`.`teacher_course_Courses_course_code`) and (`tc`.`Teachers_teacher_id` = `c`.`teacher_course_Teachers_teacher_id`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `teachercourseview`
--

/*!50001 DROP VIEW IF EXISTS `teachercourseview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `teachercourseview` AS select `t`.`teacher_id` AS `teacher_id`,`t`.`teacher_name` AS `teacher_name`,`c`.`course_code` AS `Courses_course_code`,`c`.`course_name` AS `course_name`,`c`.`credit_hours` AS `credit_hours` from ((`teacher_course` `tc` join `teachers` `t` on((`tc`.`Teachers_teacher_id` = `t`.`teacher_id`))) join `courses` `c` on((`tc`.`Courses_course_code` = `c`.`course_code`))) */;
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

-- Dump completed on 2023-07-23  8:20:16
