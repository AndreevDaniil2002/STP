package org.example;

import java.text.DecimalFormat;
import java.util.Arrays;

public class MyApp {
    public static void main(String[] args) {
        System.out.println("ЧЗХ Томас Шелби?");
        double [] v1 = {1,2,3};
        double [] v2 = {4,5,6};
        System.out.println(ScalarMulty(v1, v2));
        System.out.println(Arrays.toString(VectorMulty(v1, v2)));
        System.out.println(Arrays.toString(SummaryVector(v1, v2)));
        System.out.println(Arrays.toString(DiffVector(v1, v2)));
        System.out.println(ModuleVector(v1));
        System.out.println(AngleVectors(v1,v2));
    }

    public static double ScalarMulty(double [] v1, double [] v2) {
        return (v1[0]*v2[0] + v1[1]*v2[1] + v1[2]*v2[2]);
    }

    public static Double[] VectorMulty(double [] v1, double [] v2){
        return (new Double[]{(v1[1]*v2[2] - v1[2]*v2[1]), -(v1[0]*v2[2]-v1[2]*v2[0]), (v1[0]*v2[1] - v1[1]*v2[0])});
    }

    public static Double[]  SummaryVector(double [] v1, double [] v2){
        return(new Double[]{(v1[0]+v2[0]), (v1[1]+v2[1]), (v1[2]+v2[2])});
    }

    public static Double[] DiffVector(double [] v1, double [] v2){
        return(new Double[]{(v1[0]-v2[0]), (v1[1]-v2[1]), (v1[2]-v2[2])});
    }

    public static Double ModuleVector(double [] v1){
        return (Math.sqrt(Math.pow(v1[0],2) + Math.pow(v1[1],2) + Math.pow(v1[2],2)));
    }

    public static Double AngleVectors(double [] v1, double [] v2){
        return (Math.acos(ScalarMulty(v1, v2)/(ModuleVector(v1)*ModuleVector(v2)))*180/Math.PI);

    }
}
