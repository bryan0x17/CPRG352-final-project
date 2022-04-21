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
public class AccountServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        UserService userService = new UserService();
        String message = "";
        if (email == null) {
            message = "Your session has expired. Please login again to continue.";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

        try {
            // Check if the user is an admin
            Integer roleId = (Integer) session.getAttribute("role");
            if (roleId.equals(Role.SYSTEM_ADMIN)) {
                request.setAttribute("admin", true);
            } else {
                request.setAttribute("admin", false);
            }
            User user = userService.get(email);
            request.setAttribute("firstName", user.getFirstName());
            request.setAttribute("lastName", user.getLastName());
            request.setAttribute("email", user.getEmail());
        } catch (Exception ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/account.jsp").forward(request, response);
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
        String query = request.getQueryString();
        HttpSession session = request.getSession();
        UserService userService = new UserService();
        String message = "";
        String oldEmail = (String) session.getAttribute("email");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newpassword");
        String newEmail = request.getParameter("email");

        if (firstName == null || firstName.isBlank()
                || lastName == null || lastName.isBlank()
                || newEmail == null || newEmail.isBlank()
                || password == null || password.isBlank()) {
            message = "Please fill out all fields";

        } else {
            try {
                User user = userService.login(oldEmail, password);

                if (user == null) {
                    message = "Your password is not correct";
                } //If the username and password match
                else if (query != null && query.contains("deactivate")) {
                    userService.update(oldEmail, false, user.getFirstName(), user.getLastName(), user.getPassword(), user.getRole());
                    message = "Your account has been deactivated. Please contact an administrator to reactivate";
                    request.setAttribute("message", message);
                    session.invalidate();
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                    return;
                } else {
                    if (newPassword != null && !newPassword.isBlank()) {
                        password = newPassword;
                    }
                    // If the user is not updating their email
                    if (oldEmail.equals(newEmail)) {
                        userService.update(oldEmail, true, firstName, lastName, password, user.getRole());
                        // If the user is updating their email, we do that through userService
                    } else {
                        userService.updateEmail(newEmail, oldEmail, true, firstName, lastName, password, user.getRole());
                        session.setAttribute("email", newEmail);
                    }
                    message = "Your information has been updated";
                }
            } catch (Exception ex) {
                Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
                message = "Your information could not be updated";
            }
        }
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/WEB-INF/account.jsp").forward(request, response);
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
