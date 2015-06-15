/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;

/**
 *
 * @author Ugo
 */
public class Spectacle  implements Serializable {
    private int  id_spectacle;
    private String nom_spectacle;
    private int duree_spectacle;
    private int nombre_acteurs;
    private String evenement_historique_spectacle;
    private int note_spectacle;
    private String localisation;
    private String commentaires_spectacles;
    
    public Spectacle(String ccNumber, Long amount) {
        
    }
    

    @Override
    public String toString() {
        return "com.model.Spectacle[ccNumber=" + id_spectacle + " Amount "+ nom_spectacle+ "]";
    }
}
