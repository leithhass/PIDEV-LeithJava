/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ValidJava.entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author MSI
 */
public class Tournois {

    private int id;
    private int prize;
    private int max_equipes;
    private String lieu;
    private String name;
    private Date date;

    public Tournois(int id, int prize, int max_equipes, String lieu, String name, Date date) {
        this.id = id;
        this.prize = prize;
        this.max_equipes = max_equipes;
        this.lieu = lieu;
        this.name = name;
        this.date = date;
    }
      public Tournois(int id,String name, int prize, String lieu, int max_equipes,   Date date) {
        this.id = id;
        this.prize = prize;
        this.max_equipes = max_equipes;
        this.lieu = lieu;
        this.name = name;
        this.date = date;
    }

    public Tournois(int prize, int max_equipes, String lieu, String name, Date date) {
        this.prize = prize;
        this.max_equipes = max_equipes;
        this.lieu = lieu;
        this.name = name;
        this.date = date;
    }

    public Tournois() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public int getMax_equipes() {
        return max_equipes;
    }

    public void setMax_equipes(int max_equipes) {
        this.max_equipes = max_equipes;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + this.prize;
        hash = 29 * hash + this.max_equipes;
        hash = 29 * hash + Objects.hashCode(this.lieu);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.date);
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
        final Tournois other = (Tournois) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.prize != other.prize) {
            return false;
        }
        if (this.max_equipes != other.max_equipes) {
            return false;
        }
        if (!Objects.equals(this.lieu, other.lieu)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }

    @Override
    public String toString() {
        return "Tournois{" + "id=" + id + ", prize=" + prize + ", max_equipes=" + max_equipes + ", lieu=" + lieu + ", name=" + name + ", date=" + date + '}';
    }
    
    
    
    
    
}
