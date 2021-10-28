package library;


import javax.inject.Inject;
import java.util.Collection;

public class StandartBookFactory implements BooksFactory {

    @Inject
    public Book createBook(){
        return new Book();
    }

    @Override
    public Collection<Book> books() {
        return null;
    }
}
