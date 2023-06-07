-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: projektarbeit
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grade` (
  `id` int NOT NULL,
  `grade` tinyint NOT NULL,
  `weighting` float NOT NULL,
  `type` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `pupilID` int NOT NULL,
  `teacherID` int NOT NULL,
  `subjectID` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pupilID_idx` (`pupilID`),
  KEY `teacherID_idx` (`teacherID`),
  KEY `subjectID_idx` (`subjectID`),
  CONSTRAINT `pupilID` FOREIGN KEY (`pupilID`) REFERENCES `pupil` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `subjectID` FOREIGN KEY (`subjectID`) REFERENCES `subject` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `teacherID` FOREIGN KEY (`teacherID`) REFERENCES `teacher` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (0,1,1,'Klassenarbeit','2025-05-20',0,0,0),(1,5,1.3,'Test','2023-05-25',0,0,0),(2,6,2,'Test','2023-05-08',12,4,3),(3,1,20,'Klassenarbeit','2023-05-25',7,6,1),(4,3,4,'Präsi','2023-02-24',1,2,6),(5,4,8,'Test','2023-03-12',8,8,8),(6,2,15,'Aufgaben Abgabe','2023-01-04',20,10,4);
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-07 14:12:12
