package com.loa.system.oasystem.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.loa.system.oasystem.entity.employee.GenEmployee;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 员工表视图
 * @author 李涵林
 */
@Data
public class EmployeeVo extends GenEmployee {
    /**
     * 用户名
     */
    private String ename;

    /**
     * 真实姓名
     */
    private String realame;

    /**
     * 所属部门
     */
    private String deptname;

    /**
     * 所属岗位
     */
    private String pname;

    /**
     * 入职时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd|HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime hiredate;

    /**
     * 联系方式
     */
    private String phone;
}
