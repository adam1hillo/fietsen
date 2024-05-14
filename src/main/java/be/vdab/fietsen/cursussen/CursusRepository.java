package be.vdab.fietsen.cursussen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

interface CursusRepository extends JpaRepository<Cursus, UUID> {

    @Query("select g from GroepsCursus g")
    List<GroepsCursus> findGroepsCursussen();
    @Query("select i from IndividueleCursus i")
    List<IndividueleCursus> findIndividueleCursussen();
}
