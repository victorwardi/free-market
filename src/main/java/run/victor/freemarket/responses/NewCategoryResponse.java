package run.victor.freemarket.responses;

/**
 * @author Victor Wardi - @victorwardi
 */
public class NewCategoryResponse {

    private final String name;
    private final NewCategoryResponse parentCategory;

    public NewCategoryResponse(String name, NewCategoryResponse parentCategory) {
        this.name = name;
        this.parentCategory = parentCategory;
    }

    public String getName() {
        return name;
    }

    public NewCategoryResponse getParentCategory() {
        return parentCategory;
    }


}
