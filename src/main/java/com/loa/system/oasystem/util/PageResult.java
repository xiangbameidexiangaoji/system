package com.loa.system.oasystem.util;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页
 * @author 李涵林
 */
@Data
public class PageResult implements Serializable {
    /**
     * 当前页
     */
    private Integer pageIndex;
    /**
     * 总记录数
     */
    private Long totalPage;
    /**
     * 结果集
     */
    private List<?> result;
}
