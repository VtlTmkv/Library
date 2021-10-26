package library;

import javax.inject.Inject;
import java.io.File;
import java.util.Scanner;

public class LibraryFactory {
    Scanner scan =new Scanner(System.in);
    String path;
    public Library createLibrary(int cells){
        System.out.println("Введите путь к файлу");
        path=scan.nextLine();
        FileBooksFactory fbf = new FileBooksFactory(path);
        Library lib=new Library(cells, fbf);
        return lib;
    }
}
