CREATE DATABASE STORE_DB;
USE STORE_DB;

CREATE TABLE `Store` (  
  `SId`             	  int                 NOT NULL AUTO_INCREMENT,  
  `SName`           	  varchar(1024)       NOT NULL,  
  `FileName`              varchar(1024)       NOT NULL, 
  `Description`           varchar(1024)       NOT NULL,
  `DeveloperName`         varchar(64)         NOT NULL,
  `DeveloperEmail`        varchar(64)         NULL DEFAULT NULL,
  `Version`               double              NOT NULL,  
  `SearchingTag`          varchar(1024)       NULL DEFAULT NULL,
  `DownloadCount`         int                 NOT NULL DEFAULT 0,
  `PlatformSupported`     varchar(1024)       NOT NULL,
  `CreatedDateTime`       bigint              NOT NULL DEFAULT 0,
  `LastUpdatedDateTime`   bigint              NOT NULL DEFAULT 0,
  PRIMARY KEY (`SId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;  

DROP TABLE Store;
DROP DATABASE STORE_DB;