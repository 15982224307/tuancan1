/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50560
Source Host           : 192.168.1.109:3306
Source Database       : tcsell

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-08-06 11:44:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `accessorie`
-- ----------------------------
DROP TABLE IF EXISTS `accessorie`;
CREATE TABLE `accessorie` (
  `Foodmaterial_id` int(11) NOT NULL COMMENT '食材编号',
  `recipe_id` int(11) NOT NULL COMMENT '食谱编号',
  `accessorie_no` int(11) DEFAULT NULL COMMENT '辅料序号',
  `accessorie_weight` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '辅料重量（可以是克，也可以是少许等不确定）',
  `accessorie_memo` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '辅料备注',
  PRIMARY KEY (`Foodmaterial_id`,`recipe_id`),
  KEY `FK_Relationship_31` (`recipe_id`),
  CONSTRAINT `FK_Relationship_30` FOREIGN KEY (`Foodmaterial_id`) REFERENCES `foodmaterial` (`Foodmaterial_id`),
  CONSTRAINT `FK_Relationship_31` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`recipe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='辅料';

-- ----------------------------
-- Records of accessorie
-- ----------------------------

-- ----------------------------
-- Table structure for `answer`
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `Answer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '回答编号',
  `gMStaff_id` int(11) DEFAULT NULL COMMENT '用餐员工编号',
  `questionnaire_id` int(11) DEFAULT NULL COMMENT '问卷编号',
  `answer_text` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '回答',
  `answer_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '回答日期',
  PRIMARY KEY (`Answer_id`),
  KEY `FK_Relationship_21` (`gMStaff_id`),
  KEY `FK_Relationship_22` (`questionnaire_id`),
  CONSTRAINT `FK_Relationship_21` FOREIGN KEY (`GMStaff_id`) REFERENCES `groupmealstaff` (`GMStaff_id`),
  CONSTRAINT `FK_Relationship_22` FOREIGN KEY (`questionnaire_id`) REFERENCES `questionnaire` (`questionnaire_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='问答';

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('2', '1', '1', '1', '2018-07-19 09:23:43');
INSERT INTO `answer` VALUES ('3', '1', '1', 'dfg', '2018-07-20 11:42:27');
INSERT INTO `answer` VALUES ('6', '1', '1', 'asasfasge', '2018-07-20 11:40:05');
INSERT INTO `answer` VALUES ('8', '1', '1', 'asasfasge', '2018-07-20 11:52:22');
INSERT INTO `answer` VALUES ('9', '1', '1', 'asasfasge', '2018-07-20 12:02:11');
INSERT INTO `answer` VALUES ('10', '1', '1', 'ggg', '2018-07-20 12:07:17');
INSERT INTO `answer` VALUES ('12', null, null, 'ggg', '2018-07-22 08:38:44');
INSERT INTO `answer` VALUES ('14', null, null, 'ggg', '2018-07-22 09:32:14');

-- ----------------------------
-- Table structure for `classification`
-- ----------------------------
DROP TABLE IF EXISTS `classification`;
CREATE TABLE `classification` (
  `classification_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '小类编号',
  `maincategorie_id` int(11) DEFAULT NULL COMMENT '食材主类编号',
  `classification_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '小类名称',
  PRIMARY KEY (`classification_id`),
  KEY `FK_Relationship_26` (`maincategorie_id`),
  CONSTRAINT `FK_Relationship_26` FOREIGN KEY (`maincategorie_id`) REFERENCES `maincategorie` (`maincategorie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='食材二级分类';

-- ----------------------------
-- Records of classification
-- ----------------------------
INSERT INTO `classification` VALUES ('1', '1001', '猪');
INSERT INTO `classification` VALUES ('2', '1001', '牛');
INSERT INTO `classification` VALUES ('3', '1001', '羊');
INSERT INTO `classification` VALUES ('4', '1001', '鸡');
INSERT INTO `classification` VALUES ('5', '1001', '鸭');
INSERT INTO `classification` VALUES ('6', '1001', '鹅');
INSERT INTO `classification` VALUES ('7', '1001', '蛋');
INSERT INTO `classification` VALUES ('8', '1001', '其他');
INSERT INTO `classification` VALUES ('17', '1002', '鱼类');
INSERT INTO `classification` VALUES ('18', '1002', '虾类');
INSERT INTO `classification` VALUES ('19', '1002', '蟹类');
INSERT INTO `classification` VALUES ('20', '1002', '贝类');
INSERT INTO `classification` VALUES ('21', '1002', '其他水产');
INSERT INTO `classification` VALUES ('22', '1003', '茎叶类');
INSERT INTO `classification` VALUES ('23', '1003', '根茎类');
INSERT INTO `classification` VALUES ('24', '1003', '瓜果类');
INSERT INTO `classification` VALUES ('25', '1003', '菌类');
INSERT INTO `classification` VALUES ('26', '1003', '花朵类');
INSERT INTO `classification` VALUES ('27', '1004', '豆类');
INSERT INTO `classification` VALUES ('28', '1004', '豆制品 ');
INSERT INTO `classification` VALUES ('29', '1005', '五谷杂粮类 ');
INSERT INTO `classification` VALUES ('30', '1005', '面类');
INSERT INTO `classification` VALUES ('31', '1005', '小吃、甜饼');
INSERT INTO `classification` VALUES ('32', '1005', '方便食品类');
INSERT INTO `classification` VALUES ('33', '1006', '鲜果类');
INSERT INTO `classification` VALUES ('34', '1006', '干果类');
INSERT INTO `classification` VALUES ('35', '1007', '药食两用');
INSERT INTO `classification` VALUES ('36', '1009', '调味品 ');
INSERT INTO `classification` VALUES ('37', '1009', '油脂');
INSERT INTO `classification` VALUES ('38', '1008', '糖、蜜饯');
INSERT INTO `classification` VALUES ('39', '1008', '乳类');
INSERT INTO `classification` VALUES ('40', '1008', '酒类');
INSERT INTO `classification` VALUES ('41', '1008', '茶饮');
INSERT INTO `classification` VALUES ('42', '1010', 'yrr');

-- ----------------------------
-- Table structure for `companygrade`
-- ----------------------------
DROP TABLE IF EXISTS `companygrade`;
CREATE TABLE `companygrade` (
  `CompanyGrade_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '等级编号',
  `CompanyGrade_name` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `CompanyGrade_authority` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '功能',
  PRIMARY KEY (`CompanyGrade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='等级';

-- ----------------------------
-- Records of companygrade
-- ----------------------------
INSERT INTO `companygrade` VALUES ('1', 'zhuguan', 'update,insert');
INSERT INTO `companygrade` VALUES ('2', 'zhuguan', 'update');
INSERT INTO `companygrade` VALUES ('5', 'zhuguan', 'update,insert');

-- ----------------------------
-- Table structure for `complaint`
-- ----------------------------
DROP TABLE IF EXISTS `complaint`;
CREATE TABLE `complaint` (
  `Complaint_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '投诉编号',
  `manager_id` int(11) DEFAULT NULL COMMENT '管理员编号',
  `Complainter` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '投诉人',
  `Complaint_content` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '投诉内容',
  `Complaint_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '投诉日期',
  `Complaint_settle` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '处理结果',
  `Complaint_settledate` timestamp NULL DEFAULT NULL COMMENT '处理时间',
  PRIMARY KEY (`Complaint_id`),
  KEY `FK_Relationship_25` (`manager_id`),
  CONSTRAINT `FK_Relationship_25` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='平台投诉';

-- ----------------------------
-- Records of complaint
-- ----------------------------
INSERT INTO `complaint` VALUES ('1', null, 'aa', 'sdfe实际上分页器或者分页组件在现实中都有广泛着的应用，照理来说老卫没有必要单独撰文来提这茬。事实是，我近期刚好在写一门关于Spring Data、Thymeleaf 3、Bootstrap 4 的应用课程，所以用了Bootstrap 4的样式，结果之前很多例如 Bootstrap 3 的表格、分页器啊之类的插件都不能很好的兼容，百度谷歌无果，而且 Bootstrap 4 还没有出稳定版本，官网的示例也是少的可怜，最终下决心要自己写个分页器了，所用到的技术就是 Spring Data、Thymeleaf 3、Bootstrap 4 。\r\n\r\n分页器有哪些需求\r\n\r\n中国式报表从来都是最复杂的，随意衍生而来的分页器要求也是错综复杂。本例为求把分页器原理告诉给大家，所以，将分页组件的抽象为以下通用的内容：\r\n\r\n显示页码的列表；\r\n该列表的第一项是“上一页”，最后一项是“下一页”；\r\n当前选中的页码要高亮；\r\n当当前页的上一页没有页码可选时，则“上一页”置为不可点击的状态；\r\n当当前页的下一页没有页码可选时，则“下一页”置为不可点击的状态；\r\n我们很容易就能找到一个 Bootstrap 分页器的设计原型，如下图', '2018-07-31 15:26:25', '', null);
INSERT INTO `complaint` VALUES ('4', '1', 'bbb', '傻瓜', '2018-07-31 12:33:16', '000', null);
INSERT INTO `complaint` VALUES ('5', null, 'ggh', 'xdfx', '2018-07-31 15:25:29', null, null);
INSERT INTO `complaint` VALUES ('6', null, 'gky', 'yewwe', '2018-07-31 15:25:34', null, null);
INSERT INTO `complaint` VALUES ('7', null, 'xu', '订单号下', '2018-08-01 18:54:41', null, null);
INSERT INTO `complaint` VALUES ('8', null, 'ser', '丰富的海棠花', '2018-08-01 18:54:45', null, null);
INSERT INTO `complaint` VALUES ('9', null, 'skr', '换句话讲', '2018-08-01 18:54:48', null, null);
INSERT INTO `complaint` VALUES ('10', null, 'admin', '喝奶茶', '2018-08-01 18:54:51', null, null);
INSERT INTO `complaint` VALUES ('11', null, 'user1', '，如下图', '2018-08-01 18:54:56', null, null);
INSERT INTO `complaint` VALUES ('12', null, 'user2', '他', '2018-08-01 18:55:01', null, null);
INSERT INTO `complaint` VALUES ('13', null, 'user3', '豆腐汤', '2018-08-01 18:55:06', null, null);

-- ----------------------------
-- Table structure for `deliveringcompany`
-- ----------------------------
DROP TABLE IF EXISTS `deliveringcompany`;
CREATE TABLE `deliveringcompany` (
  `DeliveringCompany_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '公司编号',
  `CompanyGrade_id` int(11) NOT NULL COMMENT '等级编号',
  `DeliveringCompany_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '公司名称',
  `DeliveringCompany_contact` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '公司联系人',
  `DeliveringCompany_Mobile` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '联系方式（手机）',
  `DeliveringCompany_license` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '营业执照',
  `DeliveringCompany_address` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `DeliveringCompany_status` smallint(6) DEFAULT NULL COMMENT '状态（0：停用，1：启用）',
  `DeliveringCompany_bank` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '开户行',
  `DeliveringCompany_account` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '开户账号',
  `DeliveringCompany_disc` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '公司简介',
  `DeliveringCompany_tel` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '办公电话',
  `DeliveringCompany_createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `DeliveringCompany_reviewDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '审核日期',
  PRIMARY KEY (`DeliveringCompany_no`),
  KEY `FK_Relationship_1` (`CompanyGrade_id`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`CompanyGrade_id`) REFERENCES `companygrade` (`CompanyGrade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='团餐机构';

-- ----------------------------
-- Records of deliveringcompany
-- ----------------------------
INSERT INTO `deliveringcompany` VALUES ('1', '1', 'xihua', 'xiao', '13072865896', '111', '西华大学', '2', 'zh_bank', '5222222', 'greate', '012-4515', '2018-08-01 14:43:43', '2018-07-25 18:30:15');
INSERT INTO `deliveringcompany` VALUES ('2', '1', 'xihua', '33333', '13072865896', '111', '西华大学', '1', 'zh_bank', '5222222', 'greate', '012-4515', '2018-07-24 16:10:06', '0000-00-00 00:00:00');
INSERT INTO `deliveringcompany` VALUES ('3', '1', 'xihua', '肖乾勇', '13072865896', '111', '西华大学', '3', 'zh_bank', '5222222', 'greate', '012-4515', '2018-08-01 14:01:08', '2018-07-24 18:34:51');
INSERT INTO `deliveringcompany` VALUES ('4', '1', 'xihua', 'xxxxxx', '13072865896', '111', '1', '3', 'zh_bank', '5222222', 'greate', '012-4515', '2018-08-01 15:24:57', '2018-07-24 18:58:46');
INSERT INTO `deliveringcompany` VALUES ('5', '1', '地方地方搞活动覆盖', '1111', '4512', '1111111111111111111111', '四川省成都市郫县西华大学校本部', '0', '中国银行', '123456789111111111', '发不发给你发个很难形成大V非字符v在大V山东分公司担任公司的鬼地方个回复功能小姑娘奶粉呢v那你飞机飞规划局规划符合法规和凤凰飞规划局', '015345345', '2018-08-01 14:03:04', '2018-07-24 19:22:25');

-- ----------------------------
-- Table structure for `deliveringcompanystaff`
-- ----------------------------
DROP TABLE IF EXISTS `deliveringcompanystaff`;
CREATE TABLE `deliveringcompanystaff` (
  `DCompanyStaff_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '团餐机构员工编号',
  `DeliveringCompany_no` int(11) DEFAULT NULL COMMENT '公司编号',
  `DCompanyStaff_loginname` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '登录账号',
  `DCompanyStaff_password` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '登录密码',
  `DCompanyStaff_mobile` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `DCompanyStaff_position` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '职务',
  `DCompanyStaff_default` smallint(6) DEFAULT NULL COMMENT '是否默认账号（0：不是，1：是）',
  `DCompanyStaff_authority` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '权限',
  `DCompanyStaff_status` smallint(6) DEFAULT NULL COMMENT '状态（0：停用，1：启用）',
  `DCompanyStaff_createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`DCompanyStaff_id`),
  KEY `FK_Relationship_24` (`DeliveringCompany_no`),
  CONSTRAINT `FK_Relationship_24` FOREIGN KEY (`DeliveringCompany_no`) REFERENCES `deliveringcompany` (`DeliveringCompany_no`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='团餐机构员工';

-- ----------------------------
-- Records of deliveringcompanystaff
-- ----------------------------
INSERT INTO `deliveringcompanystaff` VALUES ('109', '2', '110', '000000', '110', 'option1', '1', 'option3,', '1', '2018-08-04 12:58:00');
INSERT INTO `deliveringcompanystaff` VALUES ('110', '2', '120', '000000', '120', 'option1', '1', '厨师,', '1', '2018-08-04 12:58:00');
INSERT INTO `deliveringcompanystaff` VALUES ('111', '2', '119', '000000', '119', 'option1', '1', '厨师,员工,', '1', '2018-08-04 12:58:01');
INSERT INTO `deliveringcompanystaff` VALUES ('112', '2', '520', '000000', '520', 'option1', '1', '厨师,', '1', '2018-08-04 12:58:01');
INSERT INTO `deliveringcompanystaff` VALUES ('113', '2', '521', '000000', '521', 'option1', '1', '员工,', '1', '2018-08-04 12:58:02');

-- ----------------------------
-- Table structure for `deliveringmaster`
-- ----------------------------
DROP TABLE IF EXISTS `deliveringmaster`;
CREATE TABLE `deliveringmaster` (
  `DeliveringMaster_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '配送单编号',
  `GroupMealUnit_id` int(11) DEFAULT NULL COMMENT '用餐单位编号',
  `DeliveringCompany_no` int(11) DEFAULT NULL COMMENT '公司编号',
  `DeliveringMaster_delivedate` timestamp NULL DEFAULT NULL COMMENT '配送日期',
  `DeliveringMaster_price` decimal(8,2) DEFAULT NULL COMMENT '单价',
  `DeliveringMaster_amount` int(11) DEFAULT NULL COMMENT '份数',
  `DeliveringMaster_memo` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `DeliveringMaster_status` smallint(6) DEFAULT NULL COMMENT '状态（0：新建，1：确认，2：已支付）',
  `DeliveringMaster_isEmergency` smallint(6) DEFAULT NULL COMMENT '是否应急配送（0：不是，1：是）',
  `DeliveringMaster_createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `DeliveringMaster_creater` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `DeliveringMaster_confirmer` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '确认人',
  PRIMARY KEY (`DeliveringMaster_id`),
  KEY `FK_Relationship_13` (`GroupMealUnit_id`),
  KEY `FK_Relationship_15` (`DeliveringCompany_no`),
  CONSTRAINT `FK_Relationship_13` FOREIGN KEY (`GroupMealUnit_id`) REFERENCES `groupmealunit` (`GroupMealUnit_id`),
  CONSTRAINT `FK_Relationship_15` FOREIGN KEY (`DeliveringCompany_no`) REFERENCES `deliveringcompany` (`DeliveringCompany_no`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='配送单';

-- ----------------------------
-- Records of deliveringmaster
-- ----------------------------
INSERT INTO `deliveringmaster` VALUES ('7', '3', '2', '2018-08-04 12:52:56', '15.00', '2', '', '0', '0', '2018-08-04 12:52:56', '520', null);
INSERT INTO `deliveringmaster` VALUES ('8', '2', '2', '2018-08-04 12:53:32', '15.00', '1', '', '0', '0', '2018-08-04 12:53:32', '250', null);

-- ----------------------------
-- Table structure for `delivering_detail`
-- ----------------------------
DROP TABLE IF EXISTS `delivering_detail`;
CREATE TABLE `delivering_detail` (
  `DeliveringDetail_no` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '配送明细序号',
  `DeliveringMaster_id` int(11) NOT NULL COMMENT '配送单编号',
  `recipe_id` int(11) NOT NULL COMMENT '食谱编号',
  `DeliveringDetail_number` int(11) DEFAULT NULL COMMENT '菜品数量',
  `DeliveringDetail_memo` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`DeliveringMaster_id`,`recipe_id`),
  KEY `FK_Relationship_23` (`recipe_id`),
  CONSTRAINT `FK_Relationship_14` FOREIGN KEY (`DeliveringMaster_id`) REFERENCES `deliveringmaster` (`DeliveringMaster_id`),
  CONSTRAINT `FK_Relationship_23` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`recipe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='配送明细';

-- ----------------------------
-- Records of delivering_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `diningstandard`
-- ----------------------------
DROP TABLE IF EXISTS `diningstandard`;
CREATE TABLE `diningstandard` (
  `Standard_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '餐标编号',
  `DeliveringCompany_no` int(11) DEFAULT NULL COMMENT '公司编号',
  `Standard_name` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `Standard_meatnumber` smallint(6) DEFAULT NULL COMMENT '荤菜个数',
  `Standard_Vegetablenumber` smallint(6) DEFAULT NULL COMMENT '素菜个数',
  `Standard_price` decimal(8,2) DEFAULT NULL COMMENT '单价',
  `Standard_IsFreeSoup` smallint(6) DEFAULT NULL COMMENT '是否赠送汤菜(0:否，1：是)',
  `Standard_IsFreeDessert` smallint(6) DEFAULT NULL COMMENT '是否赠送甜点(0:否，1：是)',
  `Standard_isFreeFruit` smallint(6) DEFAULT NULL COMMENT '是否赠送水果(0:否，1：是)',
  `Standard_CreateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`Standard_id`),
  KEY `FK_Relationship_7` (`DeliveringCompany_no`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`DeliveringCompany_no`) REFERENCES `deliveringcompany` (`DeliveringCompany_no`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='餐标';

-- ----------------------------
-- Records of diningstandard
-- ----------------------------
INSERT INTO `diningstandard` VALUES ('1', '1', '15快', '5', '5', '15.55', '1', '1', '1', '2018-07-21 16:39:40');
INSERT INTO `diningstandard` VALUES ('2', '1', '15快', '5', '5', '16.50', '1', '1', '1', '2018-07-21 16:43:21');
INSERT INTO `diningstandard` VALUES ('3', '2', '15快', '2', '1', '15.00', '1', '0', '0', '2018-08-05 14:48:08');
INSERT INTO `diningstandard` VALUES ('4', '2', '20快', '5', '2', '20.00', '1', '0', '0', '2018-08-05 14:48:11');
INSERT INTO `diningstandard` VALUES ('5', '2', '22元', '6', '3', '22.50', '0', '0', '1', '2018-08-02 18:35:42');
INSERT INTO `diningstandard` VALUES ('6', '3', '12.5快', '4', '2', '16.00', '1', '0', '0', '2018-08-05 14:49:07');
INSERT INTO `diningstandard` VALUES ('7', '3', '13kuai', '3', '3', '13.50', '0', '0', '0', '2018-08-05 14:50:00');

-- ----------------------------
-- Table structure for `foodmaterial`
-- ----------------------------
DROP TABLE IF EXISTS `foodmaterial`;
CREATE TABLE `foodmaterial` (
  `Foodmaterial_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '食材编号',
  `classification_id` int(11) DEFAULT NULL COMMENT '小类编号',
  `Foodmaterial_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '食材名称',
  `Foodmaterial_disc` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '食材描述',
  `Foodmaterial_icon` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '食材图片',
  `Foodmaterial_createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '食材创建日期',
  PRIMARY KEY (`Foodmaterial_id`),
  KEY `FK_Relationship_27` (`classification_id`),
  CONSTRAINT `FK_Relationship_27` FOREIGN KEY (`classification_id`) REFERENCES `classification` (`classification_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10003 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='食材';

-- ----------------------------
-- Records of foodmaterial
-- ----------------------------
INSERT INTO `foodmaterial` VALUES ('1', '1', '猪肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('2', '1', '排骨', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('3', '1', '猪蹄', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('4', '1', '猪肝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('5', '1', '猪肚', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('6', '1', '猪大肠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('7', '1', '瘦肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('8', '1', '里脊肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('9', '1', '五花肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('10', '1', '猪腰', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('11', '1', '金华火腿', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('12', '1', '猪心', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('13', '1', '猪脑', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('14', '1', '猪血', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('15', '1', '猪肺', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('16', '1', '猪舌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('17', '1', '猪头肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('18', '1', '火腿', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('19', '1', '猪肉皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('20', '1', '猪小肠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('21', '1', '火腿肠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('22', '1', '叉烧肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('23', '1', '猪腿肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('24', '1', '猪蹄筋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('25', '1', '猪小排', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('26', '1', '猪脊骨', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('27', '1', '猪肘', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('28', '1', '猪大排', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('29', '1', '腊肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('30', '1', '猪胰子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('31', '1', '咸肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('32', '1', '猪尾', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('33', '1', '午餐肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('34', '1', '腊肠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('35', '1', '猪脾', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('36', '1', '猪耳', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('37', '1', '后臀尖肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('38', '1', '肥肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('39', '1', '培根', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('40', '1', '猪胫骨', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('41', '1', '猪肉松', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('42', '1', '软五花肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('43', '1', '猪脬', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('44', '1', '五香熏肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('45', '1', '德国腊肠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('46', '2', '牛肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('47', '2', '牛排', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('48', '2', '牛腩', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('49', '2', '肥牛', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('50', '2', '牛肚', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('51', '2', '酱牛肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('52', '2', '牛里脊', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('53', '2', '牛尾', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('54', '2', '牛蹄筋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('55', '2', '牛肝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('56', '2', '牛腱子肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('57', '2', '牛舌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('58', '2', '牛骨', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('59', '2', '牛心', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('60', '2', '牛腰子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('61', '2', '牛鞭', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('62', '2', '牛脊髓', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('63', '2', '牛肉干', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('64', '2', '牛蹄', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('65', '2', '牛肺', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('66', '2', '牛腿肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('67', '2', '牛血', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('68', '2', '牛脑', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('69', '2', '牛肉熏肠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('70', '3', '羊肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('71', '3', '羊排', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('72', '3', '羊腿肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('73', '3', '羊肝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('74', '3', '羊肚', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('75', '3', '羊骨', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('76', '3', '羊里脊', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('77', '3', '羊腰子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('78', '3', '羊心', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('79', '3', '羊血', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('80', '3', '羊脑', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('81', '3', '羊肺', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('82', '3', '羊尾', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('83', '3', '羊头肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('84', '3', '羊蹄肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('85', '3', '羊眼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('86', '3', '羊肠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('87', '3', '羊脊髓', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('88', '3', '羊蹄筋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('89', '3', '羊耳', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('90', '3', '羊舌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('91', '4', '鸡肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('92', '4', '鸡翅', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('93', '4', '鸡腿', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('94', '4', '鸡爪', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('95', '4', '乌鸡', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('96', '4', '鸡肝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('97', '4', '鸡胸脯肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('98', '4', '鸡胗', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('99', '4', '野鸡', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('100', '4', '童子鸡', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('101', '4', '鸡内金', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('102', '4', '鸡心', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('103', '4', '鸡血', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('104', '4', '火鸡', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('105', '4', '母鸡', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('106', '4', '鸡腰子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('107', '4', '鸡皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('108', '4', '珍珠鸡', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('109', '4', '公鸡', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('110', '4', '鸡骨架', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('111', '4', '火鸡腿', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('112', '4', '鸡肠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('113', '4', '鸡头', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('114', '4', '鸡脖子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('115', '4', '火鸡胸脯肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('116', '4', '鸡冠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('117', '4', '火鸡肝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('118', '5', '鸭肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('119', '5', '鸭翅', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('120', '5', '鸭舌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('121', '5', '鸭肠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('122', '5', '鸭肝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('123', '5', '鸭掌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('124', '5', '鸭胗', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('125', '5', '鸭头', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('126', '5', '鸭血', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('127', '5', '野鸭', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('128', '5', '烤鸭', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('129', '5', '鸭心', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('130', '5', '烧鸭', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('131', '5', '北京填鸭', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('132', '5', '鸭胸脯肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('133', '5', '鸭脖', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('134', '5', '鸭骨', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('135', '5', '鸭皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('136', '5', '鸭腰', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('137', '5', '鸭胰', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('138', '6', '鹅肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('139', '6', '鹅翅', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('140', '6', '鹅舌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('141', '6', '鹅肠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('142', '6', '鹅肝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('143', '6', '鹅掌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('144', '6', '鹅胗', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('145', '6', '鹅头', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('146', '6', '鹅血', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('147', '6', '野鹅', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('148', '6', '烤鹅', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('149', '6', '鹅心', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('150', '6', '烧鹅', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('151', '6', '鹅胸脯肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('152', '6', '鹅脖', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('153', '6', '鹅骨', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('154', '6', '鹅皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('155', '6', '鹅腰', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('156', '6', '鹅胰', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('157', '7', '鸡蛋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('158', '7', '咸鸭蛋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('159', '7', '鹌鹑蛋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('160', '7', '鸡蛋黄', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('161', '7', '鸭蛋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('162', '7', '皮蛋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('163', '7', '鸡蛋清', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('164', '7', '鸽蛋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('165', '7', '鹅蛋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('166', '7', '鸡蛋黄粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('167', '7', '蛋饺', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('168', '8', '兔肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('169', '8', '牛蛙', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('170', '8', '燕窝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('171', '8', '鸽肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('172', '8', '狗肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('173', '8', '田鸡', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('174', '8', '驴肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('175', '8', '兔头', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('176', '8', '鹿肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('177', '8', '麻雀', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('178', '8', '鹌鹑肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('179', '8', '斑鸠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('180', '8', '鹧鸪', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('181', '8', '香肠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('182', '8', '熊掌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('183', '8', '麂子肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('184', '8', '果子狸', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('185', '8', '蜗牛', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('186', '8', '蚕蛹', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('187', '8', '雏鸽', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('188', '8', '肉皮清冻', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('189', '8', '禾花雀', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('190', '8', '热狗', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('191', '8', '雁肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('192', '8', '驼峰', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('193', '8', '黄雀', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('194', '8', '泥肠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('195', '8', '鹿肾', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('196', '8', '茶肠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('197', '8', '海狗', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('198', '17', '鲫鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('199', '17', '草鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('200', '17', '带鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('201', '17', '鳕鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('202', '17', '鲢鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('203', '17', '泥鳅', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('204', '17', '鳝鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('205', '17', '鲤鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('206', '17', '鲶鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('207', '17', '大黄鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('208', '17', '甲鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('209', '17', '黑鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('210', '17', '墨鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('211', '17', '鲈鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('212', '17', '鲅鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('213', '17', '金枪鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('214', '17', '鲑鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('215', '17', '银鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('216', '17', '鱼翅', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('217', '17', '鱼肚', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('218', '17', '鱿鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('219', '17', '沙丁鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('220', '17', '青鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('221', '17', '鱼丸', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('222', '17', '章鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('223', '17', '平鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('224', '17', '咸鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('225', '17', '武昌鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('226', '17', '小黄鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('227', '17', '鱼籽', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('228', '17', '鲢鱼头', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('229', '17', '鳜鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('230', '17', '石斑鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('231', '17', '鱿鱼干', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('232', '17', '柴鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('233', '17', '海鳗', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('234', '17', '银鱼干', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('235', '17', '罗非鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('236', '17', '鲭鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('237', '17', '秋刀鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('238', '17', '鲟鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('239', '17', '河鳗', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('240', '17', '鲮鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('241', '17', '鱼皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('242', '17', '鳙鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('243', '17', '白鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('244', '17', '鲨鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('245', '17', '墨鱼仔', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('246', '17', '鳟鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('247', '17', '加吉鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('248', '17', '墨鱼干', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('249', '17', '鱼唇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('250', '17', '凤尾鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('251', '17', '鲥鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('252', '17', '鳎目鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('253', '17', '虱目鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('254', '17', '鲻鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('255', '17', '鲱鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('256', '17', '鳓鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('257', '17', '鱼子酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('258', '17', '红衫鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('259', '17', '鱼骨', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('260', '17', '黄钻鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('261', '17', '塘鳢鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('262', '17', '乌鱼蛋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('263', '17', '草鱼肠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('264', '17', '梭子鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('265', '17', '孔鳐', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('266', '17', '鲆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('267', '17', '鲽', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('268', '17', '鲮鱼罐头', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('269', '17', '月鳢', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('270', '17', '鱼筋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('271', '17', '绿鳍马面豚', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('272', '17', '青鱼肝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('273', '17', '三文鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('274', '17', '白虾', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('275', '18', '河虾', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('276', '18', '小龙虾', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('277', '18', '虾仁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('278', '18', '龙虾', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('279', '18', '基围虾', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('280', '18', '明虾', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('281', '18', '虾皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('282', '18', '对虾', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('283', '18', '虾米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('284', '18', '海虾', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('285', '18', '虾酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('286', '18', '皮皮虾', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('287', '18', '草虾', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('288', '18', '青虾', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('289', '18', '虾籽', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('290', '18', '虾脑酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('291', '19', '螃蟹', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('292', '19', '青蟹', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('293', '19', '海蟹', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('294', '19', '蟹肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('295', '19', '蟹黄', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('296', '20', '鲍鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('297', '20', '扇贝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('298', '20', '海螺', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('299', '20', '干贝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('300', '20', '蛏子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('301', '20', '田螺', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('302', '20', '河蚌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('303', '20', '蛤蜊', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('304', '20', '淡菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('305', '20', '海虹', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('306', '20', '鲜贝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('307', '20', '蚬子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('308', '20', '螺', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('309', '20', '海蚌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('310', '20', '蛏干', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('311', '20', '香螺', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('312', '20', '赤贝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('313', '20', '泥蚶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('314', '21', '海参', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('315', '21', '海带', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('316', '21', '紫菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('317', '21', '海蜇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('318', '21', '乌龟', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('319', '21', '海蜇头', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('320', '21', '鲍鱼干', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('321', '21', '海藻', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('322', '21', '琼脂', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('323', '21', '蚝豉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('324', '21', '海白菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('325', '21', '蛤士蟆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('326', '21', '石花菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('327', '21', '裙带菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('328', '21', '海肠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('329', '21', '珍珠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('330', '22', '白菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('331', '22', '油菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('332', '22', '韭菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('333', '22', '菠菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('334', '22', '空心菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('335', '22', '西兰花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('336', '22', '圆白菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('337', '22', '小白菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('338', '22', '绿豆芽', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('339', '22', '生菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('340', '22', '芦笋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('341', '22', '鱼腥草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('342', '22', '莴笋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('343', '22', '芹菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('344', '22', '荠菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('345', '22', '黄花菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('346', '22', '紫甘蓝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('347', '22', '马齿苋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('348', '22', '香椿', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('349', '22', '香菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('350', '22', '芥菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('351', '22', '芹菜叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('352', '22', '黄豆芽', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('353', '22', '茼蒿', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('354', '22', '茴香', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('355', '22', '木耳菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('356', '22', '大葱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('357', '22', '酸白菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('358', '22', '芥蓝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('359', '22', '娃娃菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('360', '22', '九层塔', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('361', '22', '蕨菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('362', '22', '西芹', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('363', '22', '苜蓿', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('364', '22', '苤蓝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('365', '22', '蒜苔', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('366', '22', '豌豆苗', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('367', '22', '莼菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('368', '22', '甜菜根', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('369', '22', '苋菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('370', '22', '韭黄', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('371', '22', '豌豆尖', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('372', '22', '马兰', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('373', '22', '水芹菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('374', '22', '番薯叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('375', '22', '油麦菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('376', '22', '冬寒菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('377', '22', '萝卜缨', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('378', '22', '油菜心', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('379', '22', '小葱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('380', '22', '芝麻叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('381', '22', '竹叶菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('382', '22', '薇菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('383', '22', '牛皮菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('384', '22', '大白菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('385', '22', '螺丝菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('386', '22', '葱白', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('387', '22', '豆瓣菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('388', '22', '野苋菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('389', '22', '小蒜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('390', '22', '辣白菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('391', '22', '韭苔', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('392', '22', '香芹', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('393', '22', '孢子甘蓝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('394', '22', '清明菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('395', '22', '蒜黄', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('396', '22', '苣荬菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('397', '22', '蒲菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('398', '22', '莴苣', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('399', '22', '野韭菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('400', '22', '野葱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('401', '22', '白菜薹', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('402', '22', '油菜薹', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('403', '22', '蒌蒿', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('404', '22', '灰条菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('405', '22', '紫菜薹', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('406', '22', '辣根', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('407', '22', '牛蒡叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('408', '22', '乌菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('409', '22', '榆钱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('410', '22', '冲菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('411', '22', '掐不齐', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('412', '22', '小叶芥菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('413', '22', '葡萄叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('414', '22', '海芥兰', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('415', '22', '韭葱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('416', '22', '荞菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('417', '22', '青葱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('418', '22', '甜菜叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('419', '22', '野苣', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('420', '22', '红菊苣', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('421', '22', '大蓟', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('422', '22', '槐树芽', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('423', '22', '蒜白', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('424', '22', '薰衣草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('425', '22', '泥胡菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('426', '22', '雪菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('427', '22', '芥兰', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('428', '23', '土豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('429', '23', '胡萝卜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('430', '23', '山药', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('431', '23', '白萝卜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('432', '23', '洋葱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('433', '23', '莲藕', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('434', '23', '竹笋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('435', '23', '芋头', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('436', '23', '魔芋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('437', '23', '藕粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('438', '23', '荸荠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('439', '23', '百合', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('440', '23', '姜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('441', '23', '红萝卜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('442', '23', '甘薯', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('443', '23', '春笋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('444', '23', '冬笋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('445', '23', '水萝卜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('446', '23', '玉兰片', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('447', '23', '青萝卜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('448', '23', '慈姑', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('449', '23', '笋干', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('450', '23', '萝卜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('451', '23', '芥菜头', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('452', '23', '木薯', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('453', '23', '大蒜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('454', '23', '青蒜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('455', '23', '子姜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('456', '23', '荸荠粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('457', '23', '洋姜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('458', '23', '心里美萝卜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('459', '23', '甘薯粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('460', '23', '豆薯', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('461', '23', '葛根', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('462', '23', '地笋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('463', '23', '荠菜根', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('464', '23', '芜菁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('465', '23', '干菜笋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('466', '23', '甘薯片', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('467', '23', '黑芥', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('468', '23', '意大利红洋葱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('469', '23', '芹黄', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('470', '23', '紫薯', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('471', '23', '扁尖', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('472', '24', '南瓜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('473', '24', '黄瓜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('474', '24', '苦瓜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('475', '24', '冬瓜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('476', '24', '丝瓜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('477', '24', '茄子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('478', '24', '番茄', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('479', '24', '豇豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('480', '24', '青椒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('481', '24', '辣椒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('482', '24', '菜花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('483', '24', '豌豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('484', '24', '蚕豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('485', '24', '茭白', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('486', '24', '西葫芦', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('487', '24', '毛豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('488', '24', '扁豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('489', '24', '四季豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('490', '24', '秋葵', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('491', '24', '芸豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('492', '24', '柿子椒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('493', '24', '刀豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('494', '24', '葫芦', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('495', '24', '菱角', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('496', '24', '节瓜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('497', '24', '菜瓜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('498', '24', '樱桃番茄', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('499', '24', '青尖椒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('500', '24', '菱角粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('501', '24', '瓠瓜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('502', '24', '豌豆淀粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('503', '24', '红尖椒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('504', '24', '干葫芦条', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('505', '24', '四棱豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('506', '24', '杭椒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('507', '24', '冬瓜籽', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('508', '24', '荷兰豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('509', '24', '小米椒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('510', '25', '香菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('511', '25', '平菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('512', '25', '银耳', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('513', '25', '木耳', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('514', '25', '金针菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('515', '25', '口蘑', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('516', '25', '蘑菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('517', '25', '猴头菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('518', '25', '竹荪', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('519', '25', '发菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('520', '25', '杏鲍菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('521', '25', '草菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('522', '25', '红菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('523', '25', '干香菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('524', '25', '滑子菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('525', '25', '花菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('526', '25', '石耳', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('527', '25', '白灵菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('528', '25', '鹿角菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('529', '25', '羊肚菌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('530', '25', '松蘑', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('531', '25', '鸡枞', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('532', '25', '蟹味菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('533', '25', '柳松茸', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('534', '25', '凤尾菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('535', '25', '葛仙米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('536', '25', '牛肝菌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('537', '25', '黄耳', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('538', '25', '鸡腿菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('539', '25', '干巴菌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('540', '25', '榛蘑', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('541', '25', '白菌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('542', '25', '灰树花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('543', '25', '榆黄蘑', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('544', '25', '白参菌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('545', '25', '鸡油菌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('546', '25', '羊栖菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('547', '25', '青头菌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('548', '25', '罐装金针菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('549', '25', '栽培洋菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('550', '25', '茶树菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('551', '25', '姬松茸', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('552', '25', '白玉菇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('553', '26', '玫瑰花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('554', '26', '菊花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('555', '26', '韭菜花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('556', '26', '桂花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('557', '26', '贡菊', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('558', '27', '黑豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('559', '27', '绿豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('560', '27', '赤小豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('561', '27', '大豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('562', '27', '青豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('563', '27', '白扁豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('564', '27', '眉豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('565', '27', '纳豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('566', '27', '大白豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('567', '27', '干刀豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('568', '27', '斑豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('569', '27', '绿扁豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('570', '27', '红腰豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('571', '27', '美国大杏仁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('572', '28', '豆腐', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('573', '28', '南豆腐', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('574', '28', '豆浆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('575', '28', '腐竹', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('576', '28', '冻豆腐', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('577', '28', '豆腐干', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('578', '28', '素鸡', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('579', '28', '豆腐脑', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('580', '28', '香干', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('581', '28', '内酯豆腐', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('582', '28', '红豆沙', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('583', '28', '北豆腐', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('584', '28', '日本豆腐', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('585', '28', '黄豆粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('586', '28', '豆腐渣', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('587', '28', '干豆腐', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('588', '28', '油皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('589', '28', '绿豆沙', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('590', '28', '油豆腐', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('591', '28', '绿豆面', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('592', '28', '蚕豆淀粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('593', '28', '烤麸', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('594', '28', '素火腿', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('595', '28', '素肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('596', '28', '素虾', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('597', '28', '素鱼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('598', '28', '永川豆豉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('599', '28', '老干妈豆豉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('600', '29', '大米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('601', '29', '小米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('602', '29', '薏米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('603', '29', '燕麦', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('604', '29', '黑米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('605', '29', '糙米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('606', '29', '糯米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('607', '29', '荞麦', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('608', '29', '玉米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('609', '29', '燕麦片', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('610', '29', '芡实米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('611', '29', '粳米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('612', '29', '馒头', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('613', '29', '玉米面', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('614', '29', '西谷米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('615', '29', '米饭', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('616', '29', '甜玉米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('617', '29', '高粱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('618', '29', '大麦', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('619', '29', '小麦', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('620', '29', '玉米淀粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('621', '29', '香米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('622', '29', '黄米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('623', '29', '紫糯米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('624', '29', '籼米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('625', '29', '玉米笋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('626', '29', '黄玉米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('627', '29', '稷米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('628', '29', '白玉米', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('629', '30', '面粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('630', '30', '糯米粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('631', '30', '通心粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('632', '30', '澄粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('633', '30', '粉丝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('634', '30', '油面筋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('635', '30', '粉条', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('636', '30', '面条', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('637', '30', '水面筋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('638', '30', '莜麦面', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('639', '30', '小米面', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('640', '30', '面肥', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('641', '30', '籼米粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('642', '30', '河粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('643', '30', '意大利面', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('644', '30', '全麦粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('645', '30', '烙饼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('646', '30', '苦荞麦粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('647', '30', '挂面', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('648', '30', '黄米面', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('649', '30', '太白粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('650', '30', '荞麦粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('651', '30', '冷面', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('652', '30', '小麦麸', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('653', '30', '小麦富强粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('654', '30', '长形意大利面条', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('655', '30', '螺旋面', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('656', '30', '乌冬面', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('657', '30', '米粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('658', '30', '低筋面粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('659', '30', '高筋面粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('660', '30', '自发粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('661', '31', '年糕', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('662', '31', '凉粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('663', '31', '粉皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('664', '31', '汤圆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('665', '31', '凉面', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('666', '31', '蛋糕', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('667', '31', '春卷', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('668', '31', '窝窝头', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('669', '31', '油炒面', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('670', '31', '煎饼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('671', '31', '薄脆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('672', '31', '锅巴', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('673', '31', '面皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('674', '31', '麻花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('675', '31', '油炸馓子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('676', '31', '原味蛋糕', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('677', '31', '鸡蛋黄糕', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('678', '31', '烧饼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('679', '31', '果胶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('680', '31', '威化', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('681', '31', '起酥派皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('682', '31', '甜派皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('683', '31', '果冻', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('684', '31', '龙虾片', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('685', '31', '焦圈', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('686', '31', '咸派皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('687', '31', '龟苓膏粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('688', '32', '面包', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('689', '32', '油条', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('690', '32', '饼干', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('691', '32', '炸薯片', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('692', '32', '油饼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('693', '32', '面包屑', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('694', '32', '吐司', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('695', '32', '咸面包', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('696', '32', '金丝银卷', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('697', '32', '面包糠', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('698', '32', '麦片', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('699', '33', '木瓜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('700', '33', '苹果', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('701', '33', '草莓', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('702', '33', '桂圆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('703', '33', '梨', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('704', '33', '柠檬', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('705', '33', '猕猴桃', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('706', '33', '菠萝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('707', '33', '芒果', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('708', '33', '山楂', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('709', '33', '樱桃', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('710', '33', '无花果', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('711', '33', '柿子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('712', '33', '葡萄干', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('713', '33', '番石榴', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('714', '33', '西瓜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('715', '33', '椰子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('716', '33', '桂圆肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('717', '33', '火龙果', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('718', '33', '荔枝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('719', '33', '香蕉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('720', '33', '柿饼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('721', '33', '枣', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('722', '33', '柚子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('723', '33', '橘子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('724', '33', '蜜枣', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('725', '33', '哈密瓜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('726', '33', '橄榄', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('727', '33', '枇杷', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('728', '33', '李子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('729', '33', '甘蔗', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('730', '33', '桑椹', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('731', '33', '桃', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('732', '33', '蓝莓', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('733', '33', '葡萄', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('734', '33', '金橘', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('735', '33', '橙子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('736', '33', '杏', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('737', '33', '西番莲', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('738', '33', '梅子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('739', '33', '椰蓉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('740', '33', '甜瓜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('741', '33', '椰子肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('742', '33', '杨梅', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('743', '33', '柑橘', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('744', '33', '椰浆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('745', '33', '刺梨', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('746', '33', '菠萝蜜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('747', '33', '葡萄柚', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('748', '33', '鸭梨', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('749', '33', '杨桃', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('750', '33', '无花果干', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('751', '33', '石榴', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('752', '33', '山竹', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('753', '33', '雪花梨', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('754', '33', '蜜桃', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('755', '33', '香梨', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('756', '33', '紫葡萄', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('757', '33', '黑枣', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('758', '33', '酸枣', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('759', '33', '白兰瓜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('760', '33', '杏干', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('761', '33', '海棠果', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('762', '33', '蜜橘', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('763', '33', '马奶子葡萄', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('764', '33', '巴梨', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('765', '33', '芦柑', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('766', '33', '京白梨', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('767', '33', '小枣', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('768', '33', '蔓越莓', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('769', '33', '李干', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('770', '33', '蜜柑', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('771', '33', '脐橙', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('772', '34', '花生', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('773', '34', '核桃', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('774', '34', '芝麻', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('775', '34', '栗子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('776', '34', '腰果', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('777', '34', '松子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('778', '34', '花生仁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('779', '34', '开心果', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('780', '34', '枸杞', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('781', '34', '莲子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('782', '34', '杏仁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('783', '34', '黑芝麻', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('784', '34', '白果', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('785', '34', '松子仁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('786', '34', '白芝麻', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('787', '34', '甜杏仁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('788', '34', '桃仁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('789', '34', '南瓜子仁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('790', '34', '葵花子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('791', '34', '南瓜子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('792', '34', '榛子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('793', '34', '葵花子仁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('794', '34', '西瓜子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('795', '34', '西瓜子仁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('796', '34', '花生粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('797', '34', '榧子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('798', '34', '榛子仁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('799', '35', '黄芪', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('800', '35', '当归', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('801', '35', '决明子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('802', '35', '冬虫夏草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('803', '35', '何首乌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('804', '35', '肉苁蓉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('805', '35', '罗汉果', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('806', '35', '西洋参', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('807', '35', '芦荟', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('808', '35', '人参', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('809', '35', '天麻', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('810', '35', '阿胶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('811', '35', '益母草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('812', '35', '杜仲', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('813', '35', '紫苏叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('814', '35', '鹿茸', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('815', '35', '黄精', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('816', '35', '党参', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('817', '35', '高丽参', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('818', '35', '丁香', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('819', '35', '茯苓', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('820', '35', '牡蛎', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('821', '35', '五味子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('822', '35', '西瓜皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('823', '35', '甘草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('824', '35', '陈皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('825', '35', '槐花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('826', '35', '川贝母', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('827', '35', '荷叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('828', '35', '雪蛤膏', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('829', '35', '蛇肉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('830', '35', '石斛', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('831', '35', '丹参', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('832', '35', '三七', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('833', '35', '白芷', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('834', '35', '玉米须', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('835', '35', '薄荷', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('836', '35', '乌梅', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('837', '35', '紫河车', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('838', '35', '干山药', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('839', '35', '车前草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('840', '35', '川芎', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('841', '35', '枸杞叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('842', '35', '玉竹', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('843', '35', '仙人掌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('844', '35', '红花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('845', '35', '槟榔', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('846', '35', '夏枯草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('847', '35', '砂仁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('848', '35', '苦杏仁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('849', '35', '白术', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('850', '35', '蛤蚧', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('851', '35', '穿山甲', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('852', '35', '鳖甲', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('853', '35', '太子参', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('854', '35', '桑叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('855', '35', '桔梗', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('856', '35', '巴戟天', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('857', '35', '菟丝子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('858', '35', '火麻仁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('859', '35', '草果', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('860', '35', '酸枣仁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('861', '35', '淫羊藿', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('862', '35', '马兰头', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('863', '35', '生地黄', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('864', '35', '桑椹子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('865', '35', '灵芝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('866', '35', '艾叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('867', '35', '熟地黄', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('868', '35', '松针', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('869', '35', '锁阳', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('870', '35', '女贞子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('871', '35', '金银花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('872', '35', '山茱萸', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('873', '35', '土茯苓', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('874', '35', '鸡血藤', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('875', '35', '鹿筋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('876', '35', '穿心莲', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('877', '35', '牛膝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('878', '35', '驴鞭', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('879', '35', '附子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('880', '35', '瓜蒌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('881', '35', '佛手', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('882', '35', '独脚金', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('883', '35', '车前子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('884', '35', '通草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('885', '35', '狗鞭', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('886', '35', '海马', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('887', '35', '紫苏子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('888', '35', '桑寄生', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('889', '35', '茵陈蒿', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('890', '35', '肉豆蔻', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('891', '35', '益智仁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('892', '35', '西红花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('893', '35', '山楂干', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('894', '35', '旱莲草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('895', '35', '白芍药', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('896', '35', '肉桂', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('897', '35', '麦门冬', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('898', '35', '干姜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('899', '35', '黄芩', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('900', '35', '鸡骨草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('901', '35', '百里香', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('902', '35', '北沙参', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('903', '35', '山慈姑', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('904', '35', '红参', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('905', '35', '五加皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('906', '35', '蒲公英', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('907', '35', '草豆蔻', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('908', '35', '桃花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('909', '35', '藿香', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('910', '35', '洛神花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('911', '35', '鹿角胶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('912', '35', '冬瓜皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('913', '35', '天门冬', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('914', '35', '柏子仁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('915', '35', '牛蒡根', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('916', '35', '南沙参', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('917', '35', '土三七', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('918', '35', '地骨皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('919', '35', '柴胡', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('920', '35', '辛夷', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('921', '35', '橙皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('922', '35', '剑花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('923', '35', '茉莉花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('924', '35', '芦荟花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('925', '35', '覆盆子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('926', '35', '马钱子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('927', '35', '白花蛇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('928', '35', '蜈蚣', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('929', '35', '花椒叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('930', '35', '蚕茧', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('931', '35', '百合花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('932', '35', '白豆蔻', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('933', '35', '骨碎补', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('934', '35', '仙鹤草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('935', '35', '高良姜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('936', '35', '桂枝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('937', '35', '青蒿', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('938', '35', '荆芥', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('939', '35', '乌梢蛇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('940', '35', '万年青', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('941', '35', '白参', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('942', '35', '丝瓜络', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('943', '35', '半夏', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('944', '35', '淡豆豉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('945', '35', '人参须', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('946', '35', '天花粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('947', '35', '麦芽', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('948', '35', '桑白皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('949', '35', '金樱子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('950', '35', '夜香花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('951', '35', '木香', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('952', '35', '夜交藤', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('953', '35', '野菊花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('954', '35', '香附', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('955', '35', '地龙', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('956', '35', '续断', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('957', '35', '香薷', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('958', '35', '栀子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('959', '35', '胖大海', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('960', '35', '枇杷叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('961', '35', '荜茇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('962', '35', '补骨脂', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('963', '35', '水蛇', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('964', '35', '山稔子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('965', '35', '麻黄', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('966', '35', '胡椒根', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('967', '35', '葱须', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('968', '35', '白花蛇舌草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('969', '35', '莲花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('970', '35', '防风', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('971', '35', '浮小麦', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('972', '35', '黄连', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('973', '35', '泽泻', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('974', '35', '龙骨', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('975', '35', '百部', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('976', '35', '白及', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('977', '35', '海螵蛸', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('978', '35', '荆芥穗', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('979', '35', '鲜菊花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('980', '35', '芦根', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('981', '35', '芭蕉花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('982', '35', '王不留行', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('983', '35', '淡竹叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('984', '35', '狗脊', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('985', '35', '侧柏叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('986', '35', '苍术', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('987', '35', '白茅根', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('988', '35', '细辛', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('989', '35', '薤白', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('990', '35', '合欢皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('991', '35', '干葛根', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('992', '35', '羚羊角', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('993', '35', '月季花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('994', '35', '龟胶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('995', '35', '藕节', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('996', '35', '狗肝菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('997', '35', '水蛭', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('998', '35', '威灵仙', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('999', '35', '郁金', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1000', '35', '手掌参', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1001', '35', '水葫芦', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1002', '35', '苍耳子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1003', '35', '石决明', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1004', '35', '石榴皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1005', '35', '合欢花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1006', '35', '使君子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1007', '35', '马鞭草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1008', '35', '仙茅', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1009', '35', '鸭舌草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1010', '35', '苦参', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1011', '35', '灯心草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1012', '35', '豕希莶草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1013', '35', '沉香', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1014', '35', '全蝎', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1015', '35', '川乌头', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1016', '35', '绿豆花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1017', '35', '白僵蚕', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1018', '35', '生姜皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1019', '35', '禾虫', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1020', '35', '沙苑蒺藜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1021', '35', '蝉蜕', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1022', '35', '竹茹', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1023', '35', '桑螵蛸', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1024', '35', '佩兰', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1025', '35', '板蓝根', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1026', '35', '鹅肠草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1027', '35', '九香虫', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1028', '35', '半边莲', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1029', '35', '朱砂', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1030', '35', '络石藤', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1031', '35', '败酱草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1032', '35', '紫花地丁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1033', '35', '牡丹皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1034', '35', '土大黄', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1035', '35', '塘葛菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1036', '35', '玄参', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1037', '35', '香橼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1038', '35', '谷精草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1039', '35', '萆解', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1040', '35', '蛇蜕', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1041', '35', '龟甲', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1042', '35', '麝香', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1043', '35', '襄荷', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1044', '35', '小蓟', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1045', '35', '葛花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1046', '35', '冰片', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1047', '35', '吴茱萸', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1048', '35', '桑枝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1049', '35', '羌活', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1050', '35', '百灵草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1051', '35', '鸡冠花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1052', '35', '地锦草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1053', '35', '乌灵参', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1054', '35', '猪苓', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1055', '35', '枳实', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1056', '35', '秦艽', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1057', '35', '白芥子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1058', '35', '白附子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1059', '35', '莱菔子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1060', '35', '青风藤', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1061', '35', '桂子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1062', '35', '红豆蔻', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1063', '35', '羊脂', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1064', '35', '泽兰', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1065', '35', '露蜂房', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1066', '35', '石上柏', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1067', '35', '川牛膝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1068', '35', '柑杞', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1069', '35', '知母', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1070', '35', '乌药', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1071', '35', '蒲黄', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1072', '35', '延胡索', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1073', '35', '甘松', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1074', '35', '虎杖', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1075', '35', '赤芍药', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1076', '35', '款冬花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1077', '35', '石菖蒲', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1078', '35', '白头翁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1079', '35', '磁石', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1080', '35', '排草香', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1081', '35', '珍珠母', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1082', '35', '苎麻根', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1083', '35', '刺蒺藜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1084', '35', '牵牛子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1085', '35', '水竹叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1086', '35', '川楝子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1087', '35', '地鳖', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1088', '35', '金雀花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1089', '35', '罗布麻', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1090', '35', '野菊', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1091', '35', '苦竹叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1092', '35', '蔓荆子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1093', '35', '黄荆子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1094', '35', '远志', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1095', '35', '鹿角霜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1096', '35', '神曲', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1097', '35', '升麻', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1098', '35', '檀香', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1099', '35', '垂盆草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1100', '35', '漏芦', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1101', '35', '浙贝母', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1102', '35', '海风藤', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1103', '35', '地榆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1104', '35', '茜草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1105', '35', '树子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1106', '35', '钩藤', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1107', '35', '金达莱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1108', '35', '冬葵子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1109', '35', '伸筋藤', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1110', '35', '北豆根', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1111', '35', '青葙子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1112', '35', '鹤顶草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1113', '35', '小旋花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1114', '35', '夜明砂', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1115', '35', '寻骨风', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1116', '35', '雀卵', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1117', '35', '酸模', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1118', '35', '常山', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1119', '35', '滑石', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1120', '35', '椿白皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1121', '35', '防己', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1122', '35', '银柴胡', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1123', '35', '藁本', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1124', '35', '爵床', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1125', '35', '郁李仁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1126', '35', '海桐皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1127', '35', '南藤', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1128', '35', '萍蓬草根', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1129', '35', '旋覆花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1130', '35', '芫花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1131', '35', '前胡', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1132', '35', '苍术苗', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1133', '35', '樗白皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1134', '35', '木棉花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1135', '35', '仙草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1136', '35', '刺老芽', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1137', '36', '辣椒酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1138', '36', '酱油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1139', '36', '咖喱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1140', '36', '豆豉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1141', '36', '八角', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1142', '36', '盐', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1143', '36', '醋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1144', '36', '泡菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1145', '36', '番茄酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1146', '36', '花椒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1147', '36', '芝麻酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1148', '36', '泡打粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1149', '36', '泡椒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1150', '36', '椒盐', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1151', '36', '豆瓣酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1152', '36', '芥末', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1153', '36', '霉干菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1154', '36', '红曲', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1155', '36', '苏打粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1156', '36', '桂皮', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1157', '36', '花生酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1158', '36', '甜面酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1159', '36', '黄酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1160', '36', '鱼露', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1161', '36', '白醋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1162', '36', '孜然', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1163', '36', '味精', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1164', '36', '料酒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1165', '36', '腌雪里蕻', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1166', '36', '胡椒粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1167', '36', '蚝油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1168', '36', '榨菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1169', '36', '酸黄瓜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1170', '36', '吉士粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1171', '36', '胡椒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1172', '36', '番茄汁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1173', '36', '冬菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1174', '36', '卤汁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1175', '36', '嫩肉粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1176', '36', '豆瓣', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1177', '36', '姜汁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1178', '36', '碱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1179', '36', '酵母', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1180', '36', '贡菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1181', '36', '色拉酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1182', '36', '腐乳', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1183', '36', '桂花酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1184', '36', '味噌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1185', '36', '沙姜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1186', '36', '葱油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1187', '36', '发酵粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1188', '36', '腌韭菜花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1189', '36', '沙茶酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1190', '36', '香叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1191', '36', '糖色', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1192', '36', '芽菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1193', '36', '五香粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1194', '36', '酱黄瓜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1195', '36', '罗勒叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1196', '36', '果冻粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1197', '36', '花椒油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1198', '36', '白矾', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1199', '36', '陈醋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1200', '36', '肉桂粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1201', '36', '糖蒜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1202', '36', '番茄沙司', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1203', '36', '萝卜干', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1204', '36', '苹果醋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1205', '36', '鸡精', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1206', '36', '芡粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1207', '36', '花椒粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1208', '36', '白胡椒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1209', '36', '生抽', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1210', '36', '米醋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1211', '36', '茴香籽', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1212', '36', '塔塔粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1213', '36', '黑醋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1214', '36', '野山椒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1215', '36', '虾油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1216', '36', '蒸肉粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1217', '36', '吉利丁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1218', '36', '食用色素', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1219', '36', '白酱油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1220', '36', '辣椒粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1221', '36', '老抽', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1222', '36', '蜜糖', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1223', '36', '香茅', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1224', '36', '红糟', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1225', '36', '柱侯酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1226', '36', '豆瓣辣酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1227', '36', '香醋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1228', '36', '酱萝卜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1229', '36', '腌芥菜头', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1230', '36', '茴香粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1231', '36', '芥末油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1232', '36', '香糟', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1233', '36', '鸡粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1234', '36', '熟石膏粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1235', '36', '粗盐', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1236', '36', '芝麻花生酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1237', '36', '辣酱油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1238', '36', '香草精', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1239', '36', '醋精', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1240', '36', '臭豆腐', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1241', '36', '杏酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1242', '36', '乳黄瓜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1243', '36', '蒜蓉辣酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1244', '36', '酱油膏', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1245', '36', '迷迭香', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1246', '36', '糖醋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1247', '36', '八宝菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1248', '36', '腐乳汁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1249', '36', '芥菜干', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1250', '36', '干腌菜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1251', '36', '葱汁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1252', '36', '苹果酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1253', '36', '天妇罗', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1254', '36', '红辣椒粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1255', '36', '酱姜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1256', '36', '番茄甜辣酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1257', '36', '香精', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1258', '36', '胡葱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1259', '36', '甜醋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1260', '36', '鲜味王', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1261', '36', '栗子酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1262', '36', '蜂乳', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1263', '36', '干豆豉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1264', '36', '酸豆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1265', '36', '酒醋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1266', '36', '玉米酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1267', '36', '芥菜子', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1268', '36', '阳起石', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1269', '36', '小豆蔻', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1270', '36', '甜酱油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1271', '36', '海盐', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1272', '36', '牛肉精', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1273', '36', '生石灰', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1274', '36', '百香果果酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1275', '36', '牛至', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1276', '36', '葡萄酒醋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1277', '36', '香油辣酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1278', '36', '牛肉辣瓣酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1279', '36', '细叶芹', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1280', '36', '德国芥末酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1281', '36', '五柳料', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1282', '36', '俄力冈', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1283', '36', '乳化剂', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1284', '36', '基础白少司', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1285', '36', '香蜂草', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1286', '36', '香芒果酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1287', '36', '莳萝籽', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1288', '36', '柑橘橘皮果酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1289', '36', '香桃', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1290', '36', '双色樱桃果酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1291', '36', '剁椒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1292', '36', 'XO酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1293', '36', '糟卤', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1294', '36', '韩式辣椒酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1295', '36', '海底椰', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1296', '36', '高汤', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1297', '36', '郫县豆瓣酱', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1298', '36', '抹茶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1299', '36', '香草荚', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1300', '36', '十三香', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1301', '37', '色拉油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1302', '37', '香油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1303', '37', '菜籽油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1304', '37', '花生油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1305', '37', '大豆油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1306', '37', '猪油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1307', '37', '橄榄油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1308', '37', '辣椒油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1309', '37', '胡麻油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1310', '37', '牛油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1311', '37', '鸡油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1312', '37', '起酥油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1313', '37', '植物油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1314', '37', '羊油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1315', '37', '鸭油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1316', '37', '麦芽油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1317', '37', '猪网油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1318', '37', '菌油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1319', '37', '杏仁油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1320', '37', '蒸鱼豉油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1321', '38', '蜂蜜', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1322', '38', '冰糖', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1323', '38', '麦芽糖', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1324', '38', '糖桂花', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1325', '38', '白砂糖', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1326', '38', '赤砂糖', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1327', '38', '金糕', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1328', '38', '蔗糖', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1329', '38', '杏脯', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1330', '38', '巧克力', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1331', '38', '果糖', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1332', '38', '橘饼', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1333', '38', '山楂脯', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1334', '38', '苹果脯', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1335', '38', '红绿丝', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1336', '38', '梅脯', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1337', '38', '果糖浆', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1338', '38', '红糖', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1339', '38', '话梅', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1340', '39', '奶酪', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1341', '39', '酸奶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1342', '39', '牛奶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1343', '39', '奶油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1344', '39', '黄油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1345', '39', '羊奶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1346', '39', '酥油', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1347', '39', '人乳', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1348', '39', '全脂牛奶粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1349', '39', '奶油乳酪', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1350', '39', '炼乳', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1351', '40', '黄酒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1352', '40', '江米酒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1353', '40', '红葡萄酒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1354', '40', '啤酒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1355', '40', '白葡萄酒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1356', '40', '花雕酒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1357', '40', '白酒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1358', '40', '梅酒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1359', '40', '白兰地', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1360', '40', '朗姆酒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1361', '40', '清酒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1362', '40', '咖啡酒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1363', '40', '威士忌', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1364', '40', '大曲酒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1365', '40', '雪利酒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1366', '40', '干白葡萄酒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1367', '40', '干红葡萄酒', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1368', '41', '可乐', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1369', '41', '茶叶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1370', '41', '乌龙茶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1371', '41', '红茶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1372', '41', '绿茶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1373', '41', '果汁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1374', '41', '咖啡', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1375', '41', '冰淇淋', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1376', '41', '柠檬汁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1377', '41', '可可粉', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1378', '41', '椰子水', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1379', '41', '杏仁露', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1380', '41', '花茶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1381', '41', '碳酸饮料', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1382', '41', '甘蔗汁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1383', '41', '柳橙汁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1384', '41', '甘菊茶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1385', '41', '常用水', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1386', '41', '白毫银针', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1387', '41', '龙井', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1388', '41', '浓缩橘汁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1389', '41', '普洱茶', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('1390', '41', '橙汁', null, null, '2018-07-22 17:50:36');
INSERT INTO `foodmaterial` VALUES ('10002', '42', '皮鸡蛋', '我最爱', null, '2018-08-03 11:31:26');

-- ----------------------------
-- Table structure for `groupmealcontract`
-- ----------------------------
DROP TABLE IF EXISTS `groupmealcontract`;
CREATE TABLE `groupmealcontract` (
  `GMContract_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '合同编号',
  `Standard_id` int(11) DEFAULT NULL COMMENT '餐标编号',
  `GroupMealUnit_id` int(11) DEFAULT NULL COMMENT '用餐单位编号',
  `GMlContract_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '合同名称',
  `GMlContract_disc` varchar(2048) COLLATE utf8_bin DEFAULT NULL COMMENT '合同描述',
  `GMlContract_expirydate` timestamp NULL DEFAULT NULL COMMENT '过期时间',
  `GMContract_meatnumber` smallint(6) DEFAULT NULL COMMENT '配送荤菜个数',
  `GMlContract_vegetablenumber` smallint(6) DEFAULT NULL COMMENT '配送素菜个数',
  `GMlContract_status` smallint(6) DEFAULT NULL COMMENT '合同状态',
  `GMContract_signdate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '签订日期',
  `GMlContract_GroupA` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '甲方签名',
  `GMContract_GroupB` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '乙方签名',
  `GMContract_createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`GMContract_id`),
  KEY `FK_Relationship_2` (`Standard_id`),
  KEY `FK_Relationship_8` (`GroupMealUnit_id`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`Standard_id`) REFERENCES `diningstandard` (`Standard_id`),
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`GroupMealUnit_id`) REFERENCES `groupmealunit` (`GroupMealUnit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='团餐合同';

-- ----------------------------
-- Records of groupmealcontract
-- ----------------------------
INSERT INTO `groupmealcontract` VALUES ('3', '3', '3', '合同', '描述', '2018-08-12 16:26:29', '2', '1', '1', '2018-08-12 19:04:30', 'xiao', 'wc', '2018-07-21 19:04:23');
INSERT INTO `groupmealcontract` VALUES ('5', '3', '2', null, null, '2018-08-12 16:26:41', '5', '2', '0', '2018-08-12 16:27:44', 'xiai', 'wc', '2018-08-05 16:27:20');

-- ----------------------------
-- Table structure for `groupmealmenumaster`
-- ----------------------------
DROP TABLE IF EXISTS `groupmealmenumaster`;
CREATE TABLE `groupmealmenumaster` (
  `GroupMealMenumaster_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '团餐菜单编号',
  `GroupMealUnit_id` int(11) DEFAULT NULL COMMENT '用餐单位编号',
  `GroupMealMenumaster_name` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `GroupMealMenumaster_createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`GroupMealMenumaster_id`),
  KEY `FK_Relationship_3` (`GroupMealUnit_id`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`GroupMealUnit_id`) REFERENCES `groupmealunit` (`GroupMealUnit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='团餐菜单主表';

-- ----------------------------
-- Records of groupmealmenumaster
-- ----------------------------
INSERT INTO `groupmealmenumaster` VALUES ('8', '3', '111', '2018-08-03 11:34:54');
INSERT INTO `groupmealmenumaster` VALUES ('9', '2', '222', '2018-08-01 09:24:10');
INSERT INTO `groupmealmenumaster` VALUES ('10', '1', '333', '2018-08-01 09:24:17');

-- ----------------------------
-- Table structure for `groupmealstaff`
-- ----------------------------
DROP TABLE IF EXISTS `groupmealstaff`;
CREATE TABLE `groupmealstaff` (
  `GMStaff_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用餐员工编号',
  `GroupMealUnit_id` int(11) DEFAULT NULL COMMENT '用餐单位编号',
  `GMStaf_Mobile` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `GMStaff_name` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `GMStaff_status` smallint(6) DEFAULT NULL COMMENT '状态(0：停用，1：启用)',
  `GMStaff_sex` varchar(8) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `GMStaf_isdefualt` smallint(6) DEFAULT NULL COMMENT '是否默认账号（0：不是,1：是）',
  `GMStaf_loginname` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '登录账号',
  `GMStaf_password` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `Unit_ticker_id` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT 'Unit_ticker_id',
  `GMStaff_OpenId` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT 'openId',
  `GMStaf_createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`GMStaff_id`),
  KEY `FK_Relationship_12` (`GroupMealUnit_id`),
  CONSTRAINT `FK_Relationship_12` FOREIGN KEY (`GroupMealUnit_id`) REFERENCES `groupmealunit` (`GroupMealUnit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='团餐员工';

-- ----------------------------
-- Records of groupmealstaff
-- ----------------------------
INSERT INTO `groupmealstaff` VALUES ('1', '1', '1', '1', '1', '1', '1', '2', null, '1', 'o81TH1TH9szWjykZQcY2-1S1_eWI', '2018-07-22 16:40:15');
INSERT INTO `groupmealstaff` VALUES ('3', '1', '2', '2', '2', null, '0', '3', null, '2', '2', '2018-07-22 16:40:32');
INSERT INTO `groupmealstaff` VALUES ('10', '2', '5', 'ds1a', '0', 'nv', '0', null, null, null, null, '2018-08-03 14:00:54');
INSERT INTO `groupmealstaff` VALUES ('11', '2', '45245', 'ds1a', '0', 'nv111111', '0', null, null, null, null, '2018-08-03 14:00:54');
INSERT INTO `groupmealstaff` VALUES ('14', '3', '24', null, '0', null, '0', null, null, null, null, '2018-08-03 14:00:54');
INSERT INTO `groupmealstaff` VALUES ('15', '3', '254', null, null, null, null, null, null, null, null, '2018-08-03 14:00:56');
INSERT INTO `groupmealstaff` VALUES ('16', '1', null, null, null, null, null, null, null, null, null, '2018-08-03 16:14:58');

-- ----------------------------
-- Table structure for `groupmealunit`
-- ----------------------------
DROP TABLE IF EXISTS `groupmealunit`;
CREATE TABLE `groupmealunit` (
  `GroupMealUnit_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用餐单位编号',
  `GroupMealUnit_name` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `GroupMealUnit_contact` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人',
  `GroupMealUnit_mobile` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '联系方式（手机）',
  `GroupMealUnit_license` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '营业执照',
  `GroupMealUnit_address` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `GroupMealUnit_bank` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '开户行',
  `GroupMealUnit_account` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '开户账号',
  `GroupMealUnit_status` smallint(6) DEFAULT NULL COMMENT '状态(0：停用，1：启用)',
  `GroupMealUnit_officetel` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '办公电话',
  `GroupMealUnit_disc` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '公司简介',
  `GroupMealUnit_createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `GroupMealUnit_reviewDate` timestamp NOT NULL DEFAULT '1979-01-01 00:00:00' COMMENT '审核日期',
  `QR_Code` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '二维码',
  `GroupMealUnit_ticker_id` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT 'ticker_id',
  PRIMARY KEY (`GroupMealUnit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用餐单位';

-- ----------------------------
-- Records of groupmealunit
-- ----------------------------
INSERT INTO `groupmealunit` VALUES ('1', '西华大学', '1', '1', '1', '1', '1', '1', '0', null, null, '2018-07-27 18:37:49', '2018-07-10 13:44:05', null, null);
INSERT INTO `groupmealunit` VALUES ('2', '四川大学', '1', '1', '1', '1', '1', '1', '1', null, null, '2018-07-27 18:49:25', '2018-07-11 12:29:56', null, null);
INSERT INTO `groupmealunit` VALUES ('3', '电子科大', '1', '1', '1', '1', '1', '1', '2', null, null, '2018-07-28 12:03:32', '1979-01-01 00:00:00', null, 'ws');

-- ----------------------------
-- Table structure for `gtodmessage`
-- ----------------------------
DROP TABLE IF EXISTS `gtodmessage`;
CREATE TABLE `gtodmessage` (
  `gtodmessage_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '消息编号',
  `gtodmessage_status` smallint(6) DEFAULT NULL COMMENT '消息状态（0：新建，1：已读）',
  `gtodmessage_content` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '消息内容',
  `gtodmessage_sender` int(11) DEFAULT NULL COMMENT '发起人编号（用餐企业）',
  `gtodmessage_receiver` int(11) DEFAULT NULL COMMENT '处理人编号（团餐机构）',
  `gtodmessage_createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '消息创建日期',
  PRIMARY KEY (`gtodmessage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='应急通知消息';

-- ----------------------------
-- Records of gtodmessage
-- ----------------------------
INSERT INTO `gtodmessage` VALUES ('3', '1', null, null, null, '2018-07-23 13:08:07');

-- ----------------------------
-- Table structure for `maincategorie`
-- ----------------------------
DROP TABLE IF EXISTS `maincategorie`;
CREATE TABLE `maincategorie` (
  `maincategorie_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '食材主类编号',
  `maincategorie_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '食材主类名称',
  PRIMARY KEY (`maincategorie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1011 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='食材一级分类';

-- ----------------------------
-- Records of maincategorie
-- ----------------------------
INSERT INTO `maincategorie` VALUES ('1001', '肉禽蛋类');
INSERT INTO `maincategorie` VALUES ('1002', '水产类');
INSERT INTO `maincategorie` VALUES ('1003', '蔬菜类及制品');
INSERT INTO `maincategorie` VALUES ('1004', '豆类、豆制品');
INSERT INTO `maincategorie` VALUES ('1005', '五谷杂粮、面类');
INSERT INTO `maincategorie` VALUES ('1006', '谷物及制品');
INSERT INTO `maincategorie` VALUES ('1007', '果品类');
INSERT INTO `maincategorie` VALUES ('1008', '药食两用类');
INSERT INTO `maincategorie` VALUES ('1009', '调味品、油脂、其他');
INSERT INTO `maincategorie` VALUES ('1010', 'er');

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `manager_loginname` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '登录名',
  `manager_password` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '登录密码',
  `manager_name` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `manager_status` smallint(6) DEFAULT NULL COMMENT '状态（0：停用，1启用）',
  `manager_mobile` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `manager_createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='平台管理员';

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', 'ds', 'sdas', 'san', '1', '130', '2018-07-20 14:03:38');
INSERT INTO `manager` VALUES ('4', 'saa', '12', 'wc', null, null, '2018-07-22 09:32:12');

-- ----------------------------
-- Table structure for `material`
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `Foodmaterial_id` int(11) NOT NULL COMMENT '食材编号',
  `recipe_id` int(11) NOT NULL COMMENT '食谱编号',
  `material_no` int(11) DEFAULT NULL COMMENT '原料序号（用于排序）',
  `material_weight` int(11) DEFAULT NULL COMMENT '原料的重量(克为单位)',
  `material_memo` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`Foodmaterial_id`,`recipe_id`),
  KEY `FK_Relationship_29` (`recipe_id`),
  CONSTRAINT `FK_Relationship_28` FOREIGN KEY (`Foodmaterial_id`) REFERENCES `foodmaterial` (`Foodmaterial_id`),
  CONSTRAINT `FK_Relationship_29` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`recipe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='原料';

-- ----------------------------
-- Records of material
-- ----------------------------

-- ----------------------------
-- Table structure for `menudetail`
-- ----------------------------
DROP TABLE IF EXISTS `menudetail`;
CREATE TABLE `menudetail` (
  `GroupMealMenumaster_id` int(11) NOT NULL COMMENT '团餐菜单编号',
  `recipe_id` int(11) NOT NULL COMMENT '食谱编号',
  `MenuDetail_no` int(11) DEFAULT NULL COMMENT '菜单序号',
  `MenuDetail_mome` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`GroupMealMenumaster_id`,`recipe_id`),
  KEY `FK_Relationship_9` (`recipe_id`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`GroupMealMenumaster_id`) REFERENCES `groupmealmenumaster` (`GroupMealMenumaster_id`),
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`recipe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='菜单明细';

-- ----------------------------
-- Records of menudetail
-- ----------------------------
INSERT INTO `menudetail` VALUES ('8', '1', '3', null);
INSERT INTO `menudetail` VALUES ('8', '5', '3', null);
INSERT INTO `menudetail` VALUES ('8', '6', '3', null);
INSERT INTO `menudetail` VALUES ('8', '11', '3', null);
INSERT INTO `menudetail` VALUES ('8', '13', '3', null);
INSERT INTO `menudetail` VALUES ('8', '15', '3', null);
INSERT INTO `menudetail` VALUES ('8', '16', '3', null);
INSERT INTO `menudetail` VALUES ('8', '19', '3', null);
INSERT INTO `menudetail` VALUES ('9', '1', '3', null);
INSERT INTO `menudetail` VALUES ('9', '3', '3', null);
INSERT INTO `menudetail` VALUES ('9', '5', '3', null);
INSERT INTO `menudetail` VALUES ('9', '6', '3', null);
INSERT INTO `menudetail` VALUES ('9', '7', '3', null);
INSERT INTO `menudetail` VALUES ('9', '8', '3', null);
INSERT INTO `menudetail` VALUES ('9', '10', '3', null);
INSERT INTO `menudetail` VALUES ('9', '11', '3', null);
INSERT INTO `menudetail` VALUES ('9', '12', '3', null);
INSERT INTO `menudetail` VALUES ('9', '13', '3', null);
INSERT INTO `menudetail` VALUES ('9', '15', '3', null);
INSERT INTO `menudetail` VALUES ('9', '16', '3', null);
INSERT INTO `menudetail` VALUES ('9', '17', '3', null);
INSERT INTO `menudetail` VALUES ('9', '19', '3', null);
INSERT INTO `menudetail` VALUES ('10', '1', '1', null);
INSERT INTO `menudetail` VALUES ('10', '3', '1', null);
INSERT INTO `menudetail` VALUES ('10', '5', '1', null);
INSERT INTO `menudetail` VALUES ('10', '6', '1', null);
INSERT INTO `menudetail` VALUES ('10', '7', '1', null);
INSERT INTO `menudetail` VALUES ('10', '8', '1', null);
INSERT INTO `menudetail` VALUES ('10', '9', '1', null);
INSERT INTO `menudetail` VALUES ('10', '10', '1', null);
INSERT INTO `menudetail` VALUES ('10', '11', '1', null);
INSERT INTO `menudetail` VALUES ('10', '12', '1', null);
INSERT INTO `menudetail` VALUES ('10', '13', '1', null);
INSERT INTO `menudetail` VALUES ('10', '14', '1', null);
INSERT INTO `menudetail` VALUES ('10', '15', '1', null);
INSERT INTO `menudetail` VALUES ('10', '16', '1', null);
INSERT INTO `menudetail` VALUES ('10', '17', '1', null);
INSERT INTO `menudetail` VALUES ('10', '18', '1', null);
INSERT INTO `menudetail` VALUES ('10', '19', '1', null);

-- ----------------------------
-- Table structure for `questionnaire`
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire`;
CREATE TABLE `questionnaire` (
  `questionnaire_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问卷编号',
  `questionnaire_disc` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '问题描述',
  `questionnaire_type` smallint(6) DEFAULT NULL COMMENT '类型（1：单选，2：多选，3：主管题）',
  `questionnaire_ChoiceA` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '选择A',
  `questionnaire_ChoiceB` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '选择B',
  `questionnaire_ChoiceC` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '选择C',
  `questionnaire_Choiced` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '选择D',
  PRIMARY KEY (`questionnaire_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='问卷';

-- ----------------------------
-- Records of questionnaire
-- ----------------------------
INSERT INTO `questionnaire` VALUES ('1', '1', '1', 'sa', 'aa', 'aaa', 'aa');
INSERT INTO `questionnaire` VALUES ('2', 'abc', '1', 'll', 'hh', 'fgfg', '88');
INSERT INTO `questionnaire` VALUES ('4', 'efg', '2', 'a', 'b', 'c', 'ddd');
INSERT INTO `questionnaire` VALUES ('6', 'efg', '2', 'e', 'r', 't', 'y');

-- ----------------------------
-- Table structure for `recipe`
-- ----------------------------
DROP TABLE IF EXISTS `recipe`;
CREATE TABLE `recipe` (
  `recipe_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '食谱编号',
  `RecipeType_id` int(11) DEFAULT NULL COMMENT '食谱分类编号',
  `DeliveringCompany_no` int(11) DEFAULT NULL COMMENT '公司编号',
  `recipe_name` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '食谱名称',
  `recipe_material` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '原料',
  `recipe_accessorie` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '辅料',
  `recipe_processing` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '加工流程',
  `recipe_Meat_or_vegetable` smallint(6) DEFAULT NULL COMMENT '荤素标志（1：荤菜，2：素菜））',
  `recipe_type` smallint(6) DEFAULT NULL COMMENT '菜品类型（1：炒菜，2：凉菜，3：汤菜，4：蒸菜，5：烧菜）',
  `recipe_IsCakes` smallint(6) DEFAULT NULL COMMENT '是否糕点（0：不是,1：是）',
  `recipe_character` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '菜品特色',
  `recipe_people` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '适合人群',
  `recipe_icon` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '食谱图标',
  `recipe_costprice` decimal(8,2) DEFAULT NULL COMMENT '成本单价',
  `recipe_status` smallint(6) DEFAULT NULL COMMENT '食谱状态(0：不可用，1：可用)',
  `recipe_owner` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '创建者',
  `recipe_createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`recipe_id`),
  KEY `FK_Relationship_5` (`RecipeType_id`),
  KEY `FK_Relationship_6` (`DeliveringCompany_no`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`RecipeType_id`) REFERENCES `recipetype` (`RecipeType_id`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`DeliveringCompany_no`) REFERENCES `deliveringcompany` (`DeliveringCompany_no`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='食谱';

-- ----------------------------
-- Records of recipe
-- ----------------------------
INSERT INTO `recipe` VALUES ('1', '1', '2', '回锅肉', null, null, '1', '2', '5', '1', '1', '1', '66.0.3359.139.manifest', '1.00', '1', '1', '2018-08-02 12:00:35');
INSERT INTO `recipe` VALUES ('3', '1', '2', '土豆丝土豆丝', null, null, null, '2', '1', '2', '2', '2', '2', '1.00', '0', '2', '2018-08-02 09:55:45');
INSERT INTO `recipe` VALUES ('5', '3', '2', '红烧肉', null, null, null, '1', '1', '0', null, null, null, '2.00', '0', null, '2018-08-02 09:55:47');
INSERT INTO `recipe` VALUES ('6', '4', '2', '肉', null, null, null, '1', '1', '0', null, null, null, '3.00', '0', null, '2018-08-02 09:55:48');
INSERT INTO `recipe` VALUES ('7', '3', '2', '小炒肉1', null, null, null, '1', null, null, null, null, null, '2.50', '1', null, '2018-08-02 10:02:49');
INSERT INTO `recipe` VALUES ('8', '4', '2', '酸菜鱼1', null, null, null, '1', null, null, null, null, null, '2.00', '1', null, '2018-08-02 09:55:48');
INSERT INTO `recipe` VALUES ('9', '1', '2', '粉丝', null, null, null, '2', null, null, null, null, null, '2.00', '1', null, '2018-08-02 10:02:51');
INSERT INTO `recipe` VALUES ('10', '3', '2', '藕丁1', null, null, null, '2', '1', '0', null, null, null, '1.00', '1', null, '2018-08-02 10:02:54');
INSERT INTO `recipe` VALUES ('11', '22', '2', '藕丁2', null, null, null, '2', '1', '0', null, null, null, '1.00', '1', null, '2018-08-02 10:02:55');
INSERT INTO `recipe` VALUES ('12', '23', '2', '土豆丝2', null, null, null, '2', '1', '0', null, null, null, '1.00', '1', null, '2018-08-02 10:02:56');
INSERT INTO `recipe` VALUES ('13', '23', '2', '藕丁4', null, null, null, '2', null, null, null, null, null, '1.00', '1', null, '2018-08-02 10:02:57');
INSERT INTO `recipe` VALUES ('14', '22', '2', '土豆丝3', null, null, null, '2', null, null, null, null, null, '2.00', '1', null, '2018-08-02 10:02:59');
INSERT INTO `recipe` VALUES ('15', '1', '2', '酸菜鱼2', null, null, null, '1', null, null, null, null, null, '3.00', '0', null, '2018-08-02 10:02:59');
INSERT INTO `recipe` VALUES ('16', '4', '2', '小炒肉2', null, null, null, '1', null, null, null, null, null, '2.00', '0', null, '2018-08-02 10:03:02');
INSERT INTO `recipe` VALUES ('17', '23', '2', '土豆丝4', null, null, null, '2', null, null, null, null, null, '1.00', '1', null, '2018-08-02 10:03:05');
INSERT INTO `recipe` VALUES ('18', '22', '2', '酸菜鱼3', null, null, null, '1', null, null, null, null, null, '4.00', '0', null, '2018-08-02 10:03:07');
INSERT INTO `recipe` VALUES ('19', '23', '2', '小炒肉4', null, null, null, '1', null, null, null, null, null, '3.00', '1', null, '2018-08-02 10:03:09');

-- ----------------------------
-- Table structure for `recipetype`
-- ----------------------------
DROP TABLE IF EXISTS `recipetype`;
CREATE TABLE `recipetype` (
  `RecipeType_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '食谱分类编号',
  `RecipeType_name` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '菜系名称',
  `RecipeType_disc` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT '菜系简介',
  `RecipeType_createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`RecipeType_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='食谱分类';

-- ----------------------------
-- Records of recipetype
-- ----------------------------
INSERT INTO `recipetype` VALUES ('1', 'tast', '瓶中多余', '2018-07-26 11:52:37');
INSERT INTO `recipetype` VALUES ('3', 'ddddd', '品质好', '2018-07-26 09:44:05');
INSERT INTO `recipetype` VALUES ('4', 'aaaaaa', '花样多', '2018-07-26 11:53:19');
INSERT INTO `recipetype` VALUES ('22', 'f4f', 'dasd', '2018-07-26 18:20:01');
INSERT INTO `recipetype` VALUES ('23', '担任过', '风格', '2018-07-26 18:20:19');
INSERT INTO `recipetype` VALUES ('24', '才下班', '梵蒂冈', '2018-07-26 18:20:41');
INSERT INTO `recipetype` VALUES ('25', ' 方法', '对方感受到', '2018-07-26 18:20:49');
INSERT INTO `recipetype` VALUES ('26', 'sdsd', '二货到付退回', '2018-08-03 11:34:14');
INSERT INTO `recipetype` VALUES ('27', '上风官司', '的发热体验', '2018-07-26 18:21:12');
INSERT INTO `recipetype` VALUES ('28', '三相四线', '三生三世少时诵诗书上', '2018-08-03 11:33:01');
INSERT INTO `recipetype` VALUES ('29', '风动旛动', '地方', '2018-08-03 11:33:46');
INSERT INTO `recipetype` VALUES ('30', 'ggg', '对人体是日本 ', '2018-08-03 12:24:34');

-- ----------------------------
-- Table structure for `stafforder`
-- ----------------------------
DROP TABLE IF EXISTS `stafforder`;
CREATE TABLE `stafforder` (
  `StaffOrder_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '点餐编号',
  `GMStaff_id` int(11) DEFAULT NULL COMMENT '用餐员工编号',
  `recipe_id` int(11) DEFAULT NULL COMMENT '食谱编号',
  `StaffOrder_usedate` date DEFAULT NULL COMMENT '所属日期',
  `StaffOrder_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '点餐日期',
  PRIMARY KEY (`StaffOrder_id`),
  KEY `FK_Relationship_16` (`GMStaff_id`),
  KEY `FK_Relationship_20` (`recipe_id`),
  CONSTRAINT `FK_Relationship_16` FOREIGN KEY (`GMStaff_id`) REFERENCES `groupmealstaff` (`GMStaff_id`),
  CONSTRAINT `FK_Relationship_20` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`recipe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='点餐';

-- ----------------------------
-- Records of stafforder
-- ----------------------------
INSERT INTO `stafforder` VALUES ('5', '1', '7', '2018-08-04', '2018-08-04 12:03:16');
INSERT INTO `stafforder` VALUES ('6', '3', '5', '2018-08-04', '2018-08-04 12:03:16');
INSERT INTO `stafforder` VALUES ('7', '10', '6', '2018-08-04', '2018-08-04 12:03:17');
INSERT INTO `stafforder` VALUES ('8', '10', '7', '2018-08-04', '2018-08-04 12:06:14');
INSERT INTO `stafforder` VALUES ('9', '14', '9', '2018-08-04', '2018-08-04 12:03:18');
INSERT INTO `stafforder` VALUES ('10', '15', '8', '2018-08-04', '2018-08-04 12:03:18');
INSERT INTO `stafforder` VALUES ('12', '15', '7', '2018-08-04', '2018-08-04 12:03:19');
INSERT INTO `stafforder` VALUES ('13', '14', '8', '2018-08-04', '2018-08-04 12:03:19');
INSERT INTO `stafforder` VALUES ('14', '14', '6', '2018-08-04', '2018-08-04 12:03:21');
INSERT INTO `stafforder` VALUES ('15', '15', '6', '2018-08-04', '2018-08-04 12:03:21');
INSERT INTO `stafforder` VALUES ('16', '10', '3', '2018-08-04', '2018-08-04 12:03:21');
INSERT INTO `stafforder` VALUES ('17', '10', '5', '2018-08-04', '2018-08-04 12:03:21');
INSERT INTO `stafforder` VALUES ('18', '10', '14', '2018-08-04', '2018-08-04 12:03:21');
INSERT INTO `stafforder` VALUES ('19', '10', '12', '2018-08-04', '2018-08-04 12:03:21');
INSERT INTO `stafforder` VALUES ('20', '10', '18', '2018-08-04', '2018-08-04 12:03:21');

-- ----------------------------
-- Table structure for `tomorrowmenudetail`
-- ----------------------------
DROP TABLE IF EXISTS `tomorrowmenudetail`;
CREATE TABLE `tomorrowmenudetail` (
  `TomorrowMenu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '明日菜单明细编号',
  `TomorrowMenuMaster_id` int(11) NOT NULL DEFAULT '0' COMMENT '明日菜单编号',
  `recipe_id` int(11) NOT NULL DEFAULT '0' COMMENT '食谱编号',
  `TomorrowMenu_IsRecommend` smallint(6) DEFAULT NULL COMMENT '是否推荐 0:不推荐 1：推荐',
  `TomorrowMenu_memo` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`TomorrowMenu_id`),
  KEY `FK_Relationship_19` (`TomorrowMenuMaster_id`),
  KEY `FK_Relationship_32` (`recipe_id`),
  CONSTRAINT `FK_Relationship_19` FOREIGN KEY (`TomorrowMenuMaster_id`) REFERENCES `tomorrowmenumaster` (`TomorrowMenuMaster_id`),
  CONSTRAINT `FK_Relationship_32` FOREIGN KEY (`recipe_id`) REFERENCES `recipe` (`recipe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='明日菜单明细';

-- ----------------------------
-- Records of tomorrowmenudetail
-- ----------------------------
INSERT INTO `tomorrowmenudetail` VALUES ('42', '23', '16', '0', null);
INSERT INTO `tomorrowmenudetail` VALUES ('43', '23', '19', '1', null);
INSERT INTO `tomorrowmenudetail` VALUES ('44', '23', '1', '0', null);
INSERT INTO `tomorrowmenudetail` VALUES ('45', '24', '19', '0', null);
INSERT INTO `tomorrowmenudetail` VALUES ('46', '24', '5', '0', null);
INSERT INTO `tomorrowmenudetail` VALUES ('47', '24', '6', '1', null);
INSERT INTO `tomorrowmenudetail` VALUES ('48', '24', '3', '1', null);
INSERT INTO `tomorrowmenudetail` VALUES ('49', '25', '18', '0', null);
INSERT INTO `tomorrowmenudetail` VALUES ('50', '25', '19', '1', null);
INSERT INTO `tomorrowmenudetail` VALUES ('51', '25', '6', '1', null);
INSERT INTO `tomorrowmenudetail` VALUES ('52', '25', '7', '0', null);
INSERT INTO `tomorrowmenudetail` VALUES ('53', '25', '10', '0', null);
INSERT INTO `tomorrowmenudetail` VALUES ('54', '25', '12', '1', null);

-- ----------------------------
-- Table structure for `tomorrowmenumaster`
-- ----------------------------
DROP TABLE IF EXISTS `tomorrowmenumaster`;
CREATE TABLE `tomorrowmenumaster` (
  `TomorrowMenuMaster_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '明日菜单编号',
  `GroupMealUnit_id` int(11) DEFAULT NULL COMMENT '用餐单位编号',
  `TomorrowMenuMaster_usedate` date DEFAULT NULL COMMENT '使用日期',
  `TomorrowMenuMaster_expiredate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '有效期',
  `TomorrowMenuMaster_status` smallint(6) DEFAULT NULL COMMENT '状态 0:失效 1:有效',
  `TomorrowMenuMaster_memo` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `TomorrowMenuMaster_createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`TomorrowMenuMaster_id`),
  KEY `FK_Relationship_18` (`GroupMealUnit_id`),
  CONSTRAINT `FK_Relationship_18` FOREIGN KEY (`GroupMealUnit_id`) REFERENCES `groupmealunit` (`GroupMealUnit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='明日菜单主表';

-- ----------------------------
-- Records of tomorrowmenumaster
-- ----------------------------
INSERT INTO `tomorrowmenumaster` VALUES ('23', '3', '2018-08-04', '2018-08-04 15:27:17', '1', null, '2018-08-03 15:26:36');
INSERT INTO `tomorrowmenumaster` VALUES ('24', '2', '2018-08-04', '2018-08-04 15:27:23', '1', null, '2018-08-03 15:26:43');
INSERT INTO `tomorrowmenumaster` VALUES ('25', '1', '2018-08-04', '2018-08-04 15:27:31', '1', null, '2018-08-03 15:26:50');
