package com.hamitmizrak.bean;

import com.hamitmizrak.audit.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class AuditorAwareBean {

    //import org.springframework.data.domain.AuditorAware;
    @Bean
    public AuditorAware auditorAwareMethod(){
        return new AuditorAwareImpl();
    }
}
