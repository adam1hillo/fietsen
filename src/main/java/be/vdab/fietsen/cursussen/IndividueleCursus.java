package be.vdab.fietsen.cursussen;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "individuelecursussen")
class IndividueleCursus extends Cursus{
    private int duurtijd;

    int getDuurtijd() {
        return duurtijd;
    }
}
