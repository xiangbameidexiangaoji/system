package com.loa.system.oasystem.service.impl;

import com.loa.system.oasystem.dao.role.GenAdminRoleMapper;
import com.loa.system.oasystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李涵林
 * @data 2020/4/22 20:26
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private GenAdminRoleMapper genAdminRoleMapper;

    @Override
    public List<String> selectRoleKeys(Short empid) {
        return this.genAdminRoleMapper.selectRolesByUserId(empid);
    }
}
