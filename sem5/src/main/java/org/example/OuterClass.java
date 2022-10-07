package org.example;

public class OuterClass {
    private int privateVariable=0;
    public int publicVariable=1;
    protected int protectedVariable=2;
    int vatiable = 4;
    public static int StaticVariable = 0;

    public OuterClass(){

    }

    private void privatMethod(){
        System.out.println("This is privat meyhod");
    }
    private void protectedMethod(){
        System.out.println("This is protected meyhod");
    }
    private void publictedMethod(){
        System.out.println("This is public meyhod");
    }
    private void method(){
        System.out.println("This is default meyhod");
    }

    public class InnerClass
    {
        public InnerClass()
        {
            System.out.println(privateVariable);
            System.out.println(publicVariable);
            System.out.println(protectedVariable);
            System.out.println(vatiable);
            privatMethod();
            publictedMethod();
            protectedMethod();
            method();
        }

    }
    public static class StaticInnerClass{
        public void method(){
            System.out.println(StaticVariable);

        }
    }

}
