package security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author ymbcxb
 * @title
 * @Package security.config
 * @date 2019/8/15 20:59
 */
@Slf4j
public class MyFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("自定义拦截器被执行");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
