package be.vdab.fietsen.docenten;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class TaakNietGevondenException extends RuntimeException{
    TaakNietGevondenException() {
        super("Taak niet gevonden");
    }
}
