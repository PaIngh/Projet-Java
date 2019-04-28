package notesElevesProfesseurs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManipulation {

    /**
     * Cette methode permet d'importer les professeurs depuis le fichier .csv
     * @return listProfs, arraylist contenant tous les professeurs
     */

    public ArrayList<Professeur> importProfs()
    {
        System.out.print("///////////////////////////\nImport des professeurs\n///////////////////////////\n \n ");
        String sProfs = "csvfiles/profs.csv";   //processus d'import du fichier dans le programme, commun à la majorité des methodes de cette classe
        File profs = new File(sProfs);
        ArrayList<Professeur> listProfs = new ArrayList<>(); //creation d'une arraylist pour stocker les nouveaux objets professeur créés
        try
        {
            Scanner scanProfs = new Scanner(profs);
            while(scanProfs.hasNext())
            {
                String data = scanProfs.next();
                String[] values = data.split(";");  //séparation des donnees sur une meme ligne du fichier (en fonction du séparateur, ici ";"
                listProfs.add(new Professeur(values[0], values[1]));  //creation des nouveaux objets professeur
            }
        }
        catch (FileNotFoundException e)     //si le chemin du fichier ne retourne rien, on jette une exception
        {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

        System.out.print("///////////////////////////\nTest de bon import d'un professeur:\n");  //affiche les donnees d'un des nouveaux objets professeur
        listProfs.get(3).toString();
        System.out.print("///////////////////////////\n\n");
        return listProfs;
    }


    /**
     * Cette méthode permet d'importer les eleves depuis le fichier .csv
     * @param listProfs arraylist contenant tous les professeurs, necessaires pour contruire la liste de notes initiale
     * @return listEleves, arraylist contenant tous les eleves
     */

    public ArrayList<Eleve> importEleves(ArrayList<Professeur> listProfs)
    {
        System.out.print("///////////////////////////\nImport des élèves\n///////////////////////////\n \n ");

        String sEleves = "csvfiles/eleves.csv";  //import du fichier dans le programme
        File eleves = new File(sEleves);
        ArrayList<Eleve> listEleves = new ArrayList<>();  //creation d'une arraylist pour stocker les nouveaux objets eleve créés
        try
        {
            Scanner scanEleves = new Scanner(eleves);
            while(scanEleves.hasNext())
            {
                String data = scanEleves.next();
                String values[] = data.split(";");
                listEleves.add(new Eleve(values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]), listProfs.get(0)));  //creation des nouveaux objets eleve
            }

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }


        System.out.print("///////////////////////////\nTest de bon import d'un élève:\n");  //affiche les donnees d'un des objets eleve créés
        String prenom1 = listEleves.get(0).getPrenom();
        String nom1 = listEleves.get(0).getNom();
        System.out.println("L'eleve 1 s'appelle " + prenom1 + " " + nom1 + "\n/////////////////////////// \n\n");
        return listEleves;
    }

    /**
     * Cette methode permet d'importer toutes les promotions depuis le fichier .csv
     * @return listPromo, arraylist contenant toutes les promotions
     */

    public ArrayList<Promotion> importPromos()
    {
        System.out.print("///////////////////////////\nImport des promotions\n///////////////////////////\n \n ");

        String sPromos = "csvfiles/promo.csv";  //import du fichier dans le programme
        File promos = new File(sPromos);
        ArrayList<Promotion> listPromos = new ArrayList<>();  //creation d'une arraylist pour stocker les nouveaux objets promo créés
        try
        {
            Scanner scanPromos = new Scanner(promos);
            while(scanPromos.hasNext())
            {
                String data = scanPromos.next();
                //String[] values = data.split(";");
                listPromos.add(new Promotion(data));  //creation des nouveaux objets eleve
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        return listPromos;
    }

    /**
     * Cette methode permet d'attribuer chaque eleve à sa promotion respective
     * @param listEleves arraylist contenant tous les eleves
     * @param listPromos arraylist contenant toutes les promos
     */

    public void elevesPromos(ArrayList<Eleve> listEleves, ArrayList<Promotion> listPromos)
    {
        System.out.print("///////////////////////////\nAttribution des élèves à leur promotion respective\n///////////////////////////\n \n ");

        String sElevesPromos = "csvfiles/elevespromos.csv";  //import du fichier dans le programme
        File elevespromos = new File(sElevesPromos);
        try
        {
            Scanner scanElevesPromos = new Scanner(elevespromos);
            while(scanElevesPromos.hasNext())
            {
                String data = scanElevesPromos.next();
                String[] values = data.split(";");
                this.findAndFill(listPromos, listEleves.get(Integer.parseInt(values[0])), values[1]); //appel de la methode findAndFill pour ranger l'eleve dans sa promo correspondante
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

        System.out.print("///////////////////////////\nAffichage de tous les élèves de la promotion L3\n");  //affiche tous les eleves d'une promo pour s'assurer que la methode a fonctionne
        System.out.println("La promo L3 est composée de");
        Promotion promo = recherchePromo(listPromos, "L3");
        for (int i = 0; i<promo.getEleves().size(); i++)
        {
            System.out.println(promo.getEleves().get(i).getPrenom() + " " + promo.getEleves().get(i).getNom());
        }
        System.out.println("///////////////////////////\n \n ");
    }

    /**
     * Cette methode permet d'importer toutes les evaluations depuis le fichier .csv
     * @param listPromos arraylist contenant toutes les promotions
     * @param listProfs arraylist contenant tous les professeurs
     */

    public void importEvals(ArrayList<Promotion> listPromos, ArrayList<Professeur> listProfs)
    {
        System.out.print("///////////////////////////\nImport des evalutations\n///////////////////////////\n");
        String sEvaluations = "csvfiles/evaluations.csv";   //import du fichier dans le programme
        File evaluations = new File(sEvaluations);
        try
        {
            Scanner scanEvaluations = new Scanner(evaluations);
            while(scanEvaluations.hasNext())
            {
                String data = scanEvaluations.next();
                String[] values = data.split(";");
                Professeur prof = this.rechercheProf(values[0], values[1], listProfs);  //recherche le professeur correspondant en fonction de son nom et prenom
                prof.setNote(Integer.parseInt(values[3]), Double.parseDouble(values[4]), Integer.parseInt(values[6]), values[2], listPromos.get(0), listPromos.get(1), listPromos.get(2), listPromos.get(3), listPromos.get(4), values[5]); //le professeur ajoute l'evaluation a l'eleve concerne, en fonction de toutes les donnees fournies
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
    }

    /**
     * Cette methode permet d'ajouter une nouvelle note à un eleve, et de mettre à jour le fichier evaluations.csv avec ces nouvelles donnees
     * @param listProfs arraylist contenant tous les professeurs
     * @param listPromos arraylist contenant toutes les promotions
     */


    public void ajoutNote(ArrayList<Professeur> listProfs, ArrayList<Promotion> listPromos)
    {
        System.out.print("///////////////////////////\nAjout d'une nouvelle note à l'élève 4, sauvegarde dans le fichier evaluations\n");
        String sEvaluations = "csvfiles/evaluations.csv";
        File evaluations = new File(sEvaluations);
        listProfs.get(3).setNote(4, 13, 2, "M1", listPromos.get(0), listPromos.get(1), listPromos.get(2), listPromos.get(3), listPromos.get(4), "Physique"); //le professeur choisi ajoute une nouvelle evaluation, avec tous les parametres choisis
        writeEval(listProfs.get(3).getPrenom(), listProfs.get(3).getNom(), "M1", "4", "13", "Physique", "2", evaluations); //on fait appel à la methode writeEval pour retranscrire cette nouvelle note dans le fichier evaluations.csv
    }


    /**
     * Cette methode permet de rechercher une promo donnee dans la liste des promos, et d'y ajouter l'eleve specifie. Par la suite, elle met a jour les donnees de l'eleve avec la promo correcte
     * @param listPromos arraylist contenant toutes les promotions
     * @param eleve objet eleve, l'eleve que l'on veut ajouter a la promo
     * @param promo chaine de caractere, nom de la promo a laquelle on veut ajouter un eleve
     */

    public void findAndFill(ArrayList<Promotion> listPromos, Eleve eleve, String promo)
    {
        for(int i = 0; i< listPromos.size(); i++)
        {
            if(promo.equals(listPromos.get(i).getNom()))  //ajoute un eleve dans la promo si son nom correspond
            {
                listPromos.get(i).addEleve(eleve);
            }
        }
    }


    /**
     * Cette methode permet de rechercher une promotion specifique dans la liste, et de la retourner
     * @param listPromos arraylist contenant toutes les promotions
     * @param promo chaine de caractere, nom de la promo que l'on recherche
     * @return la promotion recherchee
     */

    public Promotion recherchePromo(ArrayList<Promotion> listPromos, String promo)
    {
        for (int i = 0; i<listPromos.size(); i++)
        {
            if(listPromos.get(i).getNom().equals(promo))    //retourne la promo recherchee si son nom correspond
            {
                return listPromos.get(i);
            }
        }
        throw new IllegalStateException("Cette promo n'existe pas");
    }

    /**
     * Cette methode recherche un professeur dans la liste des professeurs en fonction de son nom et prenom
     * @param prenom chaine de caractere, prenom du professeur recherche
     * @param nom chaine de caractere, nom du professeur recherche
     * @param listProfs arraylist contenant tous les professeurs
     * @return  le professeur recherche s'il existe
     */

    public Professeur rechercheProf(String prenom, String nom, ArrayList<Professeur> listProfs)
    {
        for(int i = 0; i<listProfs.size(); i++)
        {
            if(listProfs.get(i).getPrenom().equals(prenom) && listProfs.get(i).getNom().equals(nom)) //retourne le professeur recherche si son nom et prenom correspondent
            {
                return listProfs.get(i);
            }
        }
        throw new IllegalStateException("Ce prof n'existe pas");
    }


    /**
     * Cette methode permet d'ecrire les données d'une nouvelle evaluation dans le fichier evaluations.csv
     * @param prenom chaine de caracteres, prenom du correcteur
     * @param nom chaine de caracteres, nom du correcteur
     * @param promo chaine de caracteres, promotion de l'eleve
     * @param ID chaine de caracteres, ID de l'eleve
     * @param note chaine de caracteres, note de l'eleve
     * @param matiere chaine de caracteres, matiere concernee par l'evaluation
     * @param index chaine de caracteres, index auquel la note est inserree
     * @param evaluations fichier evaluations.csv
     */

    public void writeEval(String prenom, String nom, String promo, String ID, String note, String matiere, String index, File evaluations)
    {
        try
        {
            FileWriter fw = new FileWriter(evaluations, true); //cree un FileWriter pour ecrire dans le fichier, le booleen ayant pour valeur "true" indique que l'on ajoute les nouvelles valeurs a la fin du fichier existant
            String line = "\n" + prenom + ";" + nom + ";" + promo + ";" + ID  + ";" + note + ";" + matiere + ";" + index;  //creation de la chaine de caracteres a introduire dans le fichier
            fw.write(line); //ecriture dans le fichier
            fw.close(); //fermeture du FileWriter, tres important

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
