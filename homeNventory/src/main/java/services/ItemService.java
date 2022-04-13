/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dataaccess.ItemDB;
import java.util.List;
import models.Category;
import models.Item;
import models.User;

/**
 *
 * @author Bryan
 */
public class ItemService {
    private final ItemDB itemDb = new ItemDB();
    
    public Item get(Integer id) throws Exception {
        Item item = this.itemDb.get(id);
        return item;
    }
    
    public List<Item> getAll() throws Exception {
        List<Item> categories = this.itemDb.getAll();
        return categories;
    }
    
    public void insert(Integer itemId, String itemName, double price, Category category, User owner) throws Exception {
        Item item = new Item(itemId, itemName, price, category, owner);
        this.itemDb.insert(item);
    }
    
    public void update(Integer itemId, String itemName, double price, Category category, User owner) throws Exception {
        Item item = new Item(itemId, itemName, price, category, owner);
        this.itemDb.update(item);
    }
    
    public void delete(Integer itemId) throws Exception {
        Item item = this.get(itemId);
        this.itemDb.delete(item);
    }
}
