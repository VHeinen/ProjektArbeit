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
-- Table structure for table `pupil`
--

DROP TABLE IF EXISTS `pupil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pupil` (
  `id` int NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `classID` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `classID_idx` (`classID`),
  CONSTRAINT `classID` FOREIGN KEY (`classID`) REFERENCES `schoolclass` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pupil`
--

LOCK TABLES `pupil` WRITE;
/*!40000 ALTER TABLE `pupil` DISABLE KEYS */;
INSERT INTO `pupil` VALUES (0,'Test','Test',0),(1,'Hans','Olaf',2),(2,'Irene','Palm',0),(3,'Harald','Wurst',2),(4,'Java','Itzz',1),(5,'Jason','Wald',1),(6,'Franz','Erhardt',3),(7,'Jessica','Nutella',3),(8,'Petra','Potsdamm',1),(9,'Günther','Udo',1),(10,'Popo','Lala',3),(11,'Olaf','Snowman',2),(12,'Que','Nyguen',1),(13,'Exe','NotFound',2),(14,'Saskia','Schwarz',3),(15,'Jonas','Johann',1),(16,'Karsten','Key',2),(17,'Lilly','Lama',3),(18,'Bernhard','Bob',1),(19,'Willy','Braun',3),(20,'Lara','Udo',1),(21,'Anna','Blatt',2),(22,'Gutfried','Hye',2),(23,'Zorro','Zahn',3),(24,'Yuuki','Hanabi',1),(25,'Bernd','Hard',2);
/*!40000 ALTER TABLE `pupil` ENABLE KEYS */;
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
