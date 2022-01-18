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
@Table(name = "dependencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dependencias.findAll", query = "SELECT d FROM Dependencias d")
    , @NamedQuery(name = "Dependencias.findById", query = "SELECT d FROM Dependencias d WHERE d.id = :id")
    , @NamedQuery(name = "Dependencias.findByNombre", query = "SELECT d FROM Dependencias d WHERE d.nombre = :nombre")})
public class Dependencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dependenciaId")
    private Collection<Empleados> empleadosCollection;

    public Dependencias() {
    }

    public Dependencias(Integer id) {
        this.id = id;
    }

    public Dependencias(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Empleados> getEmpleadosCollection() {
        return empleadosCollection;
    }

    public void setEmpleadosCollection(Collection<Empleados> empleadosCollection) {
        this.empleadosCollection = empleadosCollection;
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
        if (!(object instanceof Dependencias)) {
            return false;
        }
        Dependencias other = (Dependencias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sic.prueba.models.Dependencias[ id=" + id + " ]";
    }
    
}
