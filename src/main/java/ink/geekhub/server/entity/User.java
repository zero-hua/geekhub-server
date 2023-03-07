package ink.geekhub.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;

/**
 * @author linghua
 */
@Data
public class User {
    @JsonIgnore
    @NotNull(message = "用户ID不能为空！")
    private Long id;

    @NotNull(message = "用户名不能为空！")
    private String username;

    @NotNull(message = "邮箱不能为空！")
    @Email
    private String email;

    @NotNull(message = "密码不能为空！")
    @JsonIgnore
    private String password;

    @JsonIgnore
    private String salt;

    private Date signupDate;

    @Length(message = "公司名长度2-20个字符", min = 2, max = 20)
    private String company;

    @Length(message = "位置长度2-20字符", min = 2, max = 20)
    private String location;

    @URL(message = "无效的website")
    private String website;

    @Length(message = "QQ号长度不正确", min = 6, max = 14)
    private String qq;

    @Length(message = "motto长度过长", max = 200)
    private String motto;
}
