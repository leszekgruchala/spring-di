package eu.gruchala.spring.other;

import java.util.Comparator;

import org.springframework.stereotype.Service;

/** @author lgr */
//Indicates that class represents business logic and can be found by Spring container
@Service
public class CaseInsensitiveComparator implements Comparator<String> {

    public int compare(final String o1, final String o2) {
        assert o1 != null && o2 != null;
        return String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
    }
}
