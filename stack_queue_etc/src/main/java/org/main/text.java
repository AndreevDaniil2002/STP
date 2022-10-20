package org.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class text {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder();
        TreeSet<String> ts = new TreeSet<>();
        String s;
        try {
            BufferedReader in = new BufferedReader(new FileReader("Input.txt"));
            s = in.readLine();
            String [] s1 = s.split(" ");
            Collections.addAll(ts, s1);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        ts.remove(",");

        System.out.println(ts);

        String s2 = String.valueOf(ts).replace("]", "");
        s2 = s2.replace("[", "");
        s2 = s2.replace(",", "");

        try {
            FileWriter myWriter = new FileWriter("result.txt");
            myWriter.write(s2);
            myWriter.close();
            System.out.println("Text saved successfully.");
        } catch (Exception e) {
            System.out.println("Text saving failed.");
            e.printStackTrace();
        }


    }
}
