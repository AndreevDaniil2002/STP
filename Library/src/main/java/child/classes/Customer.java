package child.classes;

import parent.classes.Book;
import parent.classes.Person;

public class Customer extends Person {
    public Customer(int id, String name, String surname, String lastName, String adress, String email) {
        super(id, name, surname, lastName, adress, email);
    }

    public static void setRatingToBook(Book book, int rating){
        book.setRating(rating);
    }
}
