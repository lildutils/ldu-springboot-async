package com.lildutils.springboot.async.config;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import com.lildutils.springboot.async.ex.handler.LDuAsyncExceptionHandler;
import com.lildutils.springboot.async.task.LDuAsyncTaskExecutor;

@Configuration
@EnableAsync
public class LDuAsyncConfigurer implements AsyncConfigurer
{
	@Override
	public Executor getAsyncExecutor()
	{
		return new LDuAsyncTaskExecutor();
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler()
	{
		return new LDuAsyncExceptionHandler();
	}

}
