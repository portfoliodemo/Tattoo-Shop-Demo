/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user_name");
        if (!"admin".equals(user)){
            response.sendRedirect("inventory");
            return;
        }
        int totalValue = 0;
        String path = getServletContext().getRealPath("/WEB-INF/homeitems.txt");
        File file = new File(path);
        Scanner inFile = new Scanner(file).useDelimiter(",");
        while (inFile.hasNext()){
            for (int i = 0; i < 3; i++){
                inFile.next();
            }
            String cost = inFile.next();
            totalValue += Integer.parseInt(cost);
            inFile.nextLine();
            
        }
        request.setAttribute("totalValue", totalValue);
        inFile.close();
        
       

        getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("login");
        getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);

    }
}
