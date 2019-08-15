package security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ymbcxb
 * @title
 * @Package security.controller
 * @date 2019/8/15 15:18
 */
@RestController
public class HelloController {

    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping("/hello2")
    public ModelAndView hello2(){
        return new ModelAndView("hello2");
    }

    @RequestMapping("/hello3")
    public ModelAndView hello3(){
        return new ModelAndView("hello3");
    }

}
