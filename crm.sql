/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-05-12 11:41:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'zhangshuzhen', '123456');
INSERT INTO `t_admin` VALUES ('2', 'zoupeng', '111111');

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` bit(1) NOT NULL,
  `tel` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `wechat` varchar(255) DEFAULT NULL,
  `seller_id` bigint(20) NOT NULL,
  `job_id` bigint(20) DEFAULT NULL,
  `salarylevel_id` bigint(255) DEFAULT NULL,
  `customersource_id` bigint(255) DEFAULT NULL,
  `inputuser_id` bigint(255) DEFAULT NULL,
  `inputtime` date DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  `state` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('3', '张三', '23', '', '18888888888', null, null, null, '1', '6', '12', '4', '2', '2019-01-15', '1', '1');
INSERT INTO `t_customer` VALUES ('4', '李四', '22', '', '18652654123', null, null, null, '2', '6', '12', '2', null, '2019-01-15', '1', '1');
INSERT INTO `t_customer` VALUES ('5', '王五', '27', '', '17895699874', null, null, null, '1', '6', '12', '3', null, '2019-01-15', '1', '1');
INSERT INTO `t_customer` VALUES ('6', '赵柳', '36', '\0', '15652358976', null, null, null, '2', '7', '12', '1', null, '2019-01-15', '1', '1');
INSERT INTO `t_customer` VALUES ('7', '张无忌', '54', '', '13285236985', null, null, null, '1', '7', '12', '1', '2', '2019-01-15', '1', '1');
INSERT INTO `t_customer` VALUES ('11', '萨达姆', '33', '', '15612375896', null, null, null, '2', '7', '11', '2', null, '2019-01-15', '2', '1');
INSERT INTO `t_customer` VALUES ('12', '陈中方', '18', '\0', '13131313131', null, null, null, '1', '8', '15', '2', null, '2019-01-15', '1', '1');
INSERT INTO `t_customer` VALUES ('13', '姚浩', '18', '', '13444444444', null, null, null, '2', '8', '15', '2', null, '2019-01-17', '1', '1');

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `manager_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `dirPath` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', 'dept1', '部门1', '2', null, null, '0', null);
INSERT INTO `t_department` VALUES ('2', 'dept2', '部门2', '1', null, null, '-1', null);
INSERT INTO `t_department` VALUES ('3', 'dept3', '部门3', '1', '1', null, '-1', null);
INSERT INTO `t_department` VALUES ('4', 'dept4', '部门4', '2', '2', null, '0', null);
INSERT INTO `t_department` VALUES ('5', 'dept5', '部门5', '1', '3', '', '-1', null);
INSERT INTO `t_department` VALUES ('6', 'dept6', '部门6', '2', '3', null, '0', null);
INSERT INTO `t_department` VALUES ('7', 'dept7', '部门7', '1', '4', '', '-1', null);
INSERT INTO `t_department` VALUES ('8', 'dept8', '部门8', '2', '4', '', '0', null);
INSERT INTO `t_department` VALUES ('9', 'dept9', '部门9', '1', '5', '', '-1', null);
INSERT INTO `t_department` VALUES ('10', 'dept10', '部门10', '26', '5', '', '0', null);
INSERT INTO `t_department` VALUES ('11', 'dept11', '部门11', '1', '6', '', '-1', null);

