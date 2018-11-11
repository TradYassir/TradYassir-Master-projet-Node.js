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
public class Medecin {
    private int idmed;
    private String nommed;
    public Medecin(){
        this.idmed=0;
        this.nommed=null;
    }
    public Medecin(int id,String nom){
        this.idmed=id;
        this.nommed=nom;
    }
    public Medecin (int id){
        this.idmed=id;
    }
    public int getId(){
        return this.idmed;
    }
    public String getNom(){
        return this.nommed;
    }
    public void setId(int id){
        this.idmed=id;
    }
    public void setNom(String nom){
        this.nommed=nom;
    }
}
