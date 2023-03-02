/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.j2ee.test;

import com.j2ee.model.Eleve;
import com.j2ee.model.Filiere;
import com.j2ee.repository.EleveDaoImp;
import com.j2ee.repository.FiliereDaoImp;
import com.j2ee.repository.IEleveDao;
import com.j2ee.repository.IFiliereDao;
import com.j2ee.service.FiliereServiceImp;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author asus
 */
public class Essai {
     public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
                                            context.load("file:src/main/webapp/WEB-INF/applicationContext.xml");
                                            context.refresh();

       FiliereDaoImp filiereDao = new FiliereDaoImp();
       EleveDaoImp eleveDao = new EleveDaoImp();

       FiliereServiceImp filiereService = new FiliereServiceImp();
//**************Filiere DaoImp test**************************\\        
//        Filiere fil = new Filiere();
//        fil.setCode_Fil("GINF");
//        fil.setNom_Fil("Genie info");
//        
//        filiereDao.createFiliere(fil);
//        listerFiliere(filiereDao);
        
        
//        Filiere fil = filiereDao.getFiliere("GINF");
//         
//        fil.setNom_Fil("Genie informatique");
//        filiereDao.updateFiliere(fil);
//        listerFiliere(filiereDao);
        
//        filiereDao.deleteFiliere("GINF");
//        listerFiliere(filiereDao);


//       Filiere fil2 = filiereDao.getFiliere("GINF");
//          
//         System.out.println("Nombre d'eleves de la filiere " + fil2.getCode_Fil() + ": " + filiereDao.getFilEleves(fil2.getCode_Fil()));
            

//**************EleveDaoImp test**************************\\
//
//        Eleve e = new Eleve();
//        e.setCne("cne1");
//        e.setNom("Ali");
//        e.setPrenom("Rachid");
//        e.setMoyenne(17);
//        e.setRef_Fil(fil2);
//        
//        eleveDao.createEleve(e);
//        listerEleve(eleveDao);
//        
//        System.out.println("\nNombre d'eleves de la filiere " + fil2.getCode_Fil() + ": " + filiereDao.getFilEleves(fil2.getCode_Fil()).size()+"\n");
//         
//        Eleve e = eleveDao.getEleve("cne1");
//        
//        e.setNom("Mairou Ali");
//        eleveDao.updateEleve(e);
//        listerEleve(eleveDao);
//        
//        eleveDao.deleteEleve("cne1");
//        listerEleve(eleveDao);
        
        List<Filiere> filieres = new ArrayList();
        List<Integer> nbEleveParFiliere = new ArrayList();
        
        filieres = filiereDao.getAll();
        for(Filiere f : filieres){
            nbEleveParFiliere.add(filiereDao.getFilEleves(f.getCode_Fil()).size());
        }
        
        for(int i : nbEleveParFiliere){
            System.out.println(i);
        }
    }
     
     public static void listerFiliere(IFiliereDao filiereDao){
         List<Filiere> listFil = filiereDao.getAll();
         System.out.println("*********************LISTE DES FILIERES***************************");
        for(Filiere f : listFil){
            System.out.println("\nFiliere : " + f);
        }
        System.out.println("*********************FIN LISTE DES FILIERES***************************");
     }
     
     public static void listerEleve(IEleveDao eleveDao){
        List<Eleve> listEleve = eleveDao.getAll();
        System.out.println("*********************LISTE DES ELEVES***************************");
        for(Eleve el : listEleve){
            System.out.println("Eleve : " + el);
        }
        System.out.println("*********************FIN LISTE DES ELEVES***************************");
     }
}

