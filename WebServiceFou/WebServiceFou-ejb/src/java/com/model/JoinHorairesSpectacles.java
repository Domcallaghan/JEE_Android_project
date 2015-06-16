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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ugo
 */
@Entity
@Table(name = "join_horaires_spectacles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JoinHorairesSpectacles.findAll", query = "SELECT j FROM JoinHorairesSpectacles j"),
    @NamedQuery(name = "JoinHorairesSpectacles.findByIdJointure", query = "SELECT j FROM JoinHorairesSpectacles j WHERE j.idJointure = :idJointure"),
    @NamedQuery(name = "JoinHorairesSpectacles.findByRefIdSpectacle", query = "SELECT j FROM JoinHorairesSpectacles j WHERE j.refIdSpectacle = :refIdSpectacle"),
    @NamedQuery(name = "JoinHorairesSpectacles.findByRefIdHoraire", query = "SELECT j FROM JoinHorairesSpectacles j WHERE j.refIdHoraire = :refIdHoraire"),
    @NamedQuery(name = "JoinHorairesSpectacles.findByMois", query = "SELECT j FROM JoinHorairesSpectacles j WHERE j.mois = :mois")})
public class JoinHorairesSpectacles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jointure")
    private Integer idJointure;

    @Column(name = "ref_id_spectacle")
    private int refIdSpectacle;

    @Column(name = "ref_id_horaire")
    private int refIdHoraire;
    @Column(name = "mois")
    private Integer mois;

    public JoinHorairesSpectacles() {
    }

    public JoinHorairesSpectacles(Integer idJointure) {
        this.idJointure = idJointure;
    }

    public JoinHorairesSpectacles(Integer idJointure, int refIdSpectacle, int refIdHoraire) {
        this.idJointure = idJointure;
        this.refIdSpectacle = refIdSpectacle;
        this.refIdHoraire = refIdHoraire;
    }

    public Integer getIdJointure() {
        return idJointure;
    }

    public void setIdJointure(Integer idJointure) {
        this.idJointure = idJointure;
    }

    public int getRefIdSpectacle() {
        return refIdSpectacle;
    }

    public void setRefIdSpectacle(int refIdSpectacle) {
        this.refIdSpectacle = refIdSpectacle;
    }

    public int getRefIdHoraire() {
        return refIdHoraire;
    }

    public void setRefIdHoraire(int refIdHoraire) {
        this.refIdHoraire = refIdHoraire;
    }

    public Integer getMois() {
        return mois;
    }

    public void setMois(Integer mois) {
        this.mois = mois;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJointure != null ? idJointure.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JoinHorairesSpectacles)) {
            return false;
        }
        JoinHorairesSpectacles other = (JoinHorairesSpectacles) object;
        if ((this.idJointure == null && other.idJointure != null) || (this.idJointure != null && !this.idJointure.equals(other.idJointure))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.JoinHorairesSpectacles[ idJointure=" + idJointure + " ]";
    }
    
}
