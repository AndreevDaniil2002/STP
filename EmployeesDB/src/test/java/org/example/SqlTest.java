package org.example;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class SqlTest {
    static String[][] employees = new String[5][7];

    public static void main(String[] args) {
        employees[0] = (new String[]{"0", "Juan", "Vardos", "1996", "Italia", "1000", "free"});
        employees[1] = (new String[]{"1","Jennifer","Whalen","1984","Mexico","5223","married"});
        employees[2] = (new String[]{"2","William","Gietz","1985","Mexico","2288","married"});
        employees[3] = (new String[]{"3","Kevin","Mourgos","1998","Italia","2800","free"});
        employees[4] = (new String[]{"4","Randall","Matos","1985","Mexico","2687","free"});
    }
    @Test
    void testSelectById (){
        assertArrayEquals(employees[1], MyApp.SelectById("1"));
    }

    /*@Test
    void testSelectByDate (){
        assertArrayEquals(new String[][] {{"2","William","Gietz","1985","Mexico","2288","married"}, {"4","Randall","Matos","1985","Mexico","2687","free"}}, MyApp.SelectByDate("1985"));
    }*/

    @Test
    void testSum(){
        assertEquals(13998, MyApp.Sum());
    }

}
