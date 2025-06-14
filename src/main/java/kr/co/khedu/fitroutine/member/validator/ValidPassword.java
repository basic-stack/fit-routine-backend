package kr.co.khedu.fitroutine.member.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d!@#$%^&*()_+=\\-{}\\[\\]|:;\"'<>,.?/~`]{8,}$")
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface ValidPassword {
    String message() default "비밀번호는 8자 이상, 영문 대소문자, 숫자를 포함해야 합니다";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
