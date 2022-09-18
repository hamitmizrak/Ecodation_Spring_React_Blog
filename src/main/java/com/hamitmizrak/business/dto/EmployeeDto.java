package com.hamitmizrak.business.dto;


import com.hamitmizrak.annotations.BlogRegisterUniqueEmailAddress;
import com.hamitmizrak.annotations.EmployeeUniqueEmailAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//lombok
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class EmployeeDto {
    private Long id;

    @NotNull(message="{employee.username.validation.constraint.NotNull.message}")
    private String name;

    @NotNull(message = "{employee.email.validation.constraint.NotNull.message}")
    @Email
    //Bu annotation'ı biz yazdık
    //@EmployeeUniqueEmailAddress
    @Size(max=155)
    private String email;
}
