package ink.geekhub.server.controller.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author linghua
 */
@Data
public class SignupVO {
    @NotNull
    @Size(min = 1, max = 50)
    private String username;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 4, max = 100)
    private String password;

    @NotNull
    @Size(min = 4, max = 6)
    private String verifyCode;
}
