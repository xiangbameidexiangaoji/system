package com.loa.system.oasystem.service.impl;

import com.loa.system.oasystem.dao.employee.GenEmployeeMapper;
import com.loa.system.oasystem.entity.employee.GenEmployee;
import com.loa.system.oasystem.entity.employee.GenEmployeeExample;
import com.loa.system.oasystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author 李涵林
 * @data 2020/4/17 0:13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private GenEmployeeMapper genEmployeeMapper;

    @Override
    public GenEmployee login(String username, String password) {
        GenEmployeeExample genEmployeeExample = new GenEmployeeExample();
         genEmployeeExample.createCriteria()
                 .andLogicalDeleted(false)
                 .andEnameEqualTo(username)
                 .andPasswordEqualTo(password);
        List<GenEmployee> genEmployees = this.genEmployeeMapper.selectByExample(genEmployeeExample);
        if(!CollectionUtils.isEmpty(genEmployees) && genEmployees.size() > 1){
            return genEmployees.get(0);
        }
        return genEmployees.get(0);
    }
}
