package com.sunld.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) 
@Retention(RetentionPolicy.RUNTIME) 
@Documented 
public @interface LogAnnotation {
	/** 日志类型 **/ 
	public int type() default -1;
	/** 日志内容 **/ 
    public String content() default "";
}
