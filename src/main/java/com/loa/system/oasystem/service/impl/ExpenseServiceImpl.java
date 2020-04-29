package com.loa.system.oasystem.service.impl;

import com.loa.system.oasystem.dao.expense.GenExpenseMapper;
import com.loa.system.oasystem.service.ExpenseService;
import com.loa.system.oasystem.vo.ExpenseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 报销业务
 * @author 李涵林
 * @data 2020/4/10 15:30
 */
@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private GenExpenseMapper genExpenseMapper;
    @Override
    public Integer saveExpense(ExpenseVo expenseVo) {
        return null;
    }

    @Override
    public String appRover(String name) {
        return null;
    }

}
