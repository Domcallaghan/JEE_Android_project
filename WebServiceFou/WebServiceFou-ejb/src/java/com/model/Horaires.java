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
@Table(name = "horaires")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horaires.findAll", query = "SELECT h FROM Horaires h"),
    @NamedQuery(name = "Horaires.findByIdHoraires", query = "SELECT h FROM Horaires h WHERE h.idHoraires = :idHoraires"),
    @NamedQuery(name = "Horaires.findByHoraires", query = "SELECT h FROM Horaires h WHERE h.horaires = :horaires")})
public class Horaires implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horaires")
    private Integer idHoraires;

    @Size(min = 1, max = 50)
    @Column(name = "horaires")
    private String horaires;

    public Horaires() {
    }

    public Horaires(Integer idHoraires) {
        this.idHoraires = idHoraires;
    }

    public Horaires(Integer idHoraires, String horaires) {
        this.idHoraires = idHoraires;
        this.horaires = horaires;
    }

    public Integer getIdHoraires() {
        return idHoraires;
    }

    public void setIdHoraires(Integer idHoraires) {
        this.idHoraires = idHoraires;
    }

    public String getHoraires() {
        return horaires;
    }

    public void setHoraires(String horaires) {
        this.horaires = horaires;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHoraires != null ? idHoraires.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horaires)) {
            return false;
        }
        Horaires other = (Horaires) object;
        if ((this.idHoraires == null && other.idHoraires != null) || (this.idHoraires != null && !this.idHoraires.equals(other.idHoraires))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Horaires[ idHoraires=" + idHoraires + " ]";
    }
    
}
