package security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import security.pojo.User;

/**
 * @author ymbcxb
 * @title
 * @Package security.repository
 * @date 2019/8/15 17:33
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
