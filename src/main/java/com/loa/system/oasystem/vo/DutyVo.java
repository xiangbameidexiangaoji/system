package com.loa.system.oasystem.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 视图
 */
@Data
public class DutyVo {
    /**
     * id  dtid
     */
    private Short id;
    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 所属部门
     */
    private String deptName;

    /**
     * 出勤时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDateTime attendanceTime;

    /**
     * 签到时间 signintime
     */
    @JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
    private LocalDateTime signInTime;

    /**
     * 签退时间 signouttime
     */
    @JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
    private LocalDateTime signOutTime;
}
