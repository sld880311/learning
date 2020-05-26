package com.sunld.annotation;

import java.lang.reflect.Method;

public class AnnotationUtil {
	
	public static void getLogInfo(Class<?> clazz) {
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(LogAnnotation.class)) {
				LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
				// 注解信息的处理地方
				System.out.println(annotation.content() + " 类型：" + annotation.type());
			}
		}
	}
	
	public static void main(String[] args) {
		AnnotationUtil.getLogInfo(Login.class);
	} 
}
