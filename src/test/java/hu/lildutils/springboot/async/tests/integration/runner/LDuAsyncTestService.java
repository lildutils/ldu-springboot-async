package hu.lildutils.springboot.async.tests.integration.runner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LDuAsyncTestService {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss.SSS");

    @Async
    public void anotherAsyncMethod() {
        final String nowFormatted = DATE_TIME_FORMATTER.format(LocalDateTime.now());
        System.out.println("LDuAsyncTestComponent.anotherAsyncMethod at: " + nowFormatted);
    }

    @Async
    public void throwException() {
        throw new RuntimeException("Test RuntimeException for Async methods");
    }

}
