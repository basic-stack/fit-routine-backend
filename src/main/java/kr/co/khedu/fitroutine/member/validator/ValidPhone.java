package kr.co.khedu.fitroutine.member.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

@Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface ValidPhone {
    String message() default "올바른 전화번호 형식이 아닙니다 (예: 010-1234-5678)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
