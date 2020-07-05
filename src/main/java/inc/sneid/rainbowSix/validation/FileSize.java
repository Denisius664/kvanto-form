package inc.sneid.rainbowSix.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Constraint(validatedBy = FileSizeValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface FileSize {
    String message() default "Don't correct size";
    long min() default 0;
    long max() default Long.MAX_VALUE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
