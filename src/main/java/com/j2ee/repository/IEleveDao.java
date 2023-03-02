/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.j2ee.repository;

import com.j2ee.model.Eleve;
import java.util.List;

/**
 *
 * @author asus
 */
public interface IEleveDao {
    public List<Eleve> getAll();
    public Eleve getEleve(String cne);
    public void createEleve(Eleve eleve);
    public void updateEleve(Eleve eleve);
    public void deleteEleve(String cne);
}
