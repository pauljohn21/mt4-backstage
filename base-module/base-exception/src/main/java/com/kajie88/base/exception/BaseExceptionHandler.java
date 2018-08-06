package com.kajie88.base.exception;

import com.kajie88.base.dto.resp.BaseRespDTO;
import com.kajie88.base.enums.common.ResponseStatus;
import com.kajie88.base.enums.error.CommonError;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class BaseExceptionHandler {


    //异常处理
    @ExceptionHandler(value = Exception.class)
    public Object resolveException(HttpServletRequest httpServletRequest, Exception e) {

        e.printStackTrace();
//        if (isAjax(httpServletRequest)) {  fixme 坑判断请求是否为ajax请求
        if (true) {
            BaseRespDTO respDTO = new BaseRespDTO();
            IException discoverException = null;
            if (e instanceof IException) {
                //先判断是否为 自定义异常
                discoverException = (IException) e;
            } else {
                discoverException = new CommonException(CommonError.SYSTEM_ERROR, "系统异常！请联系管理员(。・＿・。)ﾉI’m sorry~");
            }
            respDTO.error(discoverException.getError());

            return respDTO;
        } else {
            return "error2";
        }

    }

//    public static boolean isAjax(HttpServletRequest httpServletRequest) {
//        System.out.println(httpServletRequest.getHeader("X-Requested-With"));
//        return (httpServletRequest.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(httpServletRequest.getHeader("X-Requested-With").toString()));
//    }
}
