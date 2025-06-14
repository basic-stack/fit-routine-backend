package kr.co.khedu.fitroutine.member.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface ValidEmail {
    String message() default "올바른 이메일 형식이 아닙니다";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
