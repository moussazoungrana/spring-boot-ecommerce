package com.ecommerce.spring_ecommerce.services.category;



import com.ecommerce.spring_ecommerce.entities.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getAll();

    public Category findCategoryById(Long id);

    public Category saveCategory(Category category);

    public Category updateCategory(Category category);


    public Boolean deleteCategory(Long id);
}
