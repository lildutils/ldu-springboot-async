package hu.lildutils.springboot.async.tests.integration.component;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.lildutils.springboot.async.EnableLDuAsync;

@SpringBootApplication
@EnableLDuAsync
public class LDuAsyncTestRunner {

    public static void main(final String[] args) {
        SpringApplication.run(LDuAsyncTestRunner.class, args);
    }

}
