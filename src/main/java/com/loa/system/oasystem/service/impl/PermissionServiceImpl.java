package com.loa.system.oasystem.service.impl;

import com.loa.system.oasystem.dao.permission.GenAdminPermissionMapper;
import com.loa.system.oasystem.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 李涵林
 * @data 2020/4/22 22:42
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private GenAdminPermissionMapper genAdminPermissionMapper;


    @Override
    public Set<String> selectPermsByUserId(Short empid) {
        List<String> permissions = this.genAdminPermissionMapper.selectPermsByUserId(empid);
        Set<String> permissionSet = new HashSet<>();
        permissions.stream()
                .forEach((p)->{
                    if(p!=null){
                        permissionSet.addAll(Arrays.asList(p.trim().split(",")));
                    }
                });
        return permissionSet;
    }
}
