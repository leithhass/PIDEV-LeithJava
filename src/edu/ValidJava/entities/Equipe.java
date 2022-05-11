/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ValidJava.entities;

import java.util.Objects;

/**
 *
 * @author MSI
 */
public class Equipe {
    private int id;
    private int nbr_joueurs;
    private String nom_equipe;
    private String nom_joueurs;

    public Equipe(int id, int nbr_joueurs, String nom_equipe, String nom_joueurs) {
        this.id = id;
        this.nbr_joueurs = nbr_joueurs;
        this.nom_equipe = nom_equipe;
        this.nom_joueurs = nom_joueurs;
    }

    public Equipe(int nbr_joueurs, String nom_equipe, String nom_joueurs) {
        this.nbr_joueurs = nbr_joueurs;
        this.nom_equipe = nom_equipe;
        this.nom_joueurs = nom_joueurs;
    }

    public Equipe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbr_joueurs() {
        return nbr_joueurs;
    }

    public void setNbr_joueurs(int nbr_joueurs) {
        this.nbr_joueurs = nbr_joueurs;
    }

    public String getNom_equipe() {
        return nom_equipe;
    }

    public void setNom_equipe(String nom_equipe) {
        this.nom_equipe = nom_equipe;
    }

    public String getNom_joueurs() {
        return nom_joueurs;
    }

    @Override
    public String toString() {
        return "Equipe{" + "id=" + id + ", nbr_joueurs=" + nbr_joueurs + ", nom_equipe=" + nom_equipe + ", nom_joueurs=" + nom_joueurs + '}';
    }

    public void setNom_joueurs(String nom_joueurs) {
        this.nom_joueurs = nom_joueurs;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        hash = 79 * hash + this.nbr_joueurs;
        hash = 79 * hash + Objects.hashCode(this.nom_equipe);
        hash = 79 * hash + Objects.hashCode(this.nom_joueurs);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipe other = (Equipe) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.nbr_joueurs != other.nbr_joueurs) {
            return false;
        }
        if (!Objects.equals(this.nom_equipe, other.nom_equipe)) {
            return false;
        }
        if (!Objects.equals(this.nom_joueurs, other.nom_joueurs)) {
            return false;
        }
        return true;
    }
    
    
    
}
