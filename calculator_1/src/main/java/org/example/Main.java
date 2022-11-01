package org.example;

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
        for (String s : problem_splited) {
            if (brakes_dic.contains(s)) {
                if (Objects.equals(s, brakes_dic.get(0))
                        || Objects.equals(s, brakes_dic.get(2))
                        || Objects.equals(s, brakes_dic.get(4))) {
                    brakes.add(s);
                } else {
                    if (s.equals(brakes_dic.get(1))) {
                        if (brakes.getLast().equals(brakes_dic.get(0))) {
                            for (int l = 0; l < number_count; l++)
                                calculate();
                            brakes.pollLast();
                        } else {
                            System.out.println("Неверный порядок скобок");
                            return;
                        }
                    } else if (s.equals(brakes_dic.get(3))) {
                        if (brakes.getLast().equals(brakes_dic.get(2))) {
                            for (int l = 0; l < number_count; l++)
                                calculate();
                            brakes.pollLast();
                        } else {
                            System.out.println("Неверный порядок скобок");
                            return;
                        }
                    } else if (s.equals(brakes_dic.get(5))) {
                        if (brakes.getLast().equals(brakes_dic.get(4))) {
                            for (int l = 0; l < number_count; l++)
                                calculate();
                            brakes.pollLast();
                        } else {
                            System.out.println("Неверный порядок скобок");
                            return;
                        }
                    }
                }
            } else if (signs_dic.contains(s))
                signs.add(s);
            else {
                try {
                    Integer a = Integer.parseInt(s);
                    //System.out.println(a);
                    numbers.add(a);
                    number_count++;
                } catch (NumberFormatException e) {
                    System.out.println("Вы написали бред");
                    return;
                }

            }
        }
        for (int i = 0; i < number_count-1; i++)
            calculate();
        System.out.println(numbers.getLast());
    }
    public static void calculate(){
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
            System.out.println(numbers.getLast());
            number_count --;
    }
}