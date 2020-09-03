package run.victor.freemarket.requests;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

import org.springframework.util.Assert;
import run.victor.freemarket.models.Category;
import run.victor.freemarket.validators.anotations.IdExists;
import run.victor.freemarket.validators.anotations.UniqueValue;

/**
 * @author Victor Wardi - @victorwardi
 */
public class NewCategoryRequest {

    @NotBlank
    @UniqueValue(domainClass = Category.class, fieldName = "name")
    private final String name;

    @IdExists(domainClass = Category.class, fieldName = "id")
    private final Long parentCategoryId;

    public NewCategoryRequest(String name, Long parentCategoryId) {
        this.name = name;
        this.parentCategoryId = parentCategoryId;
    }

    public String getName() {
        return name;
    }

    public Long getParentCategoryId() {
        return parentCategoryId;
    }

    public Category toCategory(EntityManager entityManager){
        Category category = new Category(name);
        if(parentCategoryId != null) {
            Category parentCategory = entityManager.find(Category.class, parentCategoryId);
            Assert.notNull(parentCategory, "Parent Category cannot be null");
            category.setParent(parentCategory);
        }
        return category;
    }
}
