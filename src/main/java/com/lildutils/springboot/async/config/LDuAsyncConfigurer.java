package com.lildutils.springboot.async.config;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import com.lildutils.springboot.async.ex.handler.LDuAsyncExceptionHandler;
import com.lildutils.springboot.async.task.LDuAsyncTaskExecutor;

@Configuration
@EnableAsync(proxyTargetClass = true)
public class LDuAsyncConfigurer implements AsyncConfigurer
{
	@Autowired
	private Environment environment;

	@Override
	public Executor getAsyncExecutor()
	{
		return new LDuAsyncTaskExecutor(
				environment.getProperty( "ldu.async.task-prefix", "LDu-AsyncTaskExecutor--" ) );
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler()
	{
		return new LDuAsyncExceptionHandler();
	}

}
