package be.vdab.fietsen.docenten;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
class EenAndereGebruikerWijzigdeDeDocentException extends RuntimeException{
    EenAndereGebruikerWijzigdeDeDocentException() {
        super("Een andere gebruiker wijzigde de docent.");
    }
}
