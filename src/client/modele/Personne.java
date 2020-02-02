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
public abstract class Personne {
    private final String cin;
    private final String nom;
    private final String prenom;
    private int max_emprunts;
    private int emprunts;
    
    Personne(String cin,String nom, String prenom ){
        this.cin=cin;
        this.nom=nom;
        this.prenom=prenom;
        max_emprunts=1;
        emprunts=0;
    }
    
    public String toString(){
        return "Cin: "+cin+
                "Nom: "+nom+
                "Prenom: "+prenom;
    }

    void IncrementerEmprunts(){
        emprunts++;
    }
    void DescrementerEmprunts(){
        emprunts--;
    }
    public void setMax_emprunts(int max_emprunts) {
        this.max_emprunts = max_emprunts;
    }

    public String getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getMax_emprunts() {
        return max_emprunts;
    }

    public int getEmprunts() {
        return emprunts;
    }
    
    
    
}
