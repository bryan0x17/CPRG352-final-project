package services;

import dataaccess.UserDB;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Item;
import models.Role;
import models.User;

public class UserService {

    private UserDB userDb = new UserDB();

    public User get(String email) throws Exception {
        User user = this.userDb.get(email);
        return user;
    }
    
    public User getByActivationUuid(String uuid) throws Exception {
        User user = this.userDb.getByActivationUuid(uuid);
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

    public void resetPassword(String email, String path, String url) {
        String uuid = UUID.randomUUID().toString();
        String link = url + "?uuid=" + uuid;
        try {
            User user = this.userDb.get(email);
            if (user != null) {

                Logger.getLogger(UserService.class.getName()).log(Level.INFO, "Reset password by {0}", email);

                String to = user.getEmail();
                String subject = "Home nVentory Reset Password";
                String template = path + "/emailtemplates/resetpassword.html";

                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                tags.put("date", (new java.util.Date()).toString());
                tags.put("link", link);

                GmailService.sendMail(to, subject, template, tags);

                //Add the uuid to the user database
                user.setResetPasswordUuid(uuid);
                this.userDb.update(user);
            } else {
                throw new Exception("No such user");
            }
        } catch (Exception e) {
            Logger.getLogger(UserService.class.getName()).log(Level.WARNING, "Unsuccesfull reset request by " + email, e);
        }
    }

    public void changePassword(String email, String password, String uuid) throws Exception {
        User user = this.userDb.get(email);
        if (user != null && user.getResetPasswordUuid().equals(uuid)) {
            user.setPassword(password);
            user.setResetPasswordUuid(null);
            this.userDb.update(user);
            Logger.getLogger(UserService.class.getName()).log(Level.INFO, "Password changed by {0}", email);
        } else {
            throw new Exception("User does not exist or incorrect UUID");
        }
    }

    public void sendRegistrationEmail(String email, String path, String url) throws Exception {
        String uuid = UUID.randomUUID().toString();
        String link = url + "?uuid=" + uuid;

        User user = this.userDb.get(email);
        if (user != null) {
            String to = user.getEmail();
            String subject = "Home nVentory Registration";
            String template = path + "/emailtemplates/registration.html";

            HashMap<String, String> tags = new HashMap<>();
            tags.put("firstname", user.getFirstName());
            tags.put("lastname", user.getLastName());
            tags.put("date", (new java.util.Date()).toString());
            tags.put("link", link);

            GmailService.sendMail(to, subject, template, tags);

            //Add the uuid to the user database
            user.setActivationUuid(uuid);
            this.userDb.update(user);
        } else {
            throw new Exception("No such user");
        }
    }
    
    public void activate(User user, String path) throws Exception {
        if (user != null) {
            String to = user.getEmail();
            String subject = "Welcome to Home nVentory";
            String template = path + "/emailtemplates/welcome.html";

            HashMap<String, String> tags = new HashMap<>();
            tags.put("firstname", user.getFirstName());
            tags.put("lastname", user.getLastName());

            GmailService.sendMail(to, subject, template, tags);

            //Null the uuid and activate the user account
            user.setActivationUuid(null);
            user.setActive(true);
            this.userDb.update(user);
        } else {
            throw new Exception("No such user");
        }
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
