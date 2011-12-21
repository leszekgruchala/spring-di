package eu.gruchala.spring.other;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author lgr
 */
@Configuration
@EnableWebMvc
public class MvcConfiguration {

    final static Logger L = LoggerFactory.getLogger(MvcConfiguration.class);

    //  Indicates that method produces a bean to be managed by Spring
    @Bean
    ViewResolver viewResolver() {
        final InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/views/");
        resolver.setSuffix(".jsp");
        L.info("Working with viewResolver");
        return resolver;
    }
}
