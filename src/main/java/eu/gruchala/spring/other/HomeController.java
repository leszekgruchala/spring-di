package eu.gruchala.spring.other;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.Comparator;

/**
 * @author lgr
 */
@Controller
public class HomeController {

    final static Logger L = LoggerFactory.getLogger(HomeController.class);

    //Can be also @Autowired by field, without constructor
    private final Comparator<String> comparator;

    //  With javax.inject on classpath, we can use also standard DI annotations
    @Inject
    public HomeController(Comparator<String> comparator) {
        this.comparator = comparator;
    }

    @RequestMapping(value = "/")
    public String home() {
        L.info("Invocation of HomeController");
        return "home";
    }

    @RequestMapping(value = "/compare", method = RequestMethod.GET)
    public String compare(@RequestParam("input1") String input1, @RequestParam("input2") String input2, Model model) {
        final int result = comparator.compare(input1, input2);
        String inEnglish = (result < 0) ? "less than" : (result > 0 ? "greater than" : "equal to");
        String output = "According to our Comparator, '" + input1 + "' is " + inEnglish + "'" + input2 + "'";
        model.addAttribute("output", output);
        return "compareResult";
    }
}
