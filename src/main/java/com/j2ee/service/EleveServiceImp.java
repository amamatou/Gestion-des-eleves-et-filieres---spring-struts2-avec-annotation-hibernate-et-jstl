/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.j2ee.service;

import com.j2ee.model.Eleve;
import com.j2ee.repository.IEleveDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EleveServiceImp implements IEleveService{
    
    @Autowired
    IEleveDao dao;

    @Override
    public List<Eleve> getAll() {
        return dao.getAll();
    }

    @Override
    public Eleve getEleve(String cne) {
        return dao.getEleve(cne);
    }

    @Override
    public void createEleve(Eleve eleve) {
        dao.createEleve(eleve);
    }

    @Override
    public void updateEleve(Eleve eleve) {
        dao.updateEleve(eleve);
    }

    @Override
    public void deleteEleve(String cne) {
        dao.deleteEleve(cne);
    }
    
    
}
