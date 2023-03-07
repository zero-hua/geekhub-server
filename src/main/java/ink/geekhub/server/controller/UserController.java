package ink.geekhub.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ink.geekhub.server.entity.User;
import ink.geekhub.server.service.IUserService;
import ink.geekhub.server.utils.MailService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author linghua
 */
@RestController
@RequestMapping("/api")
@Validated
public class UserController {

    @Resource
    private IUserService userService;

    @Resource
    private MailService mailService;

    @GetMapping("/user/{account}")
    public User findUser(@PathVariable String account) {
        return userService.getOne(new QueryWrapper<User>(){{
            eq("username", account).or().eq("email", account);
        }});
    }

    @PutMapping("/user")
    public void updateUser(User user) {
        Session session = SecurityUtils.getSubject().getSession();
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.list();
    }
}
