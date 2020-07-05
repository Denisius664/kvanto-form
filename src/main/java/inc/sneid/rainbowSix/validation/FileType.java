package inc.sneid.rainbowSix.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Constraint(validatedBy = FileTypeValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface FileType {
    String message() default "Don't correct type of file";
    String[] types();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
