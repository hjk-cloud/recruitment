-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: recruitment
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_company`
--

DROP TABLE IF EXISTS `t_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_company`
(
    `id`                 bigint NOT NULL,
    `company_name`       varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL,
    `category`           varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL,
    `number_scale`       varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL COMMENT '人数规模',
    `address`            varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL,
    `website`            varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL,
    `company_profile`    varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '企业简介',
    `full_name`          varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL COMMENT '企业全称',
    `credit_code`        char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci     DEFAULT NULL COMMENT '企业信用代码',
    `establish_date`     date                                                          DEFAULT NULL,
    `registered_capital` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL COMMENT '注册资本',
    `verification`       smallint                                                      DEFAULT NULL COMMENT '是否通过审核',
    `create_time`        datetime                                                      DEFAULT NULL,
    `update_time`        datetime                                                      DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_company`
--

LOCK
TABLES `t_company` WRITE;
/*!40000 ALTER TABLE `t_company` DISABLE KEYS */;
INSERT INTO `t_company`
VALUES (0, 'test_842e9d00692c', 'test_7431791608cd', 'test_4d3a6e343d38', 'test_ab4c1ae6f46d', 'test_7503c7fc8bcc',
        'test_e6168440be0d', 'test_08fd7bc271fd', 'test_9a85c5ffb653', '2022-07-29', 'test_996331351841', 1, NULL,
        NULL),
       (1581990422140551168, 'test_842e9d00692c', 'test_7431791608cd', 'test_4d3a6e343d38', 'test_ab4c1ae6f46d',
        'test_7503c7fc8bcc', 'test_e6168440be0d', 'test_08fd7bc271fd', 'test_9a85c5ffb653', '2022-07-29',
        'test_996331351841', 0, NULL, NULL),
       (1581990458278674432, 'test_842e9d00692c', 'test_7431791608cd', 'test_4d3a6e343d38', 'test_ab4c1ae6f46d',
        'test_7503c7fc8bcc', 'test_e6168440be0d', 'test_08fd7bc271fd', 'test_9a85c5ffb653', '2022-07-29',
        'test_996331351841', 0, NULL, NULL),
       (1582295097465241600, 'test_842e9d00692c', 'test_7431791608cd', 'test_4d3a6e343d38', 'test_ab4c1ae6f46d',
        'test_7503c7fc8bcc', 'test_e6168440be0d', 'test_08fd7bc271fd', 'test_9a85c5ffb653', '2022-07-29',
        'test_996331351841', 0, NULL, NULL),
       (1582332054236954624, 'test_842e9d00692c', 'test_7431791608cd', 'test_4d3a6e343d38', 'test_ab4c1ae6f46d',
        'test_7503c7fc8bcc', 'test_e6168440be0d', 'test_08fd7bc271fd', 'test_9a85c5ffb653', '2022-07-29',
        'test_996331351841', 0, NULL, NULL),
       (1582332400048930816, 'test_842e9d00692c', 'test_7431791608cd', 'test_4d3a6e343d38', 'test_ab4c1ae6f46d',
        'test_7503c7fc8bcc', 'test_e6168440be0d', 'test_08fd7bc271fd', 'test_9a85c5ffb653', '2022-07-29',
        'test_996331351841', -1, NULL, NULL),
       (1582332462984462336, 'test_842e9d00692c', 'test_7431791608cd', 'test_4d3a6e343d38', 'test_ab4c1ae6f46d',
        'test_7503c7fc8bcc', 'test_e6168440be0d', 'test_08fd7bc271fd', 'test_9a85c5ffb653', '2022-07-29',
        'test_996331351841', 1, '2022-10-18 19:27:12', '2022-10-18 19:27:12');
/*!40000 ALTER TABLE `t_company` ENABLE KEYS */;
UNLOCK
TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-20 15:32:07
