/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;

/**
 *
 * @author MYC
 */
public class Consultation {
    private int idcons;
    Patient pat;
    Medecin med;
    Date datecons;
    Double frais;
    public Consultation(){
        
    }
    public Consultation(int idc,Patient idp,Medecin idm,Date datec,Double f){
        this.idcons=idc;
        this.pat=idp;
        this.med=idm;
        this.datecons=datec;
        this.frais=f;
    }
    public int getIdC(){
        return this.idcons;
    }
    public Patient getIdp(){
        return this.pat;
    }
    public Medecin getIdM(){
        return this.med;
    }
    public Date getDatec(){
        return this.datecons;
    }
    public Double getFrais(){
        return this.frais;
    }

    public void setIdcons(int idcons) {
        this.idcons = idcons;
    }

    public void setIdpat(Patient idpat) {
        this.pat = idpat;
    }

    public void setIdmed(Medecin idmed) {
        this.med = idmed;
    }

    public void setDatecons(Date datecons) {
        this.datecons = datecons;
    }

    public void setFrais(Double frais) {
        this.frais = frais;
    }
    
}
