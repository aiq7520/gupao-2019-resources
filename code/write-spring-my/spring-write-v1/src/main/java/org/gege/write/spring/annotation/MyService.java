package org.gege.write.spring.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/28 17:57
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyService {
    String value() default "";
}
