package springGame.Kelad;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String uri;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(uri);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), getDatabaseNameFromUri());
    }

    private String getDatabaseNameFromUri() {
        try {
            URI uriObject = new URI(uri);
            String db = uriObject.getPath();
            return db.substring(1);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Invalid MongoDB URI", e);
        }
    }
}

