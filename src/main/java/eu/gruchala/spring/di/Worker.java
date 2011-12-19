package eu.gruchala.spring.di;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author lgr
 */
@Service(value = "workerBean")
@Primary
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Worker implements Participant {
    @Override
    public void learn() {
    }
}
