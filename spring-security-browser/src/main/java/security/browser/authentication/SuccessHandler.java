package security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ymbcxb
 * @title
 * @Package security.browser.authentication
 * @date 2019/8/14 10:04
 * @Description 成功处理器
 */
@Component("successHandler")
@Slf4j
public class SuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        log.info("登录成功");
        RequestCache requestCache = new HttpSessionRequestCache();
        DefaultRedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(httpServletRequest,httpServletResponse
                ,requestCache.getRequest(httpServletRequest,httpServletResponse)
                .getRedirectUrl());
//        httpServletResponse.setContentType("application/json;charset=UTF-8");
//        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(authentication));
    }
}
