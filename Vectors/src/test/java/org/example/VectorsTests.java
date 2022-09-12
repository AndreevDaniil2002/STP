package org.example;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class VectorsTests {
    double v1[] = {1,2,3};
    double v2[] = {4,5,6};
    @Test
    @DisplayName("Testing Scalar Multiply operation in MyApp")
    void testScalarMultiply(){
        assertEquals(32.0, MyApp.ScalarMulty(v1, v2));
    }
    @Test
    @DisplayName("Testing Scalar Multiply operation in MyApp")
    void testVectorMulty(){
        assertArrayEquals(new Double[]{-3.0, 6.0, -3.0}, MyApp.VectorMulty(v1, v2));
    }
    @Test
    @DisplayName("Testing Scalar Multiply operation in MyApp")
    void testSummaryVector(){
        assertArrayEquals(new Double[]{5.0, 7.0, 9.0}, MyApp.SummaryVector(v1, v2));
    }
    @Test
    @DisplayName("Testing Scalar Multiply operation in MyApp")
    void testDiffVector(){
        assertArrayEquals(new Double[]{-3.0, -3.0, -3.0}, MyApp.DiffVector(v1, v2));
    }
    @Test
    @DisplayName("Testing Scalar Multiply operation in MyApp")
    void testModuleVector(){
        assertEquals(3.7416573867739413, MyApp.ModuleVector(v1));
    }
    @Test
    @DisplayName("Testing Scalar Multiply operation in MyApp")
    void testAngleVectors(){
        assertEquals(12.933154491899135, MyApp.AngleVectors(v1,v2));
    }
}
