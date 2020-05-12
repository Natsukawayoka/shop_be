/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : gwxcx

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2018-04-26 16:09:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dz` varchar(255) DEFAULT NULL,
  `isMr` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `shq` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `qu` varchar(255) DEFAULT NULL,
  `sheng` varchar(255) DEFAULT NULL,
  `shi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ik9bfkytk5lrm7yq2bhnf6fe6` (`userId`),
  CONSTRAINT `FK_ik9bfkytk5lrm7yq2bhnf6fe6` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('2', '江苏省连云港市', '1', '李四', '55161651616', null, '2', null, null, null);
INSERT INTO `address` VALUES ('4', '我是地址', '0', '测试地址', '111111111', null, '2', null, null, null);

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `price` double NOT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `selected` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pvkclq3v68c3acqo6ivqh2f92` (`goodsId`),
  KEY `FK_ep0mtwg2w4rju18rk2wm153wg` (`userId`),
  CONSTRAINT `FK_ep0mtwg2w4rju18rk2wm153wg` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_pvkclq3v68c3acqo6ivqh2f92` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------

-- ----------------------------
-- Table structure for dd
-- ----------------------------
DROP TABLE IF EXISTS `dd`;
CREATE TABLE `dd` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `status` int(11) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_548toqb33aavwqnpti6to5fwv` (`goodsId`),
  KEY `FK_ictbe1fmckey0v1blmqidtbbh` (`userId`),
  CONSTRAINT `FK_548toqb33aavwqnpti6to5fwv` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`),
  CONSTRAINT `FK_ictbe1fmckey0v1blmqidtbbh` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dd
-- ----------------------------
INSERT INTO `dd` VALUES ('13', '江苏省南京市秦淮区', '18042615530001', null, '2018-04-26 15:53:27', '张三', '1', '18761111254', '58', '4', '9', '2');
INSERT INTO `dd` VALUES ('14', '江苏省南京市秦淮区', '18042615530002', null, '2018-04-26 15:53:27', '张三', '2', '18761111254', '2000', '4', '13', '2');
INSERT INTO `dd` VALUES ('15', '江苏省连云港市', '18042615540001', null, '2018-04-26 15:54:18', '李四', '1', '55161651616', '58', '3', '9', '2');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` int(11) DEFAULT NULL,
  `isLb` int(11) DEFAULT NULL,
  `price` double NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `url1` varchar(255) DEFAULT NULL,
  `url2` varchar(255) DEFAULT NULL,
  `url3` varchar(255) DEFAULT NULL,
  `url4` varchar(255) DEFAULT NULL,
  `ppId` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_m8jpxcm9wffl7vgvxeydquemp` (`ppId`),
  CONSTRAINT `FK_m8jpxcm9wffl7vgvxeydquemp` FOREIGN KEY (`ppId`) REFERENCES `pp` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('6', '0', '0', '200', '越南进口 中原G7卡布奇诺咖啡榛子味108g', '\\upload\\0ac31ed0492411e8c33eebcb94d33deb0rBEhVlHH_XgIAAAAAAETwlrybXcAAAexwFoy1cAARPa309.jpg', '\\upload\\0ac60500492411e8c33eebcb94d33deb1rBEhVVHH_XcIAAAAAAIUXJqSy2oAAAexwFLvmsAAhR0845.jpg', '\\upload\\0ac6c850492411e8c33eebcb94d33deb2rBEhVVHH_XUIAAAAAAFulkr4a64AAAexwDaSSEAAW6u609.jpg', '\\upload\\0ac76490492411e8c33eebcb94d33deb3rBEhVVHH_XUIAAAAAAFulkr4a64AAAexwDaSSEAAW6u609.jpg', '7', '0');
INSERT INTO `goods` VALUES ('7', '0', '0', '23', ' 越南进口 中原G7三合一速溶咖啡1600g (16gx100条）', '\\upload\\3b82d380492411e8c33eebcb94d33deb05a9f6537N55ab8e52.jpg', '\\upload\\3b854480492411e8c33eebcb94d33deb1576a3b19Nc30012c0.jpg', '\\upload\\3b8607d0492411e8c33eebcb94d33deb257677d39N40618593.jpg', '\\upload\\3b86cb20492411e8c33eebcb94d33deb3576a3b19Nc30012c0.jpg', '7', '0');
INSERT INTO `goods` VALUES ('8', '0', '0', '80', '马来西亚进口 沃欧咖啡（wow coffee）3合1速溶白咖啡1600g/袋（16g×100条）炭烧风味', '\\upload\\5a46f490492411e8c33eebcb94d33deb05ab510e4N1e710808 (1).jpg', '\\upload\\5a4790d0492411e8c33eebcb94d33deb15ab510e4N1e710808.jpg', '\\upload\\5a485420492411e8c33eebcb94d33deb259531e1bN832cb1c9.jpg', '\\upload\\5a491770492411e8c33eebcb94d33deb359531e1bN832cb1c9.jpg', '7', '0');
INSERT INTO `goods` VALUES ('9', '0', '0', '58', '马来西亚进口 零涩 蓝山风味速溶三合一咖啡 40条640g', '\\upload\\86b94820492411e8c33eebcb94d33deb059bf6ea1N5cc1d80a.jpg', '\\upload\\86bc0740492411e8c33eebcb94d33deb159bf6ea4Nff15b492.jpg', '\\upload\\86bd18b0492411e8c33eebcb94d33deb259bf6eabN762acd76 (1).jpg', '\\upload\\86bddc00492411e8c33eebcb94d33deb359bf6eabN762acd76.jpg', '7', '2');
INSERT INTO `goods` VALUES ('10', '0', '1', '65', '马来西亚进口 益昌白咖啡3合1（减少糖）袋装600g*2袋', '\\upload\\a2a4f4d0492411e8c33eebcb94d33deb05a4da264Nedb45b8b.jpg', '\\upload\\a2a78ce0492411e8c33eebcb94d33deb158afc65dN2fc779d1.jpg', '\\upload\\a2a85030492411e8c33eebcb94d33deb258afc693Na0ea477d.jpg', '\\upload\\a2a93a90492411e8c33eebcb94d33deb358afc693Na8e1bec0.jpg', '8', '0');
INSERT INTO `goods` VALUES ('11', '0', '1', '62', '马来西亚进口 旧街场（OLDTOWN）榛果味20条盒装 三合一白咖啡800g', '\\upload\\c6b54960492411e8c33eebcb94d33deb05ab9f8c9N42c4fe30.jpg', '\\upload\\c6b79350492411e8c33eebcb94d33deb158bf6a6bNe347b01a (1).jpg', '\\upload\\c6ba7980492411e8c33eebcb94d33deb258bf6a6bNe347b01a.jpg', '\\upload\\c6bb3cd0492411e8c33eebcb94d33deb358bf6a76Nfd2dfe8e.jpg', '9', '0');
INSERT INTO `goods` VALUES ('12', '0', '1', '65', '英国进口 雀巢多趣酷思(Nescafé Dolce Gusto) 咖啡胶囊 卡布奇诺胶囊咖啡 研磨咖啡粉16颗装', '\\upload\\fc4a05c0492411e8c33eebcb94d33deb0591beca1Nf9051cbc (1).jpg', '\\upload\\fc4f35e0492411e8c33eebcb94d33deb1591beca1Nf9051cbc.jpg', '\\upload\\fc502040492411e8c33eebcb94d33deb2591beca1Nf9051cbc (1).jpg', '\\upload\\fc50e390492411e8c33eebcb94d33deb3591beca1Nf9051cbc.jpg', '9', '0');
INSERT INTO `goods` VALUES ('13', '0', '1', '500', '测试商品1', '\\upload\\b0aa8430492611e8218ee14260ef743e0591beca1Nf9051cbc (1).jpg', '\\upload\\b0adb880492611e8218ee14260ef743e1591beca1Nf9051cbc.jpg', '\\upload\\b0b00270492611e8218ee14260ef743e2591beca1Nf9051cbc (1).jpg', '\\upload\\b0b0ecd0492611e8218ee14260ef743e3591beca1Nf9051cbc.jpg', '15', '2');

-- ----------------------------
-- Table structure for lb
-- ----------------------------
DROP TABLE IF EXISTS `lb`;
CREATE TABLE `lb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isDelete` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lb
-- ----------------------------
INSERT INTO `lb` VALUES ('1', '1', '测试一级');
INSERT INTO `lb` VALUES ('2', '1', '测试23');
INSERT INTO `lb` VALUES ('3', '1', '测试一级2');
INSERT INTO `lb` VALUES ('4', '1', '测试一级3');
INSERT INTO `lb` VALUES ('5', '1', '测试一级4');
INSERT INTO `lb` VALUES ('6', '1', '测试一级5');
INSERT INTO `lb` VALUES ('7', '1', '测试一级6');
INSERT INTO `lb` VALUES ('8', '0', '速溶咖啡');
INSERT INTO `lb` VALUES ('9', '0', '元豆');
INSERT INTO `lb` VALUES ('10', '0', '挂耳式');
INSERT INTO `lb` VALUES ('11', '0', '胶囊咖啡');
INSERT INTO `lb` VALUES ('12', '0', '咖啡粉');
INSERT INTO `lb` VALUES ('13', '0', '咖啡豆');
INSERT INTO `lb` VALUES ('14', '1', '11');
INSERT INTO `lb` VALUES ('15', '1', '333');
INSERT INTO `lb` VALUES ('16', '0', '测试一级');

-- ----------------------------
-- Table structure for manage
-- ----------------------------
DROP TABLE IF EXISTS `manage`;
CREATE TABLE `manage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `passWord` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manage
-- ----------------------------
INSERT INTO `manage` VALUES ('1', 'admin', '111111', '管理员', '1');
INSERT INTO `manage` VALUES ('2', 'ss', 'ss', 'ss', '2');

