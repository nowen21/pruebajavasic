/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sic.prueba.controllers;

import com.sic.prueba.models.Tramites;
import com.sic.prueba.respositories.TramiteRepository;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ing. Jose Dumar Jimenez Ruiz
 */
@Controller
public class TramiteController implements Serializable {

    @Autowired
    private TramiteRepository tramiter;

    @GetMapping({"/tramites"})
    public ModelAndView getAllTramites() {
        ModelAndView mav = new ModelAndView("tramite");
        mav.addObject("tramites", tramiter.findAll());
        return mav;
    }

    @GetMapping("/nuevotra")
    public ModelAndView nuevotra() {
        ModelAndView mav = new ModelAndView("nuevotra");
        Tramites tramite = new Tramites();
        mav.addObject("tramite", tramite);
        return mav;
    }

    @PostMapping("/saveTramite")
    public String saveEmployee(@ModelAttribute Tramites tramite) {
        tramiter.save(tramite);
        return "redirect:/tramites";
    }

}
