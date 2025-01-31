package blog.evgeni.goldfish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import blog.evgeni.goldfish.token.Chain;
import blog.evgeni.goldfish.token.Token;

@SpringBootApplication
public class GoldfishApplication {

	private static final Logger log = LoggerFactory.getLogger(GoldfishApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GoldfishApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Token token = new Token(
				"IQBC", "#address", 2, Chain.SOL
			);
			log.info("Token: " + token.toString());
		};
	}

}
