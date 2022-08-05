package com.cvte.springboottest1.util;

import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cvte
 * @date 2022/8/5 3:39 PM
 */
public class BindingResultCustomUtils {
    public static Map<String,String> resultToMap(BindingResult result){
        Map<String, String> map = new HashMap<>();
        result.getFieldErrors().forEach((item)->{
            String message = item.getDefaultMessage();
            String field = item.getField();
            map.put(field,message);
        });
        return map;
    }
}
