package run.victor.freemarket.user;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Victor Wardi - @victorwardi
 */
public class NewUserResponse {

    private final String login;
    private final String psw;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime createdTime;

    public NewUserResponse(String login, String psw, LocalDateTime createdTime) {
        this.login = login;
        this.psw = psw;
        this.createdTime = createdTime;
    }

    public static NewUserResponse fromModel(User user) {
        return new NewUserResponse(user.getLogin(), user.getPassword(), user.getCreatedTime());
    }

    public String getLogin() {
        return login;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public String getPsw() {
        return psw;
    }
}
