/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Models.Items;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.InventoryService;

/**
 *
 * @author 709488
 */
public class InventoryServlet extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         InventoryService is = new InventoryService();
        try {
            HttpSession session = request.getSession();
            String user = (String) session.getAttribute("user_name");
            System.out.println(user);
            List<Items> item = is.getAll(user);
            request.setAttribute("itemsList", item);
            
        } catch (Exception ex) {
            Logger.getLogger(InventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        
        String category = request.getParameter("category");
        String itemName = request.getParameter("itemName");
        String price = request.getParameter("price");
        
     
        
      
        
        if ("".equals(category) || "".equals(itemName) || "".equals(price) )
        {
            request.setAttribute("errorMessage", "Invalid. Please re-enter");
               request.getRequestDispatcher("/WEB-INF/inventory.jsp")
                        .forward(request, response);
            //getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);
        }
        if (Integer.parseInt(price) < 0){
             request.setAttribute("errorMessage", "Invalid. Please re-enter");
               request.getRequestDispatcher("/WEB-INF/inventory.jsp")
                        .forward(request, response);
        }
        
        
      
       
        
       
        getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);
    }

   
}
