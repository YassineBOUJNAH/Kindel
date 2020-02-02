/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import client.modele.Document;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cours
 */
public class Kindle {
    private final int numero;
    static private int nb=0;
    final String server_ip="127.0.0.1";
    final int server_port=8889;
    OutputStreamWriter  sortie;
    BufferedReader entree;
    ObjectInputStream entreeObjet;
    Kindle(){
        numero=++nb;
    }
    boolean connetion() throws IOException{
        Socket soc = new Socket (server_ip, server_port) ;
        //Ecriture
        OutputStream flux1 = soc.getOutputStream() ;
        sortie = new OutputStreamWriter (flux1) ;
        //Lecture
         InputStream flux2 = soc.getInputStream ();
         entree= new BufferedReader (new InputStreamReader (flux2));
         entreeObjet= new ObjectInputStream(flux2);
         return true;
    }
    boolean onKindle() throws IOException{
       if (connetion()){
         //Envoyer donnees de localisation
         //Envoyer les donnees log
        return true;
       }
        else
         return false;
    }
    boolean offKindle() throws IOException{
        sortie.close();
        entree.close();
        return true;
    }
    boolean authentification(String login, String pass) throws IOException{
        sortie.write(login);
        sortie.write('\n');
        System.out.println("login envoye");
        sortie.write(pass);
        sortie.write('\n');
        System.out.println("pass envoye");
        sortie.flush();
        String msg= entree.readLine();
        System.out.println(msg);
        return true;
     
    } 
    LinkedList<Document> chercheDocument(String type, String donnee){
        //envoyer la requete
        //recuperer la liste des document en utilisant la serialisation
        return null;
    }
    void visulaiser(String isbn){
        //recuperer le fchier du document
        //affciher le fichier sur ecran
        // donner une option pour sortir du fichier
    }
    public static void main(String[] args) throws IOException{
        Kindle k=new Kindle();
        boolean conection = k.onKindle();
        if(conection){
            Scanner sc= new Scanner(System.in);
            System.out.println("Veuillez saisir le login");
            String login=sc.nextLine();
            System.out.println("Veuillez saisir le password");
            String password=sc.nextLine();
            if(k.authentification(login, password)){ 
                System.out.println("Veuillez choisir une option:\n");
                System.out.println("1: Chercher un document par ISBN");
                System.out.println("2: Chercher un document par titre");
                System.out.println("3: Chercher un document par auteur");
                System.out.println("4: Chercher un document par editeur");
                int choix=sc.nextInt();
                if(choix==1){
                    System.out.println("3");
                     System.out.println("Veuillez saisir l'ISBN");
                     String isbn=sc.nextLine();
                     k.sortie.write("isbn\n");
                     k.sortie.write(isbn);
                    try {
                        Document doc=(Document)k.entreeObjet.readObject();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Kindle.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 
                     
                }
                else if(choix==2){
                }
                else if(choix==3){
                }
                else if(choix==4){
                }
                else{
                }
                
                
       
            }
            else{
                System.out.println("erreur d'authentification");
            }
                 
            }
        else{
            System.out.println("erreur de connexion");
        }
            //String msg="Hello";
            //k.sortie.write(msg);
            //k.sortie.flush();
            
       
     }
}
