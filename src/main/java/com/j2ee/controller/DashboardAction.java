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


public class DashboardAction extends ActionSupport{
    
    List<Filiere> filieres = new ArrayList();
    List<Eleve> eleves = new ArrayList();
    int nbTotalEleves, nbTotalFilieres;
    Map<String,Integer> nbEleveParFiliere = new HashMap<String,Integer>();
     
    @Autowired 
    private IFiliereService filiereService;
    
    @Autowired 
    private IEleveService eleveService;

    public List<Filiere> getFilieres() {
        return filieres;
    }

    public List<Eleve> getEleves() {
        return eleves;
    }

    public void setFiliereService(IFiliereService filiereService) {
        this.filiereService = filiereService;
    }

    public int getNbTotalEleves() {
        return nbTotalEleves;
    }

    public int getNbTotalFilieres() {
        return nbTotalFilieres;
    }

    public Map<String,Integer> getNbEleveParFiliere() {
        return nbEleveParFiliere;
    }
    

    @Override
    public String execute() {
        filieres = filiereService.getAll();
        eleves = eleveService.getAll();
        
        nbTotalFilieres = filieres.size();
        nbTotalEleves = eleves.size();
        
        for(Filiere f : filieres){
            int nbEleveFil = 0;
            for(Eleve e : eleves){
                if(e.getRef_Fil().getCode_Fil().equals(f.getCode_Fil())){
                    nbEleveFil ++;
                }
            }
            nbEleveParFiliere.put(f.getNom_Fil(),nbEleveFil);
        }
        return SUCCESS;
    }

}
