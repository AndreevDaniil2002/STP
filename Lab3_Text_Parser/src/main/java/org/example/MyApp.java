package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder();
        try {
            FileReader myReader = new FileReader("Input.txt");
            int character=myReader.read();
            while(character!=-1)
            {
                //System.out.print((char) character);
                sb.append((char) character);
                character=myReader.read();
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("Text reading failed.");
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();


        try {
            FileWriter myWriter = new FileWriter("result.txt");
            myWriter.write("Кол-во слов: " + CountWords(String.valueOf(sb)) + "\n" +
                    "Кол-во прописных букв: " + UpperCaseCount(String.valueOf(sb)) + "\n" +
                    "Кол-во строчных букв: " + LowerCaseCount(String.valueOf(sb)) + "\n" +
                    "Кол-во пробелов: " + SpaceCount(String.valueOf(sb)) + "\n" +
                    "Целые числа в 16ой СС: " + CountInt(String.valueOf(sb)) + "\n" +
                    "Числа с плавающей точкой: " + CountFloat(String.valueOf(sb)) + "\n" +
                    "Кол-во знаков препинания: " + (String.valueOf(sb).length() - DeleteTrash(String.valueOf(sb)).length()) + "\n" +
                    "Индексы появления слова \"" + word + "\" " + FindWord(String.valueOf(sb), word));
            myWriter.close();
            System.out.println("Text saved successfully.");
        } catch (Exception e) {
            System.out.println("Text saving failed.");
            e.printStackTrace();
        }
    }

    public static int CountWords(String text){
        String [] words = text.split(" ");
        int decrease = 0;
        for (String word : words) {
            //System.out.println(words[i]);
            if (Objects.equals(word, "") || Objects.equals(word, "–") || Objects.equals(word, "+"))
                decrease++;
        }
        return words.length - decrease;
    }

    public static int UpperCaseCount(String text){
        char [] arr = text.toCharArray();
        int count = 0;
        for (char c : arr) {
            if (Character.isUpperCase(c))
                count++;
        }
        return count;
    }

    public static int LowerCaseCount(String text){
        char [] arr = text.toCharArray();
        int count = 0;
        for (char c : arr){
            if (Character.isLowerCase(c))
                count++;
        }
        return count;
    }

    public static int SpaceCount(String text){
        String [] arr = text.split("");
        int count = 0;
        for (String s : arr) {
            if (Objects.equals(s, " "))
                count++;
        }
        return count;
    }

    public static ArrayList<String> CountInt(String text){
        String [] arr = text.split(" ");
        ArrayList<Integer> ints = new ArrayList<Integer>();
        ArrayList<String> ints_16 = new ArrayList<String>();

        for (String s : arr) {
            try {
                int a = Integer.parseInt(s);
                ints.add(a);
            } catch (NumberFormatException e) {
                continue;
            }
        }
        for (Integer anInt : ints) ints_16.add(toHexadecimal(anInt));
        return ints_16;
    }

    public static ArrayList<Float> CountFloat(String text){
        String [] arr = text.split(" ");
        ArrayList<Float> floats = new ArrayList<Float>();
        for (String s : arr) {
            if (s.contains(".")) {
                try {
                    float b = Float.parseFloat(String.valueOf(Math.round(Float.parseFloat(s) * 100)))/100;
                    floats.add(b);
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }
        System.out.println(floats);
        return floats;
    }

    public static StringBuffer DeleteTrash(String text){
        String [] temp = text.split("");
        StringBuffer arr = new StringBuffer(text);
        int i = 0;
        for (int j = 0; j<temp.length; j++){
            if ((Objects.equals(temp[j], ".") || Objects.equals(temp[j], ",") || Objects.equals(temp[j], "!")
                    || Objects.equals(temp[j], "?") || Objects.equals(temp[j], "\"")) && Objects.equals(temp[j + 1], " ")) {
                arr.delete(i, i + 1);
                i -= 1;
            }
            i++;
        }
        //System.out.println(arr);
        return arr;
    }

    public static ArrayList<Integer> FindWord(String text, String word){
        String [] arr = text.split(" ");
        int index = -1;
        ArrayList <Integer> indexes = new ArrayList<>();
        for (String s : arr) {
            if (Objects.equals(s, word)) {
                indexes.add(index);
                int temp = index + word.length() - 1;
                indexes.add(temp);
            }
            index += (s.length() + 1);
        }
        return indexes;
    }
    public static String toHexadecimal(int a){
        return Integer.toHexString(a);
    }

}
