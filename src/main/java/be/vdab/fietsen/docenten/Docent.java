package be.vdab.fietsen.docenten;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "docenten")
class Docent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String voornaam;
    private String familienaam;
    private BigDecimal wedde;
    private String emailAdres;
    @Enumerated(EnumType.STRING)
    private Geslacht geslacht;

    @Version
    private long versie;

    protected Docent() {}

    Docent(String voornaam, String familienaam, BigDecimal wedde, String emailAdres, Geslacht geslacht) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.wedde = wedde;
        this.emailAdres = emailAdres;
        this.geslacht = geslacht;
    }

    void setWedde(BigDecimal wedde) {
        this.wedde = wedde;
    }

    Geslacht getGeslacht() {
        return geslacht;
    }

    String getEmailAdres() {
        return emailAdres;
    }

    long getId() {
        return id;
    }

    String getVoornaam() {
        return voornaam;
    }

    String getFamilienaam() {
        return familienaam;
    }

    BigDecimal getWedde() {
        return wedde;
    }
}
