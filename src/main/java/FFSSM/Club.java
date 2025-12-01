package FFSSM;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

public class Club {

    @Getter @Setter
    public DiplomeDeMoniteur president;

    @Getter @Setter
    public String nom;

    @Getter @Setter
    public String adresse;

    @Getter @Setter
    public String telephone;

    // Liste des plongées organisées par le club
    private Set<Plongee> activites = new HashSet<>();

    public Club(DiplomeDeMoniteur president, String nom, String telephone) {
        this.president = president;
        this.nom = nom;
        this.telephone = telephone;
    }

    public Set<Plongee> plongeesNonConformes() {
        Set<Plongee> nonConformes = new HashSet<>();
        for (Plongee p : activites) {
            if (!p.estConforme()) {
                nonConformes.add(p);
            }
        }
        return nonConformes;
    }

    public void organisePlongee(Plongee p) {
        activites.add(p);
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }
}
