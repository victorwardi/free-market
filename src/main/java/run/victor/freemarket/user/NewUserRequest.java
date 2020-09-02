package run.victor.freemarket.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import run.victor.freemarket.validators.UniqueValue;

/**
 * @author Victor Wardi - @victorwardi
 */
public class NewUserRequest {

    @NotBlank @Email
    @UniqueValue(domainClass = User.class, fieldName = "login")
    private final String login;

    @NotBlank
    @Size(min = 6)
    private final String password;

    public NewUserRequest(@NotBlank String login, @NotBlank String password) {
        this.login = login;
        this.password = password;
    }

    public User toModel() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return new User(login, passwordEncoder.encode(password));
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
