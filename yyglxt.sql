/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50016
Source Host           : localhost:3308
Source Database       : yyglxt

Target Server Type    : MYSQL
Target Server Version : 50016
File Encoding         : 65001

Date: 2017-04-08 11:31:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `film`
-- ----------------------------
DROP TABLE IF EXISTS `film`;
CREATE TABLE `film` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(90) default NULL,
  `country` varchar(60) default NULL,
  `director` varchar(30) default NULL,
  `mianActor` varchar(300) default NULL,
  `time` varchar(60) default NULL,
  `kind` varchar(30) default NULL,
  `language` varchar(90) default NULL,
  `intro` varchar(1500) default NULL,
  `imgName` varchar(60) default NULL,
  `img` blob,
  `upDate` varchar(45) default NULL,
  `downDate` varchar(48) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of film
-- ----------------------------
INSERT INTO `film` VALUES ('2', '破风', '中国', '林超贤', '王珞丹,陈家乐,彭于晏,崔始源,窦骁,连凯,欧阳娜娜,洛诗', '125分钟', '爱情,剧情,动作', '中文', '电影以单车队为主轴，讲述了赛车手的故事，传递正能量', '1438951419482.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD, '2015-06-30', '2015-07-10');
INSERT INTO `film` VALUES ('3', '捉妖记', '中国', '许诚毅', '田雨橙,白百何,保剑锋,钟汉良,汤唯,闫妮,吴君如,曾志伟,姚晨,张悦轩,姜武,井柏然', '117分钟', '剧情,奇幻', '中文', '小伙子天荫（井柏然饰）阴差阳错地怀上了即将降世的小妖王，他被降妖天师小岚（白百何饰）一路保护着躲过各种妖怪。虽然二人渐渐对小妖产生了感情，小岚却明白她只为把这只惹人眼红的小妖卖个好价钱，在人妖混杂的世界里，他们的命运无疑将牵动人心。', '1439171652691.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD, '2015-06-25', '2015-07-31');
INSERT INTO `film` VALUES ('4', '新步步惊心', '中国', '宋迪', '于波,窦骁,杨?宁,周骏超,宋伊人,陈意涵, 成泰? , 杜志国 , 顾宝明 ,周骏超', '115分钟', '爱情,古装,奇幻', '中文', '情感一直不如意???都市白领张小文，因一次意外的时光逆转，穿越到古代变成了清朝的格格马尔泰若曦，张小文现代人的思维与生活习惯与身处古代的格格身份形成了巨大的反差，并引起了皇室的疑心。同时，聪明机智、阳光活泼的她更是得到了两位阿哥四爷胤?和十四爷胤?的倾爱，两人对若曦展开了风格迥然不同的爱的攻势，一个是唯我独尊、深情内敛的霸道总裁，一个是有求必应默默为爱守候的柔情骑士，上演了一段揪心、惊心又暖心的旷世三角恋情，在现在与未来之间，张小文究竟会情归何处..', '1439171803588.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD, '2015-08-09', '2015-10-01');
INSERT INTO `film` VALUES ('5', '西游记之大圣归来', '中国', '田晓鹏', '林子杰,张磊,吴文伦,童自荣,刘九容', '85分钟', '动作,动画,奇幻', '中文', '大闹天宫后的四百多年，齐天大圣成了一个传说，在山妖横行的长安城，百姓们在朝夕不保中惶惶度日', '1439171956298.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD, '2015-07-25', '2015-08-03');
INSERT INTO `film` VALUES ('6', '魔镜', '中国', '彭发', '孙坚,周泓', '90分钟', '惊悚', '中文', '深夜，年轻女孩在朋友聚会后酒驾不幸路遇车祸，独自养伤的她欣喜又羞涩的与一位年轻陌生男子微信互聊起来。一来一往中男子与她互生情愫，相约互换照片，女孩精心打扮后自拍照片通过手机发送过去，却收到了诡异的照片和回复', '1439172107841.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD, '2015-09-01', '2015-10-11');
INSERT INTO `film` VALUES ('7', '宅女侦探桂香', '中国', '彭顺', '王珞丹,周渝民, 任达华', '90分钟', '喜剧,??作,爱情', '中文', '宅女桂香（王珞丹饰）3岁识字、7岁抓小偷、13岁帮警察破案，从小到达成功破获无数起凶杀悬案，是远近闻名的天才侦探。然而高智商的桂香却有情商缺陷，不但惨遭男友抛弃，还无法走出情伤。就在桂香终日沉浸在失恋伤感中时，一起碎尸案发生在她面前，并将她卷入到另外一宗更离奇的案件中去。在寻找真凶的过程中，桂香遇到看似无害却总是跟她作对的刑警阿哲（周渝民饰），两个人展开了一场智力角逐，也离真相越来越近', '1439172856174.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD, '2015-09-02', '2015-09-30');

-- ----------------------------
-- Table structure for `filmticket`
-- ----------------------------
DROP TABLE IF EXISTS `filmticket`;
CREATE TABLE `filmticket` (
  `id` int(11) NOT NULL auto_increment,
  `seat` varchar(45) default NULL,
  `time` varchar(45) default NULL,
  `filmName` varchar(75) default NULL,
  `address` varchar(120) default NULL,
  `sid` int(11) default NULL,
  `price` double default NULL,
  `buyTime` varchar(60) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of filmticket
-- ----------------------------
INSERT INTO `filmticket` VALUES ('58', '297-328', '2015-7-20 12:13', '西游记之大圣归来', '第3大厅', '31', '29', '2015-08-11 10:01:14');
INSERT INTO `filmticket` VALUES ('59', '111-142', '2015-7-20 12:13', '宅女侦探桂香', '第3大厅', '29', '29', '2015-08-12 10:01:14');
INSERT INTO `filmticket` VALUES ('60', '204-173', '2015-7-20 12:13', '捉妖记', '第1大厅', '22', '29', '2015-07-12 11:56:18');
INSERT INTO `filmticket` VALUES ('61', '173-204', '2015-7-20 12:13', '捉妖记', '第1大厅', '22', '23.2', '2015-07-14 09:50:50');
INSERT INTO `filmticket` VALUES ('62', '142-173', '2015-7-20 12:13', '捉妖记', '第1大厅', '22', '28.42', '2015-07-14 09:51:42');
INSERT INTO `filmticket` VALUES ('63', '204-235', '2015-7-20 12:13', '新步步惊心', '第2大厅', '23', '23.2', '2015-07-14 09:58:27');
INSERT INTO `filmticket` VALUES ('64', '204-173', '2015-7-20 12:13', '新步步惊心', '第2大厅', '23', '23.2', '2015-08-14 10:06:34');
INSERT INTO `filmticket` VALUES ('65', '80-173', '2015-7-20 12:13', '新步步惊心', '第2大厅', '23', '29', '2015-08-14 10:16:49');
INSERT INTO `filmticket` VALUES ('66', '111-111', '2015-7-20 12:13', '新步步惊心', '第2大厅', '23', '23.2', '2015-08-15 15:47:50');
INSERT INTO `filmticket` VALUES ('67', '173-111', '2015-7-20 12:13', '捉妖记', '第1大厅', '22', '23.2', '2015-08-15 15:50:28');
INSERT INTO `filmticket` VALUES ('68', '142-173', '2015-7-20 12:13', '宅女侦探桂香', '第3大厅', '29', '23.2', '2015-08-15 15:52:56');
INSERT INTO `filmticket` VALUES ('69', '111-142', '2015-7-20 12:13', '破风', '第1大厅', '35', '23.2', '2015-08-15 15:55:15');
INSERT INTO `filmticket` VALUES ('70', '111-142', '2015-7-20 12:13', '破风', '第1大厅', '35', '23.2', '2015-08-15 15:55:17');
INSERT INTO `filmticket` VALUES ('71', '111-142', '2015-7-20 12:13', '破风', '第1大厅', '35', '23.2', '2015-08-15 15:55:18');
INSERT INTO `filmticket` VALUES ('72', '111-142', '2015-7-20 12:13', '破风', '第1大厅', '35', '23.2', '2015-08-15 15:55:18');
INSERT INTO `filmticket` VALUES ('73', '235-235', '2015-7-20 12:13', '西游记之大圣归来', '第3大厅', '31', '28.42', '2015-08-15 15:57:41');
INSERT INTO `filmticket` VALUES ('74', '235-235', '2015-7-20 12:13', '西游记之大圣归来', '第3大厅', '31', '28.42', '2015-08-15 15:57:42');
INSERT INTO `filmticket` VALUES ('75', '142-142', '2015-7-20 12:13', '新步步惊心', '第2大厅', '23', '23.2', '2015-08-15 17:47:35');
INSERT INTO `filmticket` VALUES ('76', '142-142', '2015-7-20 12:13', '新步步惊心', '第2大厅', '23', '23.2', '2015-08-15 17:47:37');
INSERT INTO `filmticket` VALUES ('77', '235-204', '2015-7-20 12:13', '宅女侦探桂香', '第3大厅', '29', '23.2', '2015-08-15 17:50:29');
INSERT INTO `filmticket` VALUES ('78', '266-297', '2015-7-20 12:13', '宅女侦探桂香', '第3大厅', '29', '23.2', '2015-08-15 17:52:58');
INSERT INTO `filmticket` VALUES ('79', '142-235', '2015-7-20 12:13', '新步步惊心', '第2大厅', '23', '28.42', '2015-08-15 18:01:47');
INSERT INTO `filmticket` VALUES ('80', '235-173', '2015-7-20 12:13', '捉妖记', '第1大厅', '22', '23.2', '2015-08-16 17:04:42');
INSERT INTO `filmticket` VALUES ('81', '235-204', '2015-7-20 12:13', '捉妖记', '第1大厅', '22', '27.55', '2015-08-16 17:04:57');
INSERT INTO `filmticket` VALUES ('82', '111-266', '2015-7-20 12:13', '捉妖记', '第1大厅', '22', '29', '2015-08-16 17:10:47');
INSERT INTO `filmticket` VALUES ('83', '111-266', '2015-7-20 12:13', '捉妖记', '第1大厅', '22', '29', '2015-08-16 17:10:48');
INSERT INTO `filmticket` VALUES ('84', '111-266', '2015-7-20 12:13', '捉妖记', '第1大厅', '22', '29', '2015-08-16 17:10:49');
INSERT INTO `filmticket` VALUES ('85', '111-266', '2015-7-20 12:13', '捉妖记', '第1大厅', '22', '29', '2015-08-16 17:10:49');
INSERT INTO `filmticket` VALUES ('86', '111-266', '2015-7-20 12:13', '捉妖记', '第1大厅', '22', '29', '2015-08-16 17:10:49');
INSERT INTO `filmticket` VALUES ('87', '111-266', '2015-7-20 12:13', '捉妖记', '第1大厅', '22', '29', '2015-08-16 17:10:53');
INSERT INTO `filmticket` VALUES ('88', '111-266', '2015-7-20 12:13', '捉妖记', '第1大厅', '22', '29', '2015-08-16 17:10:53');
INSERT INTO `filmticket` VALUES ('89', '111-266', '2015-7-20 12:13', '捉妖记', '第1大厅', '22', '27.55', '2015-08-16 17:11:02');
INSERT INTO `filmticket` VALUES ('90', '204-235', '2015-7-20 12:13', '捉妖记', '第1大厅', '22', '29', '2015-08-16 17:12:20');
INSERT INTO `filmticket` VALUES ('91', '204-235', '2015-7-20 12:13', '捉妖记', '第1大厅', '22', '29', '2015-08-16 17:12:21');
INSERT INTO `filmticket` VALUES ('92', '204-235', '2015-7-20 12:13', '捉妖记', '第1大厅', '22', '29', '2015-08-16 17:12:21');
INSERT INTO `filmticket` VALUES ('93', '235-142', '2015-7-20 12:13', '新步步惊心', '第2大厅', '23', '27.55', '2015-08-16 17:13:15');
INSERT INTO `filmticket` VALUES ('94', '173-204', '2015-7-20 12:13', '新步步惊心', '第2大厅', '23', '27.55', '2015-08-16 17:13:29');
INSERT INTO `filmticket` VALUES ('95', '173-80', '2015-7-20 12:13', '新步步惊心', '第2大厅', '23', '27.55', '2015-08-16 17:14:39');
INSERT INTO `filmticket` VALUES ('96', '266-266', '2015-7-20 12:13', '新步步惊心', '第3大厅', '25', '27.55', '2015-08-16 17:15:04');
INSERT INTO `filmticket` VALUES ('97', '266-204', '2015-7-20 12:13', '新步步惊心', '第3大厅', '25', '27.55', '2015-08-16 17:15:17');
INSERT INTO `filmticket` VALUES ('98', '235-266', '2015-7-20 12:13', '魔镜', '第3大厅', '30', '27.55', '2015-08-16 17:15:42');
INSERT INTO `filmticket` VALUES ('99', '328-266', '2015-7-20 12:13', '魔镜', '第3大厅', '30', '24.65', '2015-08-16 17:15:53');
INSERT INTO `filmticket` VALUES ('100', '204-204', '2015-7-20 12:13', '西游记之大圣归来', '第1大厅', '26', '27.55', '2015-08-16 17:16:41');
INSERT INTO `filmticket` VALUES ('101', '235-204', '2015-7-20 12:13', '西游记之大圣归来', '第1大厅', '26', '27.55', '2015-08-16 17:16:55');
INSERT INTO `filmticket` VALUES ('102', '173-204', '2015-7-20 12:13', '西游记之大圣归来', '第2大厅', '27', '27.55', '2015-08-16 17:17:10');
INSERT INTO `filmticket` VALUES ('103', '173-173', '2015-8-10 9:0', '魔镜', '第2大厅', '40', '59', '2015-08-17 09:34:52');
INSERT INTO `filmticket` VALUES ('104', '173-173', '2015-8-10 9:0', '魔镜', '第2大厅', '40', '59', '2015-08-17 09:34:53');
INSERT INTO `filmticket` VALUES ('105', '173-173', '2015-8-10 9:0', '魔镜', '第2大厅', '40', '59', '2015-08-17 09:34:53');
INSERT INTO `filmticket` VALUES ('106', '173-173', '2015-8-10 9:0', '魔镜', '第2大厅', '40', '59', '2015-08-17 09:34:53');
INSERT INTO `filmticket` VALUES ('108', '204-204', '2015-7-20 12:13', '魔镜', '第3大厅', '30', '27.55', '2015-11-29 09:37:42');
INSERT INTO `filmticket` VALUES ('109', '173-111', '2015-7-6 12:13', '破风', '第1大厅', '21', '27.55', '2016-01-07 08:53:50');
INSERT INTO `filmticket` VALUES ('110', '49-80', '2015-7-6 12:13', '破风', '第1大厅', '21', '27.55', '2016-03-02 19:19:23');
INSERT INTO `filmticket` VALUES ('112', '80-80', '2015-7-6 12:13', '破风', '第1大厅', '21', '29', '2016-03-02 19:19:48');
INSERT INTO `filmticket` VALUES ('113', '80-80', '2015-7-6 12:13', '破风', '第1大厅', '21', '29', '2016-03-02 19:19:48');
INSERT INTO `filmticket` VALUES ('114', '80-80', '2015-7-6 12:13', '破风', '第1大厅', '21', '28.42', '2016-03-02 19:19:56');
INSERT INTO `filmticket` VALUES ('115', '111-80', '2015-7-6 12:13', '破风', '第1大厅', '21', '27.55', '2016-03-02 19:20:13');
INSERT INTO `filmticket` VALUES ('118', '173-235', '2015-7-20 12:13', '新步步惊心', '第1大厅', '34', '27.55', '2017-01-18 04:45:11');
INSERT INTO `filmticket` VALUES ('119', '173-204', '2015-7-20 12:13', '新步步惊心', '第1大厅', '34', '27.55', '2017-01-18 04:45:12');
INSERT INTO `filmticket` VALUES ('120', '111-142', '2015-7-20 12:13', '新步步惊心', '第1大厅', '34', '28.42', '2017-01-18 04:46:54');
INSERT INTO `filmticket` VALUES ('121', '142-142', '2015-7-20 12:13', '新步步惊心', '第1大厅', '34', '28.42', '2017-01-18 04:46:56');
INSERT INTO `filmticket` VALUES ('122', '173-142', '2015-7-20 12:13', '新步步惊心', '第1大厅', '34', '28.42', '2017-01-18 04:46:59');
INSERT INTO `filmticket` VALUES ('123', '204-142', '2015-7-20 12:13', '新步步惊心', '第1大厅', '34', '28.42', '2017-01-18 04:47:00');
INSERT INTO `filmticket` VALUES ('124', '235-142', '2015-7-20 12:13', '新步步惊心', '第1大厅', '34', '28.42', '2017-01-18 04:47:01');
INSERT INTO `filmticket` VALUES ('125', '266-142', '2015-7-20 12:13', '新步步惊心', '第1大厅', '34', '28.42', '2017-01-18 04:47:02');
INSERT INTO `filmticket` VALUES ('126', '297-142', '2015-7-20 12:13', '新步步惊心', '第1大厅', '34', '28.42', '2017-01-18 04:47:03');
INSERT INTO `filmticket` VALUES ('127', '328-142', '2015-7-20 12:13', '新步步惊心', '第1大厅', '34', '28.42', '2017-01-18 04:47:04');
INSERT INTO `filmticket` VALUES ('128', '328-173', '2015-7-20 12:13', '新步步惊心', '第1大厅', '34', '28.42', '2017-01-18 04:47:04');
INSERT INTO `filmticket` VALUES ('129', '297-173', '2015-7-20 12:13', '新步步惊心', '第1大厅', '34', '28.42', '2017-01-18 04:47:05');
INSERT INTO `filmticket` VALUES ('130', '297-204', '2015-7-20 12:13', '新步步惊心', '第1大厅', '34', '28.42', '2017-01-18 04:47:06');
INSERT INTO `filmticket` VALUES ('131', '297-235', '2015-7-20 12:13', '新步步惊心', '第1大厅', '34', '28.42', '2017-01-18 04:47:07');
INSERT INTO `filmticket` VALUES ('132', '297-266', '2015-7-20 12:13', '新步步惊心', '第1大厅', '34', '28.42', '2017-01-18 04:47:09');

-- ----------------------------
-- Table structure for `fyt`
-- ----------------------------
DROP TABLE IF EXISTS `fyt`;
CREATE TABLE `fyt` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(90) default NULL,
  `kind` varchar(60) default NULL,
  `seating` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of fyt
-- ----------------------------
INSERT INTO `fyt` VALUES ('1', '第1影厅', '普通', '10-10');
INSERT INTO `fyt` VALUES ('2', '第2影厅', '3D', '9-9');
INSERT INTO `fyt` VALUES ('3', '第3影厅', 'MAX', '10-10');

-- ----------------------------
-- Table structure for `upfilm`
-- ----------------------------
DROP TABLE IF EXISTS `upfilm`;
CREATE TABLE `upfilm` (
  `id` int(11) NOT NULL auto_increment,
  `filmName` varchar(60) default NULL,
  `fyt` int(11) default NULL,
  `kind` varchar(30) default NULL,
  `language` varchar(30) default NULL,
  `startTime` varchar(45) default NULL,
  `time` varchar(45) default NULL,
  `price` double default NULL,
  `upTime` varchar(45) default NULL,
  `imgName` varchar(120) default NULL,
  `img` blob,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of upfilm
-- ----------------------------
INSERT INTO `upfilm` VALUES ('21', '破风', '1', '爱情,剧情,动作', '中文', '2015-7-6 12:13', '125分钟', '29', '2015-06-30', '1438951419482.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `upfilm` VALUES ('22', '捉妖记', '1', '剧情,奇幻', '中文', '2015-7-20 12:13', '117分钟', '29', '2015-06-25', '1439171652691.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `upfilm` VALUES ('23', '新步步惊心', '2', '爱情,古装,奇幻', '中文', '2015-7-20 12:13', '115分钟', '29', '2015-08-09', '1439171803588.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `upfilm` VALUES ('24', '新步步惊心', '1', '爱情,古装,奇幻', '中文', '2015-7-20 12:13', '115分钟', '29', '2015-08-09', '1439171803588.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `upfilm` VALUES ('26', '西游记之大圣归来', '1', '动作,动画,奇幻', '中文', '2015-7-20 12:13', '85分钟', '29', '2015-07-25', '1439171956298.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `upfilm` VALUES ('27', '西游记之大圣归来', '2', '动作,动画,奇幻', '中文', '2015-7-20 12:13', '85分钟', '29', '2015-07-25', '1439171956298.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `upfilm` VALUES ('28', '西游记之大圣归来', '3', '动作,动画,奇幻', '中文', '2015-7-20 12:13', '85分钟', '29', '2015-07-25', '1439171956298.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `upfilm` VALUES ('29', '宅女侦探桂香', '3', '喜剧,动作,爱情', '中文', '2015-7-20 12:13', '90分钟', '29', '2015-09-02', '1439172856174.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `upfilm` VALUES ('30', '魔镜', '3', '惊悚', '中文', '2015-7-20 12:13', '90分钟', '29', '2015-09-01', '1439172107841.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `upfilm` VALUES ('31', '西游记之大圣归来', '3', '动作,动画,奇幻', '中文', '2015-7-20 12:13', '85分钟', '29', '2015-07-25', '1439171956298.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `upfilm` VALUES ('32', '西游记之大圣归来', '1', '动作,动画,奇幻', '中文', '2015-7-20 12:13', '85分钟', '29', '2015-07-25', '1439171956298.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `upfilm` VALUES ('33', '捉妖记', '1', '剧情,奇幻', '中文', '2015-7-20 12:13', '117分钟', '29', '2015-06-25', '1439171652691.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `upfilm` VALUES ('34', '新步步惊心', '1', '爱情,古装,奇幻', '中文', '2015-7-20 12:13', '115分钟', '29', '2015-08-09', '1439171803588.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `upfilm` VALUES ('35', '破风', '1', '爱情,剧情,动作', '中文', '2015-7-20 12:13', '125分钟', '29', '2015-06-30', '1438951419482.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `upfilm` VALUES ('36', '魔镜', '1', '惊悚', '中文', '2015-7-20 12:13', '90分钟', '29', '2015-09-01', '1439172107841.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `upfilm` VALUES ('37', '捉妖记', '1', '剧情,奇幻', '中文', '2015-8-17 8:0', '117分钟', '50', '2015-06-25', '1439171652691.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `upfilm` VALUES ('38', '捉妖记', '3', '剧情,奇幻', '中文', '2015-8-17 8:0', '117分钟', '50', '2015-06-25', '1439171652691.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `upfilm` VALUES ('40', '魔镜', '2', '惊悚', '中文', '2015-8-10 9:0', '90分钟', '59', '2015-09-01', '1439172107841.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `userName` varchar(180) default NULL,
  `password` varchar(162) default NULL,
  `limits` varchar(45) default NULL,
  `name` varchar(30) default NULL,
  `sex` varchar(3) default NULL,
  `tel` varchar(45) default NULL,
  `IDcard` varchar(54) default NULL,
  `address` varchar(120) default NULL,
  `imgName` varchar(60) default NULL,
  `img` blob,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '1', '李奎', '男', '15754326082', '522323199601136233', '贵州兴义', '1438916041980.png', 0xEFBFBD504E470D0A1A0A);
INSERT INTO `user` VALUES ('9', 'employee4', 'employee4', '2', '王艾', '女', '15125489654', '522321199611116254', '贵州兴义', '1439280411589.jpeg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `user` VALUES ('10', 'employee', 'employee', '2', '李明', '男', '15754986587', '522321199548654521', '吉林长春', '1439279865416.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);

-- ----------------------------
-- Table structure for `vip`
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(30) default NULL,
  `sex` varchar(3) default NULL,
  `integral` varchar(33) default NULL,
  `grade` varchar(30) default NULL,
  `tel` varchar(45) default NULL,
  `imgName` varchar(90) default NULL,
  `img` blob,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of vip
-- ----------------------------
INSERT INTO `vip` VALUES ('1', '张三', '男', '10367', '白银', '15754698875', '1439776728965.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `vip` VALUES ('2', '杨晓彤', '女', '2324', '白银', '15755565621', '1439736335874.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `vip` VALUES ('3', '柳青', '女', '1392', '青铜', '13954625486', '1439736169847.jpg', 0xEFBFBDEFBFBDEFBFBDEFBFBD);
INSERT INTO `vip` VALUES ('4', '游客', null, null, '游客', null, null, null);
