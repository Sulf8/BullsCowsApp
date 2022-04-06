package pakhmutov.bullscowsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
/*@ComponentScan({"pakhmutov.bullscowsapp"})
@EntityScan("pakhmutov.bullscowsapp.*")
@EnableJpaRepositories("pakhmutov.bullscowsapp.repositories")*/
public class BullsCowsAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(BullsCowsAppApplication.class, args);
    }
}
