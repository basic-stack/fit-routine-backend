package kr.co.khedu.fitroutine.member.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.hibernate.validator.constraints.Range;

import java.lang.annotation.*;

@Range(min = 1, max = 499)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface ValidHeight {
    String message() default "올바른 신장이 아닙니다";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
