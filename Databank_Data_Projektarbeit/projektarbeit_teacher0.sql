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
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` int NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `firstSubjectID` int NOT NULL,
  `secondSubjectID` int NOT NULL,
  `thirdSubjectID` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `firstSubjectID_idx` (`firstSubjectID`),
  KEY `secondSubjectID_idx` (`secondSubjectID`),
  KEY `thirdSubjectID_idx` (`thirdSubjectID`),
  CONSTRAINT `firstSubjectID` FOREIGN KEY (`firstSubjectID`) REFERENCES `subject` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `secondSubjectID` FOREIGN KEY (`secondSubjectID`) REFERENCES `subject` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `thirdSubjectID` FOREIGN KEY (`thirdSubjectID`) REFERENCES `subject` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (0,'Test','Test',0,0,0),(1,'Tara','Thom',0,2,3),(2,'Tom','Tree',5,2,0),(3,'Ken','Kaneki',1,2,0),(4,'Hans','Baum',5,3,10),(5,'Peter','Müller',10,8,3),(6,'Johanna','Tee',4,8,20),(7,'Beate','Klaus',20,19,1),(8,'Angelika','Raute',1,2,3),(9,'Florian','Edgar',1,4,7),(10,'Jürgen','Blub',12,13,15);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-07 14:14:09
