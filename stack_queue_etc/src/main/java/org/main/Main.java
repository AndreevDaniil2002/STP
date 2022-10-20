package org.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String> dic = new HashMap<String, String>();
        String s;
        try {
            BufferedReader in = new BufferedReader(new FileReader("Input.txt"));
            s = in.readLine();
            while(s != null){
                String [] s1 = s.split(":");
                dic.put(s1[0], s1[1]);
                s = in.readLine();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(dic);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String word = scanner.nextLine();
            if (Objects.equals(word, "exit"))
                break;
            System.out.println(dic.get(word));
        }
    }
}
