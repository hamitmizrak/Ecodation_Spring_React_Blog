package com.hamitmizrak.annotations;

import com.hamitmizrak.data.entity.BlogRegisterEntity;
import com.hamitmizrak.data.repository.IBlogRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailAddressValidation implements ConstraintValidator<BlogRegisterUniqueEmailAddress,String> {

    IBlogRegisterRepository repository;
    @Autowired
    public UniqueEmailAddressValidation(IBlogRegisterRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isValid(String emailAddress, ConstraintValidatorContext context) {
       BlogRegisterEntity entity= repository.findByEmail(emailAddress);
       //Eğer bu email veri tabanımızda varsa
        if(entity!=null){
            return false;
        }
        return true;
    }
}
