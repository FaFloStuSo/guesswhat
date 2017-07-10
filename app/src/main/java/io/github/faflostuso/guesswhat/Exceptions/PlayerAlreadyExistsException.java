package io.github.faflostuso.guesswhat.Exceptions;

/**
 * Created by florian on 10.07.17.
 */

public class PlayerAlreadyExistsException extends Exception {
    String msg;

    public PlayerAlreadyExistsException(){}

    public PlayerAlreadyExistsException(String msg){
        super(msg);
    }

    public PlayerAlreadyExistsException(Throwable cause){
        super(cause);
    }

    public PlayerAlreadyExistsException(String msg, Throwable cause){
        super(msg, cause);
    }
}
