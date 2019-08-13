package security.browser.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author ymbcxb
 * @title
 * @Package security.browser
 * @date 2019/8/13 19:57
 * @Description 自定义用户验证逻辑
 */
@Slf4j
@Component
public class MyUserDetailService implements UserDetailsService {


    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * 处理用户信息获取逻辑
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查找用户信息
        String password = passwordEncoder.encode("123456");
        log.info("登陆用户名: {}",username);
        log.info("密码: {}",password);
        return new User(username,password,
                true,true,true,true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
