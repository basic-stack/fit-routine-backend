package kr.co.khedu.fitroutine.member.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

@Pattern(regexp = "^[a-zA-Z0-9]{2,16}$")
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface ValidNickname {
    String message() default "닉네임은 2~16자의 영문/숫자만 사용 가능합니다";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
