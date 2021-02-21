/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Models.HomeItem;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 709488
 */
public class InventoryServlet extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user_name");
         int totalUserValue = 0;
        String fileUser = "";
        String path = getServletContext().getRealPath("/WEB-INF/homeitems.txt");
        File file = new File(path);
        Scanner inFile = new Scanner(file).useDelimiter(",");
        while (inFile.hasNext()){
            fileUser = inFile.next();
            inFile.next();
            inFile.next();
               
                
                String cost = inFile.next();
                 if (fileUser.equals(user)){
            totalUserValue += Integer.parseInt(cost);
            }
                 if (inFile.hasNext()){
                         inFile.nextLine();
                 }
        }
         session.setAttribute("inventoryValue", totalUserValue);
          inFile.close();
        getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String category = request.getParameter("category");
        String itemName = request.getParameter("itemName");
        String price = request.getParameter("price");
        String user = (String) session.getAttribute("user_name");
        String path = getServletContext().getRealPath("/WEB-INF/homeitems.txt");
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, true))); 
        
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
        
        HomeItem newItem = new HomeItem(user, category, itemName, price);
       pw.println(newItem.formatToFile());
       pw.close();
       request.setAttribute("errorMessage", "Item Was Successfully Added to your Inventory");
        
       
        getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);
    }

   
}
