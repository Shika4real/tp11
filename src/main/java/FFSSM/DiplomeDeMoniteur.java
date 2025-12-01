package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DiplomeDeMoniteur {

    private final int numeroDiplome;
    private final Plongeur possesseur;
    private final List<Embauche> embauches = new ArrayList<>();

    public DiplomeDeMoniteur(Plongeur possesseur, int numeroDiplome) {
        this.numeroDiplome = numeroDiplome;
        this.possesseur = possesseur;
    }

    public Club employeurActuel() {
        // On cherche la dernière embauche non terminée
        Optional<Embauche> embaucheActive = embauches.stream()
                .filter(e -> !e.estTerminee())
                .findFirst();
                
        return embaucheActive.map(Embauche::getEmployeur).orElse(null);
    }
    
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
        // Terminer l'embauche précédente si elle existe
        Club employeurActuel = employeurActuel();
        if (employeurActuel != null) {
             terminerEmbauche(debutNouvelle.minusDays(1));
        }
        
        Embauche nouvelle = new Embauche(debutNouvelle, this, employeur);
        embauches.add(nouvelle);
    }

    public void terminerEmbauche(LocalDate fin) {
        for (Embauche e : embauches) {
            if (!e.estTerminee()) {
                e.setFin(fin);
                return; // On ne termine que la courante
            }
        }
    }

    public List<Embauche> emplois() {
        return embauches;
    }
}
