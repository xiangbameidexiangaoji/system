package com.loa.system.oasystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loa.system.oasystem.dao.position.GenPositionMapper;
import com.loa.system.oasystem.entity.position.GenPosition;
import com.loa.system.oasystem.service.PositionService;
import com.loa.system.oasystem.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author 李涵林
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private GenPositionMapper genPositionMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer savePosition(GenPosition genPosition) {
        return this.genPositionMapper.insertSelective(genPosition);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer delPosition(Short posid) {
        return this.genPositionMapper.deleteByPrimaryKey(posid);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer delListPosition(Short[] posid) {
        return Arrays.stream(posid)
                .map(this::delPosition)
                .mapToInt(p -> p)
                .sum();
        /**
         *         int sum = 0;
         *         for (Short aShort : posid) {
         *             Integer p = delPosition(aShort);
         *             int i = p;
         *             sum += i;
         *         }
         *         return sum;
         */
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer updatePosition(GenPosition genPosition) {
        return this.genPositionMapper.updateByPrimaryKeySelective(genPosition);
    }

    @Override
    public PageResult selectPositionAllByPage(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<GenPosition> selectAll = this.genPositionMapper.selectAll();
        PageInfo<GenPosition> pageInfo = new PageInfo<>(selectAll);
        PageResult pageResult = new PageResult();
        pageResult.setPageIndex(page);
        pageResult.setResult(pageInfo.getList());
        pageResult.setTotalPage(pageInfo.getTotal());
        return pageResult;
    }
}
