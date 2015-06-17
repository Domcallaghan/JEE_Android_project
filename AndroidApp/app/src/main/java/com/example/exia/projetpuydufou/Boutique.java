package com.example.exia.projetpuydufou;

/**
 * Created by Louis on 16/06/2015.
 */
public class Boutique
{

    int id;
    String nom;
    float note;
    String localisation;

    public int getNbrNotes() {
        return nbrNotes;
    }

    public void setNbrNotes(int nbrNotes) {
        this.nbrNotes = nbrNotes;
    }

    int nbrNotes;

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

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }



}
