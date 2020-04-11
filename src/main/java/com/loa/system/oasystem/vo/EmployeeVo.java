package com.loa.system.oasystem.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 员工表视图
 * @author 李涵林
 */
@Data
public class EmployeeVo{

    /**
     * 用户id
     */
    private Short empId;

    /**
     * 性别
     */
    private String sex;

    /**
     * 用户名
     */
    private String name;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 所属部门
     */
    private String deptName;

    /**
     * 所属岗位
     */
    private String posName;

    /**
     * 入职时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDateTime hireDate;

    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDateTime birthDate;

    /**
     * 离职时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDateTime leaveData;

    /**
     * 是否离职,0-离职 1-在职
     */
    private Short onDuty;

    /**
     * 上级领导名字
     */
    private String mgrName;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 紧急联系人
     */
    private String emergencyContact;

    /**
     * 身份证号码
     */
    private String idCard;

}
