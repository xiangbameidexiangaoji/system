package com.loa.system.oasystem.util;

import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resp {
    public final static int SUCCESS = 1;
    public final static int FAIL = 0;
    public final static String SUCCESS_MSG = "成功";
    public final static String FAIL_MSG = "失败";

    private int code;

    private String msg;

    private Object data;

    public Resp setData(Object data) {
        if (data instanceof Page) {
            Map<String, Object> dataMap = new HashMap<>();
            Page page = (Page) data;
            dataMap.put("list", data);
            dataMap.put("total", page.getTotal());
            dataMap.put("pageNum", page.getPageNum());
            dataMap.put("pageSize", page.getPageSize());
            dataMap.put("pages", page.getPages());
            data = dataMap;
        }
        this.data = data;
        return this;
    }

    public Resp(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Resp success() {
        return new Resp(SUCCESS, SUCCESS_MSG);
    }

    public static Resp success(String msg) {
        return new Resp(SUCCESS, msg);
    }

    public static Resp success(Object data) {
        return new Resp(SUCCESS, SUCCESS_MSG, data);
    }

    public static Resp success(String msg, Object data) {
        return new Resp(SUCCESS, msg, data);
    }

    public static Resp fail() {
        return new Resp(FAIL, FAIL_MSG);
    }

    public static Resp fail(String msg) {
        return new Resp(FAIL, msg);
    }

    public static Resp fail(Object data) {
        return new Resp(FAIL, FAIL_MSG, data);
    }

    public static Resp fail(String msg, Object data) {
        return new Resp(FAIL, msg, data);
    }

}
