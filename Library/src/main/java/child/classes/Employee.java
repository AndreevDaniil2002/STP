package child.classes;

import parent.classes.Book;
import parent.classes.Library;
import parent.classes.Person;
import parent.classes.Statistic;

import java.util.Objects;

public class Employee extends Person {
    public Employee(int id, String name, String surname, String lastName, String adress, String email) {
        super(id, name, surname, lastName, adress, email);
    }

    public static void findBookByName (String name){
        int count = 0;
        for (int i = 0; i < Library.books.size(); i++){
            if (Objects.equals(Library.books.get(i).getName(), name)){
                System.out.println("книга с названием " + name + " есть, данные о книге " + Library.books.get(i).getName()
                        + ": Автор " + Library.books.get(i).getAuthor() + " Издание " + Library.books.get(i).getIzdanie()
                        + " рейтинг " + Library.books.get(i).getRating());
                count++;
            }
        }
        if (count == 0){
            System.out.println("Книги с таким названием нет");
        }
    }

    public static void findBookByAuthor (String author){
        int count = 0;
        for (int i = 0; i < Library.books.size(); i++){
            if (Objects.equals(Library.books.get(i).getAuthor(), author)){
                System.out.println("книга с названием " + Library.books.get(i).getName() + " есть, данные о книге " + Library.books.get(i).getName()
                        + ": Автор " + Library.books.get(i).getAuthor() + " Издание " + Library.books.get(i).getIzdanie()
                        + " рейтинг " + Library.books.get(i).getRating());
                count++;
            }
        }
        if (count == 0){
            System.out.println("Книги с таким автором нет");
        }
    }

    public static void findBookByYear (int year){
        int count = 0;
        for (int i = 0; i < Library.books.size(); i++){
            if (Objects.equals(Library.books.get(i).getYear(), year)){
                System.out.println("книга с названием " + Library.books.get(i).getName() + " есть, данные о книге " + Library.books.get(i).getName()
                        + ": Автор " + Library.books.get(i).getAuthor() + " Издание " + Library.books.get(i).getIzdanie()
                        + " рейтинг " + Library.books.get(i).getRating());
                count++;
            }
        }
        if (count == 0){
            System.out.println("Книги, написанной в этом году");
        }
    }

    public static void giveBookToCustomer(Book book, Person customer){
        int j = 0;
        for (int i = 0; i < Library.statistics.size(); i++){
            if (Library.statistics.get(i).getBook() == book && Library.statistics.get(i).getReader().getId() != 0){
                Library.statistics.get(i).setReader(customer);
                j++;
            }
        }
        if (j == 0){
            System.out.println("Такой книги нет, не могу ее вам выдать");
        }
    }

    public static void returnBooktoLibrary(Book book, Employee employee){
        Library.statistics.add(new Statistic(book, employee));
    }
}
