/*
Navicat MySQL Data Transfer

Source Server         : L
Source Server Version : 50155
Source Host           : localhost:3306
Source Database       : pms

Target Server Type    : MYSQL
Target Server Version : 50155
File Encoding         : 65001

Date: 2015-04-15 13:14:49
*/
use pms;

SET FOREIGN_KEY_CHECKS=0;

create table OSN_USER_OPERATION( 
id int(11) NOT NULL AUTO_INCREMENT,
fromUser varchar(50) DEFAULT NULL, 
toUser varchar(50), 
msgType  varchar(10),  
content  varchar(5000), 
picUrl  varchar(200), 
location_X  varchar(50), 
location_Y  varchar(50), 
label  varchar(200), 
linkTitle  varchar(100), 
linkDesc  varchar(200), 
linkUrl  varchar(200), 
eventType  varchar(20), 
eventKey  varchar(30),  
createTime  datetime, 
PRIMARY KEY (`id`)
)

create table OSN_EVENT(  
id int primary key  identity(1,1),
eventType varchar(30),  
eventKey  varchar(30),  
textId int,
status int,  
 PRIMARY KEY (`id`) 
)

create table OSN_ARTICLES(  
id int(11) NOT NULL AUTO_INCREMENT,
title varchar(50), 
description varchar(5000),  
picUrl  varchar(200),  
repkey varchar(50),  
url varchar(200),  
status int ,
addTime  datetime,  
 PRIMARY KEY (`id`) 
)


create table OSN_WECHAT_BIND(  
id int(11) NOT NULL AUTO_INCREMENT,
openID varchar(50),
phone varchar(20), 
addtime  datetime,
 PRIMARY KEY (`id`) 
)


create table OSN_YIXIN_BIND(  
id int(11) NOT NULL AUTO_INCREMENT,
openID varchar(50),
phone varchar(20), 
addtime  datetime,
 PRIMARY KEY (`id`) 
)

 
  insert into [WH_DB].[dbo].[OSN_ARTICLES]
  (title,[description],[picUrl],[repkey],[url],[status])
  values ('查套餐','查套餐','http://61.191.37.72/dualchat/images/btn1_1.jpg','menu1_btn1','https://www.baidu.com/','0')