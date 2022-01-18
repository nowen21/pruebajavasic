/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sic.prueba.respositories;

import com.sic.prueba.models.Tramites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ing. Jose Dumar Jimenez Ruiz
 */
@Repository
public interface TramiteRepository extends JpaRepository<Tramites, Integer>{
    public Tramites findById(int id);
}
