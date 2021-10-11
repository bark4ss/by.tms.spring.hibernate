package com.example.by_tms_spring_hibernate.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;

//https://devcolibri.com/spring-data-jpa-%D0%BF%D0%B8%D1%88%D0%B5%D0%BC-dao-%D0%B8-services-%D1%87%D0%B0%D1%81%D1%82%D1%8C-2/
@Configuration
@ComponentScan("com.example")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver(){

        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("error/403");
        registry.addViewController("/hello").setViewName("hello");
    }

    @Bean(name = "messageSource")
    public MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource ret = new ReloadableResourceBundleMessageSource();

        // Set the base name for the messages properties file.
        ret.setBasename("classpath:config/messages");
        ret.setCacheSeconds(1);
        ret.setUseCodeAsDefaultMessage(true);
        ret.setDefaultEncoding("utf-8");
        return ret;
    }

    /* The localeResolver is used to resolve user locale data. The CookieLocaleResolver object is used to save user locale information in browser cookie.
     * This way user locale info can be transferred between request. If user disable cookie then you can use SessionLocaleResolver instead. */
    /*@Bean(name = "localeResolver")
    public CookieLocaleResolver getCookieLocaleResolver(){
        // Create a CookieLocaleResolver object.
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        // Set cookie name
        localeResolver.setCookieName("cookie-locale-info");
        // Set default locale value.
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        // Set cookie max exist time.
        localeResolver.setCookieMaxAge(3600);
        return localeResolver;
    }*/

    @Bean(name = "localeResolver")
    public SessionLocaleResolver getSessionLocaleResolver(){
        // Create a SessionLocaleResolver object.
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        // Set default locale in session.
        localeResolver.setDefaultLocale(new Locale("en"));
        return localeResolver;
    }

    @Bean(name="localeInterceptor")
    public LocaleChangeInterceptor getLocaleInterceptor(){
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLocaleInterceptor());
    }
}
