package be.vdab.fietsen.cursussen;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

abstract class Cursus {
    @Id
    private UUID id;
    private String naam;

    public UUID getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
