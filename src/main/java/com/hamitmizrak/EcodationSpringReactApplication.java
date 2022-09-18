package com.hamitmizrak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
        //org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        //org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)
//AuditingEnable
//Dikkat: AuditorAware metodumuzu buraya yazacağız
@EnableJpaAuditing(auditorAwareRef = "auditorAwareMethod")
public class EcodationSpringReactApplication {

    public static void main(String[] args) {
        //devtool active inactive
        System.setProperty("spring.devtools.restart.enabled","false");

        //Disables headless JOptionPane
        System.setProperty("java.awt.headless", "false");

        //PSVM
        SpringApplication.run(EcodationSpringReactApplication.class, args);
    }

}
