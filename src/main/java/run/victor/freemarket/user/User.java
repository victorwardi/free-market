package run.victor.freemarket.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

/**
 * @author Victor Wardi - @victorwardi
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Email
    @Column(unique = true)
    private String login;

    @NotBlank
    @Size(min = 6)
    private String password;

    @CreationTimestamp
    private LocalDateTime createdTime;

    public User() {
    }

    public User(@NotBlank String login, @NotBlank String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
}
