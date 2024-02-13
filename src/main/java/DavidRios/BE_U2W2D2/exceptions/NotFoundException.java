package DavidRios.BE_U2W2D2.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException (long id) {
        super("Il post n. " + id + " non è stato trovato.");
    }
}
