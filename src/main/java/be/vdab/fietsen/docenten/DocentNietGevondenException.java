package be.vdab.fietsen.docenten;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class DocentNietGevondenException extends RuntimeException{
    DocentNietGevondenException() {
        super("Docent niet gevonden.");
    }
}
