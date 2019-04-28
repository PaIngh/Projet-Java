package notesElevesProfesseurs;
import java.util.*;


public class Eleve {
    private static final int NB_EVALUATIONS = 10;
    private String nom;
    private String prenom;
    private Date naissance = new Date();
    private ArrayList<Evaluation> notes = new ArrayList<Evaluation>();
    private static int count = 0;
    private int ID;
    private HashSet<Professeur> correcteurs = new HashSet<Professeur>();
    private String promo;
    private double moyenne;
    private double mediane;


    /**
     * Constructeur d'un nouvel objet élève
     *
     * @param nom : nom de famille de l'eleve
     * @param prenom : prenom de l'eleve
     * @param jour : jour de naissance
     * @param mois : mois de naissance
     * @param année : annee de naissance
     * @param p0 : professeur factice necessaire à la mise en place du tableau de notes initiales
     */
    public Eleve(String nom, String prenom, int jour, int mois, int année, Professeur p0)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance.setJour(jour);
        this.naissance.setMois(mois);
        this.naissance.setAnnée(année);
        this.ID = count++;
        setInitialEvals(p0);
    }

    /**
     * Crée un tableau de notes initial pour lesquelles les valeurs sont toutes -1, et le professeur est un factice sans valeurs définies
     * @param p0 : professeur factice nécessaire pour executer les methodes de création de notes(correcteur)
     */
    public void setInitialEvals(Professeur p0)
    {
        ArrayList<Evaluation> initial = new ArrayList<Evaluation>();
        for(int i = 0; i<NB_EVALUATIONS; i++)
        {
            Evaluation eval = new Evaluation(" ", -1, this, p0);
            initial.add(eval);
        }
        notes = initial;
    }

    /**
     * getter nom de famille
     * @return : nom de famille
     */

    public String getNom()
    {
        return this.nom;
    }

    /**
     * getter prenom
     * @return prenom
     */

    public String getPrenom()
    {
        return this.prenom;
    }

    /**
     * getter de la liste des evaluations
     * @return arraylist contenant toutes les evaluations
     */

    public ArrayList<Evaluation> getNotes()
    {
        return notes;
    }


    /**
     * getter ID
     *
     * @return le numéro identifiant unique de l'eleve
     */
    public int getID()
    {
        return this.ID;
    }

    /**
     * setter promo
     * @param promo chaine de caracteres, nom de la promo dont l'eleve fait partie
     */

    public void setPromo(String promo)
    {
        this.promo = promo;
    }

    /**
     * getter promo
     * @return chaine de caracteres, nom de la promo dont l'eleve fait partie
     */

    public String getPromo()
    {
        return promo;
    }

    /**
     * getter correcteurs
     * @return  hashset contenant tous les correcteurs
     */

    public HashSet getCorrecteurs()
    {
        for (int i=0; i<this.notes.size(); i++)
        {
            correcteurs.add(this.notes.get(i).getProf());
        }
        return correcteurs;
    }


    /**
     * méthode de calcul de la moyenne d'un étudiant
     */

    public void setMoyenne()
    {
        int iter = 0;  //utilisé pour déterminer le nombre de notes à prendre en compte
        double moy;
        double sum = 0; // somme de toutes les notes à prendre en compte
        for(int i = 0; i<this.notes.size(); i++)
        {
            if(this.notes.get(i).getNote() != -1)
            {
                sum = sum + this.notes.get(i).getNote();
                iter +=1;
            }
        }
        if(iter == 0)  //s'il n'y a aucune note à prendre en compte, on jette une exception
        {
            throw new IllegalStateException("Pas de notes");
        }
        else  //sinon on calcule la moyenne grace aux variables précedemment incrémentées
        {
            moy = sum / iter;
            this.moyenne = moy;
        }
    }

    /**
     * méthode de calcul de la médiane
     */

    public void setMediane()
    {
        int start = 0; //utilisé pour savoir par quelle note démarrer les opérations, une fois le tableau trié
        int iter = 0; // utilisé pour savoir combien de notes prendre en compte
        double med;
        Collections.sort(notes, Comparators.ordreNote); //mise en ordre croissant des notes
        for(int i = 0; i<this.notes.size(); i++)
        {
            if(this.notes.get(i).getNote() == -1)  //si une note n'est pas à prendre en compte on décale le démarrage d'une case
            {
                start +=1;
            }
            else  //sinon on comptabilise la note
            {
                iter+=1;
            }
        }
        if(iter == 0) //s'il n'y a aucune note à prendre en compte, on jette une exception
        {
            throw new IllegalStateException("Pas de notes");
        }
        else if((iter % 2) == 0) //sinon on calcule la médiane, dans le cas où il existe un nombre de notes pair
        {
            int middle = iter/2;
            med = this.notes.get(start+middle).getNote() + this.notes.get(start+middle-1).getNote();
            med = med/2;
            this.mediane = med;
        }
        else  // ou impair
        {
            int middle = start+(iter/2);
            med = this.notes.get(middle).getNote();
            this.mediane = med;
        }
    }

    /**
     * getter de la moyenne
     * @return la moyenne de l'etudiant
     */

    public double getMoyenne() {
        setMoyenne();
        return moyenne;
    }

    /**
     * getter médiane
     * @return la médiane des notes de l'etudiant
     */

    public double getMediane() {
        setMediane();
        return mediane;
    }

    /**
     * méthode d'affichage des notes
     * @return chaine de caractère, liste des notes de l'etudiant
     */

    public String dispNotes()
    {
        String report = new String();
        for (int i = 0; i< this.notes.size(); i++)
        {
            report = report.concat(this.notes.get(i).getMatiere() + ": " + this.notes.get(i).getNote() + " "); //ajoute les valeurs de chaque note à la chaine
        }
        return report;
    }

    /**
     * méthode d'affichage des correcteurs
     * @return chaine de caractère, liste des correcteurs
     */

    public String dispCorrecteurs()
    {
        String crew = "[";
        crew = crew.concat(getCorrecteurs().toString() + "]"); // ajoute le nom de chaque correcteur à la chaine
        return crew;
    }

    /**
     * méthode toString, résume toutes les infos d'un étudiant
     * @return chaine de caractères, infos de l'etudiant
     */

    @Override
    public String toString()
    {
        String notes = dispNotes();
        double moy = this.getMoyenne();
        double med = this.getMediane();
        String correcteurs = dispCorrecteurs();
        System.out.print("(" + this.prenom + "," + this.nom + ")\nid:" + this.ID +"\nPromotion: " + this.promo + "\nnotes: " + notes + "\nmoyenne: " + moy + "\nmediane: " + med + "\ncorrecteur(s): " + correcteurs + "\n");
        return null;
    }


}
