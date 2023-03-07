package ink.geekhub.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ink.geekhub.server.controller.vo.SignupVO;
import ink.geekhub.server.entity.User;
import ink.geekhub.server.mapper.UserMapper;
import ink.geekhub.server.service.IUserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * User业务类
 * @author linghua
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public void save(SignupVO signupVO) {
        User user = new User();
        user.setEmail(signupVO.getEmail());
        user.setUsername(signupVO.getUsername());
        //盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        //哈希256加密
        user.setPassword(new SimpleHash("SHA-256", signupVO.getPassword(), salt, 2).toString());
        user.setSalt(salt);
        user.setSignupDate(new Date());
        save(user);
    }
}
