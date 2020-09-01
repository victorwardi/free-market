package run.victor.freemarket.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Victor Wardi - @victorwardi
 */
@RestController
@RequestMapping("/v1/users")
public class NewUserController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public NewUserResponse registerUser(@RequestBody @Valid NewUserRequest newUserRequest) {
        final User user = newUserRequest.toModel();
        entityManager.persist(user);
        return  NewUserResponse.fromModel(user);
    }

}
