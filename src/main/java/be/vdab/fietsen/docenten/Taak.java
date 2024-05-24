package be.vdab.fietsen.docenten;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "taken")
public class Taak {
    @Id
    private long id;
    private String naam;
    @ManyToMany
    @JoinTable(
            name = "docententaken",
            joinColumns = @JoinColumn(name = "taakId"),
            inverseJoinColumns = @JoinColumn(name = "docentId"))
    @OrderBy("voornaam, familienaam")
    private Set<Docent> docenten;

    protected Taak() {}
    public Taak(String naam) {
        this.naam = naam;
        docenten = new LinkedHashSet<>();
    }
    void add(Docent docent) {
        if (!docenten.add(docent)) {
            throw new DocentHeeftDezeTaakAlException();
        }
    }
    Set<Docent> getDocenten() {
        return Collections.unmodifiableSet(docenten);
    }

    long getId() {
        return id;
    }

    String getNaam() {
        return naam;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Taak taak && naam.equalsIgnoreCase(taak.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(naam.toLowerCase());
    }
}
