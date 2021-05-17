package com.maryafolabi.facebookclone.util;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public FilterRegistrationBean<SessionFilter> filterFilterRegistrationBean() {
        FilterRegistrationBean<SessionFilter> registrationBean = new FilterRegistrationBean();
        SessionFilter sessionFilter = new SessionFilter();

        registrationBean.setFilter(sessionFilter);
        registrationBean.addUrlPatterns("/");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
