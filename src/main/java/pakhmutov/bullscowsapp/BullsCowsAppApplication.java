package pakhmutov.bullscowsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@ComponentScan({"pakhmutov.bullscowsapp"})
@EntityScan("pakhmutov.bullscowsapp.*")
@EnableJpaRepositories("pakhmutov.bullscowsapp.repositories")*/
public class BullsCowsAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(BullsCowsAppApplication.class, args);
    }
}
