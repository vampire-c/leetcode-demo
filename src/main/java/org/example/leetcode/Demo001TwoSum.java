package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Demo001TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int[] ints = twoSum1(nums, 6);
        System.out.println();
    }

    public static int[] twoSum1(int[] nums, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ints[0] = i;
                    ints[1] = j;
                    return ints;
                }
            }
        }
        return ints;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 判断哈希表中是否存在 key = target - nums[i]
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            // 保存哈希表 key 为正在遍历的数组的值, value 为数值的位置
            map.put(nums[i], i);
        }
        return null;
    }

    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> hashTable = new HashMap<Integer, Integer>();
        // 从首尾同时开始
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            // 判断 i + j
            if ((nums[i] + nums[j]) == target) {
                return new int[]{i, j};
            }

            // 判断哈希表中是否存在 key = target - nums[i]
            if (hashTable.containsKey(target - nums[i])) {
                return new int[]{i, hashTable.get(target - nums[i])};
            }

            // 判断哈希表中是否存在 key = target - nums[j]
            if (hashTable.containsKey(target - nums[j])) {
                return new int[]{j, hashTable.get(target - nums[j])};
            }
            // 保存哈希表 key 为正在遍历的数组的值, value 为数值的位置
            hashTable.put(nums[i], i);
            hashTable.put(nums[j], j);
        }
        return null;
    }

}
