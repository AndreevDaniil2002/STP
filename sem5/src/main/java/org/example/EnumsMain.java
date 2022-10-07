package org.example;

import java.util.Locale;
import java.util.Scanner;

public class EnumsMain {
    enum DayOfWeek{
        SATURDAY("День1"),
        SUNDAY("День2"),
        MONDAY("День3"),
        TUESDAY("День4"),
        WEDNESDAY("День5"),
        THURSDAY("День6"),
        FRIDAY("День7"),;
        private String code;
        DayOfWeek(String code){
            this.code=code;
        }
        public String getCode(){
            return code;
        }
    }
    public static void main(String [] args){
        DayOfWeek day = DayOfWeek.SATURDAY;
        System.out.println(day);
        System.out.println(day.ordinal());

        Scanner in = new Scanner(System.in);
        System.out.println("Enter day");
        day = DayOfWeek.valueOf((in.next().toUpperCase(Locale.ROOT)));
        switch (day){
            case SATURDAY -> {
                System.out.println("Holiday1");
            }
            case SUNDAY -> {
                System.out.println("Holiday2");
            }
            case MONDAY -> {
                System.out.println("WorkDay1");
            }
            case TUESDAY -> {
                System.out.println("WorkDay2");
            }
            case WEDNESDAY -> {
                System.out.println("WorkDay3");
            }
            case THURSDAY -> {
                System.out.println("WorkDay4");
            }
            case FRIDAY -> {
                System.out.println("WorkDay5");
            }
        }
        DayOfWeek [] days= DayOfWeek.values();
        for (DayOfWeek MyDay:days){
            System.out.println(MyDay+" "+MyDay.getCode());
        }

    }
}