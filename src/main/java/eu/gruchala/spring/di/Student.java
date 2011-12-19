package eu.gruchala.spring.di;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author lgr
 */
@Service
@Lazy
public class Student implements Participant {

    @Override
    public void learn() {
    }
}
