package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Plongeur extends Personne {
    
    private int niveau;
    private final List<Licence> licences = new ArrayList<>();

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
    }

    public void ajouteLicence(String numero, LocalDate delivrance, Club club) {
        Licence l = new Licence(this, numero, delivrance, club);
        licences.add(l);
    }
    
    /**
     * Vérifie si le plongeur a une licence valide à la date donnée
     */
    public boolean aLicenceValide(LocalDate date) {
        for (Licence l : licences) {
            if (l.estValide(date)) {
                return true;
            }
        }
        return false;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
}
