/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.projekt;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Třída přijímá a ošetřuje veškeré vstupy od uživatele
 * @author Pavel Křenek
 */
public class ConsoleHandler {
    Scanner sc = new Scanner (System.in, "Windows-1250");
    
    Pojisteni pojisteni;
    SeznamPojisteni seznamPojisteni = new SeznamPojisteni();
    
    
    
    
    
    /**
     * Vypíše úvodní menu s nabídkou příkazů pro ovládání programu
     */
    public void vypisUvodniMenu(){
        System.out.println("=================================");
        System.out.println("Evidence pojištěných");
        System.out.println("=================================");
        System.out.println("Vyberte akci:");
        System.out.println("1 - Přidat nového pojištěnce");
        System.out.println("2 - Vypsat všechny pojištěnce");
        System.out.println("3 - Vyhledat pojištěnce");
        System.out.println("4 - Přidej pojištěnci další pojištění");
        System.out.println("5 - Konec");
        System.out.println("");
    }
    
    /**
     * Vypíše hlášku pro Zadání nového pojištěnce
     */
    public void vypisHlaskuZadaniNovehoPojistence(){
        System.out.println("\nZADÁNÍ NOVÉHO POJIŠTĚNCE");
        System.out.println("--------------------------");
    }
    
    /**
     * Vypíše hlášku pro Vyhledání pojištěnce
     */
    public void vypisHlaskuVyhledaniPojistence(){
        System.out.println("\nVYHLEDÁNÍ POJIŠTĚNCE");
        System.out.println("--------------------");
    }
    
    /**
     * 'Vypíše úvodní hlášku pro zadání údajů o pojištěnci
     */
    public void vypisHlaskuZadejUdajeOPojistenci(){
        
        System.out.println("Zadej údaje o pojištěnci");
        System.out.println("====================================================");
    }
    
    /**
     * Vypíše hláškku nad vypsáním seznamu všech pojištěnců v evidenci
     */
    public void vypisHlavickuPojistenciVEvidenci(){
        System.out.println("");
        System.out.println("POJIŠTĚNCI V EVIDENCI");
        System.out.println("---------------------");
        System.out.println("[Jméno]-[Příjmení]-[Věk]-[Telefon]"
                + "\n[Sjednaná pojištění]");        
        System.out.println("====================================================");
        
    }
    
    /**
     * Vypíše hlášku Data byla uložena
     */
    public void vypisDataBylaUlozena(){
        System.out.println("\nData byla uložena. Pokračuj klávesou ENTER.");
    }
    
    /**
     * Vypíše všechny pojištěnce předaného listu pojištěnců
     */
    public void vypisVsechnyPojistence(List<Pojistenec> pojistenci){
        for(Pojistenec p: pojistenci){
            System.out.println(p);
        }
        System.out.println();
    }
    
        
    /**
     * Metoda pro zadání jména
     * ověřuje, zda není jméno prázdný řetězec a zda v něm není číslice a pak jej vrátí
     * @return Vrací zadané jméno
     */
    public String zadejAOverJmenoPojistence(){
        boolean spravneZadano = false;
        String jmeno = "";
        
        while(!spravneZadano){
            System.out.println("Jméno: ");
            jmeno = sc.nextLine().trim();
            
            //Ověřit, že je jméno správně zadáno (není prázdné, neobsahuje číslice, je psáno bez diakritiky)
            spravneZadano = overJmenoNeboPrijmeni(jmeno);            
        }
        return jmeno;
    }
    
    /**
     * Metoda pro zadání příjmení
     * ověřuje, zda není příjmení prázdný řetězec a zda v něm není číslice a pak jej vrátí
     * @return Vrací zadané příjmení
     */
    public String zadejAOverPrijmeniPojistence(){
        boolean spravneZadano = false;
        String prijmeni = "";
        
        while(!spravneZadano){
            System.out.println("Příjmení: ");
            prijmeni = sc.nextLine().trim();
            
            //Ověřit, že je jméno správně zadáno (není prázdné, neobsahuje číslice, je psáno bez diakritiky)
            spravneZadano = overJmenoNeboPrijmeni(prijmeni);            
        }
        return prijmeni;
    }
    
    /**
     * Privátní metoda ověřuje že je jméno/příjmení správně zadání(jen písmena, bez diakr., není prázdné)
     * @param jmenoNeboPrijmeni
     * @return true - správě zadáné, false - chybně zadáno
     */
    private boolean overJmenoNeboPrijmeni(String jmenoNeboPrijmeni){
        boolean spravneZadano = false;
        String jmenoNeboPrijmeniMalymi = jmenoNeboPrijmeni.toLowerCase();
        if(jmenoNeboPrijmeni.equals("")){
                System.out.println("Jméno/Příjmení je povinný údaj.");
            } else {
                // Ověří, zda se ve jméně vykytují jen písmena bez diakritiky (ověření přes ASCII hodnoty)
                for(char znak: jmenoNeboPrijmeniMalymi.toCharArray()){
                    if ((int)znak > 96 && (int)znak < 123){
                        spravneZadano = true;
                    } else {
                        System.out.println("Jejda, jméno/příjmení může obsahovat jen písmena abecedy bez diakritiky. Zkus to, prosím, znovu.");
                        spravneZadano = false;
                        break;
                    }

                }
            }
        return spravneZadano;
    }
    
