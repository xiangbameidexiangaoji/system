package com.loa.system.oasystem.service;

import com.loa.system.oasystem.entity.duty.GenDuty;
import com.loa.system.oasystem.util.PageResult;
import com.loa.system.oasystem.vo.DutyVo;

/**
 * 出勤表
 * @author 李涵林
 */
public interface DutyService {
    /**
     * 员工签到
     * @param genDuty
     * @return
     */
    Integer singInDuty(GenDuty genDuty);

    /**
     * 员工签退
     * @param genDuty
     * @return
     */
    Integer singBack(GenDuty genDuty);

    /**
     * 查询考勤列表
     * @param dtid
     * @param ename
     * @param deptname
     * @param dtdate
     * @param page
     * @param rows
     * @return
     */
    PageResult<DutyVo> findByDutyList(Short dtid, String ename, String deptname, String dtdate, Integer page, Integer rows);
}
