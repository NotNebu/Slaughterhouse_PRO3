package Slaughterhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(scanBasePackages = {"Slaughterhouse"})
@ComponentScan(
        basePackages = {"Slaughterhouse"},
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = {CuttingSimulation.class}
        )
)
public class PackingApplication {
    public static void main(String[] args) {
        SpringApplication.run(PackingApplication.class, args);
    }
}


