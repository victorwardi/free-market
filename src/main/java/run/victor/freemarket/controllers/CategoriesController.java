package run.victor.freemarket.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import run.victor.freemarket.models.Category;
import run.victor.freemarket.requests.NewCategoryRequest;

/**
 * @author Victor Wardi - @victorwardi
 */
@RestController
@RequestMapping("/v1/categories")
public class CategoriesController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public String registerCategory(@RequestBody @Valid NewCategoryRequest newCategoryRequest) {
        final Category category = newCategoryRequest.toCategory(entityManager);
        entityManager.persist(category);
        return category.toString();
    }
}
