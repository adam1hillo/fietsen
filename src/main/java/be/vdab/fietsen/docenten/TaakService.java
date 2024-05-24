package be.vdab.fietsen.docenten;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
class TaakService {
    private final TaakRepository taakRepository;

    TaakService(TaakRepository taakRepository) {
        this.taakRepository = taakRepository;
    }

    Optional<Taak> findById(long id) {
        return taakRepository.findById(id);
    }
}
