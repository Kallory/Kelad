package springGame.Kelad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
/*
Has the following bundled in:
@Configuration: Tags the class as a source of bean definitions for the application context.
@EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. It's like telling Spring Boot to guess and configure the beans you're likely to need.
@ComponentScan: Tells Spring to look for other components, configurations, and services in the springGame.Kelad package, allowing it to find and register the GameController.

 */
public class KeladApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeladApplication.class, args);
	}

}
