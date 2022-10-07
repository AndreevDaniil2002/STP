package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyGenericClass<ClassA> genericClass = new MyGenericClass<>(new ClassA());
        genericClass.getObj().methodA();
        ArrayList<ClassC> arrayList = new ArrayList<>();
//        arrayList.add(new ClassA());
//        arrayList.add(new ClassB());
        arrayList.add(new ClassC());
        arrayList.add(new ClassD());
        ArrayList<? super  ClassD> arr = arrayList;
    }
}
