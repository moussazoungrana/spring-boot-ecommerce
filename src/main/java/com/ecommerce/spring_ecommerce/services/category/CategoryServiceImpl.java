package com.ecommerce.spring_ecommerce.services.category;

import com.ecommerce.spring_ecommerce.entities.Category;
import com.ecommerce.spring_ecommerce.repositories.CategoryRepository;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category findCategoryBySlug(String slug) {
        return categoryRepository.findBySlug(slug);
    }

    @Override
    public Category saveCategory(Category category) {
        Category savedCategory = categoryRepository.save(category);
        Slugify slg = new Slugify();
        savedCategory.setSlug(slg.slugify(savedCategory.getName()) + "-" + savedCategory.getId());
        return categoryRepository.save(savedCategory);
    }

    @Override
    public Category updateCategory(Category category) {
        Slugify slg = new Slugify();
        category.setSlug(slg.slugify(category.getName()) + "-" + category.getId());
        return categoryRepository.save(category);
    }

    @Override
    public Boolean deleteCategoryById(Long id) {
        if (this.findCategoryById(id) == null) {
            return false;
        }
        categoryRepository.deleteById(id);
        return true;
    }
}
