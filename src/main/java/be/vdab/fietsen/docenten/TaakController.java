package be.vdab.fietsen.docenten;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("taken")
class TaakController {
    private final TaakService taakService;

    TaakController(TaakService taakService) {
        this.taakService = taakService;
    }

    @GetMapping("{id}/docenten")
    Stream<DocentBeknopt> findDocentenMetTaak(@PathVariable long id) {
        return taakService.findById(id)
                .orElseThrow(TaakNietGevondenException::new)
                .getDocenten()
                .stream()
                .map(DocentBeknopt::new);
    }


    record DocentBeknopt(long id, String voornaam, String familienaam) {
        DocentBeknopt(Docent docent) {
            this(docent.getId(), docent.getVoornaam(), docent.getFamilienaam());
        }
    }
}
