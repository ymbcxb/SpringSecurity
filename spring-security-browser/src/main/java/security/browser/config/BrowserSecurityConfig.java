package security.browser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author ymbcxb
 * @title
 * @Package security.browser.config
 * @date 2019/8/13 19:22
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationSuccessHandler successHandler;
    private final AuthenticationFailureHandler failureHandler;

    @Autowired
    public BrowserSecurityConfig(AuthenticationFailureHandler failureHandler, AuthenticationSuccessHandler successHandler) {
        this.failureHandler = failureHandler;
        this.successHandler = successHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//      http.httpBasic()
        http.formLogin()
            .loginPage("/authentication/require")
            .loginProcessingUrl("/authentication/form")
            .successHandler(successHandler)
            .failureHandler(failureHandler)
            .and()
            .authorizeRequests()
            .antMatchers("/authentication/require","/login.html").permitAll()
            .anyRequest()
            .authenticated().and().csrf().disable();
}
}
