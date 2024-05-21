package be.vdab.fietsen.campussen;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.LinkedHashSet;
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

    protected Campus() {
    }

    public Campus(long id, String naam, Adres adres) {
        this.id = id;
        this.naam = naam;
        this.adres = adres;
        huurprijzen = new LinkedHashSet<>();
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
}
