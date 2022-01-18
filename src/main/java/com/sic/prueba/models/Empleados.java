/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sic.prueba.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ing. Jose Dumar Jimenez Ruiz
 */
@Entity
@Table(name = "empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e")
    , @NamedQuery(name = "Empleados.findById", query = "SELECT e FROM Empleados e WHERE e.id = :id")
    , @NamedQuery(name = "Empleados.findByDocuemento", query = "SELECT e FROM Empleados e WHERE e.docuemento = :docuemento")
    , @NamedQuery(name = "Empleados.findByNombres", query = "SELECT e FROM Empleados e WHERE e.nombres = :nombres")
    , @NamedQuery(name = "Empleados.findByApellidos", query = "SELECT e FROM Empleados e WHERE e.apellidos = :apellidos")
    , @NamedQuery(name = "Empleados.findByEmali", query = "SELECT e FROM Empleados e WHERE e.emali = :emali")
    , @NamedQuery(name = "Empleados.findByFechingr", query = "SELECT e FROM Empleados e WHERE e.fechingr = :fechingr")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "docuemento")
    private String docuemento;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "emali")
    private String emali;
    @Basic(optional = false)
    @Column(name = "fechingr")
    @Temporal(TemporalType.DATE)
    private Date fechingr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoId")
    private Collection<Tramites> tramitesCollection;
    @JoinColumn(name = "tipodocu_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tipodocus tipodocuId;
    @JoinColumn(name = "dependencia_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dependencias dependenciaId;

    public Empleados() {
    }

    public Empleados(Integer id) {
        this.id = id;
    }

    public Empleados(Integer id, String docuemento, String nombres, String apellidos, String emali, Date fechingr) {
        this.id = id;
        this.docuemento = docuemento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.emali = emali;
        this.fechingr = fechingr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocuemento() {
        return docuemento;
    }

    public void setDocuemento(String docuemento) {
        this.docuemento = docuemento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmali() {
        return emali;
    }

    public void setEmali(String emali) {
        this.emali = emali;
    }

    public Date getFechingr() {
        return fechingr;
    }

    public void setFechingr(Date fechingr) {
        this.fechingr = fechingr;
    }

    @XmlTransient
    public Collection<Tramites> getTramitesCollection() {
        return tramitesCollection;
    }

    public void setTramitesCollection(Collection<Tramites> tramitesCollection) {
        this.tramitesCollection = tramitesCollection;
    }

    public Tipodocus getTipodocuId() {
        return tipodocuId;
    }

    public void setTipodocuId(Tipodocus tipodocuId) {
        this.tipodocuId = tipodocuId;
    }

    public Dependencias getDependenciaId() {
        return dependenciaId;
    }

    public void setDependenciaId(Dependencias dependenciaId) {
        this.dependenciaId = dependenciaId;
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
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sic.prueba.models.Empleados[ id=" + id + " ]";
    }
    
}
