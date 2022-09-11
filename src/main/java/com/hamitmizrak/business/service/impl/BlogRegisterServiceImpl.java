package com.hamitmizrak.business.service.impl;

import com.hamitmizrak.bean.ModelMapperBean;
import com.hamitmizrak.bean.PasswordEncoderBean;
import com.hamitmizrak.business.dto.BlogRegisterDto;
import com.hamitmizrak.business.service.IBlogRegisterServices;
import com.hamitmizrak.data.entity.BlogRegisterEntity;
import com.hamitmizrak.data.repository.IBlogRegisterRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

//Asıl iş yükünü yapan yerdir
@Service
@Log4j2
@Transactional
public class BlogRegisterServiceImpl implements IBlogRegisterServices {
    //global variable
    IBlogRegisterRepository repository;
    ModelMapperBean modelMapperBean;
    PasswordEncoderBean passwordEncoderBean;

    //parametreli constructor
    @Autowired
    public BlogRegisterServiceImpl(IBlogRegisterRepository repository, ModelMapperBean modelMapperBean, PasswordEncoderBean passwordEncoderBean) {
        this.repository = repository;
        this.modelMapperBean = modelMapperBean;
        this.passwordEncoderBean = passwordEncoderBean;
    }

    //Model Mapper
    @Override
    public BlogRegisterDto EntityToDto(BlogRegisterEntity blogRegisterEntity) {
        return modelMapperBean.modelMapper().map(blogRegisterEntity,BlogRegisterDto.class);
    }

    @Override
    public BlogRegisterEntity DtoToEntity(BlogRegisterDto blogRegisterDto) {
        return modelMapperBean.modelMapper().map(blogRegisterDto,BlogRegisterEntity.class);
    }

    //CREATE
    // http://localhsot:8080/blog/register/create
    @Override
    @PostMapping("blog/register/create")
    public BlogRegisterDto createblogRegister(@RequestBody BlogRegisterDto blogRegisterDto) {
        //database password masking
        blogRegisterDto.setPassword(passwordEncoderBean.passwordEncoder().encode(blogRegisterDto.getPassword()));
        BlogRegisterEntity entity=DtoToEntity(blogRegisterDto);
        repository.save(entity);
        return blogRegisterDto;
    }
}
