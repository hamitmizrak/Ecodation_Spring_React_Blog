package com.hamitmizrak.bean;

import com.hamitmizrak.business.dto.EmployeeDto;
import com.hamitmizrak.business.service.impl.EmployeeServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeData {


   @Bean
    CommandLineRunner createLoginRegister(EmployeeServiceImpl service){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                for (int i = 1; i <=5;  i++) {
                    EmployeeDto registerDto=EmployeeDto.builder().name("müşteri adı").email("email"+i+"@gmail.com").build();
                    service.createEmployee(registerDto);
                }

            }
        };
    }
}
