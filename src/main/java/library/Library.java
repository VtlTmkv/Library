package library;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.ArrayList;

public class Library {
    private int cells;
    private BooksFactory bf;
    private ArrayList<Book> books=new ArrayList<Book>();

    @Inject
    public Library(@NotNull int cells,@NotNull FileBooksFactory bf){
        this.cells=cells;
        this.bf=bf;
        ArrayList <Book> buffer= (ArrayList<Book>) bf.books();
        try {
            int counter=0;
            for(Book bk:buffer){
                if(counter<=cells){
                    books.add(bk);
                    counter++;
                }
                else throw new LibraryIsFullException("The library is too small");
            }
        } catch (LibraryIsFullException e) {
            e.printStackTrace();
        }
    }

    public void takeBook(int cellNum){
        //выводится номер ячейки и инфа о книге

        System.out.println(String.valueOf(cellNum)+" : "+books.get(cellNum).toString());
        books.set(cellNum,null);
    }

    public void addBook(Book book) throws Exception {
        //добавляем книгу в библиотеку
        try {
            int counter=0;
            for(Book bk:books){
                if(bk==null&&counter<=cells){
                    books.set(counter,book);
                    break;
                }else if(counter>cells) throw new LibraryIsFullException("Library is full, you cannot add more books");
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
            System.out.println(i+" : "+book.toString());
            i++;
        }
    }

}
