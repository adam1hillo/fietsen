package be.vdab.fietsen.docenten;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

interface DocentRepository extends JpaRepository<Docent, Long> {

    List<Docent> findByWeddeOrderByFamilienaam(BigDecimal wedde);
    Optional<Docent> findByEmailAdres(String emailAdres);
    int countByWedde(BigDecimal wedde);

}
