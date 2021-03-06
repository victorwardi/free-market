package run.victor.freemarket.validators.anotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import run.victor.freemarket.validators.IdExistsValidator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Victor Wardi - @victorwardi
 */
@Documented
@Constraint(validatedBy = IdExistsValidator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface IdExists {

    String message() default "Field must exist on database";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
}