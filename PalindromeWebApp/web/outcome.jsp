<%-- 
    Document   : outcome
    Created on : 08 May 2025, 1:08:10 AM
    Author     : leseg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Outcome Page</title>
    </head>
    <body>
        <%
            String userText = (String) request.getAttribute("userText");
            String palindromeText = (String) request.getAttribute("palindromeText");
            String result = (String) request.getAttribute("result");
        %>
        <header>
            <center>
                <h1>Palindronium</h1>
                <p>
                    Flipping Words For Your Curiosity
                </p>
                <a href="index.html">Return Home</a>
            </center>
        </header>
        <section>
            <center>
                <h1>Outcome</h1>
                <p>Here is your results:</p>
                <table>
                    <tr>
                        <td>Your Text: </td>
                        <td><b><%=userText%></b></td>
                    </tr>
                    <tr>
                        <td>Reversed Text: </td>
                        <td><b><%=palindromeText%></b></td>
                    </tr>
                    <tr>
                        <td>Are They The Same: </td>
                        <td><%=result%></td>
                    </tr>
                </table>
            </center>
        </section>
    </body>
</html>
