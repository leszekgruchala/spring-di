package eu.gruchala.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lgr
 */
@Configuration
@Import(AppConfig.class)
public class TestConfig {

//    Here we can add some more test specific beans and configuration.
}
