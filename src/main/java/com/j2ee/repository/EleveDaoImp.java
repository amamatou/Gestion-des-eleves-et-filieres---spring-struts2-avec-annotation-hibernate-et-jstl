/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.j2ee.repository;

/**
 *
 * @author asus
 */
import com.j2ee.model.Eleve;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class EleveDaoImp implements IEleveDao {    

    static Session session;
    static Transaction transaction;
    private static final Logger logger = LoggerFactory.getLogger(EleveDaoImp.class);
    
    @Override
    public List<Eleve> getAll() {
        List<Eleve> eleves = new ArrayList<Eleve>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            eleves = session.createQuery("FROM Eleve").list();
        } 
        catch (HibernateException e) {
            logger.error("Erreur lors du chargement des eleves: " + e.getMessage());
            return null;
        }
        finally{
            session.close();
        }
        return eleves;
    }

    @Override
    public Eleve getEleve(String cne) {
        Eleve eleve;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            eleve = (Eleve) session.get(Eleve.class, cne);
       } 
       catch (HibernateException e) {
            logger.error("\n\nEleve de cne " + cne + " non trouvée\n" + e.getMessage());
            return null;
       }
        
       return eleve;
    }

    @Override
    public void createEleve(Eleve eleve) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction= session.beginTransaction();
            session.save(eleve);
            transaction.commit();
            logger.info("\n\nEleve ajoutée avec succes\n\n");
        }
        catch(HibernateException e){
            logger.error("Erreur lors de la creation de eleve: " + e.getMessage());
        }
        finally{
            session.close();
        }
    }

    @Override
    public void updateEleve(Eleve eleve) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction= session.beginTransaction();
            Eleve e = session.load(Eleve.class, eleve.getCne());
            e.setNom(eleve.getNom());
            e.setPrenom(eleve.getPrenom());
            e.setMoyenne(eleve.getMoyenne());
            e.setRef_Fil(eleve.getRef_Fil());
            session.update(e);
            transaction.commit();
            logger.info("Eleve modifié avec succes\n\n");
        }
        catch(HibernateException e){
            logger.error("\n\nErreur lors de la modification de l'eleve: " + e.getMessage() + "\n\n");
        }
        finally{
            session.close();
        }
    }

    @Override
    public void deleteEleve(String cne) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction= session.beginTransaction();
            Eleve eleve = session.get(Eleve.class,cne);
            session.delete(eleve);
            transaction.commit();
            logger.info("\n\nEleve supprimé avec succes\n\n");
        }
        catch(HibernateException e){
            logger.error("Erreur lors de la suppression de filiere"+ cne +": " + e.getMessage());
        }
        finally{
            session.close();
        }
    }
}
