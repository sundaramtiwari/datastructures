package com.leetcode.ds.medium;

/**
 *
 * 11. Container With Most Water
 *
 * {@link https://leetcode.com/problems/container-with-most-water/}
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7] Output: 49
 *
 * @author s0t010t
 *
 */

public class Container_With_Most_Water {

	public static void main(String[] args) {
		//int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int[] height = { 1,2,4,3 };
		System.out.println(maxArea(height));
	}

	static public int maxArea(int[] height) {int maxarea = 0, l = 0, r = height.length - 1;
    while (l < r) {
        maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
        if (height[l] < height[r])
            l++;
        else
            r--;
    }
    return maxarea;}
}