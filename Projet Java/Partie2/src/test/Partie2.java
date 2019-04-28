package test;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.FileManipulation;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;

import java.io.*;
import java.util.*;


public class Partie2 {
    public static void main(String[] args) {

        testsPartie2();
    }


    public static void testsPartie2()
    {

        FileManipulation test = new FileManipulation();
        ArrayList<Professeur> listProfs = test.importProfs();
        ArrayList<Eleve> listEleves = test.importEleves(listProfs);
        ArrayList<Promotion> listPromos = test.importPromos();
        test.elevesPromos(listEleves, listPromos);
        test.importEvals(listPromos, listProfs);

        System.out.print("///////////////////////////\nAffichage complet d'un eleve\n");
        listEleves.get(0).toString();
        System.out.println("///////////////////////////\n \n ");


        System.out.print("///////////////////////////\nRecherche dans la promo M1 de l'eleve avec identifiant = 7\n");
        Promotion sample = test.recherchePromo(listPromos, "M1");
        Eleve trouve =  sample.rechercher(7);
        String prenom2 = trouve.getPrenom();
        String nom2 = trouve.getNom();
        System.out.println("L'eleve s'appelle " + prenom2 + " " + nom2 + "\n///////////////////////////\n \n ");

        test.ajoutNote(listProfs, listPromos);

    }




}
