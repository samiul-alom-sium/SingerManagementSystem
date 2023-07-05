package com.singer.singer.config;

import org.hibernate.proxy.ProxyConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;


import java.util.Locale;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.singer.singer"})
public class WebConfig implements WebMvcConfigurer{

    @Bean
    public Validator validator(){
        final LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(messageSource());
        return validator;
    }

    @Override
    public Validator getValidator(){
        return validator();
    }
    
    @Bean
    StandardServletMultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }

    @Bean
    ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("WEB-INF/i18n/messages", "WEB-INF/i18n/application");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }
    
    // declare the static resources
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/resources/**").addResourceLocations("/").setCachePeriod(31556926);
    }

    /**
    @Bean
    InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views");
        resolver.setSuffix(".jspx");
        resolver.setRequestContextAttribute("requestContext");
        return resolver;
    }
     **/

    @Bean
    UrlBasedViewResolver tilesViewResolver(){
        UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
        tilesViewResolver.setViewClass(TilesView.class);
        return tilesViewResolver;
    }

    @Bean
    TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/layouts/layouts.xml", "/WEB-INF/views/**/views.xml");
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(localeChangeInterceptor());
        registry.addInterceptor(themeChangeInterceptor());
    }

    @Bean
    ThemeChangeInterceptor themeChangeInterceptor(){
        return new ThemeChangeInterceptor();
    }

    @Bean
    ResourceBundleThemeSource themeSource(){
        return new ResourceBundleThemeSource();
    }

    @Bean
    CookieThemeResolver themeResolver(){
        CookieThemeResolver cookieThemeResolver = new CookieThemeResolver();
        cookieThemeResolver.setDefaultThemeName("standard");
        cookieThemeResolver.setCookieMaxAge(3600);
        cookieThemeResolver.setCookieName("theme");
        return cookieThemeResolver;
    }

    @Bean
    LocaleChangeInterceptor localeChangeInterceptor(){
        return new LocaleChangeInterceptor();
    }

    @Bean
    CookieLocaleResolver localeResolver(){
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
        cookieLocaleResolver.setCookieMaxAge(3600);
        cookieLocaleResolver.setCookieName("locale");
        return cookieLocaleResolver;
    }
    
    // mvc view controller
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("singers/list");
    }
    
    // mvc default servlet handler
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }

}