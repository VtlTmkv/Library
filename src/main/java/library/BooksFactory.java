package library;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.Collection;

public interface BooksFactory {
    public Collection<Book> books();
}
