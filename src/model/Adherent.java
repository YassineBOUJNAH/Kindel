package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cours
 */
public class Adherent extends Personne {
    
    private final int numero;
    static private int nb=0;
    
    public Adherent(String cin, String nom, String prenom) {
        super(cin, nom, prenom);
        numero=nb++;
    }

    public int getNumero() {
        return numero;
    }
    
    
    
}
