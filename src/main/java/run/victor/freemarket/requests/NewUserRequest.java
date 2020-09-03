package run.victor.freemarket.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import run.victor.freemarket.models.User;
import run.victor.freemarket.validators.anotations.UniqueValue;

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

    public User toUser() {
        return new User(login, password);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
