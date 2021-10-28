package library;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jetbrains.annotations.NotNull;


import java.util.Scanner;

public class Main {
    public static void main(@NotNull String[] args) {
        Scanner scan =new Scanner(System.in);
        final Injector injector = Guice.createInjector(new MainModule());
        int capacity;
        System.out.println("Введите размер библиотеки:");
        capacity=scan.nextInt();
        LibraryFactory ld=injector.getInstance(LibraryFactory.class);
        ld.createLibrary(capacity).printOut();

    }
}
