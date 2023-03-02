/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.j2ee.repository;

import com.j2ee.model.Eleve;
import com.j2ee.model.Filiere;
import java.util.*;

/**
 *
 * @author asus
 */
public interface IFiliereDao {
    public List<Filiere> getAll();
    public Filiere getFiliere(String code);
    public void createFiliere(Filiere filiere);
    public void updateFiliere(Filiere filiere);
    public void deleteFiliere(String code);
    public List<Eleve> getFilEleves(String code);
}
