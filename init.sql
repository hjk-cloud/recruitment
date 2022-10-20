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
-- Table structure for table `t_admin`
--

DROP TABLE IF EXISTS `t_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_admin`
(
    `id`             bigint      NOT NULL,
    `admin_name`     varchar(10) NOT NULL,
    `admin_password` varchar(10) NOT NULL,
    `create_time`    datetime DEFAULT NULL,
    `update_time`    datetime DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin`
--

LOCK
TABLES `t_admin` WRITE;
/*!40000 ALTER TABLE `t_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_admin` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `t_candidate`
--

DROP TABLE IF EXISTS `t_candidate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_candidate`
(
    `id`                 bigint NOT NULL,
    `candidate_name`     varchar(4)  DEFAULT NULL,
    `candidate_password` varchar(10) DEFAULT NULL,
    `candidate_phone`    varchar(11) DEFAULT NULL,
    `sex`                tinyint     DEFAULT NULL,
    `birth_date`         varchar(7)  DEFAULT NULL,
    `city`               varchar(4)  DEFAULT NULL,
    `job_status`         varchar(4)  DEFAULT NULL,
    `education`          varchar(2)  DEFAULT NULL,
    `school`             varchar(10) DEFAULT NULL,
    `expect_salary`      varchar(10) DEFAULT NULL,
    `attachment`         text COMMENT '附件路径',
    `create_time`        datetime    DEFAULT NULL,
    `update_time`        datetime    DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_candidate`
--

LOCK
TABLES `t_candidate` WRITE;
/*!40000 ALTER TABLE `t_candidate` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_candidate` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `t_candidate_position`
--

DROP TABLE IF EXISTS `t_candidate_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_candidate_position`
(
    `id`              bigint NOT NULL,
    `candidate_id`    bigint     DEFAULT NULL,
    `position_id`     bigint     DEFAULT NULL,
    `delivery_status` varchar(5) DEFAULT NULL,
    `create_time`     datetime   DEFAULT NULL,
    `update_time`     datetime   DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_candidate_position`
--

LOCK
TABLES `t_candidate_position` WRITE;
/*!40000 ALTER TABLE `t_candidate_position` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_candidate_position` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `t_company`
--

DROP TABLE IF EXISTS `t_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_company`
(
    `id`                 bigint NOT NULL,
    `company_name`       varchar(20)  DEFAULT NULL,
    `category`           varchar(20)  DEFAULT NULL,
    `number_scale`       varchar(20)  DEFAULT NULL COMMENT '人数规模',
    `address`            varchar(20)  DEFAULT NULL,
    `website`            varchar(50)  DEFAULT NULL,
    `company_profile`    varchar(200) DEFAULT NULL COMMENT '企业简介',
    `full_name`          varchar(20)  DEFAULT NULL COMMENT '企业全称',
    `credit_code`        char(18)     DEFAULT NULL COMMENT '企业信用代码',
    `establish_date`     date         DEFAULT NULL,
    `registered_capital` varchar(20)  DEFAULT NULL COMMENT '注册资本',
    `create_time`        datetime     DEFAULT NULL,
    `update_time`        datetime     DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_company`
--

LOCK
TABLES `t_company` WRITE;
/*!40000 ALTER TABLE `t_company` DISABLE KEYS */;
INSERT INTO `t_company`
VALUES (0, 'test_842e9d00692c', 'test_7431791608cd', 'test_4d3a6e343d38', 'test_ab4c1ae6f46d', 'test_7503c7fc8bcc',
        'test_e6168440be0d', 'test_08fd7bc271fd', 'test_9a85c5ffb653', '2022-07-29', 'test_996331351841', NULL, NULL),
       (1581990422140551168, 'test_842e9d00692c', 'test_7431791608cd', 'test_4d3a6e343d38', 'test_ab4c1ae6f46d',
        'test_7503c7fc8bcc', 'test_e6168440be0d', 'test_08fd7bc271fd', 'test_9a85c5ffb653', '2022-07-29',
        'test_996331351841', NULL, NULL),
       (1581990458278674432, 'test_842e9d00692c', 'test_7431791608cd', 'test_4d3a6e343d38', 'test_ab4c1ae6f46d',
        'test_7503c7fc8bcc', 'test_e6168440be0d', 'test_08fd7bc271fd', 'test_9a85c5ffb653', '2022-07-29',
        'test_996331351841', NULL, NULL),
       (1582295097465241600, 'test_842e9d00692c', 'test_7431791608cd', 'test_4d3a6e343d38', 'test_ab4c1ae6f46d',
        'test_7503c7fc8bcc', 'test_e6168440be0d', 'test_08fd7bc271fd', 'test_9a85c5ffb653', '2022-07-29',
        'test_996331351841', NULL, NULL),
       (1582332054236954624, 'test_842e9d00692c', 'test_7431791608cd', 'test_4d3a6e343d38', 'test_ab4c1ae6f46d',
        'test_7503c7fc8bcc', 'test_e6168440be0d', 'test_08fd7bc271fd', 'test_9a85c5ffb653', '2022-07-29',
        'test_996331351841', NULL, NULL),
       (1582332400048930816, 'test_842e9d00692c', 'test_7431791608cd', 'test_4d3a6e343d38', 'test_ab4c1ae6f46d',
        'test_7503c7fc8bcc', 'test_e6168440be0d', 'test_08fd7bc271fd', 'test_9a85c5ffb653', '2022-07-29',
        'test_996331351841', NULL, NULL),
       (1582332462984462336, 'test_842e9d00692c', 'test_7431791608cd', 'test_4d3a6e343d38', 'test_ab4c1ae6f46d',
        'test_7503c7fc8bcc', 'test_e6168440be0d', 'test_08fd7bc271fd', 'test_9a85c5ffb653', '2022-07-29',
        'test_996331351841', '2022-10-18 19:27:12', '2022-10-18 19:27:12');
/*!40000 ALTER TABLE `t_company` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `t_menu`
--

DROP TABLE IF EXISTS `t_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_menu`
(
    `menu_id`     bigint NOT NULL,
    `menu_name`   varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
    `url`         varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
    `permission`  varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
    `create_time` datetime                                                      DEFAULT NULL,
    `update_time` datetime                                                      DEFAULT NULL,
    PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_menu`
--

LOCK
TABLES `t_menu` WRITE;
/*!40000 ALTER TABLE `t_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_menu` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `t_position`
--

DROP TABLE IF EXISTS `t_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_position`
(
    `id`                   bigint NOT NULL,
    `recruiter_id`         bigint       DEFAULT NULL,
    `company_id`           bigint       DEFAULT NULL,
    `position_name`        varchar(10)  DEFAULT NULL,
    `position_description` varchar(255) DEFAULT NULL,
    `highlight`            varchar(255) DEFAULT NULL,
    `category`             varchar(20)  DEFAULT NULL,
    `threshold`            varchar(255) DEFAULT NULL,
    `keyword`              varchar(20)  DEFAULT NULL,
    `address`              varchar(20)  DEFAULT NULL,
    `min_salary`           int          DEFAULT NULL,
    `max_salary`           int          DEFAULT NULL,
    `create_time`          datetime     DEFAULT NULL,
    `update_time`          datetime     DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_position`
--

LOCK
TABLES `t_position` WRITE;
/*!40000 ALTER TABLE `t_position` DISABLE KEYS */;
INSERT INTO `t_position`
VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
       (2, NULL, NULL, '2', '描述', '2', '2', '2', '2', '北京', NULL, NULL, NULL, NULL),
       (1580517072306307072, NULL, NULL, 'Java开发工程师',
        '1、参与电商基础数据建设，参与电商动态定价系统设计和搭建；2、参与电商分布式数据接入调度系统搭建及优化，打造高性能、高可用的数据接入中台；3、参与电商数据流建设，流式数据的清洗、抽取、计算等，以及大规模数据的存储和更新；4、参与电商资源特征数据挖掘，包括页面价值度、热点变化趋势等，攻克各种挑战及技术难关。',
        NULL, NULL,
        '1、本科及以上学历，计算机、数学等相关专业；2、熟练掌握Linux环境下的Go/Python/Java/C/C++等1至2种以上语言，有良好的编程习惯及逻辑实现能力；3、熟悉Hadoop，Hive，Spark，Storm，Kafka等常用工具优先；4、熟悉Web前端技术，对Html5/Css/Js/Vue/React有了解者优先。5、每周可实习4天以上，可实习4个月以上。',
        NULL, NULL, NULL, NULL, '2022-10-13 19:13:29', '2022-10-13 19:13:29'),
       (1580517176962580480, NULL, NULL, 'Java开发工程师',
        '1、参与电商基础数据建设，参与电商动态定价系统设计和搭建；2、参与电商分布式数据接入调度系统搭建及优化，打造高性能、高可用的数据接入中台；3、参与电商数据流建设，流式数据的清洗、抽取、计算等，以及大规模数据的存储和更新；4、参与电商资源特征数据挖掘，包括页面价值度、热点变化趋势等，攻克各种挑战及技术难关。',
        NULL, NULL,
        '1、本科及以上学历，计算机、数学等相关专业；2、熟练掌握Linux环境下的Go/Python/Java/C/C++等1至2种以上语言，有良好的编程习惯及逻辑实现能力；3、熟悉Hadoop，Hive，Spark，Storm，Kafka等常用工具优先；4、熟悉Web前端技术，对Html5/Css/Js/Vue/React有了解者优先。5、每周可实习4天以上，可实习4个月以上。',
        NULL, NULL, NULL, NULL, '2022-10-13 19:13:54', '2022-10-13 19:13:54'),
       (1580517236496531456, NULL, NULL, 'Java开发工程师',
        '1、参与电商基础数据建设，参与电商动态定价系统设计和搭建；2、参与电商分布式数据接入调度系统搭建及优化，打造高性能、高可用的数据接入中台；3、参与电商数据流建设，流式数据的清洗、抽取、计算等，以及大规模数据的存储和更新；4、参与电商资源特征数据挖掘，包括页面价值度、热点变化趋势等，攻克各种挑战及技术难关。',
        NULL, NULL,
        '1、本科及以上学历，计算机、数学等相关专业；2、熟练掌握Linux环境下的Go/Python/Java/C/C++等1至2种以上语言，有良好的编程习惯及逻辑实现能力；3、熟悉Hadoop，Hive，Spark，Storm，Kafka等常用工具优先；4、熟悉Web前端技术，对Html5/Css/Js/Vue/React有了解者优先。5、每周可实习4天以上，可实习4个月以上。',
        NULL, NULL, NULL, NULL, '2022-10-13 19:14:08', '2022-10-13 19:14:08'),
       (1580517241957515264, NULL, NULL, 'Java开发工程师',
        '1、参与电商基础数据建设，参与电商动态定价系统设计和搭建；2、参与电商分布式数据接入调度系统搭建及优化，打造高性能、高可用的数据接入中台；3、参与电商数据流建设，流式数据的清洗、抽取、计算等，以及大规模数据的存储和更新；4、参与电商资源特征数据挖掘，包括页面价值度、热点变化趋势等，攻克各种挑战及技术难关。',
        NULL, NULL,
        '1、本科及以上学历，计算机、数学等相关专业；2、熟练掌握Linux环境下的Go/Python/Java/C/C++等1至2种以上语言，有良好的编程习惯及逻辑实现能力；3、熟悉Hadoop，Hive，Spark，Storm，Kafka等常用工具优先；4、熟悉Web前端技术，对Html5/Css/Js/Vue/React有了解者优先。5、每周可实习4天以上，可实习4个月以上。',
        NULL, NULL, NULL, NULL, '2022-10-13 19:14:10', '2022-10-13 19:14:10'),
       (1580517244566372352, NULL, NULL, 'Java开发工程师',
        '1、参与电商基础数据建设，参与电商动态定价系统设计和搭建；2、参与电商分布式数据接入调度系统搭建及优化，打造高性能、高可用的数据接入中台；3、参与电商数据流建设，流式数据的清洗、抽取、计算等，以及大规模数据的存储和更新；4、参与电商资源特征数据挖掘，包括页面价值度、热点变化趋势等，攻克各种挑战及技术难关。',
        NULL, NULL,
        '1、本科及以上学历，计算机、数学等相关专业；2、熟练掌握Linux环境下的Go/Python/Java/C/C++等1至2种以上语言，有良好的编程习惯及逻辑实现能力；3、熟悉Hadoop，Hive，Spark，Storm，Kafka等常用工具优先；4、熟悉Web前端技术，对Html5/Css/Js/Vue/React有了解者优先。5、每周可实习4天以上，可实习4个月以上。',
        NULL, NULL, NULL, NULL, '2022-10-13 19:14:10', '2022-10-13 19:14:10'),
       (1580519219275108354, NULL, NULL, 'Java开发工程师',
        '1、参与电商基础数据建设，参与电商动态定价系统设计和搭建；2、参与电商分布式数据接入调度系统搭建及优化，打造高性能、高可用的数据接入中台；3、参与电商数据流建设，流式数据的清洗、抽取、计算等，以及大规模数据的存储和更新；4、参与电商资源特征数据挖掘，包括页面价值度、热点变化趋势等，攻克各种挑战及技术难关。',
        NULL, NULL,
        '1、本科及以上学历，计算机、数学等相关专业；2、熟练掌握Linux环境下的Go/Python/Java/C/C++等1至2种以上语言，有良好的编程习惯及逻辑实现能力；3、熟悉Hadoop，Hive，Spark，Storm，Kafka等常用工具优先；4、熟悉Web前端技术，对Html5/Css/Js/Vue/React有了解者优先。5、每周可实习4天以上，可实习4个月以上。',
        NULL, NULL, NULL, NULL, '2022-10-13 19:22:01', '2022-10-13 19:22:01'),
       (1580519221602947074, NULL, NULL, 'Java开发工程师',
        '1、参与电商基础数据建设，参与电商动态定价系统设计和搭建；2、参与电商分布式数据接入调度系统搭建及优化，打造高性能、高可用的数据接入中台；3、参与电商数据流建设，流式数据的清洗、抽取、计算等，以及大规模数据的存储和更新；4、参与电商资源特征数据挖掘，包括页面价值度、热点变化趋势等，攻克各种挑战及技术难关。',
        NULL, NULL,
        '1、本科及以上学历，计算机、数学等相关专业；2、熟练掌握Linux环境下的Go/Python/Java/C/C++等1至2种以上语言，有良好的编程习惯及逻辑实现能力；3、熟悉Hadoop，Hive，Spark，Storm，Kafka等常用工具优先；4、熟悉Web前端技术，对Html5/Css/Js/Vue/React有了解者优先。5、每周可实习4天以上，可实习4个月以上。',
        NULL, '北京', NULL, NULL, '2022-10-13 19:22:02', '2022-10-13 19:22:02'),
       (1580519852194529280, NULL, NULL, 'Java开发工程师',
        '1、参与电商基础数据建设，参与电商动态定价系统设计和搭建；2、参与电商分布式数据接入调度系统搭建及优化，打造高性能、高可用的数据接入中台；3、参与电商数据流建设，流式数据的清洗、抽取、计算等，以及大规模数据的存储和更新；4、参与电商资源特征数据挖掘，包括页面价值度、热点变化趋势等，攻克各种挑战及技术难关。',
        NULL, NULL,
        '1、本科及以上学历，计算机、数学等相关专业；2、熟练掌握Linux环境下的Go/Python/Java/C/C++等1至2种以上语言，有良好的编程习惯及逻辑实现能力；3、熟悉Hadoop，Hive，Spark，Storm，Kafka等常用工具优先；4、熟悉Web前端技术，对Html5/Css/Js/Vue/React有了解者优先。5、每周可实习4天以上，可实习4个月以上。',
        NULL, '北京', NULL, NULL, '2022-10-13 19:24:32', '2022-10-13 19:24:32'),
       (1581624250719141888, NULL, NULL, 'Java开发工程师',
        '1、参与电商基础数据建设，参与电商动态定价系统设计和搭建；2、参与电商分布式数据接入调度系统搭建及优化，打造高性能、高可用的数据接入中台；3、参与电商数据流建设，流式数据的清洗、抽取、计算等，以及大规模数据的存储和更新；4、参与电商资源特征数据挖掘，包括页面价值度、热点变化趋势等，攻克各种挑战及技术难关。',
        NULL, NULL,
        '1、本科及以上学历，计算机、数学等相关专业；2、熟练掌握Linux环境下的Go/Python/Java/C/C++等1至2种以上语言，有良好的编程习惯及逻辑实现能力；3、熟悉Hadoop，Hive，Spark，Storm，Kafka等常用工具优先；4、熟悉Web前端技术，对Html5/Css/Js/Vue/React有了解者优先。5、每周可实习4天以上，可实习4个月以上。',
        NULL, NULL, NULL, NULL, '2022-10-16 20:33:01', '2022-10-16 20:33:01'),
       (1582262480850255872, NULL, NULL, 'C++开发工程师',
        '1、参与电商基础数据建设，参与电商动态定价系统设计和搭建；2、参与电商分布式数据接入调度系统搭建及优化，打造高性能、高可用的数据接入中台；3、参与电商数据流建设，流式数据的清洗、抽取、计算等，以及大规模数据的存储和更新；4、参与电商资源特征数据挖掘，包括页面价值度、热点变化趋势等，攻克各种挑战及技术难关。',
        NULL, NULL,
        '1、本科及以上学历，计算机、数学等相关专业；2、熟练掌握Linux环境下的Go/Python/Java/C/C++等1至2种以上语言，有良好的编程习惯及逻辑实现能力；3、熟悉Hadoop，Hive，Spark，Storm，Kafka等常用工具优先；4、熟悉Web前端技术，对Html5/Css/Js/Vue/React有了解者优先。5、每周可实习4天以上，可实习4个月以上。',
        NULL, NULL, NULL, NULL, '2022-10-18 14:49:07', '2022-10-18 14:49:07'),
       (1582294901222146048, 0, 0, 'C++开发工程师',
        '1、参与电商基础数据建设，参与电商动态定价系统设计和搭建；2、参与电商分布式数据接入调度系统搭建及优化，打造高性能、高可用的数据接入中台；3、参与电商数据流建设，流式数据的清洗、抽取、计算等，以及大规模数据的存储和更新；4、参与电商资源特征数据挖掘，包括页面价值度、热点变化趋势等，攻克各种挑战及技术难关。',
        NULL, NULL,
        '1、本科及以上学历，计算机、数学等相关专业；2、熟练掌握Linux环境下的Go/Python/Java/C/C++等1至2种以上语言，有良好的编程习惯及逻辑实现能力；3、熟悉Hadoop，Hive，Spark，Storm，Kafka等常用工具优先；4、熟悉Web前端技术，对Html5/Css/Js/Vue/React有了解者优先。5、每周可实习4天以上，可实习4个月以上。',
        NULL, '北京', NULL, NULL, '2022-10-18 16:57:57', '2022-10-18 16:57:57'),
       (1582332081793531904, 0, 0, 'C++开发工程师',
        '1、参与电商基础数据建设，参与电商动态定价系统设计和搭建；2、参与电商分布式数据接入调度系统搭建及优化，打造高性能、高可用的数据接入中台；3、参与电商数据流建设，流式数据的清洗、抽取、计算等，以及大规模数据的存储和更新；4、参与电商资源特征数据挖掘，包括页面价值度、热点变化趋势等，攻克各种挑战及技术难关。',
        NULL, NULL,
        '1、本科及以上学历，计算机、数学等相关专业；2、熟练掌握Linux环境下的Go/Python/Java/C/C++等1至2种以上语言，有良好的编程习惯及逻辑实现能力；3、熟悉Hadoop，Hive，Spark，Storm，Kafka等常用工具优先；4、熟悉Web前端技术，对Html5/Css/Js/Vue/React有了解者优先。5、每周可实习4天以上，可实习4个月以上。',
        NULL, NULL, NULL, NULL, '2022-10-18 19:25:41', '2022-10-18 19:25:41');
/*!40000 ALTER TABLE `t_position` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `t_recruiter`
--

DROP TABLE IF EXISTS `t_recruiter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_recruiter`
(
    `id`             bigint NOT NULL,
    `company_id`     bigint      DEFAULT NULL,
    `recruiter_name` varchar(4)  DEFAULT NULL,
    `sex`            tinyint     DEFAULT NULL,
    `job_title`      varchar(10) DEFAULT NULL,
    `create_time`    datetime    DEFAULT NULL,
    `update_time`    datetime    DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_recruiter`
--

LOCK
TABLES `t_recruiter` WRITE;
/*!40000 ALTER TABLE `t_recruiter` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_recruiter` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_role`
(
    `role_id`      bigint NOT NULL,
    `role_chsname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
    `description`  varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
    `creat_time`   datetime                                                      DEFAULT NULL,
    `update_time`  datetime                                                      DEFAULT NULL,
    `role_name`    varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
    PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK
TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role`
VALUES (1, '管理员', '拥有所有权限', '2022-10-12 00:05:16', NULL, 'admin'),
       (2, '求职者', '拥有求职者权限', '2022-10-12 00:06:01', NULL, 'applicant'),
       (3, '招聘者', '拥有招聘者权限', '2022-10-12 00:06:46', NULL, 'recruiter');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `t_role_menu`
--

DROP TABLE IF EXISTS `t_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_role_menu`
(
    `menu_id`     bigint NOT NULL,
    `role_id`     bigint   DEFAULT NULL,
    `rm_id`       bigint   DEFAULT NULL,
    `create_time` datetime DEFAULT NULL,
    `update_time` datetime DEFAULT NULL,
    PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role_menu`
--

LOCK
TABLES `t_role_menu` WRITE;
/*!40000 ALTER TABLE `t_role_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_role_menu` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user`
(
    `user_id`       bigint NOT NULL,
    `user_name`     varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci  DEFAULT NULL,
    `user_password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
    `create_time`   datetime                                                      DEFAULT NULL,
    `update_time`   datetime                                                      DEFAULT NULL,
    PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK
TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user`
VALUES (1, '管理员', '{noop}123', NULL, NULL),
       (2, '测试求职者1', NULL, NULL, NULL),
       (3, '测试招聘者1', NULL, NULL, NULL);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `t_user_role`
--

DROP TABLE IF EXISTS `t_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user_role`
(
    `role_id`     bigint NOT NULL,
    `user_id`     bigint   DEFAULT NULL,
    `ru_id`       bigint   DEFAULT NULL,
    `create_time` datetime DEFAULT NULL,
    `update_time` datetime DEFAULT NULL,
    PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_role`
--

LOCK
TABLES `t_user_role` WRITE;
/*!40000 ALTER TABLE `t_user_role` DISABLE KEYS */;
INSERT INTO `t_user_role`
VALUES (1, 1, NULL, NULL, NULL),
       (2, 2, NULL, NULL, NULL),
       (3, 3, NULL, NULL, NULL);
/*!40000 ALTER TABLE `t_user_role` ENABLE KEYS */;
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

-- Dump completed on 2022-10-20 18:39:16
