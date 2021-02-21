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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 709488
 */

public class LoginServlet extends HttpServlet {

   
   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
         //getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    String path = getServletContext().getRealPath("/WEB-INF/users.txt");
// to read files
    BufferedReader br = new BufferedReader(new FileReader(new File(path)));
    String[] users = null;
    String line = "";
    String splitBy = ",";
    while ((line = br.readLine()) != null){
        
        users = line.split(splitBy);
          for (String x : users){
        if(x.equals(userName)){
            request.setAttribute("errorMessage", "You Logged IN");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
        }
        
        }
  
    }
       
    }
    
// to append to a file
    //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, true))); 

    }


