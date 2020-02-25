package com.interviews.klarna;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmoothieGeneratorTest {

    @Test
    public void shouldPassForValidSmoothie() {
        assertEquals("banana,honey,mango,peach,pineapple,strawberry", SmoothieGenerator.ingredients("Classic"));
    }

    @Test
    public void shouldPassForValidSmoothieWithAllergens() {
        assertEquals("banana,honey,mango,peach,pineapple", SmoothieGenerator.ingredients("Classic,-strawberry,-peanut"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewIngredient() {
        SmoothieGenerator.ingredients("Classic,chocolate");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSmoothie() {
        SmoothieGenerator.ingredients("Vitamin smoothie");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailForBlankOrEmptySmoothie() {
        SmoothieGenerator.ingredients("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailForNullSmoothie() {
        SmoothieGenerator.ingredients(null);
    }
}
