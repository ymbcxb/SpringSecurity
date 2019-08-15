package security.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author ymbcxb
 * @title
 * @Package security.pojo
 * @date 2019/8/15 17:32
 */
@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

}
