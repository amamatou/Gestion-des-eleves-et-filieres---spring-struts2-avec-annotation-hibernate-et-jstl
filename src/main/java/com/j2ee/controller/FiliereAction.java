/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.j2ee.controller;

import com.j2ee.model.Eleve;
import com.j2ee.model.Filiere;
import com.j2ee.service.IEleveService;
import com.j2ee.service.IFiliereService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author asus
 */
public class FiliereAction extends ActionSupport {
    private List<Filiere> filieres = new ArrayList();
    private Filiere filiere;
//    private int nbEleves;
    private String Code_Fil;
    private List<Eleve> eleves = new ArrayList();
    
    @Autowired
    private IFiliereService filiereService;
    
    @Autowired
    private IEleveService eleveService;

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
    
    public List<Filiere> getFilieres() {
        return filieres;
    }
    
//    public String getFilEleves(){
//        elevesFil = filiereService.getFilEleves(Code_Fil);
//        return "success";
//    }

//    public int getNbEleves() {
//        return nbEleves;
//    }
//
//    public void setNbEleves(int nbEleves) {
//        this.nbEleves = nbEleves;
//    }

    public String getCode_Fil() {
        return Code_Fil;
    }
 
    public void setCode_Fil(String Code_Fil) {
        this.Code_Fil = Code_Fil;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }

    public void setFiliereService(IFiliereService filiereService) {
        this.filiereService = filiereService;
    }
    
    //===========================================
    
    
    public boolean validation(){
        boolean codeNull, nomNull, codeLengthError, filiereExists;
        
        codeNull = filiere.getCode_Fil().length() == 0;
        codeLengthError = filiere.getCode_Fil().length() > 10;
        filiereExists = filiereService.getFiliere(filiere.getCode_Fil().toUpperCase()) != null;
        nomNull = filiere.getNom_Fil().length() == 0;
        
        if (codeNull) {
            addFieldError("filiere.code_Fil", "Le code de la filiere est obligatoire!");
        }
        if (codeLengthError) {
            addFieldError("filiere.code_Fil", "La taille maximale du code est de 10 caractères!");
        }
        if (filiereExists) {
            addFieldError("filiere.code_Fil", "Une filière ayant ce code existe déjà!");
        }
        
        if (nomNull) {
            addFieldError("filiere.nom_Fil", "Le nom de la filiere est obligatoire!");
        }
        
        return !(codeNull || filiereExists || nomNull || codeLengthError);
    }
    
    public String listFiliere() {
        filieres = filiereService.getAll();
        return "success";
    }
    
    public String createFiliereLink() {
        return "success";
    }
    
    public String createFiliere() {
        if(!validation())
            return "input";
        filiere.setCode_Fil(filiere.getCode_Fil().toUpperCase());
        filiereService.createFiliere(filiere);
        filieres = filiereService.getAll();
        return "success";
    }
    
    public String detailFiliere() {
        filiere = filiereService.getFiliere(Code_Fil);
        int nbEleveFil = 0;
        eleves = eleveService.getAll();
        for(Eleve e : eleves){
            if(e.getRef_Fil().getCode_Fil().equals(filiere.getCode_Fil())){
                nbEleveFil ++;
            }
        }
        System.out.println("\n\n************************************************\n\n" + nbEleveFil + "\n\n************************************************\n\n");
       
        return "success";
    }
    
    public String editFiliere() {
        filiere = filiereService.getFiliere(Code_Fil);
        System.out.println("\n\n************************************************\n\n" + filiere + "\n\n************************************************\n\n");
       
        return "success";
    }

    public String updateFiliere() {
         System.out.println("\n\n************************************************\n\n" + filiere + "\n\n************************************************\n\n");
       
         if (filiere.getNom_Fil().length() == 0) {
            addActionError("Le nom de la filiere est obligatoire!");
            return "input";
        }
        filiereService.updateFiliere(filiere);
        filieres = filiereService.getAll();
        filiere = new Filiere();
        return "success";
    }

    public String deleteFiliere() {
//        System.out.println("\n\n************************************************\n\n" + Code_Fil + "\n\n************************************************\n\n");
        filiere = filiereService.getFiliere(Code_Fil);
        if (!filiere.getElevesFil().isEmpty()) {
            addActionError("Impossible de supprimer la filiere "+ filiere.getNom_Fil() + ", elle contient des eleves inscrits."); 
            filieres = filiereService.getAll();
            return "input";
        }
        filiereService.deleteFiliere(Code_Fil);
        filieres = filiereService.getAll();
        return "success";
    }
    

}
