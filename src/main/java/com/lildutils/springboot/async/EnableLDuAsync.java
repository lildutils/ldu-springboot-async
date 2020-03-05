package com.lildutils.springboot.async;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.lildutils.springboot.async.config.LDuAsyncConfigurer;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(LDuAsyncConfigurer.class)
public @interface EnableLDuAsync
{

}
