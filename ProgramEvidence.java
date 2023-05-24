/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.projekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Třída reprezentuje hlavní fungování programu evidence - komunikuje
 * s ConsoleHandlerem, SeznamemPojistencu a SeznamemPojisteni
 * @author Pavel Křenek
 */
public class ProgramEvidence {
    // Proměnná s referencí na SeznamPojistencu
    public SeznamPojistencu pojistenci = new SeznamPojistencu();
    
    //Proměnná s referencí na třídu ConsolHandler
    public ConsoleHandler console = new ConsoleHandler();
        
    /**
     * Zavolá metody třídy ConsoleHandler pro zadání atributů pojištěnce
     * Pak jej vytvoří a přidá do listu pojistenci
     */
    public void pridejNovehoPojistence(){
        //Vypsání úvodních hlášek programu
        console.vypisHlaskuZadaniNovehoPojistence();
        console.vypisHlaskuZadejUdajeOPojistenci();
        
        //Zadání jednotlivých atributů Pojištěnce(jméno, příjmení, věk, telefon)
        String jmeno = console.zadejAOverJmenoPojistence();
        String prijmeni = console.zadejAOverPrijmeniPojistence();
        int vek = console.zadejAOverVek();
        String telefon = console.zadejAOverTelefon();
        
        //Zadání pojištění, které si pojištěnec zřídil
        Pojisteni pojisteni = console.zadejAVratPojisteni();
        
        //Uloží nového pojištěnce do seznamu pojistenců
        pojistenci.pridejPojistence(jmeno, prijmeni, vek, telefon, pojisteni);
        
    }
    
    /**
     * Metoda přidá vybranému pojištěnci nové pojištění
     */    
    public void pridejPojistenciPojisteni(){
        Pojistenec pojistenec = vyhledejAVratPojistence();
        console.vypisPojistence(pojistenec);
        int pocetPojisteni = pojistenec.getPojisteniPojistence().size();
                
        switch(pocetPojisteni){
            case 1:
                pojistenec.setPojisteni2(console.zadejAVratPojisteni());
                break;
            case 2:
                pojistenec.setPojisteni3(console.zadejAVratPojisteni());
                break;
            case 3:
                pojistenec.setPojisteni4(console.zadejAVratPojisteni());
                break;
            case 4: 
                pojistenec.setPojisteni5(console.zadejAVratPojisteni());
                break;
            default:
                
        }
    }
    
    /**
     * Metoda si nechá od třídy SeznamPojistencu vráti List všech pojištěnců v evidenci,
     * pak jej předá třídě ConsoleHandler a ta je vypíše
     */
    public void vypisVsechnyPojistence(){
        console.vypisHlavickuPojistenciVEvidenci();
        List<Pojistenec> pojistenciPole = pojistenci.vratVsechnyPojistence();
        console.vypisVsechnyPojistence(pojistenciPole);
    }
    
    /**
     * Přes konzoli vypíše pojištěnce, kterého jí vrátí metoda vyhledejAVratPojistence()
     */    
    public void vyhledejAVypisPojistence(){
        console.vypisPojistence(vyhledejAVratPojistence());
    }
    
    /**
     * Nechá si od konzole zadat a ověřit jméno a příjmení hledaného pojištěnce a pak jej vrátí
     * Metoda je oddělena od vypsání pojištěnce, pro budoucí použití při hledání pojištěnce pro jiné účely
     * @return nalezeny Nalezený pojištěnec dle zadání jména a příjmení
     */
    public Pojistenec vyhledejAVratPojistence(){
        //Proměnné pro uložení nalezeného pojištěnce
        Optional nalezenyOptional = null;
        Pojistenec nalezeny = null;
        
        /**
         * Hlavní cyklus - poběží dokud nebude zadáno jméno a příjmení shodující se s pojištěncem
         * v evidenci
         */
        while(nalezeny == null){
            //Vypíše úvodní hlášky programu
            console.vypisHlaskuVyhledaniPojistence();
            console.vypisHlaskuZadejUdajeOPojistenci();
            
            //Zadání a ověření jména a příjmení hledaného pojištěnce
            String jmeno = console.zadejAOverJmenoPojistence();
            String prijmeni = console.zadejAOverPrijmeniPojistence();
            
            //Vyhledání pojištěnce v seznamu všech pojištěnců - metoda vrátí objekt typu Optional
            nalezenyOptional = pojistenci.vratPojistence(jmeno, prijmeni);
            
            //Ověření, zda je objekt Optional prázdný nebo je v něm nalezený pojištěnec
            if(!nalezenyOptional.isEmpty()){
                nalezeny = (Pojistenec)nalezenyOptional.get();
            } else {
                console.vypisHlaskuNeniKlient();
            }
        }
        return nalezeny;
    }       
}
