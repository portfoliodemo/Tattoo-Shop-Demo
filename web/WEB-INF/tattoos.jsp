<%-- 
    Document   : tattoos
    Created on : Aug 2, 2021, 1:39:29 PM
    Author     : 709488
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>&#127752; Good Friend Tattoo &#127752;</title>

    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Hachi+Maru+Pop&family=Roboto&family=Indie+Flower&family=Otomanopee+One&display=swap" rel="stylesheet">

    <!-- Google Icons -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

    <!-- CSS Stylesheet(s) -->
    <link rel="stylesheet" href="./assets/css/Tattoos.css">
</head>
<body>

    <header>
        <!-- <h1><a href="./prototype.html" title="Good Friend Home">Good Friend</a></h1> -->
        <h1><a href="home" title="Good Friend Home">
        <span id="letter-g">G</span><span id="letter-o-1">o</span><span id="letter-o-2">o</span><span id="letter-d-1">d</span>
        <span id="letter-f">F</span><span id="letter-r">r</span><span id="letter-i">i</span><span id="letter-e">e</span><span id="letter-n">n</span><span id="letter-d-2">d</span>
        </a></h1> 
       
        <nav>
            <ul>
                <li><a href="about">About</a></li>
               <div class="dropdown"> 
               <li><a href="#artist-section">Artists</a></li>  
                 <div class="dropdown-content">  
                   <a href=" <c:url value='/kyle' /> ">Kyle</a>
                   <a href=" <c:url value='/steph' /> ">Steph</a>
                   <a href=" <c:url value='/jean' /> ">Jean</a>
                </div>
               </div>
                <li><a href="tattoos">Tattoos</a></li>
                <li><a href="policies">Policies</a></li>
                <li><a href="contact">Contact</a></li>
                <!-- <li><a href="#">FAQ</a></li> -->
            </ul>
        </nav>
        <div class="toggle">
            <a class="btn" href="bookAppointment">Tattoo Consult</a>
            <!-- <button type="submit">Tattoo Inquiry</button> -->
            <i class="material-icons" id="hamburger-menu" role="navigation">menu</i>
        </div>    
    </header>
</body>
</html>
