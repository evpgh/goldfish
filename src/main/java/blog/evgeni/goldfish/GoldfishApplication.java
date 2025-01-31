package blog.evgeni.goldfish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GoldfishApplication {

	private static final Logger log = LoggerFactory.getLogger(GoldfishApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GoldfishApplication.class, args);
	}
}