    /**
     * Metoda pro zadání věku 
     * - ověří, že je věk správně zadán(jen číslice, více než 18 let)
     * @return ověřený zadaný věk
     */
    public int zadejAOverVek(){
        boolean spravneZadano = false;
        String vekString = "";
        int vek = 0;
        
        while(!spravneZadano){
            System.out.println("Věk: ");
            vekString = sc.nextLine();
            
            //Ověření, že jde o číslo
            if(!overZdaJdeOCislo(vekString)){
                continue;
            }
        
            //Ověření, že je věk větší než 18
            vek = Integer.parseInt(vekString);
            if(vek >= 18){
                spravneZadano = true;
            } else {
                System.out.println("\nVěk musí být 18+. Zkus to znovu.");
            }
        }
        
        return vek;
    }
        
    /**
     * Metoda pro zadání telefonního čísla
     * - ověřuje, zda jsou zadány jen číslice, zda má číslo správnou délku 9 číslic a 
     * zda je ve sprváném formátu
     * @return Ověřené zadané číslo
     */
    public String zadejAOverTelefon(){
        boolean spravneZadano = false;
        String telefonniCislo = "";
        
        //Hlavní cyklus ověřující zda je číslo zadáno po všech ohledech správně
        while(!spravneZadano){
            System.out.println("Telefonní číslo (zadejte ve formátu XXX XXX XXX): ");
            telefonniCislo = sc.nextLine().trim();
            String telefonBezMezer = telefonniCislo.replace(" ", "");
            
            //Ověří zda jsou zadané jen číslice
            if(!overZdaJdeOCislo(telefonBezMezer)){
                continue;
            }

            //ověří jeho správnou délku 9 znaků
            if (telefonBezMezer.length() != 9){
                System.out.println("\nNějak málo/moc číslic. Zkus to znovu");
                continue;
            }
            
                     
            //Ověření, zda je telefon ve správném formátu - zda je na 3 a 7 pozici mezera
            int mezery = 0;
            for(char c: telefonniCislo.toCharArray()){
                if(telefonniCislo.indexOf(c) == 3 || telefonniCislo.indexOf(c) == 7){
                    if((int)c == 32){
                        mezery ++;
                    } else {
                        System.out.println("Telefonní číslo je ve špatném formátu.");
                        break;
                    }                   
                }
            }
            if(mezery == 2){
                spravneZadano = true;
            }
        }
        return telefonniCislo;
    }
    
    /**
     * Metoda ověřuje, že je zadané číslo (řetězec obsahuje jen číslice)
     * @param cisloString
     * @return Ověřený String řetězec
     */
    static boolean overZdaJdeOCislo(String cisloString){
        boolean spravneZadano = false;
        try {
            long cisloLong = Long.parseLong(cisloString);
            spravneZadano = true;
        } catch (Exception e){
            System.out.println("\nZadal jsi jiný znak než číslici. Zkus to znovu.");
        }
        
        return spravneZadano;
        
    }
    
    /**
     * Metoda pro zadání typu sjednaného pojištění
     * @return Sjednané pojištění
     */
    public Pojisteni zadejAVratPojisteni(){
        System.out.println("\nMOŽNOSTI POJIŠTĚNÍ");
        System.out.println("KÓD - Název pojištění: ");
        System.out.println("====================================================");
        
        //Výpíše seznam všech typů pojištění, která jsou v nabídce
        for(Pojisteni p: seznamPojisteni.getPojisteniList()){
            System.out.println(p);
        }
        
        //Pomocná proměnná pro chování nalezeného pojištění a jeho navrácení
        pojisteni = null;       
        
        //
        while(pojisteni == null){
            System.out.println("\nZadej kód vybraného pojištění:");
            String pojisteniString = sc.nextLine().trim().toUpperCase();
            
            
        
            for(Pojisteni p: seznamPojisteni.getPojisteniList()){
                if(String.valueOf(p).contains(pojisteniString) && pojisteniString.length() == 4){
                    pojisteni = p;
                    break;
                }
            }
            if(pojisteni == null){
                vypisHlaskuTakovaMoznostNeni();
            }
        }
        return pojisteni;
    }
    
    
    /**
     * Metoda pro zadání příkazu - ověřuje, zda jde o číslo a je kladné
     * @return prikaz 
     */
    public int zadaniPrikazu(){
        boolean spravneZadano = false;
        int prikaz = 0;
        
        while(!spravneZadano){
            System.out.print("Vaše volba: ");
            String cisloString = sc.nextLine();
            //Ověření, že jde o číslo ,když neprojde parsování na int vrátí false
            spravneZadano = overZdaJdeOCislo(cisloString); 
            
            if(spravneZadano){
                if(cisloString.charAt(0) != '-'){ // Ověří, jestli není číslo záporné
                    prikaz = Integer.parseInt(cisloString);
                    break;
                } else {
                    System.out.println("\nČíslo musí být kladné. Zkus to znovu.");
                    spravneZadano = false;
                }
            }    
        }
        return prikaz;
    }
    
    /**
     * Vypíše předaného pojištěnce do konzole
     * @param pojistenec 
     */
    public void vypisPojistence(Pojistenec pojistenec){
        System.out.println("");
        System.out.println(pojistenec);
    }
    
   
    /**
     * Vypíše hlášku: Program byl ukončen.
     */
    public void vypisProgramBylUkoncen(){
        System.out.println("\nProgram byl ukončen");
    }
    
    /**
     * vypíše hlášku: Taková možnost není. Zadej číslo z nabídky.
     */
    public void vypisHlaskuTakovaMoznostNeni(){
        System.out.println("\nTaková možnost není v nabídce. Zadej znovu.");
    }
    
    public void vypisHlaskuNeniKlient(){
        System.out.println("Takový klient v evidenci není. Zkus to znovu.");
    }
    
}
