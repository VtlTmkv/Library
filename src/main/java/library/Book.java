package library;

import lombok.Data;

public @Data
class Book {
    private Author author;
    private String name;

    @Override
    public String toString(){
        return "Book: "+author+" \""+name+"\"";
    }

}
