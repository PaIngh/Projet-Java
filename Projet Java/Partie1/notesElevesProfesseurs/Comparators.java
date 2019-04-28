package notesElevesProfesseurs;

import java.util.Comparator;

/**
 * interface contenant les méthodes utilisées pour les différents tris de notre programme
 */
public interface Comparators {

    /**
     * trie les evaluations selon les notes qui ont été attribuées dans l'ordre croissant au sein de leur ArrayList
     */
    static final Comparator<Evaluation> ordreNote = new Comparator<Evaluation>()
    {
        @Override
        public int compare(Evaluation o1, Evaluation o2) {
            double evaluation1 = o1.getNote();
            double evaluation2 = o2.getNote();

            return comparaison(evaluation1,evaluation2);

        }

    };

    /**
     * trie les eleves selon leur moyenne dans l'odre croissant au sein de leur ArrayList
     * En cas d'abscence de note l'eleve est placé tout en bas de la liste, en première position
     */
    static final Comparator<Eleve> ordreMoyenneCroissant = new Comparator<Eleve>()
    {
        @Override
        public int compare(Eleve o1, Eleve o2) {

            double moyenne1 = o1.getMoyenne();
            double moyenne2 = o2.getMoyenne();


            return comparaison(moyenne1,moyenne2);
        }
    };
    /**
     * trie les eleves selon leur médiane dans l'odre croissant au sein de leur ArrayList
     * En cas d'abscence de note l'eleve est placé tout en bas de la liste, en première position
     */
    static final Comparator<Eleve> ordreMedianeCroissant = new Comparator<Eleve>()
    {
        @Override
        public int compare(Eleve o1, Eleve o2) {

            double mediane1 = o1.getMediane();
            double mediane2 = o2.getMediane();


            return comparaison(mediane1,mediane2);
        }
    };

    /**
     * Fonction qui permet de gérer les comparaisons, prend les deux elements à comparer en parametre
     * @param element1
     * @param element2
     * @return un entier qui diffère selon le résultat de la comparaison
     * 1 si le premier élément est plus grand que le second
     * -1 si c'est le contraire
     * 0 si les deux éléments sont égaux
     */
    static int comparaison(double element1, double element2)
    {
        if (element1>element2)
        {
            return 1;
        }
        else if (element1<element2)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

}
