package child.classes;

import parent.classes.Person;

public class Employee extends Person {
    public Employee(int id, String name, String surname, String lastName, String adress, String email) {
        super(id, name, surname, lastName, adress, email);
    }
}
