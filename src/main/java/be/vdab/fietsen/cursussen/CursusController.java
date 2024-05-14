package be.vdab.fietsen.cursussen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cursussen")
class CursusController {
    private final CursusService cursusService;

    CursusController(CursusService cursusService) {
        this.cursusService = cursusService;
    }
    @GetMapping
    List<Cursus> findAll() {
        return cursusService.findAll();
    }
    @GetMapping("groep")
    List<GroepsCursus> findGroepsCursussen() {
        return cursusService.findGroepsCursussen();
    }
    @GetMapping("individueel")
    List<IndividueleCursus> findIndividueleCurssusen() {
        return cursusService.findIndividueleCurssusen();
    }
}
