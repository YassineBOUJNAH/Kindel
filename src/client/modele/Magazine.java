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
public class Magazine extends Document {
    String periodicite;
    String mois_edition;
    String jour_edition;

    Magazine(String isbn,String titre, String[] auteur,String editeur,int edition,int exemplaires, String periodicite, String mois_edition, String jour_edition ){
        super( isbn, titre, auteur, editeur, edition, exemplaires);
        this.periodicite=periodicite;
        this.mois_edition=mois_edition;
        this.jour_edition=jour_edition;
    }

    public String toString(){
        return super.toString()+
                "periodicite: "+periodicite+
                "mois_edition: "+mois_edition+
                "jour_edition: "+jour_edition;
    }
    
    protected void finalize(){
        System.out.println("Destruction du magazine"+this.toString());
    }
    public String getPeriodicite() {
        return periodicite;
    }

    public void setPeriodicite(String periodicite) {
        this.periodicite = periodicite;
    }

    public String getMois_edition() {
        return mois_edition;
    }

    public void setMois_edition(String mois_edition) {
        this.mois_edition = mois_edition;
    }

    public String getJour_edition() {
        return jour_edition;
    }

    public void setJour_edition(String jour_edition) {
        this.jour_edition = jour_edition;
    }
    
    
    
}
