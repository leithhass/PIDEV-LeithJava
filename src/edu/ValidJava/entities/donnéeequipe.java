/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ValidJava.entities;

/**
 *
 * @author MSI
 */
public class donnéeequipe {
     private static Equipe selectedtype = new Equipe();
    private static donnéeequipe  localdata;
       
    public static void setEquipe(Equipe f){
    selectedtype = f;
    }
    
    public static Equipe getEquipe(){
        
    return selectedtype;
    
    }
    
}
