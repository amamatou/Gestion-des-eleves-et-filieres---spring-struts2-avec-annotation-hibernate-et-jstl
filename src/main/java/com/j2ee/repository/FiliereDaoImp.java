/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.j2ee.repository;

import com.j2ee.model.Eleve;
import com.j2ee.model.Filiere;
import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FiliereDaoImp implements IFiliereDao{
    
    static Session session;
    static Transaction transaction;
    private static final Logger logger = LoggerFactory.getLogger(FiliereDaoImp.class);
    
    @Override
    public List<Filiere> getAll() {
        List<Filiere> filieres = new ArrayList<Filiere>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            filieres = session.createQuery("FROM Filiere").list();
        } 
        catch (HibernateException e) {
            logger.error("Erreur lors du chargement des filieres: " + e.getMessage());
            return null;
        }
        finally{
            session.close();
        }
        return filieres;
    }

    @Override
    public Filiere getFiliere(String code) {
        Filiere filiere;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
           filiere = (Filiere) session.get(Filiere.class, code);
       } 
       catch (HibernateException e) {
            logger.error("\n\nFiliere de code " + code + " non trouvée\n" + e.getMessage());
            return null;
       }
       
       return filiere;
    }

    @Override
    public void createFiliere(Filiere filiere) {
       try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction= session.beginTransaction();
            session.save(filiere);
            transaction.commit();
            logger.info("\n\nFiliere ajoutée avec succes\n\n");
        }
        catch(HibernateException e){
            logger.error("Erreur lors de la creation de filiere: " + e.getMessage(), e);
        }
        finally{
            session.close();
        }
    }

    @Override
    public void updateFiliere(Filiere filiere) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction= session.beginTransaction();
            Filiere f = session.load(Filiere.class, filiere.getCode_Fil());
            f.setNom_Fil(filiere.getNom_Fil());
            session.update(f);
            transaction.commit();
            logger.info("\n\nFiliere modifiée avec succes\n\n");
        }
        catch(HibernateException e){
            logger.error("Erreur lors de la modification de filiere: " + e.getMessage());
        }
        finally{
            session.close();
        }
    }
    

    @Override
    public void deleteFiliere(String code) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction= session.beginTransaction();
            Filiere filiere = session.get(Filiere.class, code);
            System.out.println("\n\n "+filiere.getCode_Fil()+" \n\n");
            session.delete(filiere);
            transaction.commit();
            logger.info("\n\nFiliere supprimée avec succes\n\n");
        }
       catch(HibernateException e){
            logger.error("Erreur lors de la suppression de filiere"+ code +": " + e.getMessage());
        }
        finally{
            session.close();
        }
    }
    
    @Override
    public List<Eleve> getFilEleves(String code){
        List<Eleve> elevesFil = new ArrayList();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            elevesFil = session.createQuery("FROM Eleve e where e.ref_Fil.Code_Fil='"+ code +"'").list();
       } 
       catch (HibernateException e) {
            logger.error(e.getMessage());
            return null;
       }
        finally{
            session.close();
        }
       
       return elevesFil;
    }
    
}
