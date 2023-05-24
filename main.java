/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.projekt;

import java.util.Scanner;

/**
 *
 * @author Pavel Křenek
 */
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        
        //instance tříd ProgramEvidence a ConsoleHandler
        ProgramEvidence evidence = new ProgramEvidence();
        ConsoleHandler console = new ConsoleHandler();
        
        //proměná, určující opakování hlavního cyklu a dále výběr příkazů pro ovládání programu
        int prikaz = 1;
       
        while(prikaz != 5){
            
            /*Vypíše úvodní menu, ale jen v případě, že byl zadáv validní příkaz - při
             *nevalidním příkazu cyklus vypsání menu přeskočí a vyžádá si nové zadání
             */
            if(prikaz > 0 && prikaz < 5){
                console.vypisUvodniMenu();
            }
            
            //Zadání volby příkazu a její ověření (jestli je číslo) 
            prikaz = console.zadaniPrikazu();
            
            //Dělení fungování programu dle zadaného příkazu
            switch(prikaz){
                    case 1:
                        evidence.pridejNovehoPojistence();
                        break;
                    case 2:
                        evidence.vypisVsechnyPojistence();
                        break;
                    case 3:
                        evidence.vyhledejAVypisPojistence();
                        break;
                    case 4:
                        evidence.pridejPojistenciPojisteni();
                        break;
                    case 5:
                        console.vypisProgramBylUkoncen();
                        break;
                    default:
                        console.vypisHlaskuTakovaMoznostNeni();
                        break;
            }
            
            /**Vypsání hlášky o uložení dat a pokračování po stisku Enteru 
             * - při nevalidním příkazu se toto přeskočí
             */
            if(prikaz > 0 && prikaz < 5){
                console.vypisDataBylaUlozena();
                String pokracovat = sc.nextLine();
            
            }
        }
        
    }
}
