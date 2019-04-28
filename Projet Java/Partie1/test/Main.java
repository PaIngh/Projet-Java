package test;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        testsPartie1();

    }

    //Question 1: les professeurs et eleves ont comme attribut communs "nom" et "prenom",
    //cela correspond au principe du polymorphisme. Cependant, son implémentation dans le
    //cadre de ce projet rend en réalité sa réalisation plus complexe sans aucun avantage
    //réel, nous avons donc décider de ne pas le mettre en place

    /**
     * Cette méthode concentre tous les tests requis pour la partie 1 du projet.
     *
     */

    public static void testsPartie1()
    {
        System.out.print("///////////////////////////\nCreation de 5 groupes de promo\n///////////////////////////\n \n ");
        Promotion L1 = new Promotion("L1");
        Promotion L2 = new Promotion("L2");
        Promotion L3 = new Promotion("L3");
        Promotion M1 = new Promotion("M1");
        Promotion M2 = new Promotion("M2");

        System.out.print("///////////////////////////\nCreation de 9 élèves\n///////////////////////////\n \n ");
        Professeur p0 = new Professeur("/", "/");
        Eleve e0 = new Eleve("Huault", "Jean", 23, 10, 1998, p0);
        Eleve e1 = new Eleve("Inghelbrecht", "Paul-Antoine", 19, 6, 1998, p0);
        Eleve e2 = new Eleve("Thong", "Nicolas", 1, 1, 1998, p0);
        Eleve e3 = new Eleve("Desperrier", "Clement", 15, 10, 1998, p0);
        Eleve e4 = new Eleve("Anki", "Simon", 23, 9, 1998, p0);
        Eleve e5 = new Eleve("Mery", "Leo", 21, 9, 1998, p0);
        Eleve e6 = new Eleve("Boudier", "Maxime", 27, 6, 1998, p0);
        Eleve e7 = new Eleve("Faugier", "Thomas", 24, 10, 1998, p0);
        Eleve e8 = new Eleve("Bouvet", "Augustin", 30, 8, 1999, p0);

        System.out.print("///////////////////////////\nTest de bonne création d'un élève:\n");
        String prenom1 = e0.getPrenom();
        String nom1 = e0.getNom();
        System.out.println("L'eleve 1 s'appelle " + prenom1 + " " + nom1 + "\n/////////////////////////// \n\n");

        System.out.print("///////////////////////////\nCreation de 4 professeurs\n///////////////////////////\n \n ");
        Professeur p1 = new Professeur("Doe", "John");
        Professeur p2 = new Professeur("Bay", "Michael");
        Professeur p3 = new Professeur("Miyazaki", "Hayao");
        Professeur p4 = new Professeur("Anderson", "Wes");


        System.out.print("///////////////////////////\nAjout des eleves a leur promo respective\n///////////////////////////\n \n ");
        L3.addEleve(e0);
        L3.addEleve(e1);
        L2.addEleve(e2);
        L1.addEleve(e3);
        M1.addEleve(e4);
        M2.addEleve(e5);
        L1.addEleve(e6);
        M1.addEleve(e7);
        L3.addEleve(e8);

        System.out.print("///////////////////////////\nCreation de 4 notes pour chaque eleve de L3\n///////////////////////////\n \n ");
        p1.setNote(0, 20, 0, "L3", L1, L2, L3, M1, M2,"Java");
        p1.setNote(1,20, 0, "L3", L1, L2, L3, M1, M2, "Java");
        p1.setNote(8,15, 0, "L3", L1, L2, L3, M1, M2, "Java");
        p2.setNote(0, 17, 1, "L3", L1, L2, L3, M1, M2,"Maths");
        p2.setNote(1, 18, 1, "L3", L1, L2, L3, M1, M2,"Maths");
        p2.setNote(8, 12, 1, "L3", L1, L2, L3, M1, M2,"Maths");
        p3.setNote(0, 12, 2, "L3", L1, L2, L3, M1, M2,"Physique");
        p3.setNote(1, 14, 2, "L3", L1, L2, L3, M1, M2,"Physique");
        p3.setNote(8, 18, 2, "L3", L1, L2, L3, M1, M2,"Physique");
        p4.setNote(0, 16, 3, "L3", L1, L2, L3, M1, M2,"Anglais");
        p4.setNote(1, 12, 3, "L3", L1, L2, L3, M1, M2,"Anglais");
        p4.setNote(8, 13, 3, "L3", L1, L2, L3, M1, M2,"Anglais");

        System.out.print("///////////////////////////\nAffichage complet d'un eleve\n");
        e0.toString();
        System.out.println("///////////////////////////\n \n ");


        System.out.print("///////////////////////////\nAffichage de tous les eleves de la promo L3");
        ArrayList<Eleve> eleves = new ArrayList<Eleve>();
        eleves = L3.getEleves();
        System.out.println("La promo L3 est composée de");
        for (int i = 0; i<eleves.size(); i++)
        {
            System.out.println(eleves.get(i).getPrenom() + " " + eleves.get(i).getNom());
        }
        System.out.println("///////////////////////////\n \n ");

        System.out.print("///////////////////////////\nRecherche dans la promo M1 de l'eleve avec identifiant = 7\n");
        Eleve trouve =  M1.rechercher(7);
        String prenom2 = trouve.getPrenom();
        String nom2 = trouve.getNom();
        System.out.println("L'eleve s'appelle " + prenom2 + " " + nom2 + "\n///////////////////////////\n \n ");


        System.out.println("\n\nTri de la promo L3 par moyenne croissante:");
        L3.sortByMoyenneRising();
        System.out.println("\n\nTri de la promo L3 par moyenne decroissante:");
        L3.sortByMoyenneDecreasing();
        System.out.println("\n\nTri de la promo L3 par mediane croissante:");
        L3.sortByMedianeRising();
        System.out.println("\n\nTri de la promo L3 par mediane decroissante:");
        L3.sortByMedianeDecreasing();


    }

}
