package security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ymbcxb
 * @title
 * @Package security.controller
 * @date 2019/8/13 20:48
 */
@Slf4j
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(HttpServletRequest httpServletRequest){
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                log.info(cookie.getName() + " : " + cookie.getValue());
            }
        }
        return "hello";
    }
}
