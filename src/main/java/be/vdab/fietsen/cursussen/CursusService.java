package be.vdab.fietsen.cursussen;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
class CursusService {

    private final CursusRepository cursusRepository;

    CursusService(CursusRepository cursusRepository) {
        this.cursusRepository = cursusRepository;
    }

    List<Cursus> findAll() {
        return cursusRepository.findAll();
    }

    List<GroepsCursus> findGroepsCursussen() {
        return cursusRepository.findGroepsCursussen();

    }
    List<IndividueleCursus> findIndividueleCursussen() {
        return cursusRepository.findIndividueleCursussen();
    }
}
