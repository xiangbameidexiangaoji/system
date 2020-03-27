/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50712
 Source Host           : localhost:3306
 Source Schema         : oa

 Target Server Type    : MySQL
 Target Server Version : 50712
 File Encoding         : 65001

 Date: 23/03/2020 22:32:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auditing
-- ----------------------------
DROP TABLE IF EXISTS `auditing`;
CREATE TABLE `auditing`  (
  `auditid` smallint(10) NOT NULL COMMENT '审核编号',
  `expid` smallint(10) NOT NULL COMMENT '报销单编号',
  `ename` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '审核人',
  `result` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '审核结果',
  `auditdesc` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '审核说明',
  `del` smallint(1) NOT NULL DEFAULT 0 COMMENT '删除表示 1:已删除 0:未删除',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '审核时间',
  PRIMARY KEY (`auditid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '报销单审核表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `deptno` smallint(8) NOT NULL COMMENT '部门编号',
  `deptname` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '部门名称',
  `location` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '部门位置',
  `del` smallint(1) NOT NULL DEFAULT 0 COMMENT '删除表示 1:已删除 0:未删除',
  PRIMARY KEY (`deptno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for duty
-- ----------------------------
DROP TABLE IF EXISTS `duty`;
CREATE TABLE `duty`  (
  `dtid` smallint(10) NOT NULL COMMENT '出勤编号',
  `ename` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '员工名称',
  `dtdate` datetime(0) NOT NULL COMMENT '出勤日期',
  `signintime` datetime(0) NULL DEFAULT NULL COMMENT '签到时间',
  `signouttime` datetime(0) NULL DEFAULT NULL COMMENT '签退时间',
  PRIMARY KEY (`dtid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '出勤表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `empid` smallint(20) NOT NULL AUTO_INCREMENT COMMENT '员工id,主键',
  `ename` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `password` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `deptno` smallint(8) NULL DEFAULT NULL COMMENT '部门编号',
  `posid` smallint(8) NULL DEFAULT NULL COMMENT '岗位编号',
  `mgrid` smallint(8) NULL DEFAULT NULL COMMENT '上级编号',
  `realname` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `sex` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthdate` datetime(0) NOT NULL COMMENT '出生日期',
  `hiredate` datetime(0) NOT NULL COMMENT '入职时间',
  `leavedate` datetime(0) NULL DEFAULT NULL COMMENT '离职时间',
  `onduty` smallint(1) NULL DEFAULT NULL COMMENT '0-离职  1-在职',
  `emptype` smallint(1) NULL DEFAULT NULL COMMENT '1.普通员工  2.管理人员 含经理、总监、总裁等  3.管理员',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `qq` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'QQ',
  `emercontactperson` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '紧急联系人',
  `idcard` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `del` smallint(1) NOT NULL DEFAULT 0 COMMENT '删除表示 1:已删除 0:未删除',
  PRIMARY KEY (`empid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for expense
-- ----------------------------
DROP TABLE IF EXISTS `expense`;
CREATE TABLE `expense`  (
  `expid` smallint(10) NOT NULL COMMENT '报销单编号',
  `ename` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '报销人',
  `totalamount` double(10, 2) NOT NULL COMMENT '报销总金额',
  `exptime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '报销时间',
  `expdesc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `nextauditor` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '下个审核人',
  `lastResult` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最新审核结果',
  `status` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '审核状态 1 审核中 2 审核结束通过 3 审核结束驳回',
  `del` smallint(1) NOT NULL DEFAULT 0 COMMENT '删除表示 1:已删除 0:未删除',
  PRIMARY KEY (`expid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '报销单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for expenseitem
-- ----------------------------
DROP TABLE IF EXISTS `expenseitem`;
CREATE TABLE `expenseitem`  (
  `itemid` smallint(10) NOT NULL COMMENT '报销单明细表',
  `expid` smallint(10) NULL DEFAULT NULL COMMENT '所属报销单编号',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '报销类型',
  `amount` double(8, 2) NULL DEFAULT NULL COMMENT '报销金额',
  `itemdesc` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '报销说明',
  `del` smallint(1) NOT NULL DEFAULT 0 COMMENT '删除表示 1:已删除 0:未删除',
  PRIMARY KEY (`itemid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '报销单明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for expimage
-- ----------------------------
DROP TABLE IF EXISTS `expimage`;
CREATE TABLE `expimage`  (
  `imgid` smallint(10) NOT NULL COMMENT '图片编号',
  `expid` smallint(10) NOT NULL COMMENT '图片所属报销单',
  `realname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片真实名称',
  `filename` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片上传后的名称',
  `filetype` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片类型',
  `del` smallint(1) NOT NULL DEFAULT 0 COMMENT '删除表示 1:已删除 0:未删除',
  PRIMARY KEY (`imgid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '报销单上传表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for income
-- ----------------------------
DROP TABLE IF EXISTS `income`;
CREATE TABLE `income`  (
  `icid` smallint(10) NOT NULL COMMENT '收入编号',
  `amount` double(8, 2) NULL DEFAULT NULL COMMENT '收入金额',
  `icdate` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '收入日期',
  `ictype` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收入类型',
  `indesc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收入备注',
  `userid` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '录入用户',
  `del` smallint(1) NOT NULL DEFAULT 0 COMMENT '删除表示 1:已删除 0:未删除',
  PRIMARY KEY (`icid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收入表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `pid` smallint(10) NOT NULL COMMENT '支出编号',
  `payname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支出人',
  `amount` double(10, 2) NULL DEFAULT NULL COMMENT '支出金额',
  `paytime` datetime(0) NULL DEFAULT NULL COMMENT '支出时间',
  `expid` smallint(10) NULL DEFAULT NULL COMMENT '报销编号',
  `ename` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '报销人',
  `del` smallint(1) NOT NULL DEFAULT 0 COMMENT '删除表示 1:已删除 0:未删除',
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支出表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `posid` smallint(5) NOT NULL COMMENT '岗位编号',
  `pname` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '岗位名称',
  `pdesc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '岗位描述',
  PRIMARY KEY (`posid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '岗位表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
