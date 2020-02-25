package com.algocast.maxchar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxCharTest {

    @Test
    public void shouldPassForValidInput() {
        assertEquals('a', MaxChar.maxchar("abaadca 23 111"));
    }
}
