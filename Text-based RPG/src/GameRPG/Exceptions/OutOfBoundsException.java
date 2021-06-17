package GameRPG.Exceptions;

public class OutOfBoundsException extends RuntimeException{
    private String message = "You hit your head on a wall.";

    public OutOfBoundsException () {
        super(message);
    }
}
