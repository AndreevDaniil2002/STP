package org.example;

import java.util.Arrays;

public class MyApp {
    static Employee[] employees = new Employee[5];
    static int id = 0;

    public static void main(String[] args) {
        Employee Juan = new Employee("Juan", "Vardos");
        Juan.setId(id += 1);
        Juan.setBirthYear(1996);
        Juan.setBirthPlace("Italia");
        Juan.setFee(1000);
        Juan.setStatus("free");
        employees[0] = Juan;

        Employee Jennifer = new Employee("Jennifer", "Whalen");
        Jennifer.setId(id += 1);
        Jennifer.setBirthYear(1984);
        Jennifer.setBirthPlace("Mexico");
        Jennifer.setFee(5223);
        Jennifer.setStatus("married");
        employees[1] = Jennifer;

        Employee William = new Employee("William", "Gietz");
        William.setId(id += 1);
        William.setBirthYear(1985);
        William.setBirthPlace("Mexico");
        William.setFee(2288);
        William.setStatus("married");
        employees[2] = William;

        Employee Kevin = new Employee("Kevin", "Mourgos");
        Kevin.setId(id += 1);
        Kevin.setBirthYear(1998);
        Kevin.setBirthPlace("Italia");
        Kevin.setFee(2800);
        Kevin.setStatus("free");
        employees[3] = Kevin;

        Employee Randall = new Employee("Randall", "Matos");
        Randall.setId(id += 1);
        Randall.setBirthYear(1985);
        Randall.setBirthPlace("Mexico");
        Randall.setFee(2687);
        Randall.setStatus("free");
        employees[4] = Randall;

        //SelectTopN(4);
        System.out.println(Arrays.toString(SelectById(1).getArr()));

        //System.out.println(Arrays.toString(SelectByDate(1985)[0].getArr()));
        //System.out.println(Sum());
    }

    public static void SelectTopN(int N){
        for (int i = 0; i<N; i++)
            employees[i].Print();
    }

    public static Employee SelectById(int id){
        for (Employee employee : employees) {
            if (employee.getId() == id)
                return employee;
        }
        return null;
    }

    public static Employee[] SelectByDate(int date){
        Employee [] employees_date = new Employee[5];
        int j = 0;
        for (Employee employee : employees) {
            if (employee.getBirthYear() == date) {
                employees_date[j] = employee;
                j++;
            }

        }
        return Arrays.copyOfRange(employees_date, 0, j);
    }

    public static int Sum(){
        int sum = 0;
        for (Employee employee: employees){
            sum+= employee.getFee();
        }
        return sum;
    }
//
//    public static int Sum (){
//        int sum = 0;
//        for (int i = 0; i < 5; i++) {
//            sum += Integer.parseInt(employees[i][5]);
//        }
//        return sum;
//    }
}
