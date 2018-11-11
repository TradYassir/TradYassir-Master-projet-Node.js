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
public class Patients {
    Connexion cn=new Connexion();
    
    public void Insert(Patient e) throws SQLException{
        Connection c = cn.seConnecter();
        Statement st=c.createStatement();
      st.executeQuery("insert into Patient values ("+e.getId()+",'"+e.getNom()+"')");
    }
    public void Update(Patient e) throws SQLException{
         Connection c = cn.seConnecter();
        Statement st=c.createStatement();
        st.executeUpdate("update Patient set nompat = '"+e.getNom()+"' where idpat="+e.getId());
    }
    public void Delete (int C) throws SQLException{
        Connection c = cn.seConnecter();
        Statement st=c.createStatement();
        st.executeQuery("delete from Patient where idpat="+C);
    }
    public ArrayList<Patient> ListPatient() throws SQLException{
      ArrayList<Patient> listp=new ArrayList<Patient>();
        Connection c = cn.seConnecter();
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("select * from Patient");
        while (rs.next()){
            Patient p=new Patient(rs.getInt(1),rs.getString(2));
          
                listp.add(p);
            
        }
        return listp;
    }
      public ArrayList<Patient> ListPatient1(String s) throws SQLException{
      ArrayList<Patient> listp=new ArrayList<Patient>();
        Connection c = cn.seConnecter();
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("select * from Patient where nompat='"+s+"'");
        while (rs.next()){
            Patient p=new Patient(rs.getInt(1),rs.getString(2));
            
                listp.add(p);
            
        }
        return listp;
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
      public int countP() throws SQLException{
          int a=0;
               Connection c = cn.seConnecter();
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("select count (*) from Patient");
        while (rs.next()){
            a=rs.getInt(1);
        }
        return a;
      }
}
