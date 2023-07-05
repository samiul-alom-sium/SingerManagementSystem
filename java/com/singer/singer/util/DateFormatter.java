package com.singer.singer.util;

import org.springframework.context.annotation.Bean;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter implements Formatter<Date> {

    public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date parse(String s, Locale locale)throws ParseException {
        return formatter.parse(s);
    }

    @Override
    public String print(Date date, Locale locale){
        return formatter.format(date);
    }

    @Bean
    public DateFormatter dateFormatter(){
        return new DateFormatter();
    }
}