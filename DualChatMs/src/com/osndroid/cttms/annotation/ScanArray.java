package com.osndroid.cttms.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
 * 扫描数组
 * @author OsnDroid
 *
 */
@Target({ElementType.FIELD}) 
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ScanArray {

	 String value() default "";
}
