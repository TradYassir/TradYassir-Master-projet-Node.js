/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author MYC
 */
public class Medecins {
     Connexion cn=new Connexion();
     public void Insert(Medecin M) throws SQLException{
        Connection c = cn.seConnecter();
        Statement st=c.createStatement();
      st.executeQuery("insert into Medecin values ("+M.getId()+",'"+M.getNom()+"')");
    }
    public void Update(Medecin M) throws SQLException{
         Connection c = cn.seConnecter();
        Statement st=c.createStatement();
        st.executeUpdate("update Medecin set nommed ='"+M.getNom()+"' where idmed="+M.getId());
    }
    public void Delete (int C) throws SQLException{
        Connection c = cn.seConnecter();
        Statement st=c.createStatement();
        st.executeQuery("delete from Medecin where idmed="+C);
    } 
     public ArrayList<Medecin> ListMedecin() throws SQLException{
      ArrayList<Medecin> listM=new ArrayList<Medecin>();
        Connection c = cn.seConnecter();
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("select * from Medecin");
        while (rs.next()){
            Medecin M=new Medecin(rs.getInt(1),rs.getString(2));
           
                listM.add(M);
            
        }
        return listM;
    }
      public ArrayList<Medecin> ListPatient1(String s) throws SQLException{
      ArrayList<Medecin> listM=new ArrayList<Medecin>();
        Connection c = cn.seConnecter();
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("select * from Medecin where nommed='"+s+"'");
        while (rs.next()){
            Medecin M=new Medecin(rs.getInt(1),rs.getString(2));
           
                listM.add(M);
            
        }
        return listM;
    }
      public Medecin listPatient2(int C) throws SQLException{
          Medecin M=null;
          Connection c = cn.seConnecter();
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("select * from Medecin where idmed="+C);
        while (rs.next()){
            M=new Medecin(rs.getInt(1),rs.getString(2));
        }
        return M;
      }
}
