package ru.yandex.practicum.filmorate.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = IsCorrectReleaseDate.class)
@Documented
public @interface IsCorrectLocalData {

    String message() default "{IsCorrectLocalData.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int year();

    int month();

    int day();

}
