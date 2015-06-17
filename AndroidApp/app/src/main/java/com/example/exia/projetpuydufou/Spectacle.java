package com.example.exia.projetpuydufou;

/**
 * Created by Louis on 16/06/2015.
 */
public class Spectacle
{

    int id;
    String nom;
    float duree;
    int nbrActeurs;
    String evenement;
    float note;
    String localisation;
    String commentaire;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getDuree() {
        return duree;
    }

    public void setDuree(float duree) {
        this.duree = duree;
    }

    public int getNbrActeurs() {
        return nbrActeurs;
    }

    public void setNbrActeurs(int nbrActeurs) {
        this.nbrActeurs = nbrActeurs;
    }

    public String getEvenement() {
        return evenement;
    }

    public void setEvenement(String evenement) {
        this.evenement = evenement;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

}
