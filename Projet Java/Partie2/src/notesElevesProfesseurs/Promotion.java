package notesElevesProfesseurs;



import java.util.*;


public class Promotion {
    private String nom = new String();
    private ArrayList<Eleve> eleves = new ArrayList<Eleve>();


    /**
     * constructeur d'un nouvel objet promotion
     * @param nom chaine de caractère, nom de la promo
     */
    public Promotion(String nom)
    {
        this.nom = nom;
    }

    /**
     * getter nom
     * @return nom de la promo
     */

    public String getNom()
    {
        return this.nom;
    }


    /**
     *setter nom
     * @param nom chaine de caractères, nom de la promo
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter liste eleves
     * @return eleves, arraylist contenant tous les eleves de la promo
     */

    public ArrayList<Eleve> getEleves()
    {
        return eleves;
    }

    /**
     * permet d'ajouter un eleve à la promo
     * @param eleve : eleve à ajouter
     */

    public void addEleve(Eleve eleve)
    {
        eleves.add(eleve);
        eleve.setPromo(this.nom); //définit le parametre "promo" de l'eleve comme le nom de la promo
    }

    /**
     * permet de rechercher un eleve dans la promo en fonction de son ID
     * @param ID numero d'identification unique de l'eleve
     * @return l'eleve recherché s'il fait partie de la promo, null sinon
     */

    public Eleve rechercher(int ID)
    {
        for (int i = 0; i<eleves.size(); i++)
        {
            int currentID = eleves.get(i).getID();
            if (ID == currentID)
            {
                return eleves.get(i);
            }
        }
        return null;
    }


    /**
     * permet de trier la promo par valeurs croissantes de la moyenne
     */
    public void sortByMoyenneRising()
    {
        for(int i = 0; i<eleves.size(); i++)  //effectue un calcul de la moyenne pour s'assurer que la valeur est bien à jour, pour chaque eleve
        {
            eleves.get(i).setMoyenne();
        }
        Collections.sort(eleves, Comparators.ordreMoyenneCroissant);  //appelle la fonction de tri de l'interface comparators
        for (int i = 0; i<eleves.size(); i++)
        {
            System.out.println(eleves.get(i).getPrenom() + " " +eleves.get(i).getNom() + ": " + eleves.get(i).getMoyenne());
        }

    }

    /**
     * permet de trier la promo par valeurs decroissantes de la moyenne
     */

    public void sortByMoyenneDecreasing()
    {
        for(int i = 0; i<eleves.size(); i++) //effectue un calcul de la moyenne pour s'assurer que la valeur est bien à jour, pour chaque eleve
        {
            eleves.get(i).setMoyenne();
        }
        Collections.sort(eleves, Comparators.ordreMoyenneCroissant);  //appelle la fonction de tri de l'interface comparators
        Collections.reverse(eleves);  //inverse le tri pour obtenir l'ordre décroissant
        for (int i = 0; i<eleves.size(); i++)
        {
            System.out.println(eleves.get(i).getPrenom() + " " +eleves.get(i).getNom() + ": " + eleves.get(i).getMoyenne());
        }
    }

    /**
     * permet de trier la promo par valeurs croissantes de la médiane
     */

    public void sortByMedianeRising()
    {
        for(int i = 0; i<eleves.size(); i++)  //effectue un calcul de la mediane pour s'assurer que la valeur est bien à jour, pour chaque eleve
        {
            eleves.get(i).setMediane();
        }
        Collections.sort(eleves, Comparators.ordreMedianeCroissant);  //appelle la fonction de tri de l'interface comparators
        for (int i = 0; i<eleves.size(); i++)
        {
            System.out.println(eleves.get(i).getPrenom() + " " +eleves.get(i).getNom() + ": " + eleves.get(i).getMediane());
        }
    }

    /**
     * permet de trier la promo par valeurs decroissantes de la médiane
     */

    public void sortByMedianeDecreasing()
    {
        for(int i = 0; i<eleves.size(); i++)  //effectue un calcul de la mediane pour s'assurer que la valeur est bien à jour, pour chaque eleve
        {
            eleves.get(i).setMediane();
        }
        Collections.sort(eleves, Comparators.ordreMedianeCroissant);  //appelle la fonction de tri de l'interface comparators
        Collections.reverse(eleves); //inverse le tri pour obtenir l'ordre décroissant
        for (int i = 0; i<eleves.size(); i++)
        {
            System.out.println(eleves.get(i).getPrenom() + " " +eleves.get(i).getNom() + ": " + eleves.get(i).getMediane());
        }
    }

}
