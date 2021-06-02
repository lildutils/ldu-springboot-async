package hu.lildutils.springboot.async.exception.handler;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;

public class LDuAsyncUncaughtExceptionHandler extends SimpleAsyncUncaughtExceptionHandler {
	private static final Log LOGGER = LogFactory.getLog(LDuAsyncUncaughtExceptionHandler.class);

	@Override
	public void handleUncaughtException(Throwable t, Method method, Object... params) {
		if (LOGGER.isErrorEnabled()) {
			LOGGER.error("[ASYNC] Unexpected exception occurred invoking async method: " + method);
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("[ASYNC] Unexpected exception was in async method: " + method, t);
		}
	}

}
