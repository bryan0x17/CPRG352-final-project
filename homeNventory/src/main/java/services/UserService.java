package services;

import dataaccess.UserDB;
import java.util.List;
import models.Item;
import models.Role;
import models.User;

public class UserService {

    private UserDB userDb = new UserDB();

    public User get(String email) throws Exception {
        User user = this.userDb.get(email);
        return user;
    }

    public User login(String email, String password) {
        try {
            User user = this.get(email);
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    public void updateEmail(String newEmail, String oldEmail, boolean active, String firstName, String lastName, String password, Role role) throws Exception {
        // Create the new entry in the database
        this.insert(newEmail, active, firstName, lastName, password, role);
        User user = this.get(oldEmail);
        ItemService itemService = new ItemService();
        // Get all the items associated with the user
        List<Item> items = itemService.getByUser(user);
        // First check if the user had any items
        if (!items.isEmpty()) {
            User newUser = this.get(newEmail);
            // Update the items to point to the new entry
            for (Item item : items) {
                itemService.update(item.getItemId(), item.getItemName(), item.getPrice(), item.getCategory(), newUser);
            }
        }
        // Delete the original entry
        this.delete(oldEmail);

    }

    public List<User> getAll() throws Exception {
        List<User> users = this.userDb.getAll();
        return users;
    }

    public void insert(String email, boolean active, String firstName, String lastName, String password, Role role) throws Exception {
        User user = new User(email, active, firstName, lastName, password, role);
        this.userDb.insert(user);
    }

    public void update(String email, boolean active, String firstName, String lastName, String password, Role role) throws Exception {
        User user = new User(email, active, firstName, lastName, password, role);
        this.userDb.update(user);
    }

    public void delete(String email) throws Exception {
        User user = this.get(email);
        this.userDb.delete(user);
    }
}
