package com.cvte.springboottest1.exception;

import com.cvte.springboottest1.enums.UserResponseEnum;
import com.cvte.springboottest1.vo.ResultVo;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 全局异常处理类，在其中处理全局的异常，并返回给前端
 * @author: 聂裴涵
 * @date: 2022/8/5 3:05 PM
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * @description: 处理自定义业务逻辑的异常信息等
     * @author: 聂裴涵
     * @date: 2022/8/5 3:06 PM
     * @param: CustomGlobalException 接收到的异常
     * @return: ResultVo 返回前端
     **/
    @ExceptionHandler(CustomGlobalException.class)
    @ResponseBody
    public ResultVo customGlobalError(CustomGlobalException e){
        return ResultVo.fail(e.getCode(),e.getMsg());
    }

    @ExceptionHandler(VerificationException.class)
    @ResponseBody
    public ResultVo verificationError(VerificationException e){
        return ResultVo.fail(UserResponseEnum.VERIFICATION_ERROR.getCode(), UserResponseEnum.VERIFICATION_ERROR.getMsg()).data(e.getMsg());
    }
}
