package org.gege.write.spring.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/28 18:03
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {
    String value() default "";
}
