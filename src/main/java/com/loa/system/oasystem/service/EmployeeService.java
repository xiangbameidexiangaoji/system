package com.loa.system.oasystem.service;

import com.loa.system.oasystem.entity.employee.GenEmployee;
import com.loa.system.oasystem.util.PageResult;
import com.loa.system.oasystem.vo.EmployeeVo;

import java.util.List;

/**
 * @author 李涵林
 */
public interface EmployeeService {
    /**
     * 添加员工
     * @param genEmployee   员工表
     * @return
     */
    Integer save(GenEmployee genEmployee);

    /**
     * 数据回显
     * @param empid
     * @return
     */
    GenEmployee findById(Short empid);

    /**
     * 查询领导名字
     * @param ename
     * @return
     */
    List<String> findByLeaderNameLike(String ename);

    /**
     *查询员工列表
     * @param ename 员工名字
     * @param deptno 部门编号
     * @param onduty 是否在职 0-离职 1-在职
     * @param hiredate 入职时间
     * @param page 当前页
     * @param rows 行数
     * @return 列表数据
     */
    PageResult<EmployeeVo> findByEmployeeList(String ename, Short deptno, Short onduty, String hiredate,Integer page, Integer rows);

    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    Integer updateEmployee(GenEmployee employee);

    /**
     * 删除员工信息
     * @param empid
     * @return
     */
    Integer deleteEmployee(Short empid);

    /**
     * 修改员工密码
     * @param empid
     * @param password
     * @return
     */
    Integer updatePassword(Short empid ,String password);

}
