<%-- 
    Document   : palindrome_list
    Created on : 08 May 2025, 1:28:52 AM
    Author     : leseg
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.Palindrome"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Palindrome List Page</title>
        <style>
            td{
                text-align: center;
                padding: 5px;
            }
            
            .stats tr td{
                padding: 5px;
                padding-left: 40px;
                padding-right: 40px;
            }
            
            .statnum{
                font-size: 25px;
            }
        </style>
    </head>
    <body>
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
            <%
                List<Palindrome> palindromes = (List<Palindrome>) request.getAttribute("palindromes");
                int total = (Integer) request.getAttribute("total");
                int yesOutcome = (Integer) request.getAttribute("yes");
                int noOutcome = (Integer) request.getAttribute("no");
            %>
            <center>
                <table class="stats">
                    <tr>
                        <td>Yes</td>
                        <td>Total</td>
                        <td>No</td>
                    </tr>
                    <tr class="statnum">
                        <td><%=yesOutcome%></td>
                        <td><%=total%></td>
                        <td><%=noOutcome%></td>
                    </tr>
                </table>
                
                <h3>Here's the list</h3>
                <table border='2'>
                    <tr>
                        <th>Original Texts</th>
                        <th>Reversed Texts</th>
                        <th>Results</th>
                        <th>Timestamp</th>
                    </tr>
                    <%
                        for(Palindrome pal : palindromes)
                        {
                            %>
                                <tr>
                                    <td><%=pal.getUserText()%></td>
                                    <td><%=pal.getPalindromeText()%></td>
                                    <td><%=pal.getResult()%></td>
                                    <td><%=pal.getTimestamp()%></td>
                                </tr>
                            <%
                        }
                    %>
                </table>
            </center>
        </section>
        <footer>
            <center>
                <p>...This is INT316D...</p>
            </center>
        </footer>
    </body>
</html>
