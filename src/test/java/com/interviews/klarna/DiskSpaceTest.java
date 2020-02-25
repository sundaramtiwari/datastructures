package com.interviews.klarna;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DiskSpaceTest {

    @Test
    public void test1() {
        assertTrue(DiskSpace.isWritable(1, 1, new HashSet<>()));
    }

    @Test
    public void test2() {
        assertFalse(DiskSpace.isWritable(1, 1, new HashSet<>(Arrays.asList(1))));
    }

    @Test
    public void test3() {
        assertTrue(DiskSpace.isWritable(4, 2, new HashSet<>(Arrays.asList(1, 4))));
    }

    @Test
    public void test4() {
        assertTrue(DiskSpace.isWritable(7, 3, new HashSet<>(Arrays.asList(1, 3, 7))));
    }

    @Test
    public void test5() {
        assertFalse(DiskSpace.isWritable(7, 3, new HashSet<>(Arrays.asList(1, 2, 3, 4, 7))));
    }

    @Test
    public void test6() {
        assertFalse(DiskSpace.isWritable(5, 2, new HashSet<>(Arrays.asList(1, 3, 5))));
    }

}