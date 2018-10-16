package tjc.bandung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ChurchServiceSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChurchServiceSchedulerApplication.class, args);
	}
}
