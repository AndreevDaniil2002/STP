package parent.classes;

import child.classes.Customer;

public class Statistic {
    Book book;
    Customer reader;
    boolean isAvailable;

    public Statistic(Book book, Customer reader, boolean isAvailable) {
        this.book = book;
        this.reader = reader;
        this.isAvailable = isAvailable;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getReader() {
        return reader;
    }

    public void setReader(Customer reader) {
        this.reader = reader;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
