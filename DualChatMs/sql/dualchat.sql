/*
Microsoft SQL Server Management Studio

Source Server         : L
Source Server Version : 2008
Source Host           : localhost:1433
Source Database       : WH_DB

Target Server Type    : SQLServer
Target Server Version : 2008
File Encoding         : 65001

Date: 2015-04-15 13:14:49
*/

create table OSN_USER_OPERATION( --用户操作记录表
id int primary key identity(1,1),
fromUser varchar(50),--发送人
toUser varchar(50),--接收人
msgType  varchar(10), --消息类型
content  varchar(5000),--消息内容
picUrl  varchar(200),--图片地址
location_X  varchar(50),--地理位置纬度
location_Y  varchar(50),--地理位置经度
label  varchar(200),--地理位置信息
linkTitle  varchar(100),--连接标题
linkDesc  varchar(200),--连接描述
linkUrl  varchar(200),--连接地址
eventType  varchar(20), --事件类型
eventKey  varchar(30), --事件KEY
createTime  datetime --发送时间
)

create table OSN_EVENT( --事件表
id int primary key  identity(1,1),
eventType varchar(30), --事件类型
eventKey  varchar(30), --事件Key
textId int,
status int --状态 0.有效 1.无效
)

create table OSN_ARTICLES( --图文消息表
id int primary key identity(1,1),
title varchar(50),--标题
description varchar(5000), --描述
picUrl  varchar(200), --图片地址
repkey varchar(50), --获取标识
url varchar(200), --连接地址
status int --状态 0.有效 1.无效
addTime  datetime --添加时间
)


create table OSN_WECHAT_BIND( --微信绑定表
id int primary key identity(1,1),
openID varchar(50),
phone varchar(20), 
addtime  datetime
)


create table OSN_YIXIN_BIND( --易信绑定表
id int primary key identity(1,1),
openID varchar(50),
phone varchar(20), 
addtime  datetime
)

   insert into [WH_DB].[dbo].[OSN_ARTICLES]
  (title,[description],[picUrl],[repkey],[url],[status])
  values ('xxx','xxxxx','http://61.191.37.72/dualchat/images/btn1_1.jpg','menu1_btn1','https://www.baidu.com/','0')
  
  #....