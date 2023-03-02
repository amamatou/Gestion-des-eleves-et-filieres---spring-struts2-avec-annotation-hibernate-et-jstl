/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.j2ee.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="filieres")
public class Filiere implements Serializable{
    @Id
    @Column(name="Code_Fil")
    private String Code_Fil;
    
    @Column(name="Nom_Fil", nullable = false)
    private String Nom_Fil;
    
    @OneToMany(mappedBy = "ref_Fil")
    private List<Eleve> elevesFil;

    public Filiere() {
    }

    public Filiere(String Code_Fil, String Nom_Fil) {
        this.Code_Fil = Code_Fil;
        this.Nom_Fil = Nom_Fil;
    }

    public String getCode_Fil() {
        return Code_Fil;
    }

    public void setCode_Fil(String Code_Fil) {
        this.Code_Fil = Code_Fil;
    }

    public String getNom_Fil() {
        return Nom_Fil;
    }

    public void setNom_Fil(String Nom_Fil) {
        this.Nom_Fil = Nom_Fil;
    }

    public List<Eleve> getElevesFil() {
        return elevesFil;
    }

    public void setElevesFil(List<Eleve> elevesFil) {
        this.elevesFil = elevesFil;
    }

    
    
    @Override
    public String toString() {
        return "Filiere{" + "Code_Fil=" + Code_Fil + ", Nom_Fil=" + Nom_Fil + '}';
    }
    
    
}
