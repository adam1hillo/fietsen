package be.vdab.fietsen.campussen;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
class CampusHeeftDezeDocentAlException extends RuntimeException{
    CampusHeeftDezeDocentAlException() {
        super("Campus heeft deze docent al.");
    }
}
