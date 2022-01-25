-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: workshop_jpa
-- ------------------------------------------------------
-- Server version	5.7.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `lesson_information_entity`
--

DROP TABLE IF EXISTS `lesson_information_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson_information_entity` (
                                             `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                             `name` varchar(80) NOT NULL,
                                             `teacher_name` varchar(160) NOT NULL,
                                             `weekly_hour` int(11) NOT NULL,
                                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson_information_entity`
--

LOCK TABLES `lesson_information_entity` WRITE;
/*!40000 ALTER TABLE `lesson_information_entity` DISABLE KEYS */;
INSERT INTO `lesson_information_entity` VALUES (1,'Math','Danyal Topatan',5),(2,'Music','Nebahat Gülses',5);
/*!40000 ALTER TABLE `lesson_information_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_information_entity`
--

DROP TABLE IF EXISTS `student_information_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_information_entity` (
                                              `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                              `mail_address` varchar(160) NOT NULL,
                                              `name` varchar(80) NOT NULL,
                                              `surname` varchar(80) NOT NULL,
                                              `studentParentEntity_id` bigint(20) DEFAULT NULL,
                                              PRIMARY KEY (`id`),
                                              KEY `FKlsxlft2d26psvjx954744yagw` (`studentParentEntity_id`),
                                              CONSTRAINT `FKlsxlft2d26psvjx954744yagw` FOREIGN KEY (`studentParentEntity_id`) REFERENCES `student_parent_entity` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_information_entity`
--

LOCK TABLES `student_information_entity` WRITE;
/*!40000 ALTER TABLE `student_information_entity` DISABLE KEYS */;
INSERT INTO `student_information_entity` VALUES (1,'student@mail.com','John','Deer',1),(2,'studentmany@mail.com','Second Student','Many',NULL);
/*!40000 ALTER TABLE `student_information_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_lessons`
--

DROP TABLE IF EXISTS `student_lessons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_lessons` (
                                   `student_id` bigint(20) NOT NULL,
                                   `lesson_id` bigint(20) NOT NULL,
                                   KEY `FKnsqesdtlfeqfl9ucoq8oedl1e` (`lesson_id`),
                                   KEY `FKrk7binpfhybmg103ened7nms2` (`student_id`),
                                   CONSTRAINT `FKnsqesdtlfeqfl9ucoq8oedl1e` FOREIGN KEY (`lesson_id`) REFERENCES `lesson_information_entity` (`id`),
                                   CONSTRAINT `FKrk7binpfhybmg103ened7nms2` FOREIGN KEY (`student_id`) REFERENCES `student_information_entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_lessons`
--

LOCK TABLES `student_lessons` WRITE;
/*!40000 ALTER TABLE `student_lessons` DISABLE KEYS */;
INSERT INTO `student_lessons` VALUES (1,1),(1,2),(2,1),(2,2);
/*!40000 ALTER TABLE `student_lessons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_parent_entity`
--

DROP TABLE IF EXISTS `student_parent_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_parent_entity` (
                                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                         `mail_address` varchar(160) NOT NULL,
                                         `name` varchar(80) NOT NULL,
                                         `surname` varchar(80) NOT NULL,
                                         `studentInformation_id` bigint(20) DEFAULT NULL,
                                         PRIMARY KEY (`id`),
                                         KEY `FKsr8op11pfwrxe17tdy9jvrk8w` (`studentInformation_id`),
                                         CONSTRAINT `FKsr8op11pfwrxe17tdy9jvrk8w` FOREIGN KEY (`studentInformation_id`) REFERENCES `student_information_entity` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_parent_entity`
--

LOCK TABLES `student_parent_entity` WRITE;
/*!40000 ALTER TABLE `student_parent_entity` DISABLE KEYS */;
INSERT INTO `student_parent_entity` VALUES (1,'parent@mail.com','Parent Name','Parent Surname',1);
/*!40000 ALTER TABLE `student_parent_entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'workshop_jpa'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-14 21:59:26
