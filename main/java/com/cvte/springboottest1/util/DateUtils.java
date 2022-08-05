package com.cvte.springboottest1.util;

import java.sql.Date;

public class DateUtils {
    public static Date getDate(){
        return new Date(System.currentTimeMillis());
    }
}
