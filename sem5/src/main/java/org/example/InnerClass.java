package org.example;

public class InnerClass {
    public static void main(String [] args){
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass= outerClass.new InnerClass();
        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();
    }
}