package library;

import java.util.Scanner;

public class LibraryFactory {
    Scanner scan =new Scanner(System.in);
    String path;
    Library lib;
    public Library createLibrary(int cells){
        System.out.println("Введите путь к файлу");
        path=scan.nextLine();
        FileBooksFactory fbf = new FileBooksFactory(path);
        try {
             lib = new Library(cells, fbf);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return lib;
    }
}
