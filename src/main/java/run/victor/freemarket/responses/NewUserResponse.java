package run.victor.freemarket.responses;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import run.victor.freemarket.models.User;

/**
 * @author Victor Wardi - @victorwardi
 */
public class NewUserResponse {

    private final String login;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime createdTime;

    public NewUserResponse(String login, LocalDateTime createdTime) {
        this.login = login;
        this.createdTime = createdTime;
    }

    public static NewUserResponse fromUser(User user) {
        return new NewUserResponse(user.getLogin(), user.getCreatedTime());
    }

    public String getLogin() {
        return login;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

}
