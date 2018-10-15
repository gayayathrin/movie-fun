package org.superbiz.moviefun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String getIndex()
    {
        return "index";
    }

    @RequestMapping("/setup")
    public String getSetup()
    {
        return "setup";
    }
}
