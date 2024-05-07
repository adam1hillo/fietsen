package be.vdab.fietsen.docenten;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
class DocentBestaatAlException extends RuntimeException{
    DocentBestaatAlException() {
        super("Docent bestaat al.");
    }
}
