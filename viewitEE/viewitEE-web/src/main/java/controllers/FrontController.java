/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FrontController", urlPatterns = {"/","/login","/register","/order"})
public class FrontController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrontController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FrontController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

// Analyze URL patterns associated with page requests
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Get the requested URL pattern from the client
        String userPath = request.getServletPath();
        
        //Redirect depending on the chosen path
        switch (userPath){
            case "/":
                //redirect to home controller
                break;
         /* case "/movies":
                //redirect to movies service
              
                break;
            case "/bar":
                //redirect to bar controller
                break;*/
            case "/order":
                //redirect to order controller
                break;
            
        }
    }

    //Analyze URL patterns associated with form submits and transport of user data
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           //Get the requested URL pattern from the client
        String userPath = request.getServletPath();
        
        //Redirect depending on the chosen path
        switch (userPath){
            case "/":
                //redirect to home controller
                break;
            case "/login":
                //redirect to login controller
                break;
            case "/register":
                //redirect to register controller
                break;
            case "/movies":
                //redirect to movies controller
                break;
            case "/bar":
                //redirect to bar controller
                break;
            case "/order":
                //redirect to order controller
                break;
            
        }
    }

   @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
