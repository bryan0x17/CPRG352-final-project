/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dataaccess.CategoryDB;
import java.util.List;
import models.Role;
import models.Category;

/**
 *
 * @author Bryan
 */
public class CategoryService {
    private CategoryDB categoryDb = new CategoryDB();
    
    public Category get(Integer id) throws Exception {
        Category category = this.categoryDb.get(id);
        return category;
    }
    
    public List<Category> getAll() throws Exception {
        List<Category> categories = this.categoryDb.getAll();
        return categories;
    }
    
    public void insert(Integer categoryId, String categoryName) throws Exception {
        Category category = new Category(categoryId, categoryName);
        this.categoryDb.insert(category);
    }
    
    public void update(Integer categoryId, String categoryName) throws Exception {
        Category category = new Category(categoryId, categoryName);
        this.categoryDb.update(category);
    }
    
    public void delete(Integer categoryId) throws Exception {
        Category category = this.get(categoryId);
        this.categoryDb.delete(category);
    }
}
