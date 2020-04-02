package com.loa.system.oasystem.service.impl;

import com.loa.system.oasystem.dao.dept.GenDeptMapper;
import com.loa.system.oasystem.entity.dept.GenDept;
import com.loa.system.oasystem.entity.dept.GenDeptExample;
import com.loa.system.oasystem.service.DepartmentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 部门 实现类
 *
 * @author 李涵林
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private GenDeptMapper genDeptMapper;

    /**
     * 添加部门信息,发生异常进行回滚
     *
     * @param genDept 部门信息
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public Integer addDepartment(GenDept genDept) {
        return this.genDeptMapper.insertSelective(genDept);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public Integer delDepartment(Short deptno) {
        return this.genDeptMapper.logicalDeleteByPrimaryKey(deptno);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public Integer updateDepartment(GenDept genDept) {
        return this.genDeptMapper.updateByPrimaryKeySelective(genDept);
    }

    @Transactional(readOnly = true)
    @Override
    public List<GenDept> findByDepartment(Short deptno, String deptname) {
        GenDeptExample findDeptExample = new GenDeptExample();
        GenDeptExample.Criteria criteria = findDeptExample.createCriteria().andLogicalDeleted(false);
        if (deptno != null) {
            criteria.andDeptnoEqualTo(deptno);
        }
        if (StringUtils.isNotEmpty(deptname)) {
            String rName = deptname.replace(" ", "");
            criteria.andDeptnameLike(rName + "%");
        }
        return this.genDeptMapper.selectByExample(findDeptExample);
    }


}
