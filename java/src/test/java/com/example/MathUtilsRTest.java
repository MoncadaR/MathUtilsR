package com.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsRTest {

    private MathUtilsR math;

    @BeforeEach
    void setUp() {
        math = new MathUtilsR();
    }

    @AfterEach
    void tearDown() {
        math = null;
    }

    @Test
    void testAdd() {
        assertEquals(5, math.add(2, 3));
        assertEquals(-1, math.add(2, -3));
        assertEquals(0, math.add(0, 0));
    }

    @Test
    void testSubtract() {
        assertEquals(1, math.subtract(3, 2));
        assertEquals(5, math.subtract(2, -3));
        assertEquals(0, math.subtract(0, 0));
    }

    @Test
    void testMultiply() {
        assertEquals(6, math.multiply(2, 3));
        assertEquals(-6, math.multiply(2, -3));
        assertEquals(0, math.multiply(0, 99));
    }

    @Test
    void testDivideNormal() {
        assertEquals(2.0, math.divide(6, 3), 0.0001);
        assertEquals(-2.0, math.divide(6, -3), 0.0001);
    }

    @Test
    void testDivideByZero() {
        assertEquals(-1.0, math.divide(10, 0), 0.0001);
    }
}

