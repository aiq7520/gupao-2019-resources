package org.gege.write.spring.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/28 18:02
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoWired {
    String value() default "";
}
