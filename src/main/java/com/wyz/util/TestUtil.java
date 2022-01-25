package com.wyz.util;

import java.util.HashMap;
import java.util.Map;

public class TestUtil {
    public static void main(String[] args) {
        int[] ints = new int[]{1,2};
        System.out.println(ints);
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
