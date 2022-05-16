package com.ecommerce.java_ecommerce.services.category;

import com.ecommerce.java_ecommerce.entities.Category;
import com.ecommerce.java_ecommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Boolean deleteCategory(Long id) {
        if (this.findCategoryById(id) == null){
            return false;
        }
        categoryRepository.deleteById(id);
        return true;
    }
}
