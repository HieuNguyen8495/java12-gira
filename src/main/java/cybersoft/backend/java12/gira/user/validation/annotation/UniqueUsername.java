package cybersoft.backend.java12.gira.user.validation.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.backend.java12.gira.user.validation.validator.UniqueUsernameValidator;

@Constraint(validatedBy = UniqueUsernameValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface UniqueUsername {
	public String message() default "This username does exist";
	
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}
