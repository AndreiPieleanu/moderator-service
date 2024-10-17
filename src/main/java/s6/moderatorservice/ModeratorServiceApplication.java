package s6.moderatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ModeratorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModeratorServiceApplication.class, args);
    }

}
