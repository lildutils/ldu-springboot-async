package hu.lildutils.springboot.async.tests.integration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import hu.lildutils.springboot.async.tests.integration.runner.LDuAsyncTestComponent;
import hu.lildutils.springboot.async.tests.integration.runner.LDuAsyncTestRunner;
import hu.lildutils.springboot.async.tests.integration.runner.LDuAsyncTestService;

@SpringBootTest(classes = LDuAsyncTestRunner.class)
@ActiveProfiles("test")
class LDuAsyncIntegrationTests {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss.SSS");

    @Autowired
    private LDuAsyncTestComponent component;

    @Autowired
    private LDuAsyncTestService service;

    @Test
    void testContext_ok() {
        // act
        boolean contextLoaded = false;
        // action
        contextLoaded = true;
        // assert
        assertTrue(contextLoaded);
        assertNotNull(component);
        assertNotNull(service);
    }

    @Test
    void testAsyncExecute_ok() throws Exception {
        // act
        String nowFormatted = null;
        // action
        component.asyncMethod();
        nowFormatted = DATE_TIME_FORMATTER.format(LocalDateTime.now());
        System.out.println("LDuAsyncIntegrationTests.asyncMethod at: " + nowFormatted);
        service.anotherAsyncMethod();
        nowFormatted = DATE_TIME_FORMATTER.format(LocalDateTime.now());
        System.out.println("LDuAsyncIntegrationTests.anotherAsyncMethod at: " + nowFormatted);
        // assert
        assertNotNull(nowFormatted);
        assertNotNull(component);
        assertNotNull(service);
    }

    @Test
    void testAsyncException_ok() throws Exception {
        // act
        String nowFormatted = null;
        // action
        service.throwException();
        nowFormatted = DATE_TIME_FORMATTER.format(LocalDateTime.now());
        System.out.println("LDuAsyncIntegrationTests.anotherAsyncMethod at: " + nowFormatted);
        // assert
        assertNotNull(nowFormatted);
        assertNotNull(component);
        assertNotNull(service);
    }

}
