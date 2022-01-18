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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "personas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personas.findAll", query = "SELECT p FROM Personas p")
    , @NamedQuery(name = "Personas.findById", query = "SELECT p FROM Personas p WHERE p.id = :id")
    , @NamedQuery(name = "Personas.findByDocument", query = "SELECT p FROM Personas p WHERE p.document = :document")
    , @NamedQuery(name = "Personas.findByNombres", query = "SELECT p FROM Personas p WHERE p.nombres = :nombres")
    , @NamedQuery(name = "Personas.findByApellidos", query = "SELECT p FROM Personas p WHERE p.apellidos = :apellidos")
    , @NamedQuery(name = "Personas.findByTelefono", query = "SELECT p FROM Personas p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Personas.findByDicreccion", query = "SELECT p FROM Personas p WHERE p.dicreccion = :dicreccion")
    , @NamedQuery(name = "Personas.findByEmail", query = "SELECT p FROM Personas p WHERE p.email = :email")})
public class Personas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "document")
    private int document;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @Column(name = "dicreccion")
    private String dicreccion;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaId")
    private Collection<Tramites> tramitesCollection;
    @JoinColumn(name = "tipodocu_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tipodocus tipodocuId;

    public Personas() {
    }

    public Personas(Integer id) {
        this.id = id;
    }

    public Personas(Integer id, int document, String nombres, String apellidos, int telefono, String dicreccion, String email) {
        this.id = id;
        this.document = document;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.dicreccion = dicreccion;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDicreccion() {
        return dicreccion;
    }

    public void setDicreccion(String dicreccion) {
        this.dicreccion = dicreccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personas)) {
            return false;
        }
        Personas other = (Personas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sic.prueba.models.Personas[ id=" + id + " ]";
    }
    
}
