/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Models.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SubscriptionService;

/**
 *
 * @author 709488
 */
public class HomeServlet extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String email = request.getParameter("mail");
        String action = request.getParameter("action");
      
        SubscriptionService ss = new SubscriptionService();

        try {
            if (action.equals("unsubscribe")) {
                ss.delete(email);
                request.setAttribute("errorMessage", "Unsubscribe to Good Friend successfully");
            } 
        }
        catch (Exception ex) {
            request.setAttribute("errorMessage", "You are alredy ubsubscribe to Good Friend");
        }
        try{
            if (action.equals("subscribe")) {
                ss.insert(email);
                request.setAttribute("errorMessage", "Subscribe to Good Friend successfully");
            }
        }
             catch (Exception ex) {
            request.setAttribute("errorMessage", "You are alredy subscribe to Good Friend");
        }
         
        
        ArrayList<Subscription> subscription = null;
        try {
            subscription = (ArrayList<Subscription>) ss.getAll();
        } catch (Exception ex) {
            Logger.getLogger(subscribe.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }
}
