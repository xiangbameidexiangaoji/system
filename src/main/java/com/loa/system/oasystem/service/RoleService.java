package com.loa.system.oasystem.service;

import java.util.List;

/**
 * 查询角色信息
 * @author 李涵林
 * @data 2020/4/22 20:22
 */
public interface RoleService {
    /**
     * 根据用户 id 查询角色信息
     * @param empid
     * @return
     */
    List<String> selectRoleKeys(Short empid);
}
