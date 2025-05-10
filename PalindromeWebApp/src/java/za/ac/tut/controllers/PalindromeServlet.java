/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.controllers;

import java.io.IOException;
import static java.lang.System.out;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.model.PalindromeGenerator;
import za.ac.tut.model.bl.PalindromeFacadeLocal;
import za.ac.tut.model.entity.Palindrome;

/**
 *
 * @author 223141595
 */
public class PalindromeServlet extends HttpServlet {
    @EJB
    private PalindromeFacadeLocal pfl;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve from form
        String userText = request.getParameter("usertext");
        
        // Functions
        PalindromeGenerator generator = new PalindromeGenerator();
        
        String palindromeText = generator.swapText(userText);
        String result = generator.generateResult();
        
        // Store to database
        Palindrome pal = new Palindrome(userText, palindromeText, result, new Date());
        pfl.create(pal);
        
        request.setAttribute("userText", userText);
        request.setAttribute("palindromeText", palindromeText);
        request.setAttribute("result", result);
        
        RequestDispatcher disp = request.getRequestDispatcher("outcome.jsp");
        disp.forward(request, response);
    }
}
