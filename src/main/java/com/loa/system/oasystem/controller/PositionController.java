package com.loa.system.oasystem.controller;

import com.loa.system.oasystem.entity.position.GenPosition;
import com.loa.system.oasystem.service.PositionService;
import com.loa.system.oasystem.util.PageResult;
import com.loa.system.oasystem.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * 岗位管理
 * @author 李涵林
 */
@Api(tags = {"岗位管理"})
@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @ApiOperation(value = "查询所有岗位")
    @GetMapping("/")
    public Result selectPositionAllByPage(@RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer rows){
        PageResult pageResult = this.positionService.selectPositionAllByPage(page, rows);
        return Result.ok(pageResult);
    }

    @ApiOperation(value = "添加岗位")
    @PostMapping("/post")
    public Result savePosition(@Valid GenPosition genPosition){
        Integer savePosition = this.positionService.savePosition(genPosition);
        return savePosition == 1 ? Result.ok() : Result.error();
    }

    @ApiOperation(value = "根据id删除岗位")
    @DeleteMapping("{id}/post")
    public Result delPosition(@PathVariable(value = "id") Short posid){
        Integer delPosition = this.positionService.delPosition(posid);
        return delPosition == 1 ?  Result.ok() : Result.error();
    }

    @ApiOperation(value = "批量删除岗位")
    @DeleteMapping("/")
    public Result delListPosition(Short[] posid){
        Integer delListPosition = this.positionService.delListPosition(posid);
        return delListPosition == 1 ?  Result.ok() : Result.error();
    }
    @ApiOperation(value = "修改岗位")
    @PutMapping("/post")
    public Result updatePosition(GenPosition genPosition){
        Integer updatePosition = this.positionService.updatePosition(genPosition);
        return updatePosition == 1 ? Result.ok() : Result.error();
    }


}

