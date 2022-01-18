/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sic.prueba.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ing. Jose Dumar Jimenez Ruiz
 */
@Entity
@Table(name = "tipodocus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodocus.findAll", query = "SELECT t FROM Tipodocus t")
    , @NamedQuery(name = "Tipodocus.findById", query = "SELECT t FROM Tipodocus t WHERE t.id = :id")
    , @NamedQuery(name = "Tipodocus.findByTipo", query = "SELECT t FROM Tipodocus t WHERE t.tipo = :tipo")})
public class Tipodocus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipodocuId")
    private Collection<Empleados> empleadosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipodocuId")
    private Collection<Personas> personasCollection;

    public Tipodocus() {
    }

    public Tipodocus(Integer id) {
        this.id = id;
    }

    public Tipodocus(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Empleados> getEmpleadosCollection() {
        return empleadosCollection;
    }

    public void setEmpleadosCollection(Collection<Empleados> empleadosCollection) {
        this.empleadosCollection = empleadosCollection;
    }

    @XmlTransient
    public Collection<Personas> getPersonasCollection() {
        return personasCollection;
    }

    public void setPersonasCollection(Collection<Personas> personasCollection) {
        this.personasCollection = personasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodocus)) {
            return false;
        }
        Tipodocus other = (Tipodocus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sic.prueba.models.Tipodocus[ id=" + id + " ]";
    }
    
}
