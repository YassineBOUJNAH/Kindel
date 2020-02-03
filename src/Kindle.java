/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.Document;
import model.Livre;
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
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Cours
 */
public class Kindle extends JFrame {
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
    boolean authentification(String login, String pass,String type) throws IOException{
        sortie.write(type);
        sortie.write('\n');
        System.out.println("type envoye");
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
            final JFrame frame=new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            frame.setSize(620,440);
            final JFXPanel fxpanel=new JFXPanel();
            frame.add(fxpanel);

        Kindle k=new Kindle();
        boolean conection = k.onKindle();
        if(conection){
            Scanner sc= new Scanner(System.in);
            System.out.println("Veuillez saisir le type");
            String type=sc.nextLine();
            if(type.equals("etudiant"))
                 System.out.println("Veuillez saisir le CNE");
            else if(type.equals("professeur"))
                 System.out.println("Veuillez saisir le CIN");
            String login=sc.nextLine();
            System.out.println("Veuillez saisir le password");
            String password=sc.nextLine();
            if(k.authentification(login, password,type)){ 
               while(true){
                System.out.println("Veuillez choisir une option:\n     ");
                System.out.println("1: Chercher un document par ISBN   ") ;
                System.out.println("2: Chercher un document par titre  ")  ;
                System.out.println("3: Chercher un document par auteur ") ;
                System.out.println("4: Chercher un document par editeur");
                int choix=sc.nextInt();
                sc.nextLine();

                switch (choix) {
                    case 1:
                        System.out.println("Veuillez saisir l'ISBN");
                        String isbn = sc.nextLine();
                        k.sortie.write("isbn\n");
                        k.sortie.write(isbn +'\n');
                        k.sortie.flush();
                        try {
                            Document doc =(Livre)k.entreeObjet.readObject();
                            if(doc != null){
                            System.out.println(doc.getTitre()); 
                            String pdf = doc.getPdf();
                            
                            Platform.runLater(new Runnable() {
                            @Override
                            public void run()
                             {
                                WebEngine engine;
                                  WebView wv=new WebView();
                                  engine=wv.getEngine();
                                  fxpanel.setScene(new Scene(wv));
                                  engine.load(pdf);
                                 }
                             });
                               frame.setVisible(true);
                            
                            
                            }
                            else
                                System.out.println("ce document n'existe pas"); 
                           
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Kindle.class.getName()).log(Level.SEVERE, null, ex);
                        }   break;
                    case 2:   
                        System.out.println(" Veuillez saisir le titre : ");  
                        String titre  = sc.nextLine();
                        k.sortie.write("titre\n");
                        k.sortie.write(titre+'\n');
                        k.sortie.flush(); 
                        
                        System.out.println("Veuillez choisir un document à afficher :");
                 
                    try {
                        LinkedList<Document> documents = (LinkedList<Document>)k.entreeObjet.readObject();  
                           int nb = 0 ;
                           for(int i = 0 ; i < documents.size();i++){ 
                             System.out.println(i+" :"+documents.get(i).getIsbn()+"editeur:"+documents.get(i).getEditeur());
                             nb++;
                           }  
                            
                           int ch = sc.nextInt();
                                  
                                  
                                    if(ch < nb && ch> -1){ 
                                           
                                        
                                                 //affichage du document
                                              
                            String pdf = documents.get(ch).getPdf();
                            
                            Platform.runLater(new Runnable() {
                            @Override
                            public void run()
                             {
                                  WebEngine engine;
                                  WebView wv=new WebView();
                                  engine=wv.getEngine();
                                  fxpanel.setScene(new Scene(wv));
                                  engine.load(pdf);
                                 }
                             });
                               frame.setVisible(true);
                                    }
                                    else 
                                        System.out.println("choix invalid");
                       
                    } catch (ClassNotFoundException ex) {
                                       System.out.print("aucun document n'existe avec ce titre");
                    }
     
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        break;
                }
               }
                
                
       
            }
            else{
                System.out.println("erreur d'authentification");
            }
                 
            }
        else{
            System.out.println("erreur de connexion");
        }
  
       
     }
}
