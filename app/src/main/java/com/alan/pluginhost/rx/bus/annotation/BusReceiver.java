package com.alan.pluginhost.rx.bus.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)//表示这个注解适用于方法
@Retention(RetentionPolicy.RUNTIME)//表示这个注解需要保留到运行时
public @interface BusReceiver {
}
