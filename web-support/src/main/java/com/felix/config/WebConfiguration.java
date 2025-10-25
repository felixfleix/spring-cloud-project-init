package com.felix.config;

import com.felix.filter.WebMvcFilter;
import com.felix.interceptor.WebRequestInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor());
    }

    @Bean
    public WebRequestInterceptor requestInterceptor() {
        return new WebRequestInterceptor();
    }

    @Bean
    public FilterRegistrationBean<WebMvcFilter> webMvcFilter() {
        FilterRegistrationBean<WebMvcFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new WebMvcFilter());
        return registrationBean;
    }

}
