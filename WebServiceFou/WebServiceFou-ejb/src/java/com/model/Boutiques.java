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
@Table(name = "boutiques")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boutiques.findAll", query = "SELECT b FROM Boutiques b"),
    @NamedQuery(name = "Boutiques.findByIdBoutique", query = "SELECT b FROM Boutiques b WHERE b.idBoutique = :idBoutique"),
    @NamedQuery(name = "Boutiques.findByNomBoutique", query = "SELECT b FROM Boutiques b WHERE b.nomBoutique = :nomBoutique"),
    @NamedQuery(name = "Boutiques.findByNoteBoutique", query = "SELECT b FROM Boutiques b WHERE b.noteBoutique = :noteBoutique"),
    @NamedQuery(name = "Boutiques.findByLocalisationBoutique", query = "SELECT b FROM Boutiques b WHERE b.localisationBoutique = :localisationBoutique")})
public class Boutiques implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boutique")
    private Integer idBoutique;
    
    @Column(name = "nom_boutique")
    private String nomBoutique;
    
    @Column(name = "note_boutique")
    private float noteBoutique;
    
    @Column(name = "nb_notes")
    private int nbNotes;
    
    @Size(min = 1, max = 50)
    @Column(name = "localisation_boutique")
    private String localisationBoutique;

    public Boutiques() {
    }

    public Boutiques(Integer idBoutique) {
        this.idBoutique = idBoutique;
    }

    public Boutiques(Integer idBoutique, String nomBoutique, int noteBoutique, String localisationBoutique) {
        this.idBoutique = idBoutique;
        this.nomBoutique = nomBoutique;
        this.noteBoutique = noteBoutique;
        this.localisationBoutique = localisationBoutique;
    }

    public Integer getIdBoutique() {
        return idBoutique;
    }

    public void setIdBoutique(Integer idBoutique) {
        this.idBoutique = idBoutique;
    }

    public String getNomBoutique() {
        return nomBoutique;
    }

    public void setNomBoutique(String nomBoutique) {
        this.nomBoutique = nomBoutique;
    }

    public float getNoteBoutique() {
        return noteBoutique;
    }

    public void setNoteBoutique(int noteBoutique) {
        this.noteBoutique = noteBoutique;
    }

    public String getLocalisationBoutique() {
        return localisationBoutique;
    }

    public void setLocalisationBoutique(String localisationBoutique) {
        this.localisationBoutique = localisationBoutique;
    }
    
    public void noter(float note){
        float oldNote = this.noteBoutique * this.nbNotes;
        this.nbNotes++;
        this.noteBoutique = (oldNote + note) / this.nbNotes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBoutique != null ? idBoutique.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boutiques)) {
            return false;
        }
        Boutiques other = (Boutiques) object;
        if ((this.idBoutique == null && other.idBoutique != null) || (this.idBoutique != null && !this.idBoutique.equals(other.idBoutique))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Boutiques[ idBoutique=" + idBoutique + " ]";
    }
    
}
