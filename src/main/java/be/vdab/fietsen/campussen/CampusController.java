package be.vdab.fietsen.campussen;

import be.vdab.fietsen.docenten.Docent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("campussen")
public class CampusController {
    private final CampusService campusService;

    public CampusController(CampusService campusService) {
        this.campusService = campusService;
    }

    @GetMapping("westvlaams")
    Stream<CampusBeknopt> findWestVlaamse() {
        return campusService.findWestVlaamse()
                .stream()
                .map(CampusBeknopt::new);
    }
    @GetMapping("{id}/docenten")
    Stream<DocentBeknopt> findDocentenVan(@PathVariable long id) {
        return campusService.findById(id)
                .orElseThrow(CampusNietGevondenException::new)
                .getDocenten()
                .stream()
                .map(DocentBeknopt::new);
    }

    private record CampusBeknopt(long id, String naam, Adres adres) {
        CampusBeknopt(Campus campus) {
            this(campus.getId(), campus.getNaam(), campus.getAdres());
        }
    }
    private record DocentBeknopt(long id, String voornaam, String familienaam) {
        DocentBeknopt(Docent docent) {
            this(docent.getId(), docent.getVoornaam(), docent.getFamilienaam());
        }
    }
}
