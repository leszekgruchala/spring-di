package eu.gruchala.spring.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author lgr
 */
@Configuration
@Profile("prod")
public class ProductionProfile {

    @Bean(name = "profileName")
    public String getProfileName() {
        return "Production profile";
    }
}
