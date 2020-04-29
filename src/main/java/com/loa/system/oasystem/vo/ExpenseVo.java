package com.loa.system.oasystem.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.loa.system.oasystem.entity.expenseitem.GenExpenseitem;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 报销
 * @author 李涵林
 * @data 2020/4/10 15:45
 */
public class ExpenseVo {
    private String name;
    private Double maxMoney;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDateTime localDateTime;
    private String expMessage;
    /**
     * 报销明细
     */
    private List<GenExpenseitem> expDetailed;
}
