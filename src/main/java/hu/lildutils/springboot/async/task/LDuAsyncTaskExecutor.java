package hu.lildutils.springboot.async.task;

import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.env.Environment;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import hu.lildutils.springboot.async.config.LDuAsyncConfigurer;

public class LDuAsyncTaskExecutor extends SimpleAsyncTaskExecutor {
    private static final Log LOGGER = LogFactory.getLog(LDuAsyncTaskExecutor.class);

    private static final String DEFAULT_THREAD_NAME_PREFIX = "ldu-async";
    private static final Boolean DEFAULT_PERF_LOGGER_ENABLED = Boolean.TRUE;

    private boolean isPerfLoggingEnabled;

    public LDuAsyncTaskExecutor(final Environment environment) {
        super(environment.getProperty(LDuAsyncConfigurer.CONFIG_THREAD_NAME_PREFIX, DEFAULT_THREAD_NAME_PREFIX) + "--");
        isPerfLoggingEnabled = environment
                .getProperty(LDuAsyncConfigurer.CONFIG_PERF_LOGGING_ENABLED, Boolean.class, DEFAULT_PERF_LOGGER_ENABLED)
                .booleanValue();
    }

    @Override
    protected void doExecute(final Runnable task) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("[ASYNC] Invoking async task: " + task.getClass().getSimpleName());
        }

        final LocalDateTime starTime = LocalDateTime.now();
        super.doExecute(task);

        if (isPerfLoggingEnabled) {
            final LocalDateTime endTime = LocalDateTime.now();
            final Duration diffTime = Duration.between(starTime, endTime);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("[ASYNC] [PERF] Duration of the invoked async method (ms): " + diffTime.toMillis());
            }
        }
    }

}
