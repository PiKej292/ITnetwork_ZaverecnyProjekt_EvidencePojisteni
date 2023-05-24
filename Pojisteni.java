/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package cz.itnetwork.projekt;

/**
 * Výčtové typy druhů pojištění
 * @author Pavel Křenek
 */
public enum Pojisteni {
    CLO1 ("CLO1 - Úrazové pojištění"),
    CLO2 ("CLO2 - Životní pojištění"),
    DUM1 ("DUM1 - Pojištění nemovitosti"),
    DUM2 ("DUM2 - Pojištění domácnosti"),
    AUT1 ("AUT1 - Povinné ručení"),
    AUT2 ("AUT2 - Havarijní pojištění");
    
    private String text;
    
    Pojisteni(String text){
        this.text = text;
    }
    
    @Override
    public String toString(){
        return text;
    }
    
}
