package library;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.ArrayList;

public class Library {
    private int cells;
    private BooksFactory bf;
    private ArrayList<Book> books;

    @Inject
    public Library(@NotNull int cells,@NotNull FileBooksFactory bf){
        this.cells=cells;
        this.bf=bf;
        books= (ArrayList<Book>) bf.books();
    }

    public void takeBook(int cellNum){
        //выводится номер ячейки и инфа о книге
        System.out.println(String.valueOf(cellNum)+" : "+books.get(cellNum).toString());
    }

    public void addBook(Book book) throws Exception {
        //добавляем книгу в библиотеку
        try {

        }
        catch (Exception e){

        }
    }
    //выводим содержание
    public void printOut(){
        int i=0;
        for(Book book:books){
            System.out.println(i+" : "+book.toString());
        }
    }

}
