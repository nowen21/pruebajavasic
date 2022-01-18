/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sic.prueba.controllers;

import com.sic.prueba.models.Tramites;
import com.sic.prueba.services.TramiteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ing. Jose Dumar Jimenez Ruiz
 */
@RestController
public class TramitesRestController {

    @Autowired
    private TramiteService tramites;

     @GetMapping("/tramitelist")
    public List<Tramites> getAllTramites() { 
         System.out.println("contar1 ");
         List<Tramites> tramite= tramites.getAllTramites() ;
         System.out.println("contar2 ");
        return tramite;
    }

    @RequestMapping(value = "/tramitelist/{id}", method = RequestMethod.GET)
    public Tramites getTramitesById(@PathVariable("id") int id) {
        return tramites.getTramitesById(id);
    }
}
