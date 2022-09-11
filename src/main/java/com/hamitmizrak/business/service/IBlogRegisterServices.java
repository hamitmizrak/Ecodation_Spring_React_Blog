package com.hamitmizrak.business.service;

import com.hamitmizrak.business.dto.BlogRegisterDto;
import com.hamitmizrak.data.entity.BlogRegisterEntity;

public interface IBlogRegisterServices {

    //Model Mapper
    public BlogRegisterDto EntityToDto(BlogRegisterEntity blogRegisterEntity);
    public BlogRegisterEntity  DtoToEntity(BlogRegisterDto  blogRegisterDto);

    //Save
    public BlogRegisterDto createblogRegister(BlogRegisterDto blogRegisterDto);

}
