package com.loa.system.oasystem.service;

import com.loa.system.oasystem.entity.employee.GenEmployee;

/**
 * @author 李涵林
 * @data 2020/4/17 0:13
 */
public interface UserService {
    /**
     * 员工登录
     * @param username
     * @param password
     * @return
     */
    GenEmployee login(String username,String password);
}
