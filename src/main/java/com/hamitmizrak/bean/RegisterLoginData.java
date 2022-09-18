package com.hamitmizrak.bean;

import com.hamitmizrak.business.dto.BlogRegisterDto;
import com.hamitmizrak.business.service.impl.BlogRegisterServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RegisterLoginData {


  /*  @Bean
    CommandLineRunner createLoginRegister(BlogRegisterServiceImpl service){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                BlogRegisterDto registerDto=BlogRegisterDto.builder().email("hamitmizrak@gmail.com").password("root").build();
                service.createblogRegister(registerDto);
            }
        };
    }*/
}
