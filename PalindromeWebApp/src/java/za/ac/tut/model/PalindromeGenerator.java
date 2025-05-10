/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model;

/**
 *
 * @author leseg
 */
public class PalindromeGenerator  implements PalindromeGeneratorInterface{
    private String palindromeText;

    public PalindromeGenerator() {
    }

    public PalindromeGenerator(String palindromeText) {
        this.palindromeText = palindromeText;
    }
    

    public String getPalindroneText() {
        return palindromeText;
    }

    public void setPalindroneText(String palindroneText) {
        this.palindromeText = palindroneText;
    }
    
    @Override
    public String swapText(String text) {
        StringBuilder sb = new StringBuilder(text);
        
        palindromeText = (sb.reverse()).toString();
        
        return palindromeText;
    }

    @Override
    public String generateResult() {
        return palindromeText.equals(swapText(palindromeText)) ? "Yes" : "No";
    }
}
