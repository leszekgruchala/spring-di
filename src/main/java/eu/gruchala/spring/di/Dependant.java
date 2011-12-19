package eu.gruchala.spring.di;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * <p/>
 *
 * @author lgr
 */
@Service
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class Dependant {

    public Dependant() {
        System.out.println("I WAS CREATED FIRST EVEN I'M NOT A SINGLETON!");
    }
}
