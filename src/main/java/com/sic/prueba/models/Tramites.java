/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sic.prueba.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ing. Jose Dumar Jimenez Ruiz
 */
@Entity
@Table(name = "tramites")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tramites.findAll", query = "SELECT t FROM Tramites t")
    , @NamedQuery(name = "Tramites.findById", query = "SELECT t FROM Tramites t WHERE t.id = :id")
    , @NamedQuery(name = "Tramites.findByNumecons", query = "SELECT t FROM Tramites t WHERE t.numecons = :numecons")
    , @NamedQuery(name = "Tramites.findByFechredi", query = "SELECT t FROM Tramites t WHERE t.fechredi = :fechredi")
    , @NamedQuery(name = "Tramites.findByNombtram", query = "SELECT t FROM Tramites t WHERE t.nombtram = :nombtram")
    , @NamedQuery(name = "Tramites.findByDescripc", query = "SELECT t FROM Tramites t WHERE t.descripc = :descripc")})
public class Tramites implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "numecons")
    private int numecons;
    @Basic(optional = false)
    @Column(name = "fechredi")
    @Temporal(TemporalType.DATE)
    private Date fechredi;
    @Basic(optional = false)
    @Column(name = "nombtram")
    private String nombtram;
    @Basic(optional = false)
    @Column(name = "descripc")
    private String descripc;
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personas personaId;
    @JoinColumn(name = "empleado_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleados empleadoId;

    public Tramites() {
    }

    public Tramites(Integer id) {
        this.id = id;
    }

    public Tramites(Integer id, int numecons, Date fechredi, String nombtram, String descripc) {
        this.id = id;
        this.numecons = numecons;
        this.fechredi = fechredi;
        this.nombtram = nombtram;
        this.descripc = descripc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumecons() {
        return numecons;
    }

    public void setNumecons(int numecons) {
        this.numecons = numecons;
    }

    public Date getFechredi() {
        return fechredi;
    }

    public void setFechredi(Date fechredi) {
        this.fechredi = fechredi;
    }

    public String getNombtram() {
        return nombtram;
    }

    public void setNombtram(String nombtram) {
        this.nombtram = nombtram;
    }

    public String getDescripc() {
        return descripc;
    }

    public void setDescripc(String descripc) {
        this.descripc = descripc;
    }

    public Personas getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Personas personaId) {
        this.personaId = personaId;
    }

    public Empleados getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Empleados empleadoId) {
        this.empleadoId = empleadoId;
    }

    @Override
    public String toString() {
        return "com.sic.prueba.models.Tramites[ id=" + id + " ]";
    }

}
