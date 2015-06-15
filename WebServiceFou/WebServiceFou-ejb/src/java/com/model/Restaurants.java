/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ugo
 */
@Entity
@Table(name = "restaurants")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restaurants.findAll", query = "SELECT r FROM Restaurants r"),
    @NamedQuery(name = "Restaurants.findByIdRestaurant", query = "SELECT r FROM Restaurants r WHERE r.idRestaurant = :idRestaurant"),
    @NamedQuery(name = "Restaurants.findByNomRestaurant", query = "SELECT r FROM Restaurants r WHERE r.nomRestaurant = :nomRestaurant"),
    @NamedQuery(name = "Restaurants.findByLocalisationRestaurant", query = "SELECT r FROM Restaurants r WHERE r.localisationRestaurant = :localisationRestaurant"),
    @NamedQuery(name = "Restaurants.findByNoteRestaurant", query = "SELECT r FROM Restaurants r WHERE r.noteRestaurant = :noteRestaurant")})
public class Restaurants implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_restaurant")
    private Integer idRestaurant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_restaurant")
    private String nomRestaurant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "localisation_restaurant")
    private String localisationRestaurant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "note_restaurant")
    private int noteRestaurant;

    public Restaurants() {
    }

    public Restaurants(Integer idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public Restaurants(Integer idRestaurant, String nomRestaurant, String localisationRestaurant, int noteRestaurant) {
        this.idRestaurant = idRestaurant;
        this.nomRestaurant = nomRestaurant;
        this.localisationRestaurant = localisationRestaurant;
        this.noteRestaurant = noteRestaurant;
    }

    public Integer getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Integer idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getNomRestaurant() {
        return nomRestaurant;
    }

    public void setNomRestaurant(String nomRestaurant) {
        this.nomRestaurant = nomRestaurant;
    }

    public String getLocalisationRestaurant() {
        return localisationRestaurant;
    }

    public void setLocalisationRestaurant(String localisationRestaurant) {
        this.localisationRestaurant = localisationRestaurant;
    }

    public int getNoteRestaurant() {
        return noteRestaurant;
    }

    public void setNoteRestaurant(int noteRestaurant) {
        this.noteRestaurant = noteRestaurant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRestaurant != null ? idRestaurant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurants)) {
            return false;
        }
        Restaurants other = (Restaurants) object;
        if ((this.idRestaurant == null && other.idRestaurant != null) || (this.idRestaurant != null && !this.idRestaurant.equals(other.idRestaurant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Restaurants[ idRestaurant=" + idRestaurant + " ]";
    }
    
}
