package FFSSM;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Embauche {

    private final LocalDate debut;
    private LocalDate fin;
    private DiplomeDeMoniteur employe;
    private Club employeur;

    public Embauche(LocalDate debut, DiplomeDeMoniteur employe, Club employeur) {
        this.debut = debut;
        this.employe = employe;
        this.employeur = employeur;
        this.fin = null; // Par défaut pas de fin
    }

    public boolean estTerminee() {
        return fin != null;
    }
}
