/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.j2ee.service;

import com.j2ee.model.Eleve;
import com.j2ee.model.Filiere;
import com.j2ee.repository.FiliereDaoImp;
import com.j2ee.repository.IFiliereDao;
import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FiliereServiceImp implements IFiliereService{
    
    @Autowired
    IFiliereDao dao;

    public void setDao(FiliereDaoImp dao) {
        this.dao = dao;
    }

    @Override
    public List<Filiere> getAll() {
        return dao.getAll();
    }

    @Override
    public Filiere getFiliere(String code) {
        return dao.getFiliere(code);
    }

    @Override
    public void createFiliere(Filiere filiere) {
        dao.createFiliere(filiere);
    }

    @Override
    public void updateFiliere(Filiere filiere) {
        dao.updateFiliere(filiere);
    }

    @Override
    public void deleteFiliere(String code) {
        dao.deleteFiliere(code);
    }
    
    @Override
    public List<Eleve> getFilEleves(String code){
       return dao.getFilEleves(code);
    }
    
    
}
