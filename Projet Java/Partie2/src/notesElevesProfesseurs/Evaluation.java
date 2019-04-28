package notesElevesProfesseurs;

import java.util.*;
import java.math.*;



public class Evaluation {
    private String matiere;
    private double note;
    private Eleve eleve;
    private Professeur prof;


    /**
     * constructeur d'un nouvel objet evaluation
     * @param matiere chaine de caracteres, la matiere que cette note concerne
     * @param note double, valeur de la note
     * @param eleve eleve, l'eleve concerné
     * @param prof , professeur, le correcteur de cette evaluation
     */

    public Evaluation(String matiere, double note, Eleve eleve, Professeur prof)
    {
        this.matiere = matiere;
        this.note = note;
        this.eleve = eleve;
        this.prof = prof;
    }

    /**
     * getter note
     * @return  double, valeur de la note
     */

    public double getNote()
    {
        return this.note;
    }

    /**
     *
     * setter note
     * @param note double, valeur de la note
     */

    public void setNote(double note)
    {
        this.note = note;
    }


    /**
     * setter prof
     * @param prof professeur, le correcteur de cette evaluation
     */

    public void setProf(Professeur prof)
    {
        this.prof = prof;
    }

    /**
     * getter prof
     * @return professeur, le correcteur de cette evaluation
     */

    public Professeur getProf()
    {
        return this.prof;
    }

    /**
     * setter matiere
     * @param matiere chaine de caracteres, la matiere que cette note concerne
     */

    public void setMatiere(String matiere)
    {
        this.matiere = matiere;
    }

    /**
     * getter matiere
     * @return chaine de caracteres, la matiere que cette note concerne
     */

    public String getMatiere()
    {
        return this.matiere;
    }

    /**
     * methode toString, affiche toutes les informations d'une evaluation
     * @return chaine de caracteres, toutes les informations de cette evaluation
     */

    @Override
    public String toString()
    {
        return "(" + this.eleve.toString() + ") (" + this.prof.toString() + ") " + this.matiere + " " +this.note;
    }
}
