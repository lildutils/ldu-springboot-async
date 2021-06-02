package hu.lildutils.springboot.async.config;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import hu.lildutils.springboot.async.exception.handler.LDuAsyncUncaughtExceptionHandler;
import hu.lildutils.springboot.async.task.LDuAsyncTaskExecutor;

@Configuration
@EnableAsync
public class LDuAsyncConfigurer implements AsyncConfigurer {
	public static final String CONFIG_THREAD_NAME_PREFIX = "ldu.springboot.async.thread-name-prefix";
	public static final String CONFIG_PERF_LOGGING_ENABLED = "ldu.springboot.async.perf-logging-enabled";

	@Autowired
	private Environment environment;

	@Override
	public Executor getAsyncExecutor() {
		return new LDuAsyncTaskExecutor(environment);
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new LDuAsyncUncaughtExceptionHandler();
	}

}
