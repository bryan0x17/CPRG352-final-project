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
        // If the user selects manage users
        if (query != null && query.contains("users")) {
            this.showUsers(request, response);
            getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response); 
        } else if (query != null && query.contains("categories")) {
            // if the user selects manage categories
            this.showCategories(request, response);
            getServletContext().getRequestDispatcher("/WEB-INF/categories.jsp").forward(request, response);
        } else {
            // If there's no query, send the user back to the home page
            response.sendRedirect("home");
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
        String action = request.getParameter("action");
        UserService userService = new UserService();
        RoleService roleService = new RoleService();
        CategoryService categoryService = new CategoryService();
        String message = "";
        // Adding a new user
        if (action != null && action.equals("adduser")) {
            try {
                String email = request.getParameter("email");
                String firstName = request.getParameter("firstname");
                String lastName = request.getParameter("lastname");
                String password = request.getParameter("password");
                Integer roleId = Integer.parseInt(request.getParameter("role"));
                Role role = roleService.get(roleId);
                boolean active = request.getParameter("active") != null;
                userService.insert(email, active, firstName, lastName, password, role);
                message = "User added!";
                request.setAttribute("message", message);
                this.showUsers(request, response);
                getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                message = "User could not be added";
                request.setAttribute("message", message);
                this.showUsers(request, response);
                getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
            }
        // Selecting a user to edit
        } else if (action != null && action.contains("edituser?")) {
            try {
                String email = action.split("\\?", 2)[1];
                User user = userService.get(email);
                request.setAttribute("user", user);
                List<Role> roles = roleService.getAll();
                request.setAttribute("roles", roles);
                this.showUsers(request, response);
                getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                message = "Could not edit user";
                request.setAttribute("message", message);
                this.showUsers(request, response);
                getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
            }
        // Deleting a user
        } else if (action != null && action.contains("deleteuser?")) {
            try {
                String email = action.split("\\?", 2)[1];
                userService.delete(email);
                message = "User deleted";
                request.setAttribute("message", message);
                this.showUsers(request, response);
                getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                message = "User could not be deleted";
                request.setAttribute("message", message);
                this.showUsers(request, response);
                getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
            }
        // Update a user
        } else if (action != null && action.equals("updateuser")) {
            try {
                String oldEmail = request.getParameter("oldemail");
                String email = request.getParameter("email");
                String firstName = request.getParameter("firstname");
                String lastName = request.getParameter("lastname");
                String password = request.getParameter("password");
                Integer roleId = Integer.parseInt(request.getParameter("role"));
                Role role = roleService.get(roleId);
                boolean active = request.getParameter("active") != null;
                if (oldEmail.equals(email)) {
                    userService.update(email, active, firstName, lastName, password, role);
                } else {
                    userService.updateEmail(email, oldEmail, active, firstName, lastName, password, role);
                }
                message = "User updated!";
                request.setAttribute("message", message);
                this.showUsers(request, response);
                getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
                
            } catch (Exception ex) {
                Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                message = "User could not be updated";
                request.setAttribute("message", message);
                this.showUsers(request, response);
                getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
            }
        // Add a new category
        } else if (action != null && action.equals("addcategory")) {
            try {
                String name = request.getParameter("name");
                categoryService.insert(name);
                message = "Category added!";
                request.setAttribute("message", message);
                this.showCategories(request, response);
                getServletContext().getRequestDispatcher("/WEB-INF/categories.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                message = "Category could not be added";
                request.setAttribute("message", message);
                this.showCategories(request, response);
                getServletContext().getRequestDispatcher("/WEB-INF/categories.jsp").forward(request, response);
            }
        // Select a category to edit
        } else if (action != null && action.contains("editcategory?")) {
            try {
                Integer categoryId = Integer.parseInt(action.split("\\?", 2)[1]);
                Category category = categoryService.get(categoryId);
                request.setAttribute("category", category);
                this.showCategories(request, response);
                getServletContext().getRequestDispatcher("/WEB-INF/categories.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                message = "Category could not be edited";
                request.setAttribute("message", message);
                this.showCategories(request, response);
                getServletContext().getRequestDispatcher("/WEB-INF/categories.jsp").forward(request, response);
            }
        // Update the selected category
        } else if (action != null && action.equals("updatecategory")) {
            try {
                String name = request.getParameter("name");
                Integer id = Integer.parseInt(request.getParameter("id"));
                categoryService.update(id, name);
                message = "Category updated!";
                request.setAttribute("message", message);
                this.showCategories(request, response);
                getServletContext().getRequestDispatcher("/WEB-INF/categories.jsp").forward(request, response);
                
            } catch (Exception ex) {
                Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                message = "Category could not be updated";
                request.setAttribute("message", message);
                this.showUsers(request, response);
                getServletContext().getRequestDispatcher("/WEB-INF/categories.jsp").forward(request, response);
            }
        // For everything else send the user back to the admin page
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
        }
        
        

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
