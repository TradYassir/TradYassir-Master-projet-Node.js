/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MYC
 */
public class Connexion {
    Connection cnx=null;
    public Connection seConnecter(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
         System.out.println("driver ok1");
         String url="jdbc:mysql://localhost:3306/commande";
         String user="root";
         String password="";
     
            cnx=(Connection) DriverManager.getConnection(url,user,password);
                  System.out.println("connexion bien établie");
return cnx;
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
       return cnx;
    }
}
