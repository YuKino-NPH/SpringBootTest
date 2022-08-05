package com.cvte.springboottest1.exception;

import com.cvte.springboottest1.util.R;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomGlobalException.class)
    @ResponseBody
    public R error(CustomGlobalException e){
        return R.fail(e.getCode(),e.getMsg());
    }
}
