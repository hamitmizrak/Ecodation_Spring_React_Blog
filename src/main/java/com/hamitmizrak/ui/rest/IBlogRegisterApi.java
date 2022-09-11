package com.hamitmizrak.ui.rest;

import com.hamitmizrak.business.dto.BlogRegisterDto;
import com.hamitmizrak.exception.ApiResult;

public interface IBlogRegisterApi {
    //Save
    ApiResult createBlogRegister(BlogRegisterDto blogRegisterDto);
}
