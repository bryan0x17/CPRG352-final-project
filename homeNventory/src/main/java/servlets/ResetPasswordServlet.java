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
import services.UserService;

/**
 *
 * @author Bryan
 */
public class ResetPasswordServlet extends HttpServlet {

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
        String uuid = request.getParameter("uuid");

        // If the UUID exists, send the user to the change password page
        if (uuid == null || uuid.isBlank()) {
            getServletContext().getRequestDispatcher("/WEB-INF/resetpassword.jsp").forward(request, response);
        } else {
            request.setAttribute("uuid", uuid);
            getServletContext().getRequestDispatcher("/WEB-INF/changepassword.jsp").forward(request, response);
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
        String email = request.getParameter("email");
        String uuid = request.getParameter("uuid");
        String message = "";
        UserService userService = new UserService();
        // If the uuid does not exist, the user is requesting a password change email
        if (uuid == null || uuid.isBlank()) {
            String url = request.getRequestURL().toString();
            String path = getServletContext().getRealPath("/WEB-INF");
            userService.resetPassword(email, path, url);
            message = "Your request has been processed. Please check your email for the next steps.";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/resetpassword.jsp").forward(request, response);
        // Else let the user enter their new password
        } else {
            try {
                String password = request.getParameter("password");
                // Check if the user input an email and password and if the password could be changed
                if (email != null && password != null) {
                    userService.changePassword(email, password, uuid);
                    message = "Your password was changed successfully";
                } else {
                    message = "Your password could not be changed. Please try again";
                    request.setAttribute("uuid", uuid);
                }
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher("/WEB-INF/changepassword.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(ResetPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
                message = "Your password could not be changed. Please try again";
                request.setAttribute("uuid", uuid);
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher("/WEB-INF/changepassword.jsp").forward(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
