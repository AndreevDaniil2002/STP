package parent.classes;

import child.classes.Customer;
import child.classes.Employee;
import child.classes.Manager;
import enums.com.Kategories;

import javax.naming.InitialContext;
import java.util.*;

public class Library {

    public static ArrayList<Book> books = new ArrayList<>();
    public static ArrayList<Statistic> statistics = new ArrayList<>();
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static void main(String[] args) {
        Employee employee = new Employee(0, "Ivan", "Ivanov", "Ivanovich", "Moscow, Sneznaua 17", "lol@gmail.com");
        Customer customer_Anrdey = new Customer(1, "Andrey", "Andreev", "Andreevich", "Moscow, Rusanova 5", "207792@fa.ru");
        Customer customer_Sasha = new Customer(2, "Sasha", "Aleksandrov", "Aleksandrovich", "Moscow, Krutaya 11", "vlados@bk.ru");
        Customer nullCustomer = new Customer(0, "", "", "", "", "");
        Manager manager = new Manager(1, "Kostya", "Konstantinov", "Konstantinovich", "Moscow, Plohaya 2", "KostyaBig@mail.com");
        Book prestuplenie = new Book(1, "Prestuplenie i nakazanie", "Dostaevskiy", 2010, "Danya", 1840, Kategories.Roman, 0);
        Book PotniyGarry = new Book(2, "Garry Potter", "Rouling", 2019, "Olya", 1985, Kategories.Fantasy, 0);
        Book LordOfTheRings = new Book(3, "LordOfTheRings", "Tolkien", 2015, "Vlad", 1954, Kategories.Science_fiction, 0);
        Book nullbook = new Book(0, "", "", 0, "", 0, Kategories.Travel_books, 0);
        Statistic s1 = new Statistic(prestuplenie, employee);
        Statistic s2 = new Statistic(PotniyGarry, employee);
        Statistic s3 = new Statistic(LordOfTheRings, employee);

        books.add(prestuplenie);
        books.add(PotniyGarry);
        books.add(LordOfTheRings);

        statistics.add(s1);
        statistics.add(s2);
        statistics.add(s3);

        customers.add(customer_Anrdey);
        customers.add(customer_Sasha);

        int id = 0;
        System.out.println("Рады приветствовать вас в нашей библиотеке, вы кто?");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Менеджер\n2. Сотрудник\n3.Читатель");
            int choice = 0;
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Добрый день " + manager.getName() + " " + manager.getSurname());
                    int managers_choice = 0;
                    while (managers_choice != 6){
                        System.out.println("Скажите, что вы хотите сделать?");
                        System.out.println("1. Удалить книгу\n2. Посмотреть сколько книг в библиотеке, а сколько у читателей" +
                                "\n3. Посмотреть сколько книг в определенном жанре\n4. Посмотреть какие книги у конкретного читателя?" +
                                "\n5. Добавить новую книгу\n6. Вернуться назад");
                        managers_choice = Integer.parseInt(scanner.nextLine());
                        switch (managers_choice){
                            case 1:
                                System.out.println("Введите id книги которую хотите удалить");
                                int book_id = Integer.parseInt(scanner.nextLine());
                                Manager.DeleteBook(book_id);
                                break;
                            case 2:
                                Manager.HowMany();
                                break;
                            case 3:
                                System.out.println("Выберете жанр: ");
                                System.out.println(Arrays.toString(Kategories.values()));
                                String kategory = scanner.nextLine();
                                Manager.HowmanyThemes(Kategories.valueOf(kategory));
                                break;
                            case 4:
                                System.out.println("Введите id пользователя, у которого хотите посмотреть книги");
                                int user_id = Integer.parseInt(scanner.nextLine());
                                for (Customer customer : customers) {
                                    if (customer.getId() == user_id) {
                                        Manager.WhichBooksUCastomer(customer);
                                    }
                                }
                                break;
                            case 5:
                                System.out.println("Введите данные о книге в данном порядке: название, автор, издание, издатель, год, категорию");
                                String [] data = scanner.nextLine().split( " ");
                                Manager.AddBook(id, data[0], data[1], Integer.parseInt(data[2]), data[3],
                                        Integer.parseInt(data[4]), Kategories.valueOf(data[5]), 0);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Добрый день " + employee.getName() + " " + employee.getSurname());
                    int employees_choice = 0;
                    while (employees_choice != 6){
                        System.out.println("Скажите, что вы хотите сделать?");
                        System.out.println("1. Найти книгу по названию\n2. Найти книгу по Автору" +
                                "\n3. Найти книгу по году создания\n4. Выдать книгу читателю" +
                                "\n5. Вернуть книгу в библиотеку\n6. Вернуться назад");
                        employees_choice = Integer.parseInt(scanner.nextLine());
                        switch (employees_choice){
                            case 1:
                                String book_name = scanner.nextLine();
                                Employee.findBookByName(book_name);
                                break;
                            case 2:
                                String book_author = scanner.nextLine();
                                Employee.findBookByAuthor(book_author);
                                break;
                            case 3:
                                int year = Integer.parseInt(scanner.nextLine());
                                Employee.findBookByYear(year);
                                break;
                            case 4:
                                System.out.println("введите название книги, чтобы выдать ее читателю");
                                String book_name_to_give = scanner.nextLine();
                                System.out.println("введите автора книги, чтобы выдать ее читателю");
                                String book_author_to_give = scanner.nextLine();
                                System.out.println("введите id читателя");
                                int user_id_to_give = Integer.parseInt(scanner.nextLine());
                                Book boook = nullbook;
                                Customer cuustomer = nullCustomer;
                                for (Book book : books) {
                                    if (Objects.equals(book.getName(), book_name_to_give) && Objects.equals(book.getAuthor(), book_author_to_give)) {
                                        boook = book;
                                    }
                                }

                                for (Customer customer: customers){
                                    if (customer.getId() == user_id_to_give) {
                                        cuustomer = customer;
                                    }
                                }
                                if (cuustomer != nullCustomer && boook != nullbook)
                                    Employee.giveBookToCustomer(boook, cuustomer);
                                else
                                    System.out.println("Вы ввели неверные данные");
                                break;
                            case 5:
                                System.out.println("введите название книги, чтобы вернуть ее");
                                String book_name_to_return = scanner.nextLine();
                                System.out.println("введите автора книги,, чтобы вернуть ее");
                                String book_author_to_return = scanner.nextLine();
                                Book booook = nullbook;
                                for (Book book : books) {
                                    if (Objects.equals(book.getName(), book_name_to_return) && Objects.equals(book.getAuthor(), book_author_to_return)) {
                                        booook = book;
                                    }
                                }

                                if (booook != nullbook)
                                    Employee.giveBookToCustomer(booook, employee);
                                else
                                    System.out.println("Вы ввели неверные данные");
                                break;
                        }
                    }
                    break;
                case 3:
                    int customers_choice = 0;
                    while (customers_choice != 3) {
                        System.out.println("Вы новый пользователь? 1 - да, 2 - нет, 3 - вернуться назад");
                        customers_choice = Integer.parseInt(scanner.nextLine());
                        switch (customers_choice) {
                            case 1:
                                System.out.println("Рады вас видеть в нашей библиотеке, представьтесь пожалуйста");
                                System.out.println("Имя");
                                String name = scanner.nextLine();
                                System.out.println("Фамилия");
                                String surname = scanner.nextLine();
                                System.out.println("Отчество");
                                String Lastname = scanner.nextLine();
                                System.out.println("Адрес");
                                String adress = scanner.nextLine();
                                System.out.println("Почта");
                                String email = scanner.nextLine();
                                Manager.AddNewUser(id, name, surname, Lastname, adress, email);
                                break;
                            case 2:
                                int customer_choice_2 = 0;
                                while (customer_choice_2 != 4) {
                                    System.out.println("Что вы хотите сделать?");
                                    System.out.println("1. Взять книгу\n2.Вернуть книгу\n3.Выставить рейтинг книге\n4.Вернуться назад");
                                    customer_choice_2 = Integer.parseInt(scanner.nextLine());
                                    switch (customer_choice_2){
                                        case 1:
                                            System.out.println("введите название книги, чтобы выдать ее читателю");
                                            String book_name_to_give = scanner.nextLine();
                                            System.out.println("введите автора книги, чтобы выдать ее читателю");
                                            String book_author_to_give = scanner.nextLine();
                                            System.out.println("введите свой id");
                                            int user_id_to_give = Integer.parseInt(scanner.nextLine());
                                            Book boook = nullbook;
                                            Customer cuustomer = nullCustomer;
                                            for (Book book : books) {
                                                if (Objects.equals(book.getName(), book_name_to_give) && Objects.equals(book.getAuthor(), book_author_to_give)) {
                                                    boook = book;
                                                }
                                            }

                                            for (Customer customer: customers){
                                                if (customer.getId() == user_id_to_give) {
                                                    cuustomer = customer;
                                                }
                                            }
                                            if (cuustomer != nullCustomer && boook != nullbook)
                                                Employee.giveBookToCustomer(boook, cuustomer);
                                            else
                                                System.out.println("Вы ввели неверные данные");
                                            break;
                                        case 2:
                                            System.out.println("введите название книги, чтобы вернуть ее");
                                            String book_name_to_return = scanner.nextLine();
                                            System.out.println("введите автора книги,, чтобы вернуть ее");
                                            String book_author_to_return = scanner.nextLine();
                                            Book booook = nullbook;
                                            for (Book book : books) {
                                                if (Objects.equals(book.getName(), book_name_to_return) && Objects.equals(book.getAuthor(), book_author_to_return)) {
                                                    booook = book;
                                                }
                                            }

                                            if (booook != nullbook)
                                                Employee.giveBookToCustomer(booook, employee);
                                            else
                                                System.out.println("Вы ввели неверные данные");
                                            break;
                                        case 3:
                                            System.out.println("Введите название книги");
                                            String book_name = scanner.nextLine();
                                            System.out.println("Введите рейтинг от 1 до 5");
                                            int rating = Integer.parseInt(scanner.nextLine());

                                            Book boooooook = nullbook;

                                            for (int i = 0; i < books.size(); i++){
                                                if(books.get(i).getName() == book_name){
                                                    books.get(i).setRating(rating);
                                                }
                                            }

                                            break;


                                    }
                                }
                        }
                    }
            }
        }
    }
}
