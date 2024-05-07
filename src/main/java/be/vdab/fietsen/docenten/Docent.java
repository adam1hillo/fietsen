package be.vdab.fietsen.docenten;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "docenten")
public class Docent {

    @Id
    private long id;
    private String voornaam;
    private String familienaam;
    private BigDecimal wedde;
    private String emailAdres;
    @Enumerated(EnumType.STRING)
    private Geslacht geslacht;

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public String getEmailAdres() {
        return emailAdres;
    }

    public long getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public BigDecimal getWedde() {
        return wedde;
    }
}
