package com.felix.annotation;

import java.lang.annotation.*;


/**
 * @author Felix
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
@Documented
public @interface Nullable {
}
