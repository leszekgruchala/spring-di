package eu.gruchala.spring.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author lgr
 */
@Configuration
@Profile("test")
public class TestProfile {

    @Bean(name = "profileName")
    public String getProfileName() {
        return "Test profile";
    }
}
