package com.hamitmizrak.ui.rest.impl;

import com.hamitmizrak.business.dto.BlogRegisterDto;
import com.hamitmizrak.business.service.IBlogRegisterServices;
import com.hamitmizrak.exception.ApiResult;
import com.hamitmizrak.ui.rest.IBlogRegisterApi;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v.1")
@Log4j2
@CrossOrigin
public class BlogRegisterApiImpl implements IBlogRegisterApi {

    IBlogRegisterServices services;
    @Autowired
    public BlogRegisterApiImpl(IBlogRegisterServices services) {
        this.services = services;
    }

    @PostConstruct
    public void init(){
    }

    // http://localhost:8080/api/v.1/blog/registers
    @Override
    @PostMapping("blog/registers")
    // Kullanıcı ekleme alanı
    public ApiResult createBlogRegister(@Valid @RequestBody BlogRegisterDto blogRegisterDto) {
        services.createblogRegister(blogRegisterDto);
        log.info(blogRegisterDto);
        return new ApiResult(200,"/api/v.1/blog/register","Blog Register Eklendi");
    }

    //Exception Handling
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult ApiResult(MethodArgumentNotValidException methodArgumentNotValidException){
     ApiResult apiResult=new ApiResult(400,"/api/v.1/blog/register","Oop status 400 failed");
     Map<String,Object> userRegisterValidationDataField=new LinkedHashMap<>();

     for(FieldError fieldError:methodArgumentNotValidException.getBindingResult().getFieldErrors()){
         userRegisterValidationDataField.put(fieldError.getField(),fieldError.getDefaultMessage());
     }
        apiResult.setValidationDataObject(userRegisterValidationDataField);
        return apiResult;
    }
}
