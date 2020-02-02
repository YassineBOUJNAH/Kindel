package client.modele;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cours
 */
public class Professeur extends Adherent {
    private String matiere;
    final private String matricule;
    
    Professeur(String cin,String nom, String prenom, String matiere,String matricule ){
        super(cin, nom,  prenom);
        this.matiere=matiere;
        this.matricule=matricule;
        
        this.setMax_emprunts(5);
    }
    
    public String toString(){
        return super.toString()+
                "Matier: "+matiere+
                "Matricule: "+matricule;
    }

    public String getMatiere() {
        return matiere;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    
    
    
}
