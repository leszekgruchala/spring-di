package eu.gruchala.spring.di;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * <p/>
 *
 * @author lgr
 */
@Service
@Lazy
public class LazyDeveloper {

    public LazyDeveloper() {
        System.out.println("I AM ALIVE!!!");
    }

}
