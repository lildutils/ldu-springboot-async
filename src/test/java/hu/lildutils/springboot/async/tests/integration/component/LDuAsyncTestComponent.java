package hu.lildutils.springboot.async.tests.integration.component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class LDuAsyncTestComponent {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss.SSS");

    @Async
    public void asyncMethod() throws Exception {
        final String nowFormatted = DATE_TIME_FORMATTER.format(LocalDateTime.now());
        System.out.println("LDuAsyncTestComponent.asyncMethod at: " + nowFormatted);
    }

}
