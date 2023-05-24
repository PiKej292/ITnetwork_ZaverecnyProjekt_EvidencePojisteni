/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.projekt;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Třída reprezentuje Datovou strukturu sdružující všechny pojištěnce v evidenci
 * @author Pavel Křenek
 */
public class SeznamPojistencu {
    //Datová struktura pro uložení Pojištěnců - Seznam pojištěnců
    private ArrayList<Pojistenec> pojistenci = new ArrayList<>();
    
    public SeznamPojistencu(){
        
    }
    
    /**
     * Metoda přidání pojištěnce do seznamu pojištěnců
     * @param jmeno jméno
     * @param prijmeni příjmení
     * @param vek věk
     * @param telefon telefon
     * @param pojisteni pojištění
     */
    public void pridejPojistence(String jmeno, String prijmeni, int vek, String telefon, Pojisteni pojisteni){
        pojistenci.add(new Pojistenec(jmeno, prijmeni, vek, telefon, pojisteni));
    }
    
    /**
     * Metoda vrátí kompletní seznam pojištěnců
     * @return Seznam všech pojištěnců v evidenci
     */
    public ArrayList<Pojistenec> vratVsechnyPojistence(){
        return pojistenci;
    }
    
    /**
     * Vyhledá pojištěnce podle jména a příjmení
     * @param jmeno jméno
     * @param prijmeni příjmení
     * @return Hledaný pojištěnec
    */ 
    public Pojistenec vyhledejPojistence(String jmeno, String prijmeni){
        Pojistenec nalezeny = null;
              
        for(Pojistenec p: pojistenci){
            if(p.getJmeno().equals(jmeno) && p.getPrijmeni().equals(prijmeni)){
                nalezeny = p;
                break;
            }
        }
        if(nalezeny == null){
            System.out.println("Takový klient v evidenci není. Zkuste to znovu.");
        }
        return nalezeny;
    }
    
    /**
     * Metoda dle zadaných parametrů(jmeno, příjmení) prohledá list pojištěnců a vrátí objekt Optional (buď
     * hledaný Pojištěnec nebo null)
     * @param jmeno
     * @param prijmeni
     * @return nalezenyOptional (výsledek hledání v listu pojištěnců - může být null)
     */
    public Optional vratPojistence(String jmeno, String prijmeni){
        
        Optional nalezenyOptional = pojistenci
                                        .stream()
                                        .filter(p -> p.getJmeno().equals(jmeno) && p.getPrijmeni().equals(prijmeni))
                                        .findFirst();
        
        return nalezenyOptional;
    }   
}
