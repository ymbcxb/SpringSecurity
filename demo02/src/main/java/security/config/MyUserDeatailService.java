package security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import security.pojo.User;
import security.repository.UserRepository;

/**
 * @author ymbcxb
 * @title
 * @Package security.config
 * @date 2019/8/15 19:39
 */
@Slf4j
@Component("myUserDeatailService")
public class MyUserDeatailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("username : {}",username);
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        log.info("登陆成功");
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
