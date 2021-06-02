package hu.lildutils.springboot.async.tests.unit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import hu.lildutils.springboot.async.exception.handler.LDuAsyncUncaughtExceptionHandler;

class LDuAsyncUnitTests {

    @Test
    void testUncaughtAsyncException_ok() throws Exception {
        // act
        LDuAsyncUncaughtExceptionHandler handler = null;
        Throwable exception = null;
        Method method = null;
        Class<?>[] paramTypes = null;
        // action
        handler = new LDuAsyncUncaughtExceptionHandler();
        exception = new Exception("Test exception for async invocation");
        paramTypes = new Class[] {};
        method = handler.getClass().getMethod("toString", paramTypes);
        handler.handleUncaughtException(exception, method, "test", "it");
        // assert
        assertNotNull(handler);
        assertNotNull(exception);
        assertNotNull(method);
        assertNotNull(paramTypes);
    }

}
