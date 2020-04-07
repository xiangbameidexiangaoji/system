package com.loa.system.oasystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loa.system.oasystem.dao.employee.GenEmployeeMapper;
import com.loa.system.oasystem.entity.employee.GenEmployee;
import com.loa.system.oasystem.service.EmployeeService;
import com.loa.system.oasystem.util.PageResult;
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

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public Integer save(GenEmployee genEmployee) {
        LocalDateTime dateTime = LocalDateTime.now();
        genEmployee.setBirthdate(dateTime);
        return this.genEmployeeMapper.insertSelective(genEmployee);
    }

    @Override
    public GenEmployee findById(Short empid) {
        GenEmployee employee = this.genEmployeeMapper.selectByPrimaryKey(empid);
        return employee;
    }

    @Override
    public List<String> findByLeaderNameLike(String ename) {
        List<String> leaderName = this.genEmployeeMapper.findByLeaderNameLike(ename);
        return leaderName;
    }

    @Transactional(readOnly = true)
    @Override
    public PageResult<EmployeeVo> findByEmployeeList(String ename, Short deptno, Short onduty, String hiredate,Integer page, Integer rows) {
        LocalDateTime localDateTime = null;
        if(null != hiredate){
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");
            localDateTime = LocalDateTime.parse(hiredate.replace(" ", ""),df);
        }
        PageHelper.startPage(page,rows);
        List<EmployeeVo> findAll =this.genEmployeeMapper.findByEmployeeList(ename,deptno, onduty,localDateTime);
        PageInfo pageInfo = new PageInfo(findAll);
        PageResult<EmployeeVo> pageResult = new PageResult<>();
        pageResult.setResult(pageInfo.getList());
        pageResult.setPageIndex(page);
        pageResult.setTotalPage(pageInfo.getTotal());
        return pageResult;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer updateEmployee(GenEmployee employee) {
        return this.genEmployeeMapper.updateByPrimaryKeySelective(employee);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer deleteEmployee(Short empid) {
        return this.genEmployeeMapper.deleteByPrimaryKey(empid);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer updatePassword(Short empid, String password) {
        return this.genEmployeeMapper.updatePassword(empid,password);
    }

}
