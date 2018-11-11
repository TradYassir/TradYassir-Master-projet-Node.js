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
public class Consul {
      Connexion cn=new Connexion();
    
    public void Insert(Consultation co) throws SQLException{
        Connection c = cn.seConnecter();
        Statement st=c.createStatement();
      st.executeQuery("insert into Consultation values ("+co.getIdC()+","+co.getIdp()+","+co.getIdM()+","+co.getDatec()+","+co.getFrais()+")");
    }
    public void Update(Consultation co) throws SQLException{
         Connection c = cn.seConnecter();
        Statement st=c.createStatement();
        st.executeUpdate("update Consultation set datcons ='"+co.getDatec()+"',frais="+co.getFrais()+" where idcons="+co.getIdC());
    }
    public void Delete (int C) throws SQLException{
        Connection c = cn.seConnecter();
        Statement st=c.createStatement();
        st.executeQuery("delete from Consultation where idcons="+C);
    }
    public ArrayList<Consultation> ListConsult() throws SQLException{
      ArrayList<Consultation> listc=new ArrayList<Consultation>();
        Connection c = cn.seConnecter();
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("select * from Consultation");
        while (rs.next()){
           Patient p=new Patient(rs.getInt(2));
           Medecin M=new Medecin(rs.getInt(3));
           Consultation C=new Consultation(rs.getInt(1),p,M,rs.getDate(4),rs.getDouble(5));
                listc.add(C); 
        }
        return listc;
    }
      public ArrayList<Consultation> ListConsult1(int id,String choix) throws SQLException{
      ArrayList<Consultation> listc=new ArrayList<Consultation>();
        Connection c = cn.seConnecter();
        Consultation C;
      if(choix=="Patient"){
      
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("select * from Consultation where idpat="+id);
        while (rs.next()){
            Patient p=new Patient(rs.getInt(2));
           Medecin M=new Medecin(rs.getInt(3));
            C=new Consultation(rs.getInt(1),p,M,rs.getDate(4),rs.getDouble(5));
           
                listc.add(C);
            
        }
        
      }
      if(choix=="Medecin"){
                Statement st1=c.createStatement();
                ResultSet rs1=st1.executeQuery("select * from Consultation where idmed="+id);
        while (rs1.next()){
            Patient p1=new Patient(rs1.getInt(2));
           Medecin M1=new Medecin(rs1.getInt(3));
            C=new Consultation(rs1.getInt(1),p1,M1,rs1.getDate(4),rs1.getDouble(5));
                listc.add(C);
            
            }
        }
        return listc;
    }
      public Patient listPatient2(int C) throws SQLException{
          Patient p=null;
          Connection c = cn.seConnecter();
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("select * from Patient where idpat="+C);
        while (rs.next()){
            p=new Patient(rs.getInt(1),rs.getString(2));
        }
        return p;
      }
}
