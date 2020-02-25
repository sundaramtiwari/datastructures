package com.algocast.anagrams;

import org.junit.Test;

import static com.algocast.anagrams.Anagrams.areAnagrams;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnagramsTest {

    @Test
    public void testValidAnagrams() {
        assertTrue(areAnagrams("aabbbc", "cababb"));
    }

    @Test
    public void testInValidAnagrams() {
        assertFalse(areAnagrams(null, "cab"));
    }

    @Test
    public void testInValidAnagrams2() {
        assertFalse(areAnagrams("cab", null));
    }

    @Test
    public void testInValidAnagrams3() {
        assertFalse(areAnagrams("caba", "cada"));
    }

    @Test
    public void testInValidAnagrams4() {
        assertFalse(areAnagrams("", "ab"));
    }

    @Test
    public void testInValidAnagrams5() {
        assertFalse(areAnagrams("a", "ab"));
    }
}
