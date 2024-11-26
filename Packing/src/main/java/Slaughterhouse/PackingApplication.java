package Slaughterhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"Slaughterhouse"})
public class PackingApplication {
    public static void main(String[] args) {
        SpringApplication.run(PackingApplication.class, args);
    }
}
