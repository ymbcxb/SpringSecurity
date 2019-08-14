package security.browser.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import security.browser.support.ServerResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ymbcxb
 * @title
 * @Package security.browser
 * @date 2019/8/14 9:21
 */
@RestController
@Slf4j
public class BrowserSecurityController {

    /**
     * 自定义登陆页面
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ServerResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RequestCache requestCache = new HttpSessionRequestCache();
        DefaultRedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        //保存跳转前的请求
        SavedRequest savedRequest = requestCache.getRequest(request,response);
        if(savedRequest != null){
            String target = savedRequest.getRedirectUrl();
            log.info("原请求:{}",target);
            redirectStrategy.sendRedirect(request,response,"/login.html");
        }
        return new ServerResponse("需要身份验证");
    }
}
