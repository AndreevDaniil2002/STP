package org.main;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class Main {
    static ArrayDeque <Integer> numbers = new ArrayDeque<>();
    static ArrayDeque <String> brakes = new ArrayDeque<>();
    static ArrayDeque <String> signs = new ArrayDeque<>();

    static int number_count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String problem = scanner.nextLine();
        String [] problem_splited = problem.split(" ");

        ArrayList <String> signs_dic = new ArrayList<>();
        signs_dic.add("+");
        signs_dic.add("-");
        signs_dic.add("*");

        ArrayList <String> brakes_dic = new ArrayList<>();
        brakes_dic.add("{");
        brakes_dic.add("}");
        brakes_dic.add("[");
        brakes_dic.add("]");
        brakes_dic.add("(");
        brakes_dic.add(")");
        for (int i = 0; i < problem_splited.length; i++){
            if (brakes_dic.contains(problem_splited[i])) {
                if (Objects.equals(problem_splited[i], brakes_dic.get(0))
                        || Objects.equals(problem_splited[i], brakes_dic.get(2))
                        || Objects.equals(problem_splited[i], brakes_dic.get(4))) {
                    brakes.add(problem_splited[i]);
                }
                else{
                    if (problem_splited[i].equals(brakes_dic.get(1))){
                        if (brakes.getLast().equals(brakes_dic.get(0))){
                            for (int l = 0; l < number_count; l++)
                                calculate();
                            brakes.pollLast();
                        }
                        else {
                            System.out.println("Неверный порядок скобок");
                            return;
                        }
                    }
                    else if (problem_splited[i].equals(brakes_dic.get(3))){
                        if (brakes.getLast().equals(brakes_dic.get(2))){
                            calculate();
                            brakes.pollLast();
                        }
                        else {
                            System.out.println("Неверный порядок скобок");
                            return;
                        }
                    }
                    else if (problem_splited[i].equals(brakes_dic.get(5))){
                        if (brakes.getLast().equals(brakes_dic.get(4))){
                            calculate();
                            brakes.pollLast();
                        }
                        else {
                            System.out.println("Неверный порядок скобок");
                            return;
                        }
                    }
                }
            }
            else if (signs_dic.contains(problem_splited[i]))
                    signs.add(problem_splited[i]);
            else {
                try {
                    Integer a = Integer.parseInt(problem_splited[i]);
                    //System.out.println(a);
                    numbers.add(a);
                    number_count++;
                }
                catch (NumberFormatException e){
                    System.out.println("Вы написали бред");
                    return;
                }

            }
        }
        for (int i = 0; i < number_count-1; i++)
            calculate();
        System.out.println(numbers.getLast());
    }

    public static boolean calculate(){
        if (numbers.size() < 2 || signs.size() == 0){
            return false;
        }
        else{
            Integer a = numbers.pollLast();
            Integer b = numbers.pollLast();
            String sign = signs.pollLast();
            if (Objects.equals(sign, "+")){
                numbers.add(b+a);

            }
            else if (Objects.equals(sign, "-"))
                numbers.add(b-a);
            else if (Objects.equals(sign, "*"))
                numbers.add(b*a);
            //System.out.println(numbers.getLast());
            return true;
        }
    }
}
