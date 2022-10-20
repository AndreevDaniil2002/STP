package parent.classes;

public class Person {
    int Id;
    String Name;
    String Surname;
    String LastName;
    String Adress;
    String Email;

    public Person(int id, String name, String surname, String lastName, String adress, String email) {
        Id = id;
        Name = name;
        Surname = surname;
        LastName = lastName;
        Adress = adress;
        Email = email;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public static void AddingBook(Book book){

    }
}
