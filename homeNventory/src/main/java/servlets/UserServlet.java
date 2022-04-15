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
import models.User;
import services.CategoryService;
import services.ItemService;
import services.UserService;

/**
 *
 * @author Bryan
 */
public class UserServlet extends HttpServlet {

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
        String message = this.showItems(request, response);
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String message = "";
        UserService userService = new UserService();
        CategoryService categoryService = new CategoryService();
        ItemService itemService = new ItemService();
        

        // Adding an item
        if (action != null && action.equals("add")) {
            try {
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                Integer categoryId = Integer.parseInt(request.getParameter("category"));
                Category category = categoryService.get(categoryId);
                User owner = userService.get(email);
                itemService.insert(name, price, category, owner);
                message = "Item added!";
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                message = "The item could not be added!";
            }
        // Selecting an item to edit
        } else if (action != null && action.contains("edit?")) {
            try {
                Integer itemId = Integer.parseInt(action.split("\\?", 2)[1]);
                Item item = itemService.get(itemId);
                request.setAttribute("item", item);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                message = "Item could not be edited. Please try again";
            }
        // Update an item after editing
        } else if (action != null && action.equals("update")) {
            try {
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                Integer itemId = Integer.parseInt(request.getParameter("id"));
                Integer categoryId = Integer.parseInt(request.getParameter("category"));
                Category category = categoryService.get(categoryId);
                User owner = userService.get(email);
                itemService.update(itemId, name, price, category, owner);
                message = "Item updated!";
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                message = "Item could not be updated. Please try again";
            }
        }
        this.showItems(request, response);
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }
    
    private String showItems(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        UserService userService = new UserService();
        CategoryService categoryService = new CategoryService();
        String message = "";
        try {
            User user = userService.get(email);
            List<Item> items = user.getItemList();
            if (items.size() < 1) {
                message = "You have not added any items yet";
            }
            List<Category> categories = categoryService.getAll();
            request.setAttribute("items", items);
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
