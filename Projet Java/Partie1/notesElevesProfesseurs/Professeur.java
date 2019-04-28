package notesElevesProfesseurs;

import notesElevesProfesseurs.Evaluation;

public class Professeur {
    private String nom = new String();
    private String prenom = new String();


    /**
     * constructeur d'un nouvel objet professeur
     * @param nom nom de famille du professeur
     * @param prenom prenom du professeur
     */

    public Professeur(String nom, String prenom)
    {
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * getter nom
     * @return le nom de famille
     */

    public String getNom()
    {
        return this.nom;
    }

    /**
     * getter prenom
     * @return le prenom
     */

    public String getPrenom()
    {
        return this.prenom;
    }


    /**
     * methode de recherche d'un eleve en fonction de sa promotion et de son ID
     * @param ID entier, numero d'identification unique d'un eleve
     * @param promo chaine de caractere, nom de la promo dans laquelle on va chercher
     * @param L1  promotion L1
     * @param L2  promotion L2
     * @param L3  promotion L3
     * @param M1  promotion M1
     * @param M2  promotion M2
     * @return  l'eleve recherché si on l'a trouvé, null sinon
     */

    public Eleve recherche(int ID, String promo, Promotion L1, Promotion L2, Promotion L3, Promotion M1, Promotion M2)
    {

        Eleve result = new Eleve("", "", 1, 1, 1970, null); //creation d'un objet eleve, receptacle du resultat de recherche
        switch (promo)  //switch permettant de rechercher dans la bonne promo
        {
            case "L1":
                result = L1.rechercher(ID);
                break;

            case "L2":
                result = L2.rechercher(ID);
                break;

            case "L3":
                result = L3.rechercher(ID);
                break;

            case "M1":
                result = M1.rechercher(ID);
                break;

            case "M2":
                result = M2.rechercher(ID);
                break;
        }
        return result;
    }


    /**
     * methode permettant d'attribuer une note à un eleve, en fonction de son ID, sa promo, le rang auquel on veut insérer la note et la valeur de la note
     * @param ID  entier, numero d'identification unique d'un eleve
     * @param note double, valeur de la note
     * @param i  entier, rang auquel on veut inserer la note
     * @param promo  chaine de caractere, nom de la promo dans laquelle on va chercher
     * @param L1  promotion L1
     * @param L2  promotion L2
     * @param L3  promotion L3
     * @param M1  promotion M1
     * @param M2  promotion M2
     * @param matiere chaine de caractere, nom de la matiere que cette note concerne
     */

    public void setNote(int ID, double note, int i, String promo, Promotion L1, Promotion L2, Promotion L3, Promotion M1, Promotion M2, String matiere)
    {
        Eleve encours = recherche(ID, promo, L1, L2, L3, M1, M2);  // recherche de l'eleve dans la promotion selectionnee
        if(encours == null)  //si l'eleve n'existe pas on jette une exception
        {
            throw new IllegalStateException("L'eleve n'existe pas");
        }
        else if(encours.getNotes().get(i) != null) //si la note existe deja, on la modifie avec les valeurs specifiees
        {
            encours.getNotes().get(i).setNote(note);
            encours.getNotes().get(i).setProf(this);
            encours.getNotes().get(i).setMatiere(matiere);
        }
        else  // si l'eleve existe mais pas la note, on la cree
        {
            Evaluation newEval = new Evaluation(matiere, note, encours, this);
            encours.getNotes().add(newEval);
        }
    }


    /**
     * methode toString, permet d'afficher les informations personelles du professeur
     * @return
     */

    @Override
    public String toString()
    {
        return "(" + this.prenom + "," + this.nom + ")";
    }
}

