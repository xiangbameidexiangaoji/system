package com.loa.system.oasystem.config;

import com.loa.system.oasystem.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 李涵林
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

//    @ExceptionHandler(value = {SQLException.class})
//    public Result handleSQLException(SQLException ex){
//        log.error(ex.getMessage(),ex);
//        return Result.build(500, ex.getMessage(), ex.getErrorCode());
//    }

    @ExceptionHandler(value = {RuntimeException.class})
    public Result handleRuntimeException(RuntimeException ex){
        log.error("运行时异常:",ex);
        return Result.error("运行时异常:" + ex.getMessage());
    }
}
