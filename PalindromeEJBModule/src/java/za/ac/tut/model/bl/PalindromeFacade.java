/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.model.entity.Palindrome;

/**
 *
 * @author leseg
 */
@Stateless
public class PalindromeFacade extends AbstractFacade<Palindrome> implements PalindromeFacadeLocal {

    @PersistenceContext(unitName = "PalindromeEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PalindromeFacade() {
        super(Palindrome.class);
    }

    @Override
    public int countTrueResult() {
        Long count = (Long) em.createQuery("SELECT COUNT(p) FROM Palindrome p WHERE p.result = 'Yes' ").getSingleResult();
        return count.intValue();
    }

    @Override
    public int countFalseResult() {
        Long count = (Long) em.createQuery("SELECT COUNT(p) FROM Palindrome p WHERE p.result = 'No' ").getSingleResult();
        return count.intValue();
    }
    
}
