package com.hamitmizrak.ui.rest.impl;


import com.hamitmizrak.bean.PasswordEncoderBean;
import com.hamitmizrak.data.repository.IBlogRegisterRepository;
import com.hamitmizrak.exception.ApiResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Log4j2
public class AuthApi {

    IBlogRegisterRepository repository;
    PasswordEncoderBean passwordEncoderBean;

    @Autowired
    public AuthApi(IBlogRegisterRepository repository, PasswordEncoderBean passwordEncoderBean) {
        this.repository = repository;
        this.passwordEncoderBean = passwordEncoderBean;
    }

    //Basic Authentication
    @PostMapping("/api/v1.0/authentication")
    public ResponseEntity<?> autApiMethod(@RequestHeader(name="Authorization",required = false)String authentication){
        if(authentication==null){
            ApiResult apiResult=new ApiResult(401,"/api/v1.0/authentication","unauthroized");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiResult);
        }
        log.info(authentication);

        return ResponseEntity.ok().build();

    }
}
