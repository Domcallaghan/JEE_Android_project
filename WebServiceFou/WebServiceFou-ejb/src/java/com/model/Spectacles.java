/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.facade.DAL_spectacles;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
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
@Table(name = "spectacles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spectacles.findAll", query = "SELECT s FROM Spectacles s"),
    @NamedQuery(name = "Spectacles.findByIdSpectacle", query = "SELECT s FROM Spectacles s WHERE s.idSpectacle = :idSpectacle"),
    @NamedQuery(name = "Spectacles.findByNomSpectacle", query = "SELECT s FROM Spectacles s WHERE s.nomSpectacle = :nomSpectacle"),
    @NamedQuery(name = "Spectacles.findByDureeSpectacle", query = "SELECT s FROM Spectacles s WHERE s.dureeSpectacle = :dureeSpectacle"),
    @NamedQuery(name = "Spectacles.findByNombreActeurs", query = "SELECT s FROM Spectacles s WHERE s.nombreActeurs = :nombreActeurs"),
    @NamedQuery(name = "Spectacles.findByEvenementHistoriqueSpectacle", query = "SELECT s FROM Spectacles s WHERE s.evenementHistoriqueSpectacle = :evenementHistoriqueSpectacle"),
    @NamedQuery(name = "Spectacles.findByNoteSpectacle", query = "SELECT s FROM Spectacles s WHERE s.noteSpectacle = :noteSpectacle"),
    @NamedQuery(name = "Spectacles.findByLocalisation", query = "SELECT s FROM Spectacles s WHERE s.localisation = :localisation"),
    @NamedQuery(name = "Spectacles.findByCommentairesSpectacles", query = "SELECT s FROM Spectacles s WHERE s.commentairesSpectacles = :commentairesSpectacles")})
public class Spectacles implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_spectacle")
    private Integer idSpectacle;
    
    @Column(name = "nom_spectacle")
    private String nomSpectacle;

    @Column(name = "duree_spectacle")
    private float dureeSpectacle;

    @Column(name = "nombre_acteurs")
    private int nombreActeurs;
    
    @Column(name = "evenement_historique_spectacle")
    private String evenementHistoriqueSpectacle;
    
    @Column(name = "note_spectacle")
    private float noteSpectacle;
    
    @Column(name = "localisation")
    private String localisation;
    
    @Column(name = "commentaires_spectacles")
    private String commentairesSpectacles;
    
    @Column(name = "nb_notes")
    private int nbNotes;
    
    public Spectacles() {
    }

    public Spectacles(Integer idSpectacle) {
        this.idSpectacle = idSpectacle;
    }

    public Spectacles(Integer idSpectacle, String nomSpectacle, float dureeSpectacle, int nombreActeurs, String evenementHistoriqueSpectacle, float noteSpectacle, String localisation, String commentairesSpectacles) {
        this.idSpectacle = idSpectacle;
        this.nomSpectacle = nomSpectacle;
        this.dureeSpectacle = dureeSpectacle;
        this.nombreActeurs = nombreActeurs;
        this.evenementHistoriqueSpectacle = evenementHistoriqueSpectacle;
        this.noteSpectacle = noteSpectacle;
        this.localisation = localisation;
        this.commentairesSpectacles = commentairesSpectacles;
    }
    
    public Spectacles(String nomSpectacle, float dureeSpectacle, int nombreActeurs, String evenementHistoriqueSpectacle, float noteSpectacle, String localisation, String commentairesSpectacles) {
        this.nomSpectacle = nomSpectacle;
        this.dureeSpectacle = dureeSpectacle;
        this.nombreActeurs = nombreActeurs;
        this.evenementHistoriqueSpectacle = evenementHistoriqueSpectacle;
        this.noteSpectacle = noteSpectacle;
        this.localisation = localisation;
        this.commentairesSpectacles = commentairesSpectacles;
    }

    public Integer getIdSpectacle() {
        return idSpectacle;
    }
    

    public void setIdSpectacle(Integer idSpectacle) {
        this.idSpectacle = idSpectacle;
    }

    public String getNomSpectacle() {
        return nomSpectacle;
    }

    public void setNomSpectacle(String nomSpectacle) {
        this.nomSpectacle = nomSpectacle;
    }

    public float getDureeSpectacle() {
        return dureeSpectacle;
    }

    public void setDureeSpectacle(float dureeSpectacle) {
        this.dureeSpectacle = dureeSpectacle;
    }

    public int getNombreActeurs() {
        return nombreActeurs;
    }

    public void setNombreActeurs(int nombreActeurs) {
        this.nombreActeurs = nombreActeurs;
    }

    public String getEvenementHistoriqueSpectacle() {
        return evenementHistoriqueSpectacle;
    }

    public void setEvenementHistoriqueSpectacle(String evenementHistoriqueSpectacle) {
        this.evenementHistoriqueSpectacle = evenementHistoriqueSpectacle;
    }

    public float getNoteSpectacle() {
        return noteSpectacle;
    }

    public void setNoteSpectacle(int noteSpectacle) {
        this.noteSpectacle = noteSpectacle;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getCommentairesSpectacles() {
        return commentairesSpectacles;
    }

    public void setCommentairesSpectacles(String commentairesSpectacles) {
        this.commentairesSpectacles = commentairesSpectacles;
    }
    
    public void noter(float note){
        float oldNote = this.noteSpectacle * this.nbNotes;
        this.nbNotes++;
        this.noteSpectacle = (oldNote + note) / this.nbNotes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSpectacle != null ? idSpectacle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spectacles)) {
            return false;
        }
        Spectacles other = (Spectacles) object;
        if ((this.idSpectacle == null && other.idSpectacle != null) || (this.idSpectacle != null && !this.idSpectacle.equals(other.idSpectacle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Spectacles[ idSpectacle=" + idSpectacle + " ]";
    }
    
}
