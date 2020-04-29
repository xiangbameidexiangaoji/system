package com.loa.system.oasystem.service;

import java.util.Set;

/**
 * @author 李涵林
 * @data 2020/4/22 22:40
 */
public interface PermissionService {
    /**
     * 查询用户权限
     * @param empid
     * @return
     */
    Set<String> selectPermsByUserId(Short empid);
}
