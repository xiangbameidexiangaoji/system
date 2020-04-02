package com.loa.system.oasystem.service;

import com.loa.system.oasystem.entity.position.GenPosition;
import com.loa.system.oasystem.util.PageResult;

/**
 * @author 李涵林
 */
public interface PositionService {
    /**
     * 添加岗位
     * @param genPosition
     * @return
     */
    Integer savePosition(GenPosition genPosition);

    /**
     * 根据 Id 删除岗位
     * @param posid
     * @return
     */
    Integer delPosition(Short posid);

    /**
     * 批量删除岗位
     * @param posid
     * @return
     */
    Integer delListPosition(Short[] posid);

    /**
     * 修改岗位信息
     * @param genPosition
     * @return
     */
    Integer updatePosition(GenPosition genPosition);

    /**
     * 查询所有岗位信息
     * @param page
     * @param rows
     * @return
     */
    PageResult selectPositionAllByPage(Integer page, Integer rows);
}
