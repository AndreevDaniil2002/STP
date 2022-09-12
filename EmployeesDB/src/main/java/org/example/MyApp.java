package org.example;

import java.util.Arrays;
import java.util.Objects;

public class MyApp {
    static String[][] employees = new String[5][7];

    public static void main(String[] args) {
        employees[0] = (new String[]{"", "Juan", "Vardos", "1996", "Italia", "1000", "free"});
        employees[1] = (new String[]{"","Jennifer","Whalen","1984","Mexico","5223","married"});
        employees[2] = (new String[]{"","William","Gietz","1985","Mexico","2288","married"});
        employees[3] = (new String[]{"","Kevin","Mourgos","1998","Italia","2800","free"});
        employees[4] = (new String[]{"","Randall","Matos","1985","Mexico","2687","free"});

        for (int i = 0; i < 5; i++){
            employees[i][0] = String.valueOf(i);
        }

        System.out.println(Arrays.toString(SelectById("1")));
        System.out.println(Arrays.deepToString(SelectByDate("1985")));
        System.out.println(Sum());

    }

    public static String[][] SelectTopN (int N){
        return Arrays.copyOfRange(employees, 0, N);
    }

    public static String [] SelectById (String id){
        for (String[] employee : employees) {
            if (Objects.equals(employee[0], id)) {
                return employee;
            }
        }

        return employees[1];
    }

    public static String [][] SelectByDate (String date){
        String [][] employees_temp = new String[5][7];
        int j = 0;
        for (String[] employee : employees) {
            if (Objects.equals(employee[3], date) && (employee[3] != null)) {
                employees_temp[j] = employee;
                j++;
            }
        }

        return Arrays.copyOfRange(employees_temp, 0, j);
    }

    public static int Sum (){
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += Integer.parseInt(employees[i][5]);
        }
        return sum;
    }
}
