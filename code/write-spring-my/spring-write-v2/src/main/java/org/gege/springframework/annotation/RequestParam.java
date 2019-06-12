package org.gege.springframework.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/28 18:06
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestParam {
    String value() default "";
}
