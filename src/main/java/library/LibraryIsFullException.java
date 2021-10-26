package library;

public class LibraryIsFullException extends Exception{
    public LibraryIsFullException(String message){
        super(message);
    }
}
