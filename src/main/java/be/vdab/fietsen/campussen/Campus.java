package be.vdab.fietsen.campussen;

import be.vdab.fietsen.docenten.Docent;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name = "campussen")
public class Campus {
    @Id
    private long id;
    private String naam;
    @Embedded
    private Adres adres;

    @ElementCollection
    @CollectionTable(name = "huurprijzen",
    joinColumns = @JoinColumn(name = "campusId"))
    @OrderBy("vanaf")
    private Set<Huurprijs> huurprijzen;

    @OneToMany(mappedBy = "campus")
    @OrderBy("voornaam, familienaam")
    private Set<Docent> docenten;


    protected Campus() {
    }

    public Campus(String naam, Adres adres) {
        this.naam = naam;
        this.adres = adres;
        huurprijzen = new LinkedHashSet<>();
        docenten = new LinkedHashSet<>();
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Adres getAdres() {
        return adres;
    }
    public Set<Huurprijs> getHuurprijzen() {
        return Collections.unmodifiableSet(huurprijzen);
    }

    public Set<Docent> getDocenten() {
        return Collections.unmodifiableSet(docenten);
    }
    public void voegDocentToe(Docent docent) {
        if (!docenten.add(docent)) {
            throw new CampusHeeftDezeDocentAlException();
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Campus campus)) return false;
        return naam.equalsIgnoreCase(campus.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam.toLowerCase());
    }
}
