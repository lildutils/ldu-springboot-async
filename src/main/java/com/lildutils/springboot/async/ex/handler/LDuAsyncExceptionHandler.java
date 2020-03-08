package com.lildutils.springboot.async.ex.handler;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;

public class LDuAsyncExceptionHandler extends SimpleAsyncUncaughtExceptionHandler
{
	private static final Logger LOGGER = LoggerFactory.getLogger( LDuAsyncExceptionHandler.class );

	@Override
	public void handleUncaughtException( Throwable t, Method method, Object... params )
	{
		LOGGER.error( "[ASYNC] [ERROR] " + method.toString() + ": " + t.getMessage() );
		LOGGER.debug( "[ASYNC] [DEBUG] " + method.toString() + ": " + t );
	}

}
