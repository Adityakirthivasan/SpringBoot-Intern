package com.example.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {

    @Test
    void testSayHello() {
        Hello hello = new Hello();
        String result = hello.sayHello();
        assertEquals("hello", result);
    }
}
