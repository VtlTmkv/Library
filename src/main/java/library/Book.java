package library;

import lombok.Data;

public @Data
class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public String toString(){
        return "Book: "+author+" \""+title+"\" "+year;
    }

}
