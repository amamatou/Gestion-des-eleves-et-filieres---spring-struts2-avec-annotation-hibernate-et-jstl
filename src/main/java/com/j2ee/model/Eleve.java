/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.j2ee.model;

import javax.persistence.*;


@Entity
@Table(name = "eleves")
public class Eleve {
    @Id
    @Column(name = "cne")
    private String cne;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom")
    private String prenom;
    
    @Column(name = "moyenne")
    private double moyenne;
    
    @ManyToOne
    @JoinColumn(name="Ref_Fil", referencedColumnName = "Code_Fil", nullable=true)
    private Filiere ref_Fil;

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public Filiere getRef_Fil() {
        return ref_Fil;
    }

    public void setRef_Fil(Filiere ref_Fil) {
        this.ref_Fil = ref_Fil;
    }

   

    @Override
    public String toString() {
        return "Eleve{" + "cne=" + cne + ", nom=" + nom + ", prenom=" + prenom + ", moyenne=" + moyenne + ", filiere=" + ref_Fil + '}';
    }

    
}