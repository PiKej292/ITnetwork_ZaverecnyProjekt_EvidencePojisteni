/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.projekt;

import java.util.ArrayList;

/**
 * Třída reprezentuje jednotlivé pojištěnce
 * @author Pavel Křenek
 */
public class Pojistenec {
    //Základní údaje o pojištěnci
    private String jmeno;
    private String prijmeni;
    private int vek;
    private String telefon;
    
    //Formy sjednaného pojištění
    private Pojisteni pojisteni1;
    private Pojisteni pojisteni2;
    private Pojisteni pojisteni3;
    private Pojisteni pojisteni4;
    private Pojisteni pojisteni5;
    
//seznam všech pojištění, které daný pojištěnec má sjednané
    private ArrayList<Pojisteni> pojisteniPojistence = new ArrayList<>();
      
    public Pojistenec (String jmeno, String prijmeni, int vek, String telefon, Pojisteni pojisteni1) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = telefon;
        this.pojisteni1 = pojisteni1;
        pojisteniPojistence.add(pojisteni1);
    }

    /**Getter jméno pojištěnce
     * @return the jmeno jméno
     */
    public String getJmeno() {
        return jmeno;
    }

    /** Setter jméno pojištěnce
     * @param jmeno the jmeno to set
     */
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    /**
     * Getter příjmení pojištěnce
     * @return the prijmeni příjmení
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * Setter příjmení pojištěnce
     * @param prijmeni the prijmeni to set
     */
    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    /**
     * Getter věk pojištěnce
     * @return the vek věk
     */
    public int getVek() {
        return vek;
    }

    /**
     * Setter věk pojištěnce
     * @param vek the vek to set
     */
    public void setVek(int vek) {
        this.vek = vek;
    }

    /**
     * Getter telefon pojištěnce
     * @return the telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Setter telefon pojištěnce
     * @param telefon the telefon to set
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
  
    /**
     * Getter seznam všech pojištění pojištěnce
     * @return the pojisteniPojistence
     */
    public ArrayList<Pojisteni> getPojisteniPojistence() {
        return pojisteniPojistence;
    }

    /**
     * Getter Pojisteni1 
     * @return the pojisteni1
     */
    public Pojisteni getPojisteni1() {
        return pojisteni1;
    }

    /**
     * Nastaví pojisteni1 a přidá do seznamu pojištění daného pojištěnce
     * @param pojisteni1 the pojisteni1 to set
     */
    public void setPojisteni1(Pojisteni pojisteni1) {
        this.pojisteni1 = pojisteni1;
        pojisteniPojistence.add(pojisteni1);
    }

    /**
     * Getter Pojisteni2
     * @return the pojisteni2
     */
    public Pojisteni getPojisteni2() {
        return pojisteni2;
    }

    /**
     * Nastaví pojisteni2 a přidá do seznamu pojištění daného pojištěnce
     * @param pojisteni2 the pojisteni2 to set
     */
    public void setPojisteni2(Pojisteni pojisteni2) {
        this.pojisteni2 = pojisteni2;
        pojisteniPojistence.add(pojisteni2);
    }

    /**
     * Getter Pojisteni3
     * @return the pojisteni3
     */
    public Pojisteni getPojisteni3() {
        return pojisteni3;
    }

    /**
     * Nastaví pojisteni3 a přidá do seznamu pojištění daného pojištěnce
     * @param pojisteni3 the pojisteni3 to set
     */
    public void setPojisteni3(Pojisteni pojisteni3) {
        this.pojisteni3 = pojisteni3;
        pojisteniPojistence.add(pojisteni3);
    }

    /**
     * Getter Pojisteni4
     * @return the pojisteni4
     */
    public Pojisteni getPojisteni4() {
        return pojisteni4;
    }

    /**
     * Nastaví pojisteni4 a přidá do seznamu pojištění daného pojištěnce
     * @param pojisteni4 the pojisteni4 to set
     */
    public void setPojisteni4(Pojisteni pojisteni4) {
        this.pojisteni4 = pojisteni4;
        pojisteniPojistence.add(pojisteni4);
    }

    /**
     * Getter Pojisteni5
     * @return the pojisteni5
     */
    public Pojisteni getPojisteni5() {
        return pojisteni5;
    }

    /**
     * Nastaví pojisteni5 a přidá do seznamu pojištění daného pojištěnce
     * @param pojisteni5 the pojisteni5 to set
     */
    public void setPojisteni5(Pojisteni pojisteni5) {
        this.pojisteni5 = pojisteni5;
        pojisteniPojistence.add(pojisteni5);
    }

    @Override
    public String toString(){
        
        String vypis = jmeno + " - " + prijmeni + " - " + vek + " - " + telefon + "\n" ;
        for(Pojisteni p: getPojisteniPojistence()){
            vypis += p + "\n";
        }
        vypis += "--------------------------------------------------";
        
        return vypis;
                 
    }
                
}
