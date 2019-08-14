package security.browser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author ymbcxb
 * @title
 * @Package security.browser
 * @date 2019/8/14 10:38
 */
@SpringBootApplication
@EnableRedisHttpSession
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
