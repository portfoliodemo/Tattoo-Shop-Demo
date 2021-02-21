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
import java.util.ArrayList;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 709488
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user_name");
       /* if (user != null){
            response.sendRedirect("inventory");
            return;
        }*/
        session.invalidate();
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        String path = getServletContext().getRealPath("/WEB-INF/users.txt");

        String line = "";
        ArrayList<String> validUsers = new ArrayList<String>( );
        File file = new File(path);
        Scanner inFile = new Scanner(file).useDelimiter(",");
        while (inFile.hasNext()){
            validUsers.add(inFile.next());
            inFile.next();
            inFile.nextLine();
        }
        inFile.close();
        if("admin".equals(userName) && "password".equals(password)){
            response.sendRedirect("admin");
            session.setAttribute("user_name", userName);
            return;
        }
        else if (validUsers.contains(userName) && "password".equals(password)){
            response.sendRedirect("inventory");
            session.setAttribute("user_name", userName);
            return;
        }
        else {
            request.setAttribute("errorMessage", "Invalid Login");
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
      

    }

}
