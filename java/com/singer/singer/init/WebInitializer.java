package com.singer.singer.init;

import com.singer.singer.config.DataServiceConfig;
import com.singer.singer.config.WebConfig;
import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import org.apache.catalina.security.SecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    
    @Override
    protected Class<?>[] getRootConfigClasses(){
        return new Class<?>[]{
            SecurityConfig.class, DataServiceConfig.class
        };
    }
    
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
            WebConfig.class
        };
    }
    
    @Override
    protected String[] getServletMappings(){
        return new String[]{"/"};
    }
    
    @Override
    protected Filter[] getServletFilters(){
        CharacterEncodingFilter cef = new CharacterEncodingFilter(); 
        cef.setEncoding("UTF-8");
        cef.setForceEncoding(true);
        return new Filter[]{new HiddenHttpMethodFilter(), cef};
    }
    
    // multi part config
    protected void customizeRegistration(ServletRegistration.Dynamic registration){
        registration.setMultipartConfig(getMultipartConfigElement());
    }
    
    @Bean
    private MultipartConfigElement getMultipartConfigElement(){
        return new MultipartConfigElement(null, 5_000_000, 5_000_000, 0);
    }
}