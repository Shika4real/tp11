package FFSSM;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

public class Licence {
    @Getter @Setter
    public Plongeur possesseur;

    public String numero;

    @Getter @Setter
    public LocalDate delivrance;

    @Getter @Setter
    public Club club;

    public Licence(Plongeur possesseur, String numero, LocalDate delivrance, Club club) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.club = club;
    }

    /**
     * Est-ce que la licence est valide à la date indiquée ?
     * Une licence est valide pendant un an à compter de sa date de délivrance
     */
    public boolean estValide(LocalDate d) {
        // La licence est valide de dateDélivrance inclus à dateDélivrance + 1 an exclus
        LocalDate finValidite = delivrance.plusYears(1);
        return !d.isBefore(delivrance) && d.isBefore(finValidite);
    }
}
