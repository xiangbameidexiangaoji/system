package com.loa.system.oasystem.service.impl;

import com.loa.system.oasystem.dao.dept.GenDeptMapper;
import com.loa.system.oasystem.dao.employee.GenEmployeeMapper;
import com.loa.system.oasystem.entity.employee.GenEmployee;
import com.loa.system.oasystem.service.EmployeeService;
import com.loa.system.oasystem.vo.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author 李涵林
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private GenEmployeeMapper genEmployeeMapper;
    @Autowired
    private GenDeptMapper genDeptMapper;

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public Integer save(GenEmployee genEmployee) {
        LocalDateTime dateTime = LocalDateTime.now();
        genEmployee.setBirthdate(dateTime);
        return this.genEmployeeMapper.insertSelective(genEmployee);
    }

    @Override
    public List<String> findByLeaderNameLike(String ename) {
        List<String> leaderName = this.genEmployeeMapper.findByLeaderNameLike(ename);
        return leaderName;
    }

    @Transactional(readOnly = true)
    @Override
    public List<EmployeeVo> findByEmployeeList(String ename, Short deptno, Short onduty, String hiredate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(hiredate.replace(" ", ""),df);
        List<EmployeeVo> findAll =this.genEmployeeMapper.findByEmployeeList(ename,deptno, onduty,localDateTime);
        return findAll;
    }
}
