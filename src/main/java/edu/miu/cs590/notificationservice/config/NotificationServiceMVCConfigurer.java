package edu.miu.cs590.notificationservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class NotificationServiceMVCConfigurer implements WebMvcConfigurer {
    @Autowired
    private NotificationServiceInterceptor notificationServiceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(notificationServiceInterceptor);
    }
}