-- ----------------------------
-- Table structure for pl
-- ----------------------------
DROP TABLE IF EXISTS `pl`;
CREATE TABLE `pl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addTime` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `addTimes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_e9cyio3ylqs604bmm85yjljmc` (`goodsId`),
  KEY `FK_sdc08y9gf9lk62g4uwsxynab9` (`userId`),
  CONSTRAINT `FK_e9cyio3ylqs604bmm85yjljmc` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`),
  CONSTRAINT `FK_sdc08y9gf9lk62g4uwsxynab9` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pl
-- ----------------------------
INSERT INTO `pl` VALUES ('11', '2018-04-26 16:02:49', '这边希尔顿有差异', '13', '2', null);
INSERT INTO `pl` VALUES ('12', '2018-04-26 16:03:18', '还行吧，买了很多次了。', '9', '2', null);

-- ----------------------------
-- Table structure for pp
-- ----------------------------
DROP TABLE IF EXISTS `pp`;
CREATE TABLE `pp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpUrl` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `lbId` int(11) DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_f1x00nmm3d4xdha0vvpccg1g7` (`lbId`),
  CONSTRAINT `FK_f1x00nmm3d4xdha0vvpccg1g7` FOREIGN KEY (`lbId`) REFERENCES `lb` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pp
-- ----------------------------
INSERT INTO `pp` VALUES ('7', '\\upload\\1c9d6440492311e8c33eebcb94d33debtimg.jpg', 'Nestle/雀巢', '13', '0');
INSERT INTO `pp` VALUES ('8', '\\upload\\5959f1f0492311e8c33eebcb94d33debtimg1.jpg', 'grandos/格兰特', '13', '0');
INSERT INTO `pp` VALUES ('9', '\\upload\\7afaa610492311e8c33eebcb94d33deb33.jpg', '柯林咖啡', '12', '0');
INSERT INTO `pp` VALUES ('10', '\\upload\\12bd2250492611e8761713f52006195e591beca1Nf9051cbc (1).jpg', '222', '13', '1');
INSERT INTO `pp` VALUES ('13', '\\upload\\65f48a30492611e8218ee14260ef743e591beca1Nf9051cbc (1).jpg', '33-1', '15', '1');
INSERT INTO `pp` VALUES ('14', '\\upload\\69269040492611e8218ee14260ef743e591beca1Nf9051cbc.jpg', '33-2', '15', '1');
INSERT INTO `pp` VALUES ('15', '\\upload\\96eeafd0492611e8218ee14260ef743e591beca1Nf9051cbc (1).jpg', '测试2级别', '16', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `isDelete` int(11) DEFAULT NULL,
  `openId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2018-04-25 15:13:05', '0', '1');
INSERT INTO `user` VALUES ('2', null, '0', 'oPE8L0bO3eoFhK82yAXbb6UTQUHM');
