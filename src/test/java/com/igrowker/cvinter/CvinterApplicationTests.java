package com.igrowker.cvinter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class CvinterApplicationTests {
    @Autowired
    private ApplicationContext context; // Inject the application context

    @Test
    void contextLoads() {
        // Use the 'context' variable to access beans and properties
        assertNotNull(context.getBean("RecruiterController"));
    }

}
