package eu.gruchala.spring;

import eu.gruchala.spring.livecycle.Group;
import eu.gruchala.spring.other.MvcConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lgr
 */
@Configuration
@Import(MvcConfiguration.class)
@ComponentScan("eu.gruchala.spring")
public class AppConfig {

    @Bean
    public Group getGroup() {
        return new Group();
    }

}
