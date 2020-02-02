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
public class Livre extends Document {
    
    final private int Tome;
    final private String type;
    final private int nbPage;

    public int getTome() {
        return Tome;
    }

    public String getType() {
        return type;
    }

    public int getNbPage() {
        return nbPage;
    }
    
    Livre(String isbn,String titre, String[] auteur,String editeur,int edition,int exemplaires,int Tome,String type,int nbPage ){
        super( isbn, titre,auteur, editeur, edition, exemplaires);
        this.Tome=Tome;
        this.type=type;
        this.nbPage=nbPage; 
    }
    
    public String toString(){
        return super.toString()+
                " Tome: "+Tome+
                " Type:"+type+
                " nombre de pages: "+nbPage;
    }
    
    protected void finalize(){
        System.out.println("Destruction de l'objet"+this.toString());
    }
      
    
}
