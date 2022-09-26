package pl.coderslab.projectx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import pl.coderslab.projectx.conventer.UserConverter;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "pl.coderslab.projectx.repository")
public class ProjectXApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectXApplication.class, args);
    }

//@Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(userConverter());

    }
    @Bean
    public UserConverter userConverter() {
        return new UserConverter();
    }

}
