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
public class Dictionnaire extends Document {
    
    private final String langue;
    private int tome;
    
    Dictionnaire(String isbn,String titre, String[] auteur,String editeur,int edition,int exemplaires, String langue, int tome ){
       super( isbn, titre, auteur, editeur, edition, exemplaires);
       this.langue=langue;
       this.tome=tome; 
    }
    public String toString(){
        return super.toString()+
                "Langue: "+langue+
                "nmbre de tomes: "+tome;
    }
    
    protected void finalize(){
        System.out.println("Destruction du dictionanire"+this.toString());
    }
    public String getLangue() {
        return langue;
    }

    public int getTome() {
        return tome;
    }

    public void setTome(int tome) {
        this.tome = tome;
    }
    
    
}
