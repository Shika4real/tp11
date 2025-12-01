package FFSSM;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Plongee {

    public Site lieu;
    public DiplomeDeMoniteur chefDePalanquee;
    public LocalDate date;
    public int profondeur;
    public int duree;
    
    // Liste des participants
    private Set<Plongeur> palanquee = new HashSet<>();

    public Plongee(Site lieu, DiplomeDeMoniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
    }

    public void ajouteParticipant(Plongeur participant) {
        palanquee.add(participant);
    }

    public boolean estConforme() {
        // La plongée est conforme si tous les participants ont une licence valide à la date de la plongée
        for (Plongeur p : palanquee) {
            if (!p.aLicenceValide(this.date)) {
                return false;
            }
        }
        return true;
    }
}
