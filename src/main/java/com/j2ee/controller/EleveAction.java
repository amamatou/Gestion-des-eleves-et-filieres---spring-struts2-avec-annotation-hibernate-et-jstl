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


public class EleveAction  extends ActionSupport {
    private List<Eleve> eleves;
    Eleve eleve;
    private String cne;
    private List<Eleve> elevesFil = new ArrayList();
    private List<Eleve> elevesNoFil = new ArrayList();
    
    @Autowired
    private IEleveService eleveService;
    
   @Autowired
    private IFiliereService filiereService;
    List<Filiere> filieres = new ArrayList();
    Filiere filiere = new Filiere();
    String code;

    
    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public void setEleveService(IEleveService eleveService) {
        this.eleveService = eleveService;
    }

    public void setFiliereService(IFiliereService filiereService) {
        this.filiereService = filiereService;
    }

    public List<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }
    
    
    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public List<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }
    
    //===========================================
    
    public boolean validation(){
        boolean cneNull, nomNull, moyenneValid, eleveExists;
        
        cneNull = eleve.getCne().length() == 0;
        eleveExists = eleveService.getEleve(eleve.getCne()) != null;
        nomNull = eleve.getNom().length() == 0;
        moyenneValid = eleve.getMoyenne() < 0 || eleve.getMoyenne() > 20;
        
        if (cneNull) {
            addFieldError("eleve.cne", "Le cne de l'eleve est obligatoire!");
        }
        if (eleveExists) {
            addFieldError("eleve.cne", "Un eleve ayant ce cne existe déjà!");
        }
        
        if (nomNull) {
            addFieldError("eleve.nom", "Le nom de l'eleve est obligatoire!");
        }
        
        if (moyenneValid) {
            addFieldError("eleve.moyenne", "Entrer une moyenne comprise entre 0 et 20 !");
        }
                
        return !(cneNull || eleveExists || nomNull || moyenneValid);
    }
    
    public String listEleve() {
        filieres = filiereService.getAll();
        eleves = eleveService.getAll();
        return "success";
    }
    
    public String createEleveLink() {
        filieres = filiereService.getAll();
        return "success";
    }
    
    public String createEleve() {
        if(!validation()){
            filieres = filiereService.getAll();
            return "input";
        }
        eleveService.createEleve(eleve);
        eleves = eleveService.getAll();
        filieres = filiereService.getAll();
        return "success";
    }
    
    public String detailEleve() {
        filieres = filiereService.getAll();
        eleve = eleveService.getEleve(cne);
        return "success";
    }
    
    public String editEleve() {
        filieres = filiereService.getAll();
//        System.out.println("\n\n************************************************\n\n" + cne + "\n\n************************************************\n\n");
        eleve = eleveService.getEleve(cne);
        return "success";
    }

    public String updateEleve() {
        if (eleve.getNom().length() == 0 || eleve.getMoyenne() < 0 || eleve.getMoyenne() > 20) {
            addActionError("Veuillez entrez le nom de l'eleve");
            addActionError("ou");
            addActionError("Entrez une moyenne comprise entre 0 et 20 !");
            filieres = filiereService.getAll();
            return "input";
        }
        eleveService.updateEleve(eleve);
        eleves = eleveService.getAll();
        filieres = filiereService.getAll();
        eleve = new Eleve();
        return "success";
    }

    public String deleteEleve() {
        eleveService.deleteEleve(cne);
        eleves = eleveService.getAll();
        filieres = filiereService.getAll();
        return "success";
    }
    
    public String getElevesByFil(){
        filieres = filiereService.getAll();
        eleves = eleveService.getAll();
        
        System.out.println("\n\n"+ code +" \n\n");
        
        elevesFil = filiereService.getFilEleves(code);
        
        if(!elevesFil.isEmpty())
        {
            for(Eleve e : eleves)
            {
                if(!elevesFil.contains(e)){
                    elevesNoFil.add(e);
                }
            }
        }
        eleves = elevesFil;
        return "success";
    }
    
}
