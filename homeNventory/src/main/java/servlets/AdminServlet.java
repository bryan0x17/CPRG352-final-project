/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Category;
import models.Item;
import models.Role;
import models.User;
import services.CategoryService;
import services.RoleService;
import services.UserService;

/**
 *
 * @author Bryan
 */
public class AdminServlet extends HttpServlet {

   

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getQueryString();
        // If the user select manage users
        if (query != null && query.contains("users")) {
            this.showUsers(request, response);
            getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
            
        // if the user selects manage categories
        } else if (query != null && query.contains("categories")) {
            this.showCategories(request, response);
           getServletContext().getRequestDispatcher("/WEB-INF/categories.jsp").forward(request, response);
        // If the user lands on the admin page
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    /**
     * Generates the list of users and roles and attaches them to the request.
     * 
     * @param request servlet request
     * @param response servlet response
     * @return message to be displayed on the page
     */
    private String showUsers(HttpServletRequest request, HttpServletResponse response) {
        
        UserService userService = new UserService();
        RoleService roleService = new RoleService();
        String message = "";
        try {
            
            List<User> users = userService.getAll();
            List<Role> roles = roleService.getAll();
            request.setAttribute("users", users);
            request.setAttribute("roles", roles);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
    
    /**
     * Generates the list of users and roles and attaches them to the request.
     * 
     * @param request servlet request
     * @param response servlet response
     * @return message to be displayed on the page
     */
    private String showCategories(HttpServletRequest request, HttpServletResponse response) {
        
        CategoryService categoryService = new CategoryService();
        String message = "";
        try {
            
            List<Category> categories = categoryService.getAll();
            request.setAttribute("categories", categories);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
