package eu.gruchala.spring;

import eu.gruchala.spring.livecycle.Group;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lgr
 */
@Configuration
@ComponentScan("eu.gruchala.spring")
public class AppConfig {

    @Bean
    public Group getGroup() {
        return new Group();
    }

}
