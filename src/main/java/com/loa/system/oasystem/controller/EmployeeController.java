package com.loa.system.oasystem.controller;

import com.loa.system.oasystem.entity.employee.GenEmployee;
import com.loa.system.oasystem.service.EmployeeService;
import com.loa.system.oasystem.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/emp")
    public Result saveEmployee(GenEmployee genEmployee){
        return Result.ok(this.employeeService.save(genEmployee));
    }

}
