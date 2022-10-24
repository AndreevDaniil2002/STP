package child.classes;

import enums.com.Kategories;
import parent.classes.Book;
import parent.classes.Library;
import parent.classes.Person;

public class Manager extends Person {
    public Manager(int id, String name, String surname, String lastName, String adress, String email) {
        super(id, name, surname, lastName, adress, email);
    }

    public static void AddBook(int id, String name, String author, int izdanie, String publisher, int year, Kategories kategory, int rating){
        Book book = new Book(id, name, author, izdanie, publisher, year, kategory, rating);
        Library.books.add(book);
    }

    public static void DeleteBook(int id){
        int j = 0;
        for (int i = 0; i < Library.books.size(); i++){
            if (Library.books.get(i).getId() == id)
                j = i;
        }
        Library.books.remove(j);

        for (int i = 0; i < Library.statistics.size(); i++){
            if (Library.statistics.get(i).getBook().getId() == id){
                j = i;
            }
        }
        Library.statistics.remove(j);

    }

    public static void HowMany(){
        int u_customer = 0;
        int u_library = 0;
        for (int i = 0; i < Library.statistics.size(); i++){
            if (Library.statistics.get(i).getReader().getId() == 0){
                u_library++;
            }
            else {
                u_customer++;
            }
        }
        System.out.println("У читателей: " + u_customer + " В бибилиотеке: " + u_library);
    }

    public static void HowmanyThemes(Kategories kategories){
        int count = 0;
        for (int i = 0; i < Library.statistics.size(); i++) {
            if (Library.statistics.get(i).getBook().getKategory() == kategories) {
                count++;
            }
        }
        System.out.println("У нас есть " + count + " книги в жанре " + kategories);
    }

    public static void WhichBooksUCastomer(Person customer){
        int j = 0;
        for (int i = 0; i < Library.statistics.size(); i++){
            if (Library.statistics.get(i).getReader() == customer){
                System.out.println("У читателя " + customer.getName() + " " + customer.getSurname() + " есть книга " + Library.statistics.get(i).getBook().getName());
                j++;
            }
        }
        if (j==0){
            System.out.println("У читателя " + customer.getName() + " " + customer.getSurname() + " нет книг");
        }
    }

    public static void AddNewUser(int id, String name, String surname, String lastName, String adress, String email){
        Customer customer = new Customer(id, name, surname, lastName, adress, email);
        Library.customers.add(customer);
    }

}
