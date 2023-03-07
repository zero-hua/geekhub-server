package ink.geekhub.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ink.geekhub.server.controller.vo.SignupVO;
import ink.geekhub.server.entity.User;

/**
 * @author linghua
 */
public interface IUserService extends IService<User> {
    void save(SignupVO signupVO);
}
