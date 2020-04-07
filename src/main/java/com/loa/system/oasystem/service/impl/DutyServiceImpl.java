package com.loa.system.oasystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loa.system.oasystem.dao.duty.GenDutyMapper;
import com.loa.system.oasystem.entity.duty.GenDuty;
import com.loa.system.oasystem.service.DutyService;
import com.loa.system.oasystem.util.PageResult;
import com.loa.system.oasystem.vo.DutyVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author 李涵林
 */
@Service
public class DutyServiceImpl implements DutyService {

    @Autowired
    private GenDutyMapper genDutyMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer singInDuty(GenDuty genDuty) {
        return this.genDutyMapper.insertSelective(genDuty);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer singBack(GenDuty genDuty) {
        return this.genDutyMapper.updateByPrimaryKeySelective(genDuty);
    }


    @Override
    public PageResult<DutyVo> findByDutyList(Short dtid, String ename, String deptname, String dtdate, Integer page, Integer rows) {
        LocalDateTime localDateTime = null;
        if(StringUtils.isNotBlank(dtdate)){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dtdate);
            localDateTime = LocalDateTime.parse(dtdate.replace(" ", ""),dateTimeFormatter);
        }
        PageHelper.startPage(page, rows);
        List<DutyVo> list = this.genDutyMapper.findByDutyList(dtid,ename,deptname,localDateTime);
        PageInfo<DutyVo> pageInfo = new PageInfo<>(list);
        PageResult pageResult = new PageResult();
        pageResult.setPageIndex(page);
        pageResult.setTotalPage(pageInfo.getTotal());
        pageResult.setResult(pageInfo.getList());
        return pageResult;
    }

}
