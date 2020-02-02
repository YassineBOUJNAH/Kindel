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
public class Etudiant extends Adherent {
    private final String cne;
    private String filiere;
    
    Etudiant(String cin,String nom, String prenom,String cne,String filiere){
         super(cin, nom,  prenom);
         this.cne=cne;
         this.filiere=filiere;
         this.setMax_emprunts(3);
         
    }
    
    public String toString(){
        return super.toString()+
                "Cne: "+cne+
                "Filiere: "+filiere;
    }
    
    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getCne() {
        return cne;
    }
    
    
    
}
