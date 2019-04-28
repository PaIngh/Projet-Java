package notesElevesProfesseurs;



public class Date {
    private int jour;
    private int mois;
    private int année;

    /**
     * constructeur par defaut d'un nouvel objet date, sans parametres
     */

    public Date()
    {
        this.jour = 1;
        this.mois = 1;
        this.année = 1970;
    }

    /**
     * constructeur complet d'un nouvel objet date
     * @param jour entier, represente le jour
     * @param mois entier, represente le numero du mois
     * @param année entier, represente l'annee
     */

    public Date(int jour, int mois, int année)
    {
        this.jour = jour;
        this.mois = mois;
        this.année = année;
    }

    /**
     * setter jour
     * @param jour
     */

    public void setJour(int jour) {
        this.jour = jour;
    }

    /**
     * setter mois
     * @param mois
     */

    public void setMois(int mois) {
        this.mois = mois;
    }

    /**
     * setter annee
     * @param année
     */

    public void setAnnée(int année) {
        this.année = année;
    }
}
