package org.example.leetcode;

public class Demo026RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 4, 4, 4, 5, 6, 6, 6, 7, 7};
        Integer size = removeDuplicates(nums);
        System.out.println(size);
    }


    private static Integer removeDuplicates(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int p = 0;
        int q = 1;
        // System.out.println();
        // System.out.println("p = " + p);
        // System.out.println("q = " + q);
        // for (int num : nums) {
        //     System.out.print(num + "  ");
        // }
        // System.out.println();
        // System.out.println();
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
                // System.out.println("p = " + p);
                // System.out.println("q = " + q);
                // for (int num : nums) {
                //     System.out.print(num + "  ");
                // }
                // System.out.println();
                // System.out.println();
            }
            q++;
        }
        return p + 1;
    }


}
