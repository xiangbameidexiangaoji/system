package com.loa.system.oasystem.controller;

import com.loa.system.oasystem.service.DutyService;
import com.loa.system.oasystem.util.PageResult;
import com.loa.system.oasystem.util.Result;
import com.loa.system.oasystem.vo.DutyVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李涵林
 */
@Api(tags = {"考勤"})
@RestController
@RequestMapping("/duty")
public class DutyController {

    @Autowired
    private DutyService dutyService;

    @ApiOperation(value = "查询考勤列表")
    @GetMapping("/list")
    public Result findByDutyList(@RequestParam(value = "dtid",required = false) Short dtid,
                                 @RequestParam(value = "ename",required = false) String ename,
                                 @RequestParam(value = "deptname",required = false) String deptname,
                                 @RequestParam(value = "dtdate",required = false) String dtdate,
                                 @RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam(defaultValue = "10") Integer rows){
        PageResult<DutyVo> byDutyList = this.dutyService.findByDutyList(dtid, ename, deptname, dtdate, page, rows);
        return Result.ok(byDutyList);
    }

}
