package be.vdab.fietsen.docenten;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface TaakRepository extends JpaRepository<Taak, Long> {
}