-- ----------------------------
-- Table structure for t_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `realname` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `tel` varchar(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `dept_id` bigint(20) DEFAULT NULL,
  `inputtime` date DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `union_id` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employee
-- ----------------------------
INSERT INTO `t_employee` VALUES ('1', 'admin0', '陈中方', 'a53dc5754ae622c353ad1f989909c425', '1100', null, '1', null, '0', 'offop6I46JP2MZAtM9WACjAHQ7nQ', null);
INSERT INTO `t_employee` VALUES ('2', 'admin1', 'admin1', 'a53dc5754ae622c353ad1f989909c425', '1101', null, '1', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('3', 'admin', 'admin2', '7a8df906f14207f5535f99b60dfed07e', '1102', null, '2', null, '-1', null, null);
INSERT INTO `t_employee` VALUES ('4', 'admin3', 'admin3', 'admin', '1103', null, '2', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('5', 'admin4', 'zhangshuzhen', 'admin', '1104', null, '3', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('6', 'admin5', 'admin5', 'admin', '1105', null, '4', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('7', 'admin6', 'admin6', 'admin', '1106', null, '5', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('8', 'admin7', 'admin7', 'admin', '1107', null, '2', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('9', 'admin8', 'admin8', 'admin', '1108', null, '1', '2019-04-18', '0', null, null);
INSERT INTO `t_employee` VALUES ('10', 'admin9', 'admin9', 'admin', '1109', null, '2', '2019-04-18', '0', null, null);
INSERT INTO `t_employee` VALUES ('11', 'admin10', 'admin10', 'admin', '11010', null, '3', '2019-04-02', '0', null, null);
INSERT INTO `t_employee` VALUES ('12', 'admin11', 'admin11', 'admin', '11011', null, '4', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('13', 'admin12', 'admin12', 'admin', '11012', null, '5', null, '-1', null, null);
INSERT INTO `t_employee` VALUES ('14', 'admin13', 'admin13', 'admin', '11013', null, '1', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('15', 'admin14', 'admin14', 'admin', '11014', null, '2', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('16', 'admin15', 'admin15', 'admin', '11015', null, '2', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('17', 'admin16', 'admin16', 'admin', '11016', null, '1', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('18', 'admin17', 'admin17', 'admin', '11017', null, '2', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('19', 'admin18', 'admin18', 'admin', '11018', null, '3', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('20', 'admin19', 'admin19', 'admin', '11019', null, '4', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('21', 'admin20', 'admin20', 'admin', '11020', null, '1', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('22', 'admin21', 'admin21', 'admin', '11021', null, '2', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('23', 'admin22', 'admin22', 'admin', '11022', null, '3', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('24', 'admin23', 'admin23', 'admin', '11023', null, '4', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('25', 'admin24', 'admin24', 'admin', '11024', null, '5', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('26', 'admin25', 'admin25', 'admin', '11025', null, '3', null, '0', null, null);
INSERT INTO `t_employee` VALUES ('27', 'admin26', 'admin26', 'admin', '11026', null, null, null, '0', null, null);
INSERT INTO `t_employee` VALUES ('28', 'admin27', 'admin27', 'admin', '11027', null, null, null, '0', null, null);
INSERT INTO `t_employee` VALUES ('29', 'admin28', 'admin28', 'admin', '11028', null, null, null, '0', null, null);
INSERT INTO `t_employee` VALUES ('30', 'admin29', 'admin29', 'admin', '11029', null, null, null, '0', null, null);
INSERT INTO `t_employee` VALUES ('31', 'admin30', 'admin30', 'admin', '11030', null, null, null, '0', null, null);
INSERT INTO `t_employee` VALUES ('32', 'admin31', 'admin31', 'admin', '11031', null, null, null, '0', null, null);
INSERT INTO `t_employee` VALUES ('33', 'admin32', 'admin32', 'admin', '11032', null, null, null, '0', null, null);
INSERT INTO `t_employee` VALUES ('34', 'admin33', 'admin33', 'admin', '11033', null, null, null, '0', null, null);
INSERT INTO `t_employee` VALUES ('35', 'admin34', 'admin34', 'admin', '11034', null, null, null, '0', null, null);
INSERT INTO `t_employee` VALUES ('36', 'admin35', 'admin35', 'admin', '11035', null, null, null, '0', null, null);
INSERT INTO `t_employee` VALUES ('37', 'admin36', 'admin36', 'admin', '11036', null, null, null, '0', null, null);
INSERT INTO `t_employee` VALUES ('38', 'admin37', 'admin37', 'admin', '11037', null, null, null, '0', null, null);
INSERT INTO `t_employee` VALUES ('39', 'admin38', 'admin38', 'admin', '11038', null, null, null, '0', null, null);
INSERT INTO `t_employee` VALUES ('40', 'admin39', 'admin39', 'admin', '11039', null, null, null, '0', null, null);

-- ----------------------------
-- Table structure for t_employee_role
-- ----------------------------
DROP TABLE IF EXISTS `t_employee_role`;
CREATE TABLE `t_employee_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employee_role
-- ----------------------------
INSERT INTO `t_employee_role` VALUES ('1', '3', '1');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', 'employee:index', '员工管理', '/employee/index', null);
INSERT INTO `t_permission` VALUES ('2', 'department:index', '部门管理', '/department/index', null);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `intro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'test', '测试角色', '测试角色');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for t_system_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `t_system_dictionary`;
CREATE TABLE `t_system_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(50) NOT NULL,
  `name` varchar(25) NOT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `tentant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_dictionary
-- ----------------------------
INSERT INTO `t_system_dictionary` VALUES ('1', 'Job', '职业', '这是职业', '1', null);
INSERT INTO `t_system_dictionary` VALUES ('2', 'Source', '客户来源', null, '1', null);
INSERT INTO `t_system_dictionary` VALUES ('3', 'SalaryLevel', '薪资水平', null, '1', null);
INSERT INTO `t_system_dictionary` VALUES ('4', 'TraceType', '客户跟进方式', null, '1', null);

-- ----------------------------
-- Table structure for t_system_dictionary_item
-- ----------------------------
DROP TABLE IF EXISTS `t_system_dictionary_item`;
CREATE TABLE `t_system_dictionary_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL,
  `name` varchar(25) NOT NULL,
  `requence` int(11) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_dictionary_item
-- ----------------------------
INSERT INTO `t_system_dictionary_item` VALUES ('1', '2', '电话营销', '1', null, '1');
INSERT INTO `t_system_dictionary_item` VALUES ('2', '2', '朋友介绍', '2', null, '1');
INSERT INTO `t_system_dictionary_item` VALUES ('3', '2', '移动广告', '3', null, '1');
INSERT INTO `t_system_dictionary_item` VALUES ('4', '2', '自动上门', '4', null, '-1');
INSERT INTO `t_system_dictionary_item` VALUES ('6', '1', '医生', '1', '救死扶伤', '1');
INSERT INTO `t_system_dictionary_item` VALUES ('7', '1', '护士', '2', '辅助', '1');
INSERT INTO `t_system_dictionary_item` VALUES ('8', '1', '飞行员', '3', 'flyaway', '1');
INSERT INTO `t_system_dictionary_item` VALUES ('9', '1', '', '6', '测试的鹅鹅鹅鹅鹅鹅', '-1');
INSERT INTO `t_system_dictionary_item` VALUES ('10', '1', 'aaa', '19', 'sdfsdfdsfdsf', '1');
INSERT INTO `t_system_dictionary_item` VALUES ('11', '3', '<5K', '1', '月工资小于5k', '1');
INSERT INTO `t_system_dictionary_item` VALUES ('12', '3', '5K-10K', '2', null, '1');
INSERT INTO `t_system_dictionary_item` VALUES ('13', '3', '10K-20K', '3', null, '1');
INSERT INTO `t_system_dictionary_item` VALUES ('14', '3', '20K-50k', '3', null, '1');
INSERT INTO `t_system_dictionary_item` VALUES ('15', '3', '>50k', '5', null, '1');
INSERT INTO `t_system_dictionary_item` VALUES ('16', '4', '邀约上门', '1', null, '1');
INSERT INTO `t_system_dictionary_item` VALUES ('17', '4', '电话', '2', null, '1');
INSERT INTO `t_system_dictionary_item` VALUES ('18', '4', '短信', '3', null, '1');
INSERT INTO `t_system_dictionary_item` VALUES ('19', '4', '邮件', '4', null, '1');

-- ----------------------------
-- Table structure for t_tenant
-- ----------------------------
DROP TABLE IF EXISTS `t_tenant`;
CREATE TABLE `t_tenant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `companyname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `companytel` varchar(11) NOT NULL,
  `companynum` varchar(15) NOT NULL,
  `email` varchar(255) NOT NULL,
  `sysname` varchar(25) NOT NULL,
  `registertime` datetime NOT NULL,
  `state` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `coordinate` varchar(255) NOT NULL,
  `logourl` varchar(255) DEFAULT NULL,
  `setmeal_id` bigint(20) DEFAULT NULL,
  `ispay` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tenant
-- ----------------------------
INSERT INTO `t_tenant` VALUES ('1', '树根', '76d0cdb0c7229c271d85326ee0104cc4', '13272893303', '023-88888888', 'asdf@qq.com', 'leilei', '2019-04-29 18:36:05', '0', '重庆市重庆市重庆市', '106.558437,29.568996', null, null, null);
INSERT INTO `t_tenant` VALUES ('2', '树根科技', '76d0cdb0c7229c271d85326ee0104cc4', '13272893333', '023-88888888', 'asdf@qq.com', 'lishugen', '2019-04-29 18:38:48', '0', '重庆市沙坪坝区Aa', '106.463439,29.547192', null, null, null);
INSERT INTO `t_tenant` VALUES ('3', '百度科技', '76d0cdb0c7229c271d85326ee0104cc4', '15888888888', '021-89898989', 'asdfg@qq.com', 'baidu', '2019-04-29 18:39:29', '0', '北京市海淀区百度大厦', '116.307899,40.057038', null, null, null);
