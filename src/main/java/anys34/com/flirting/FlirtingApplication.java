package anys34.com.flirting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FlirtingApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlirtingApplication.class, args);
    }

}
