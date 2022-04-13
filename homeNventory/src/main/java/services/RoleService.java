/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dataaccess.RoleDB;
import java.util.List;
import models.Role;

/**
 *
 * @author Bryan
 */
public class RoleService {
    private final RoleDB roleDb = new RoleDB();
    
    public Role get(Integer id) throws Exception {
        Role role = this.roleDb.get(id);
        return role;
    }
    
    public List<Role> getAll() throws Exception {
        List<Role> categories = this.roleDb.getAll();
        return categories;
    }
    
    public void insert(Integer roleId, String roleName) throws Exception {
        Role role = new Role(roleId, roleName);
        this.roleDb.insert(role);
    }
    
    public void update(Integer roleId, String roleName) throws Exception {
        Role role = new Role(roleId, roleName);
        this.roleDb.update(role);
    }
    
    public void delete(Integer roleId) throws Exception {
        Role role = this.get(roleId);
        this.roleDb.delete(role);
    }
}
