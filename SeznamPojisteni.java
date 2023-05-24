/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.projekt;

import java.util.ArrayList;

/**
 * Třída reprezentuj seznam všech druhů pojištění
 * @author Pavel Křenek
 */
public class SeznamPojisteni {
    private ArrayList<Pojisteni> pojisteniList = new ArrayList<>();
    
    public SeznamPojisteni(){
        pojisteniList.add(Pojisteni.AUT1);
        pojisteniList.add(Pojisteni.AUT2);
        pojisteniList.add(Pojisteni.CLO1);
        pojisteniList.add(Pojisteni.CLO2);
        pojisteniList.add(Pojisteni.DUM1);
        pojisteniList.add(Pojisteni.DUM2);
    }

    /**
     * Getter seznamu všech pojištění
     * @return the pojisteniList
     */
    public ArrayList<Pojisteni> getPojisteniList() {
        return pojisteniList;
    }

    /**
     * Metoda přidá předané pojištění do seznamu všech pojištění
     * @param pojisteni pojištění
     */
    public void pridejNovyDruhPojisteni(Pojisteni pojisteni) {
        pojisteniList.add(pojisteni);
    }
    
    
    
    
}
