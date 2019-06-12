package org.gege.springframework.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/28 17:57
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Service {
    String value() default "";
}
