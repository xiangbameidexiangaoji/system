package com.loa.system.oasystem.controller;

import com.loa.system.oasystem.entity.dept.GenDept;
import com.loa.system.oasystem.service.DepartmentService;
import com.loa.system.oasystem.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 李涵林
 */
@Api(tags = {"部门管理"},description = "完成部门的增删改查")
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ApiOperation(value = "查询部门信息")
    @GetMapping("/dept")
    public Result findByDepartment(@RequestParam(required = false) Short deptno,
                                   @RequestParam(required = false) String deptname){
        List<GenDept> byDepartment = this.departmentService.findByDepartment(deptno, deptname);
        return Result.ok(byDepartment);
    }

    @ApiOperation(value = "添加部门")
    @PostMapping("/dept")
    public Result addDepartment(@Valid GenDept genDept) {
        Integer addDepartment = this.departmentService.addDepartment(genDept);
        return addDepartment > 0 ? Result.ok() : Result.error("添加失败");
    }

    @ApiOperation(value = "修改部门")
    @PutMapping("/dept")
    public Result updateDepartment(@Valid GenDept genDept){
        Integer updateDepartment = this.departmentService.updateDepartment(genDept);
        return updateDepartment > 0 ? Result.ok() : Result.error("修改失败");
    }

    @ApiOperation(value = "删除部门")
    @DeleteMapping("{id}/dept")
    public Result delDepartment(@PathVariable(value = "id") Short deptno){
        Integer delDepartment = this.departmentService.delDepartment(deptno);
        return delDepartment > 0 ? Result.ok() : Result.error("删除失败");
    }
}
