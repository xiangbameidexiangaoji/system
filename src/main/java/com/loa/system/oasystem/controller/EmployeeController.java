package com.loa.system.oasystem.controller;

import com.loa.system.oasystem.entity.employee.GenEmployee;
import com.loa.system.oasystem.service.EmployeeService;
import com.loa.system.oasystem.util.PageResult;
import com.loa.system.oasystem.util.Result;
import com.loa.system.oasystem.vo.EmployeeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author 李涵林
 */
@Api(tags = {"员工管理"})
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @ApiOperation(value = "添加员工")
    @PostMapping("/emp")
    public Result saveEmployee(GenEmployee genEmployee){
        return Result.ok(this.employeeService.save(genEmployee));
    }

    @ApiOperation(value = "查询员工列表")
    @GetMapping("/emp")
    public Result findByEmployeeList(@RequestParam(required = false) String ename,
                                     @RequestParam(required = false) Short deptno,
                                     @RequestParam(required = false) Short onduty,
                                     @RequestParam(required = false) String hiredate,
                                     @RequestParam(defaultValue = "1") Integer page,
                                     @RequestParam(defaultValue = "10") Integer rows){
        PageResult<EmployeeVo> byEmployeeList = this.employeeService.findByEmployeeList(ename, deptno, onduty, hiredate, page, rows);
        return Result.ok(byEmployeeList);
    }
    
    @ApiOperation(value = "用于数据回显")
    @GetMapping("/")
    public Result findById(Short empid){
        GenEmployee byId = this.employeeService.findById(empid);
        return Result.ok(byId);
    }
    
    @GetMapping("/leaderName")
    public List<String> findByLeaderNameLike(String ename){
        List<String> leaderNameLike = this.employeeService.findByLeaderNameLike(ename);
        CollectionUtils.isEmpty(new HashMap<>(32));
        return leaderNameLike;
    }
    
}
