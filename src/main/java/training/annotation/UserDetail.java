package training.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.CONSTRUCTOR}) //on class level
public @interface UserDetail {

    String name() default "Default";

    String email() default "default@email.com";

    String address() default "default Address";
}
