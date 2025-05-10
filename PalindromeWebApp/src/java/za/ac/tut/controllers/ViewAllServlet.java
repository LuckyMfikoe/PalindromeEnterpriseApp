/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.controllers;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.model.bl.PalindromeFacadeLocal;
import za.ac.tut.model.entity.Palindrome;

/**
 *
 * @author leseg
 */
public class ViewAllServlet extends HttpServlet {
    @EJB
    private PalindromeFacadeLocal pfl;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Palindrome> palindromes = pfl.findAll();
        int total = pfl.count();
        int yes = pfl.countTrueResult();
        int no = pfl.countFalseResult();
        
        request.setAttribute("palindromes", palindromes);
        request.setAttribute("total", total);
        request.setAttribute("yes", yes);
        request.setAttribute("no", no);
        
        RequestDispatcher disp = request.getRequestDispatcher("palindrome_list.jsp");
        disp.forward(request, response);
    }
}
