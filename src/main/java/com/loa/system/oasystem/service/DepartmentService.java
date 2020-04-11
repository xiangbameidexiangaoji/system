package com.loa.system.oasystem.service;

import com.loa.system.oasystem.entity.dept.GenDept;

import java.util.List;

/**
 * @author 李涵林
 */
public interface DepartmentService {
    /**
     *  实现部门添加
     * @param genDept   部门信息
     * @return
     */
    Integer addDepartment(GenDept genDept);

    /**
     *  删除部门信息
     * @param deptno    部门id
     * @return
     */
    Integer delDepartment(Short deptno);

    /**
     *  修改部门信息
     * @param genDept
     * @return
     */
    Integer updateDepartment(GenDept genDept);

    /**
     * 根据部门 id 或者 名称 查询部门信息。
     * @param deptno    部门id
     * @param deptname  部门名称
     * @return
     */
    List<GenDept> findByDepartment(Short deptno, String deptname);

}
