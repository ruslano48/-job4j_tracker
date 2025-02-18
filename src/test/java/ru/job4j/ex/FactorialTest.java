package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {

    @Test
    void whenNegativeNumberThenException() {
        Factorial factorial = new Factorial();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            factorial.calc(-1);
        });

        assertEquals("Number could not be less than 0", exception.getMessage());
    }

    @Test
    void whenZeroThenOne() {
        Factorial factorial = new Factorial();

        int result = factorial.calc(0);

        assertEquals(1, result);
    }

    @Test
    void whenPositiveNumberThenCorrectFactorial() {
        Factorial factorial = new Factorial();

        int result = factorial.calc(5);

        assertEquals(120, result);
    }
}