<%-- 
    Document   : home
    Created on : Jun 16, 2021, 4:29:37 PM
    Author     : 709488
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Good Friend Tattoo</title>
        <link href="https://fonts.googleapis.com/css2?family=Lobster+Two:ital,wght@1,700&display=swap" rel="stylesheet">
        <link href="<c:url value="./home.css" />" rel="stylesheet">
    </head>
    <body>
        <div class="wrapper">
            <nav>
                <!--<img src="assets/images/logo.jpg">-->
                <div class="links" align="center">
                    <a href="home.html">Home</a>
                    <a href="about.html">About</a>
                    <a href="policies.html">Policies</a>
                    <a href="artists.html">Artists</a>
                    <a href="contact.html">Contact Us</a>
                </div>
            </nav>
            
            <div class="heading">
                <!--<h1>Good Friend Tattoo</h1>-->
            </div>

            <div class="main">
                <div class="intro">
                    <img src="pic1.jpg">
                    <p>
                        We are a team of four female artists dedicated to producing beautiful tattoos while cultivating a safe, professional, and welcoming studio atmosphere. The comfort and consent of every person who enters our space is our number one priority.
                    </p>
                </div>

                <div class="art">
                    <img src="pic2.jpg">
                    <p>
                        We at Good Friend Tattoo believe in Lorem ipsum dolor sit amet consectetur adipisicing elit. Soluta laboriosam, est odit vel odio quibusdam neque veritatis eveniet eius consectetur sint aspernatur dignissimos optio ab facilis dolores, dolore similique sequi.<br><br>
                        <a href="about.html">Meet Our Artists!</a>
                    </p>
                </div>

            </div>
        </div>

        <footer>

        </footer>
    </body>
</html>
