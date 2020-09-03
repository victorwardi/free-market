package run.victor.freemarket.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import run.victor.freemarket.models.User;
import run.victor.freemarket.requests.NewUserRequest;
import run.victor.freemarket.responses.NewUserResponse;

/**
 * @author Victor Wardi - @victorwardi
 */
@RestController
@RequestMapping("/v1/users")
public class UsersController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public NewUserResponse registerUser(@RequestBody @Valid NewUserRequest newUserRequest) {
        final User user = newUserRequest.toUser();
        entityManager.persist(user);
        return  NewUserResponse.fromUser(user);
    }

}
