-- MySQL dump 10.13  Distrib 8.0.33
--
-- Host: localhost    Database: attendance_system
-- ------------------------------------------------------
-- Server version	8.0.33



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
-- Table structure for table `student_has_course`
--

DROP TABLE IF EXISTS `student_has_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_has_course` (
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
-- Dumping data for table `student_has_course`
--

LOCK TABLES `student_has_course` WRITE;
/*!40000 ALTER TABLE `student_has_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_has_course` ENABLE KEYS */;
UNLOCK TABLES;


-- Dump completed on 2023-06-06 21:43:20
