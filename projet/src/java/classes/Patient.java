/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author MYC
 */
public class Patient {
    private int idpat;
    private String nompat;
    public Patient(){
        this.idpat=0;
        this.nompat=null;
    }
    public Patient(int id,String nom){
        this.idpat=id;
        this.nompat=nom;
    }
    public Patient(int id){
        this.idpat=id;
    }
    public Patient(Patient p){
        this.idpat=p.idpat;
        this.nompat=p.nompat;
    }
    public int getId(){
        return this.idpat;
    }
    public String getNom(){
        return this.nompat;
    }
    public void setId(int id){
        this.idpat=id;
    }
    public void setNom(String nom){
        this.nompat=nom;
    }
}
