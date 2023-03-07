package ink.geekhub.server.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ink.geekhub.server.controller.vo.LoginVO;
import ink.geekhub.server.controller.vo.SignupVO;
import ink.geekhub.server.entity.User;
import ink.geekhub.server.service.IUserService;
import ink.geekhub.server.utils.HttpContextUtil;
import ink.geekhub.server.utils.MailService;
import ink.geekhub.server.utils.RandomCodeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理登录模块
 * @author linghua
 */
@Validated
@RestController
@RequestMapping("/api")
@Slf4j
public class AccountController {

    @Autowired
    private IUserService userService;

    @Autowired
    private MailService mailService;

    @PostMapping("/signup")
    public String signup(@Valid @RequestBody SignupVO signupVO) {
        System.out.println(signupVO);
        String verifyCode = (String) HttpContextUtil.getAttributeFromInSession("verifyCode");
        if (!verifyCode.equals(signupVO.getVerifyCode())) {
            return "验证码不正确，注册失败";
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", signupVO.getEmail());
        User user = userService.getOne(queryWrapper);
        if (user != null ) {
            return "该邮箱已注册";
        }
        userService.save(signupVO);
        return "注册成功";
    }

    /**
     * 需要解决后台验证码重复请求问题
     * @param email
     * @return
     */
    @GetMapping("/sendVerifyCode")
    public String sendVerifyCode(@Valid @Email @RequestParam(name = "email") String email) {
        String code = RandomCodeService.getRandomCode();
        mailService.sendVerifyCodeEmail(email, code);
        HttpContextUtil.setAttributeToSession("verifyCode", code);
        log.info("发送验证码：" + code + "到---> " + email);
        return "发送成功，请注意查收";
    }

    @PostMapping("/login")
    public User login(@RequestBody @Valid LoginVO loginVO) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginVO.getUsername(), loginVO.getPassword());
        subject.login(token);
        User user = userService.getOne(new QueryWrapper<User>(){{
            eq("email", loginVO.getUsername());
        }});
        System.out.println(user);
        HttpContextUtil.setAttributeToSession("currentUser", user);
        return user;
    }

    @GetMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "账号已退出";
    }

    @DeleteMapping("")
    public String deleteAccount() {
        return "";
    }
}
