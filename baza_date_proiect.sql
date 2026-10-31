-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: colocviu
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `intrebare`
--

DROP TABLE IF EXISTS `intrebare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `intrebare` (
  `id_i` int NOT NULL,
  `intrebare` varchar(500) NOT NULL,
  `poza` varchar(255) DEFAULT NULL,
  `sectiune` varchar(255) NOT NULL,
  `categoria` varchar(255) NOT NULL,
  PRIMARY KEY (`id_i`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `intrebare`
--

LOCK TABLES `intrebare` WRITE;
/*!40000 ALTER TABLE `intrebare` DISABLE KEYS */;
INSERT INTO `intrebare` VALUES (1,'Poți depăși pe linie continuă?','linie_continua.jpg','Depășire','B'),(2,'Viteza maximă admisă în localitate este?','viteza.jpg','Viteză','B'),(3,'Distanța de siguranță față de vehiculul din față?',NULL,'Siguranță','B'),(4,'Este permisă oprirea pe trecerea de pietoni?','trecere_pietoni.jpg','Oprire','B'),(5,'Semnificația semnului Stop?','stop.jpg','Semnalizare','B'),(6,'Când trebuie să folosești luminile de avarie?',NULL,'Semnalizare','B');
/*!40000 ALTER TABLE `intrebare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `raspuns`
--

DROP TABLE IF EXISTS `raspuns`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `raspuns` (
  `id_i` int NOT NULL,
  `id_r` char(1) NOT NULL,
  `raspuns` varchar(255) NOT NULL,
  `corect` varchar(255) NOT NULL,
  PRIMARY KEY (`id_i`,`id_r`),
  CONSTRAINT `raspuns_ibfk_1` FOREIGN KEY (`id_i`) REFERENCES `intrebare` (`id_i`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `raspuns`
--

LOCK TABLES `raspuns` WRITE;
/*!40000 ALTER TABLE `raspuns` DISABLE KEYS */;
INSERT INTO `raspuns` VALUES (1,'a','Da, dacă e urgent','N'),(1,'b','Nu, niciodată','D'),(1,'c','Da, dacă e liber','N'),(1,'d','Doar pe autostradă','N'),(2,'a','30 km/h','N'),(2,'b','50 km/h','D'),(2,'c','70 km/h','N'),(2,'d','90 km/h','N'),(3,'a','Minim 1 metru','N'),(3,'b','Minim 2 secunde','D'),(3,'c','Minim 5 metri','N'),(3,'d','Nu există regulă','N'),(4,'a','Da, dacă e urgent','N'),(4,'b','Nu, niciodată','D'),(4,'c','Da, dacă e liber','N'),(4,'d','Da, pentru maxim 1 minut','N'),(5,'a','Oprire obligatorie','D'),(5,'b','Cedeză trecerea','N'),(5,'c','Viteză redusă','N'),(5,'d','Atenție','N'),(6,'a','Când plouă','N'),(6,'b','Când ești în pană','D'),(6,'c','Când parchezi','N'),(6,'d','Când e noapte','N');
/*!40000 ALTER TABLE `raspuns` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `raspuns_test`
--

DROP TABLE IF EXISTS `raspuns_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `raspuns_test` (
  `id_t` int NOT NULL,
  `id_i` int NOT NULL,
  `id_r` char(1) NOT NULL,
  `corect` varchar(255) NOT NULL,
  PRIMARY KEY (`id_t`,`id_i`,`id_r`),
  KEY `id_i` (`id_i`,`id_r`),
  CONSTRAINT `raspuns_test_ibfk_1` FOREIGN KEY (`id_t`, `id_i`) REFERENCES `test` (`id_t`, `id_i`) ON DELETE CASCADE,
  CONSTRAINT `raspuns_test_ibfk_2` FOREIGN KEY (`id_i`, `id_r`) REFERENCES `raspuns` (`id_i`, `id_r`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `raspuns_test`
--

LOCK TABLES `raspuns_test` WRITE;
/*!40000 ALTER TABLE `raspuns_test` DISABLE KEYS */;
INSERT INTO `raspuns_test` VALUES (1,1,'b','D'),(1,2,'b','D'),(1,3,'a','D'),(1,4,'b','D'),(2,1,'a','D'),(2,4,'b','D'),(2,5,'a','D'),(3,2,'c','D'),(3,3,'b','D'),(3,4,'a','D'),(3,5,'a','D'),(3,6,'b','D');
/*!40000 ALTER TABLE `raspuns_test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8sewwnpamngi6b1dwaa88askk` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test` (
  `id_t` int NOT NULL,
  `id_i` int NOT NULL,
  `data_test` date NOT NULL,
  `punctaj_obtinut` int NOT NULL,
  PRIMARY KEY (`id_t`,`id_i`),
  KEY `id_i` (`id_i`),
  CONSTRAINT `test_ibfk_1` FOREIGN KEY (`id_i`) REFERENCES `intrebare` (`id_i`) ON DELETE CASCADE,
  CONSTRAINT `test_chk_1` CHECK ((`punctaj_obtinut` in (0,1)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,1,'2025-11-20',1),(1,2,'2025-11-20',1),(1,3,'2025-11-20',0),(1,4,'2025-11-20',1),(2,1,'2025-11-21',0),(2,4,'2025-11-21',1),(2,5,'2025-11-21',1),(3,2,'2025-11-22',0),(3,3,'2025-11-22',1),(3,4,'2025-11-22',0),(3,5,'2025-11-22',1),(3,6,'2025-11-22',1),(4,1,'2025-02-10',1),(4,2,'2025-02-10',0),(4,3,'2025-02-10',1),(100,1,'2025-03-20',1),(101,2,'2025-05-15',1),(102,3,'2025-06-01',0);
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `time_stamp` datetime(6) NOT NULL,
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  KEY `FK4qu1gr772nnf6ve5af002rwya` (`role_id`),
  CONSTRAINT `FK4qu1gr772nnf6ve5af002rwya` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-14  0:11:29
