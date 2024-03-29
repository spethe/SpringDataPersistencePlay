package actions;

/**
 * Created with IntelliJ IDEA.
 * User: swanand
 * Date: 23/7/13
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 */
import play.mvc.With;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@With(BasicAuthAction.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Inherited
@Documented
public @interface BasicAuth {

}
