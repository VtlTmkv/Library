package library;

import java.util.Scanner;

public class LibraryFactory {
    Scanner scan =new Scanner(System.in);
    String path;
    public Library createLibrary(int cells){
        System.out.println("Введите путь к файлу");
        path=scan.nextLine();
        Library lib=new Library(cells, new FileBooksFactory(path));
        return lib;
    }
}
