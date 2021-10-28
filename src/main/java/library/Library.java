package library;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;

import javax.inject.Inject;
import java.util.ArrayList;

public class Library {
    private int cells;
    private BooksFactory bf;
    private ArrayList<Book> books=new ArrayList<Book>();

    @Inject
    public Library(@NotNull int cells,@NotNull FileBooksFactory bf) throws LibraryIsFullException {
        this.cells=cells;
        this.bf=bf;
        int counter=0;
        ArrayList <Book> buffer= (ArrayList<Book>) bf.books();
        try {
            if(buffer.size()>cells) throw new LibraryIsFullException("The library is too small");
            else if(books.size()<cells){
                for (Book bk : buffer) {
                    books.add(bk);
                    counter++;
                }
                while (books.size()<cells){
                    books.add(null);
                }
            }
            else throw new LibraryIsFullException("The library is too small");
        } catch (LibraryIsFullException e) {
            throw e;
        }
    }

    public Book takeBook(int cellNum)  {
        //выводится номер ячейки и инфа о книге
        //если ячейка пустая, выбрасывается исклчение
        if (books.get(cellNum)!=null) {
            System.out.println(String.valueOf(cellNum) + " : " + books.get(cellNum).toString());
            Book book=books.get(cellNum);
            books.set(cellNum, null);
            return book;
        }
        else{
            throw new NullPointerException();
        }
    }

    public void addBook(Book book) throws LibraryIsFullException {
        //добавляем книгу в библиотеку
        try {
            int counter=0;
            for(Book bk:books){
                if(bk==null&&counter<cells-1){
                    books.set(counter,book);
                    break;
                }else if(counter>=cells) throw new LibraryIsFullException("Library is full, you cannot add more books");
                counter++;
            }
        }
        catch (LibraryIsFullException e){
            e.printStackTrace();
        }
    }
    //выводим содержание
    public void printOut(){
        int i=0;
        for(Book book:books){
            if(book!=null) {
                System.out.println(i + " : " + book.toString());
            }
            //если строка null - выводим empty
            else {
                System.out.println(i+" empty");
            }
            i++;
        }
    }

    @TestOnly
    public ArrayList<Book> getBooks(){
        return books;
    }

}
