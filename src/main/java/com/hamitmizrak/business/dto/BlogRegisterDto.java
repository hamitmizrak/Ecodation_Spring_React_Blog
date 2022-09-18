package com.hamitmizrak.business.dto;

import com.hamitmizrak.annotations.BlogRegisterUniqueEmailAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogRegisterDto {

    private Long id;

    @NotNull(message="{ecodation.username.validation.constraint.NotNull.message}")
    private String username;

    @NotNull(message = "{ecodation.email.validation.constraint.NotNull.message}")
    @Email
    //Bu annotation'ı biz yazdık
    @BlogRegisterUniqueEmailAddress
    @Size(max=155)
    private String email;

    //Hm1234@
    @NotNull(message = "{ecodation.password.validation.constraint.NotNull.message}")
    @Size(min=7,max=50)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).*$",message = "{ecodation.password.pattern.validation.constraint.NotNull.message}")
    private String password;
}

  /*
    private Long id;
    private String username;
    private String email;
    private String password;
    */
