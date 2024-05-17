package be.vdab.fietsen.docenten;

class DocentHeeftDezeBijnaamAlException extends RuntimeException{
    DocentHeeftDezeBijnaamAlException() {
        super("Docent heeft deze bijnaam al.");
    }
}
