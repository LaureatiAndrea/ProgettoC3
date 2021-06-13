-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: c3
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `clienti`
--

DROP TABLE IF EXISTS `clienti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clienti` (
  `id` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `indirizzo` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clienti`
--

LOCK TABLES `clienti` WRITE;
/*!40000 ALTER TABLE `clienti` DISABLE KEYS */;
INSERT INTO `clienti` VALUES (1,'Andrea','Laureati ','Via Caserma Guelfa 7','cliente','password'),(2,'Marco','Gaetani','Via Po 122','marcogae','password'),(3,'Francesco','Amadio','Via Casolare Rotto 13','francamadio','password'),(4,'Cristiano','Massi','Via Del Mare 12/A','crimassi','password'),(5,'Fabio','Rastelli','Via Dei Mille 102','fabrastelli','password'),(6,'Roberto','Travaglini','Via Falcone 4','robtravaglini','password'),(7,'Marco','Metodone','Piazza Carlo Magno','marcone','password');
/*!40000 ALTER TABLE `clienti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commercianti`
--

DROP TABLE IF EXISTS `commercianti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commercianti` (
  `id` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `partitaiva` varchar(11) NOT NULL,
  `idNegozio` int NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commercianti`
--

LOCK TABLES `commercianti` WRITE;
/*!40000 ALTER TABLE `commercianti` DISABLE KEYS */;
INSERT INTO `commercianti` VALUES (1,'Alberto','Rossi','88764438909',5,'commerciante','password'),(2,'Roberto','Verdi','76685990943',4,'robertoverdi','password'),(3,'Marco','Giallone','18293872834',1,'marcogiallone','password'),(4,'Patrizio','Bluetto','10299382764',2,'patriziobluetto','password'),(5,'Fabrizio','Verdone','10098009823',3,'fabrizioverdone','password'),(6,'Paolo','Creti','19889348555',6,'paolocreti','password'),(7,'Flavio','Palmioli','27738740989',7,'flaviopalmioli','password'),(8,'Tiziano','Polloni','28837465653',8,'tizianopolloni','password'),(9,'Primo','Leviano','12223123256',9,'primoleviano','password'),(10,'Gennaro','Scognamiglio','09895847321',10,'gennaroscogna','password');
/*!40000 ALTER TABLE `commercianti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corrieri`
--

DROP TABLE IF EXISTS `corrieri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `corrieri` (
  `id` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `stato` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corrieri`
--

LOCK TABLES `corrieri` WRITE;
/*!40000 ALTER TABLE `corrieri` DISABLE KEYS */;
INSERT INTO `corrieri` VALUES (1,'Patrizio','Ambrosi','DISPONIBILE','corriere','password'),(2,'Fabio','Petrelli','NON_DISPONIBILE','fabpetrelli','password'),(3,'Marco','Fenati','DISPONIBILE','marcofenati','password'),(4,'Paolo','Loreti','NON_DISPONIBILE','paoloreti','password'),(5,'Fabrizio','Clementi','DISPONIBILE','fabclementi','password'),(6,'Luca ','Ardo','DISPONIBILE','lucaardo','password'),(7,'Giacomo','Giobbi','NON_DISPONIBILE','giacomogiobbi','password'),(8,'Fabio','Maizzi','DISPONIBILE','fabiomaizzi','password');
/*!40000 ALTER TABLE `corrieri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `impiegati`
--

DROP TABLE IF EXISTS `impiegati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `impiegati` (
  `id` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `impiegati`
--

LOCK TABLES `impiegati` WRITE;
/*!40000 ALTER TABLE `impiegati` DISABLE KEYS */;
INSERT INTO `impiegati` VALUES (1,'Stefano','Damiani','impiegato','password'),(2,'Mario','Valeri','mariovaleri','password'),(3,'Davide','Torquati','davitorquati','password'),(4,'Giulio','Colacioppo','gcolacioppo','password'),(5,'Marco','Maizzi','marcomaizzi','password'),(6,'Cesare','Folognini','cesarefolo','password'),(7,'Quinto','Piunti','quintopiu','password'),(8,'Fabio','Petrelli','fabiopetrelli','password'),(9,'Carlo','Antonini','carloantonini','password'),(10,'Fabiano','Blaterone','fabianoblate','password');
/*!40000 ALTER TABLE `impiegati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `magazzini`
--

DROP TABLE IF EXISTS `magazzini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `magazzini` (
  `id` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `indirizzo` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `magazzini`
--

LOCK TABLES `magazzini` WRITE;
/*!40000 ALTER TABLE `magazzini` DISABLE KEYS */;
INSERT INTO `magazzini` VALUES (-1,'null','null'),(1,'Magazzino \"Il Punto di Ritiro\"','Via Lorenzo Martire 12'),(2,'Magazzino \"Parco Sempione\"','Via Barbara Vianello 55'),(3,'Magazzino \"Maggioni\"','Via Del Cartellino 4'),(4,'Magazzino \"Molo Sud\"','Via dei Laureati 5/B'),(5,'Magazzino \"Parco Eleonora\"','Piazza Falaschetti 77');
/*!40000 ALTER TABLE `magazzini` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `negozi`
--

DROP TABLE IF EXISTS `negozi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `negozi` (
  `id` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `indirizzo` varchar(45) NOT NULL,
  `categoria` varchar(45) NOT NULL,
  `idImpiegato` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `idImpiegato_idx` (`idImpiegato`),
  CONSTRAINT `idImpiegato` FOREIGN KEY (`idImpiegato`) REFERENCES `impiegati` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `negozi`
--

LOCK TABLES `negozi` WRITE;
/*!40000 ALTER TABLE `negozi` DISABLE KEYS */;
INSERT INTO `negozi` VALUES (1,'Bottega di Paola','Via Mattei 12','ALIMENTARI',2),(2,'Conad','Via Martiri 4','ALIMENTARI',4),(3,'Terranova','Via Clerici 2','ABBIGLIAMENTO',1),(4,'SuperTech','Via Pasubio 9','ELETTRONICA',5),(5,'EvolutionPC','Via Ciabbo 46/A','ELETTRONICA',3),(6,'Oviesse','Via Caserma 4','ABBIGLIAMENTO',6),(7,'MondoCarta','Via Boldi 22','CANCELLERIA',7),(8,'Buffetti','Via Rossi 11/F','CANCELLERIA',8),(9,'Libraccio','Via Po 66','LIBRI',9),(10,'Feltrinelli','Via Plettro 12/B','LIBRI',10);
/*!40000 ALTER TABLE `negozi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordini`
--

DROP TABLE IF EXISTS `ordini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordini` (
  `id` int NOT NULL,
  `destinazione` varchar(45) DEFAULT NULL,
  `note` varchar(45) DEFAULT NULL,
  `statoOrdine` varchar(45) NOT NULL,
  `idCliente` int NOT NULL,
  `idNegozio` int NOT NULL,
  `idCorriere` int NOT NULL,
  `idMagazzino` int DEFAULT NULL,
  `codiceRitiro` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCliente_idx` (`idCliente`),
  KEY `idMagazzino_idx` (`idMagazzino`),
  KEY `idNegozio_idx` (`idNegozio`),
  KEY `idCorriere_idx` (`idCorriere`),
  CONSTRAINT `idCliente` FOREIGN KEY (`idCliente`) REFERENCES `clienti` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idCorriere` FOREIGN KEY (`idCorriere`) REFERENCES `corrieri` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idMagazzino` FOREIGN KEY (`idMagazzino`) REFERENCES `magazzini` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idNegozio` FOREIGN KEY (`idNegozio`) REFERENCES `negozi` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordini`
--

LOCK TABLES `ordini` WRITE;
/*!40000 ALTER TABLE `ordini` DISABLE KEYS */;
INSERT INTO `ordini` VALUES (1,NULL,'Attenzione, FRAGILE','IN_NEGOZIO',1,3,6,1,9493),(2,NULL,'','TRASPORTO_IN_CORSO',2,3,8,5,290),(3,NULL,'','CONSEGNATO_AL_CLIENTE',3,3,3,2,1439),(4,'Via Caserma Guelfa 8','Consegna al piano 4','DEPOSITATO_IN_MAGAZZINO',4,3,3,-1,6),(5,'Via Del Banano 44','','IN_NEGOZIO',7,3,6,-1,6019),(6,NULL,'','DEPOSITATO_IN_MAGAZZINO',5,1,5,2,8003),(7,NULL,'','DEPOSITATO_IN_MAGAZZINO',5,1,3,4,1063),(8,'Piazza Marco Polo 1','','IN_NEGOZIO',1,5,5,-1,7326),(9,NULL,'','CONSEGNATO_AL_CLIENTE',1,5,8,2,1395),(10,NULL,'','TRASPORTO_IN_CORSO',6,5,3,2,6796),(11,NULL,'','IN_NEGOZIO',1,2,5,4,7249),(12,'Via del Cielo 122','','DEPOSITATO_IN_MAGAZZINO',7,2,5,-1,5908),(13,NULL,'','IN_NEGOZIO',1,4,3,4,151),(14,'Via Flambe 523','','IN_NEGOZIO',1,4,3,-1,9047),(15,NULL,'','DEPOSITATO_IN_MAGAZZINO',4,4,8,1,8574),(16,NULL,'','CONSEGNATO_AL_CLIENTE',1,6,6,1,8540),(17,NULL,'','TRASPORTO_IN_CORSO',1,6,1,5,6791),(18,NULL,'','TRASPORTO_IN_CORSO',1,7,1,4,9581),(19,NULL,'','IN_NEGOZIO',1,7,3,4,7340),(20,NULL,'','DEPOSITATO_IN_MAGAZZINO',6,7,3,5,6315),(21,'Piazza Clementini 122','Consegna tra le 12 e le 15','IN_NEGOZIO',1,8,5,-1,1897),(22,'Via del Guado 1','','IN_NEGOZIO',1,9,3,-1,8522),(23,NULL,'','DEPOSITATO_IN_MAGAZZINO',4,9,3,4,8077),(24,NULL,'','IN_NEGOZIO',1,10,3,2,3601),(25,NULL,'','IN_NEGOZIO',1,10,8,1,636),(26,NULL,'','IN_NEGOZIO',3,10,3,3,6074),(27,NULL,'','IN_NEGOZIO',7,10,3,4,9022),(28,NULL,'','DEPOSITATO_IN_MAGAZZINO',1,3,1,1,9244),(29,NULL,'','DEPOSITATO_IN_MAGAZZINO',5,1,1,3,6776),(30,NULL,'','IN_NEGOZIO',4,1,1,5,7712),(31,NULL,'','DEPOSITATO_IN_MAGAZZINO',4,8,1,2,4799),(32,NULL,'','DEPOSITATO_IN_MAGAZZINO',7,8,1,2,3605),(33,NULL,'','DEPOSITATO_IN_MAGAZZINO',7,7,1,3,4464),(34,NULL,'','TRASPORTO_IN_CORSO',2,7,1,3,204),(35,'Via Tarquinio Prisco 122','Consegna Al Piano 5','CONSEGNATO_AL_CLIENTE',5,10,1,-1,7484),(36,'Via Maltese 5','FRAGILE','CONSEGNATO_AL_CLIENTE',4,10,1,-1,5150);
/*!40000 ALTER TABLE `ordini` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promozioni`
--

DROP TABLE IF EXISTS `promozioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promozioni` (
  `id` int NOT NULL,
  `percentualeSconto` double NOT NULL,
  `promozioneAttiva` tinyint NOT NULL,
  `negozioId` int NOT NULL,
  `note` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `idNegozio_idx` (`negozioId`),
  CONSTRAINT `Negozio` FOREIGN KEY (`negozioId`) REFERENCES `negozi` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promozioni`
--

LOCK TABLES `promozioni` WRITE;
/*!40000 ALTER TABLE `promozioni` DISABLE KEYS */;
INSERT INTO `promozioni` VALUES (1,10,1,5,'10% sul software'),(2,15,1,4,'Su tutto l\' inventario'),(3,20,1,3,'Saldi Estivi !'),(4,10,1,6,'fino al 15 luglio !'),(5,5,1,7,'Sconto sui libri scolastici'),(6,15,1,10,'Sui libri di autori italiani'),(7,3,1,9,'Sconto del 3% sui manga'),(8,12,0,5,'sconto sugli antivirus !'),(9,5,0,5,'5% su tutto l\' usato');
/*!40000 ALTER TABLE `promozioni` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-13 15:43:53
