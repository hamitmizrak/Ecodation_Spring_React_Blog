package com.hamitmizrak.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = {UniqueEmailAddressValidation.class })
public @interface BlogRegisterUniqueEmailAddress {

    String message() default "{ecodation.unique.email.validation.constraint.NotNull.message}"; //"{javax.validation.constraints.NotNull.message}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
