package com.loa.system.oasystem.service;

import com.loa.system.oasystem.vo.ExpenseVo;

/**
 * 报销管理
 * @author 李涵林
 */
public interface ExpenseService {
    /**
     * 添加报销
     * @param expenseVo
     * @return
     */
     Integer saveExpense(ExpenseVo expenseVo);

    /**
     * 审批人
     * @param name
     * @return
     */
     String appRover(String name);
}
