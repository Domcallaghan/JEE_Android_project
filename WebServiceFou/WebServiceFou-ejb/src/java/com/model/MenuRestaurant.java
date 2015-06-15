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
@Table(name = "menu_restaurant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuRestaurant.findAll", query = "SELECT m FROM MenuRestaurant m"),
    @NamedQuery(name = "MenuRestaurant.findByIdMenuRestaurant", query = "SELECT m FROM MenuRestaurant m WHERE m.idMenuRestaurant = :idMenuRestaurant"),
    @NamedQuery(name = "MenuRestaurant.findByNomMenu", query = "SELECT m FROM MenuRestaurant m WHERE m.nomMenu = :nomMenu"),
    @NamedQuery(name = "MenuRestaurant.findByTarifMenu", query = "SELECT m FROM MenuRestaurant m WHERE m.tarifMenu = :tarifMenu"),
    @NamedQuery(name = "MenuRestaurant.findByD\u00e9tailsMenu", query = "SELECT m FROM MenuRestaurant m WHERE m.d\u00e9tailsMenu = :d\u00e9tailsMenu"),
    @NamedQuery(name = "MenuRestaurant.findByRefIdRestaurant", query = "SELECT m FROM MenuRestaurant m WHERE m.refIdRestaurant = :refIdRestaurant")})
public class MenuRestaurant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_menu_restaurant")
    private Integer idMenuRestaurant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_menu")
    private String nomMenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarif_menu")
    private float tarifMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "d\u00e9tails_menu")
    private String détailsMenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ref_id_restaurant")
    private int refIdRestaurant;

    public MenuRestaurant() {
    }

    public MenuRestaurant(Integer idMenuRestaurant) {
        this.idMenuRestaurant = idMenuRestaurant;
    }

    public MenuRestaurant(Integer idMenuRestaurant, String nomMenu, float tarifMenu, String détailsMenu, int refIdRestaurant) {
        this.idMenuRestaurant = idMenuRestaurant;
        this.nomMenu = nomMenu;
        this.tarifMenu = tarifMenu;
        this.détailsMenu = détailsMenu;
        this.refIdRestaurant = refIdRestaurant;
    }

    public Integer getIdMenuRestaurant() {
        return idMenuRestaurant;
    }

    public void setIdMenuRestaurant(Integer idMenuRestaurant) {
        this.idMenuRestaurant = idMenuRestaurant;
    }

    public String getNomMenu() {
        return nomMenu;
    }

    public void setNomMenu(String nomMenu) {
        this.nomMenu = nomMenu;
    }

    public float getTarifMenu() {
        return tarifMenu;
    }

    public void setTarifMenu(float tarifMenu) {
        this.tarifMenu = tarifMenu;
    }

    public String getDétailsMenu() {
        return détailsMenu;
    }

    public void setDétailsMenu(String détailsMenu) {
        this.détailsMenu = détailsMenu;
    }

    public int getRefIdRestaurant() {
        return refIdRestaurant;
    }

    public void setRefIdRestaurant(int refIdRestaurant) {
        this.refIdRestaurant = refIdRestaurant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenuRestaurant != null ? idMenuRestaurant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuRestaurant)) {
            return false;
        }
        MenuRestaurant other = (MenuRestaurant) object;
        if ((this.idMenuRestaurant == null && other.idMenuRestaurant != null) || (this.idMenuRestaurant != null && !this.idMenuRestaurant.equals(other.idMenuRestaurant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.MenuRestaurant[ idMenuRestaurant=" + idMenuRestaurant + " ]";
    }
    
}
