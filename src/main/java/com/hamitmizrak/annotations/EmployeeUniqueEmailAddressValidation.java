package com.hamitmizrak.annotations;

import com.hamitmizrak.data.entity.BlogRegisterEntity;
import com.hamitmizrak.data.entity.EmployeeEntity;
import com.hamitmizrak.data.repository.IBlogRegisterRepository;
import com.hamitmizrak.data.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmployeeUniqueEmailAddressValidation implements ConstraintValidator<BlogRegisterUniqueEmailAddress,String> {

    IEmployeeRepository repository;
    @Autowired
    public EmployeeUniqueEmailAddressValidation(IEmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isValid(String emailAddress, ConstraintValidatorContext context) {
       EmployeeEntity entity= repository.findByEmail(emailAddress);
       //Eğer bu email veri tabanımızda varsa
        if(entity!=null){
            return false;
        }
        return true;
    }
}
