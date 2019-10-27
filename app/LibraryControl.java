package app;

import io.DataReader;
import model.Book;
import model.Library;

public class LibraryControl{
    //zmienne do kontroli programu
    private static final int EXIT = 0;
    private static final int ADD_BOOK = 1;
    private static final int PRINT_BOOKS = 2;
    
    //zmienna do komunikacji z użytkownikiem
    private DataReader dataReader = new DataReader();
    
    //"biblioteka" przechowująca dane
    private Library library = new Library();
    
    /*
    * Główna metoda programu, która pozwala na wybó opcji i interakcję
    */
    
    public void controlLoop(){
        int option;
        
        do{
            printOptions();
            option = dataReader.getInt();
            switch(option){
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Nie ma takiej opcji, wprowadź ponownie");
            }
        }while(option != 0 );
    }
    
    private void printOptions(){
        System.out.println("Wybierz opcję: ");
        System.out.println(EXIT + " - wyjście z programu");
        System.out.println(ADD_BOOK + " - dodanie nowej książki");
        System.out.println(PRINT_BOOKS + " - wyświetl dostępne książki");
    }
    
    private void addBook(){
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }
    
    private void printBooks(){
        library.printBooks();
    }
    
    private void exit(){
        System.out.println("Zamykam program");
        //zamykamy strumień wejścia
        dataReader.close();
    }
}