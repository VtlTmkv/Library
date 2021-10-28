package library;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public final class MainTest {

    FileBooksFactory bookMock = Mockito.mock(FileBooksFactory.class);
    //загрружаем заполненный файл
    final static FileBooksFactory bookFactoryNotEmpty = new FileBooksFactory("/Users/vtltmkv/desktop/library/books.txt");
    //загружаем пустой файл, чтобы все ячейки были пустыми (null)
    final static FileBooksFactory bookFactoryEmpty = new FileBooksFactory("/Users/vtltmkv/desktop/library/books1.txt");
    //1 книгa
    final static FileBooksFactory bookFactory1Book = new FileBooksFactory("/Users/vtltmkv/desktop/library/book3.txt");

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    //Библиотека бросает исключение при создании, если ее вместимость меньше
    // чем количество книг, возвращаемое фабрикой.
    @Test(expected = LibraryIsFullException.class)
    public void testLibraryFactory() throws LibraryIsFullException {
        final Library lib=new Library(99,bookFactoryNotEmpty);
        thrown.expect(LibraryIsFullException.class);
    }

    //При создании библиотеки все книги расставлены по ячейкам в порядке как они возвращаются фабрикой книг.
    //Остальные ячейки пусты.
    @Test
    public void testCellsArragedInOrder() throws LibraryIsFullException{
        boolean actual=false;
        ArrayList <Book> bf= (ArrayList<Book>) bookFactoryNotEmpty.books();
        Library lib = new Library(100,bookFactoryNotEmpty);
        ArrayList<Book> libBooks= lib.getBooks();
        if(libBooks.equals(bf)){
            actual=true;
        }
        assertEquals(true,actual);
    }

    //При взятии книги информация о ней и ячейке выводится.
    @Test
    public void testTakeBook() throws LibraryIsFullException{
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Library lib = new Library(1, bookFactory1Book);
        lib.takeBook(0);
        ArrayList <Book> bk= (ArrayList<Book>) bookFactory1Book.books();
        String expect="0 : " + bk.get(0)+"\n";
        assertEquals(expect,output.toString());
        System.setOut(null);
    }

    //При попытке взять книгу из пустой ячейки библиотека бросает исключение.
    @Test(expected = NullPointerException.class)
    public void test() throws NullPointerException, LibraryIsFullException {
        final Library lib=new Library(10,bookFactoryEmpty);
        lib.takeBook(0);
    }

//    При взятии книги возвращается именно та книга, что была в этой ячейке.
    @Test
    public void testTakeBookIsThisBook() throws LibraryIsFullException{
        Library lib = new Library(1,bookFactory1Book);
        Book book=lib.takeBook(0);
        ArrayList <Book> bk= (ArrayList<Book>) bookFactory1Book.books();
        assertEquals(bk.get(0),book);
    }


//    При добавлении книги она размещается в первой свободной ячейке.
    @Test
    public void testAddBook() throws LibraryIsFullException{
        Library lib = new Library(bookFactoryNotEmpty.books().size(),bookFactoryNotEmpty);
        lib.takeBook(10);
        Book step1=lib.getBooks().get(10);
        lib.addBook(lib.getBooks().get(20));
        Book step2=lib.getBooks().get(10);
        assertEquals(step1,null);
        assertEquals(step2.getClass(),Book.class);
    }


//    Если при добавлении книги свободных ячеек нет, библиотека бросает исключение.
    @Test(expected = LibraryIsFullException.class)
    public void testNoEmptyCells() throws LibraryIsFullException {
        try {
            ArrayList<Book> bf = (ArrayList<Book>) bookFactoryNotEmpty.books();
            int size = bf.size();
            Library lib = new Library(size-1, bookFactoryNotEmpty);
            lib.addBook(bf.get(0));
        }
        catch (LibraryIsFullException e){
            throw e;
        }
    }

    //Вызов метода “напечатать в консоль содержимое” выводит информацию о содержимом ячеек библиотеки.
    @Test
    public void testPrintOut() throws LibraryIsFullException{
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Library lib = new Library(1, bookFactory1Book);
        lib.printOut();
        ArrayList <Book> bk= (ArrayList<Book>) bookFactory1Book.books();
        String expect="0 : " + bk.get(0).toString()+"\n";
        assertEquals(expect,output.toString());
        System.setOut(null);
    }
}
