<%-- 
    Document   : SignupDecision
    Created on : Dec 16, 2018, 11:33:33 PM
    Author     : Lakith
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Signup</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="Fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Molengo" />

    <!-- Main css -->
    <link rel="stylesheet" href="Css/Signup.css">
</head>
<body id="dbody">

    <div class="main">

        <div class="container">
            <form method="POST" class="appointment-form" id="appointment-form">
                <h2>
                    Buy OR Sell Any Wedding Related Services Online!
                </h2>
                <h3>
                    The Best Place to Buy or Sell Services
                </h3>
                <div>
                    <input type="button" class="submit" value="Buy Services" onclick="window.location.href='SignupCustomer.jsp'" />
                </div>
                <div>
                    <input type="button" class="submit" value="Sell Services" onclick="window.location.href='SignupServiceprovider.jsp'" />
                </div>
            </form>
        </div>

    </div>

    <!-- JS -->
    <script src="Vendor/jquery/jquery.min.js"></script>
    <script src="Js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
