package be.vdab.fietsen.docenten;

import be.vdab.fietsen.campussen.Campus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "docenten")
public class Docent {

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

    @ElementCollection
    @CollectionTable(name = "bijnamen", joinColumns = @JoinColumn(name = "docentId"))
    @Column(name = "bijnaam")
    private Set<String> bijnamen;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "campusId")
    private Campus campus;

    @ManyToMany(mappedBy = "docenten")
    @OrderBy("naam")
    private Set<Taak> taken;


    protected Docent(){

    }
    public Docent(String voornaam, String familienaam, BigDecimal wedde, String emailAdres, Geslacht geslacht, Campus campus) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.wedde = wedde;
        this.emailAdres = emailAdres;
        this.geslacht = geslacht;
        this.campus = campus;
        bijnamen = new LinkedHashSet<>();
        taken = new LinkedHashSet<>();
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

    void setWedde(BigDecimal wedde) {
        this.wedde = wedde;
    }

    public BigDecimal getWedde() {
        return wedde;
    }

    public String getEmailAdres() {
        return emailAdres;
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    void voegBijnaamToe(String bijnaam) {
        if (!bijnamen.add(bijnaam)) {
            throw new DocentHeeftDezeBijnaamAlException();
        }
    }
    void verwijderBijnaam(String bijnaam) {
        bijnamen.remove(bijnaam);
    }
    public Set<String> getBijnamen() {
        return Collections.unmodifiableSet(bijnamen);
    }

    public Campus getCampus() {
        return campus;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Docent docent && emailAdres.equalsIgnoreCase(docent.emailAdres);
    }
    @Override
    public int hashCode() {
        return emailAdres.toLowerCase().hashCode();
    }

    void add(Taak taak) {
        if (!taken.add(taak)) {
            throw new DocentHeeftDezeTaakAlException();
        }
    }
    public Set<Taak> getTaken() {
        return Collections.unmodifiableSet(taken);
    }
}
