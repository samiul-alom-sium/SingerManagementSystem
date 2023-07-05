package com.singer.singer;

import com.singer.singer.util.DateFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;

public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addFormatter(dateFormatter());
    }

    @Bean
    private Formatter<?> dateFormatter() {
        return new DateFormatter();
    }


}
