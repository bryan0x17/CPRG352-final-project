/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Role;
import models.User;
import services.UserService;

/**
 *
 * @author Bryan
 */
public class LoginServlet extends HttpServlet {

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
        // By going to the login page, users are logged out
        HttpSession session = request.getSession();
        session.invalidate();
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
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

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String message = "";

        if (email != null && password != null) {
            UserService userService = new UserService();
            User user = userService.login(email, password);
            // Only let the user login if their account is active
            if (user != null && user.getActive()) {
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                Role role = user.getRole();
                session.setAttribute("role", role.getRoleId());
                // Send the user to the admin page if they're a sysadmin
                if (role.getRoleId().equals(Role.SYSTEM_ADMIN)) {
                    response.sendRedirect("admin");
                } else {
                    response.sendRedirect("home");
                }
                return;
            } else {
                message = "You could not be logged in. Please try again or reset your password";
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.INFO, "Incorrect password or deactivated account");
            }

        } else {
            message = "You have not entered an email or password";
        }
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

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
