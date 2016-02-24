/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle8;

import java.util.ArrayList;

/**
 *
 * @author Derlei
 */
public class ListaTabuleiros extends ArrayList<Tabuleiro>{

    /**
     * Returns true if this list contains the specified element.
     * @param t Tabuleiro
     * @return boolean
     */
    public boolean contains(Tabuleiro t) {

        for (Tabuleiro tabuleiro : this) {
            if(tabuleiro.equals(t))
                return true;
        }
        return false;
    }
    
}
