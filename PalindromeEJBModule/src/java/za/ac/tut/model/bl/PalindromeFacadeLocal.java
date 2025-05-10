/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.model.entity.Palindrome;

/**
 *
 * @author leseg
 */
@Local
public interface PalindromeFacadeLocal {

    void create(Palindrome palindrome);

    void edit(Palindrome palindrome);

    void remove(Palindrome palindrome);

    Palindrome find(Object id);

    List<Palindrome> findAll();

    List<Palindrome> findRange(int[] range);

    int count();
    
    int countTrueResult();
    
    int countFalseResult();
    
}
