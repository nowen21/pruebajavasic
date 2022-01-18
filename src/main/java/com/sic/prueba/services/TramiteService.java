/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sic.prueba.services;

import com.sic.prueba.models.Tramites;
import com.sic.prueba.respositories.TramiteRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ing. Jose Dumar Jimenez Ruiz
 */
@Service
public class TramiteService {
    @Autowired
    TramiteRepository tramiter;
    public List<Tramites> getAllTramites(){
       List<Tramites> tramite= tramiter.findAll() ;
        if( tramite==null){
             tramite=new ArrayList<>();
        }
        return tramite;
    }
    
    public Tramites getTramitesById(int id){
      return tramiter.findById(id);  
    }
    
    
}
