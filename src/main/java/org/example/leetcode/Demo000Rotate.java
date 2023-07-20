package org.example.leetcode;

public class Demo000Rotate {

    public static void main1(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7};


        rotate2(ints, 3);


        System.out.println();
        for (int anInt : ints) {
            System.out.print(anInt);
        }
        System.out.println();
    }

    public static void rotate1(int[] nums, int k) {
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = temp[i];
        }
    }

    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void rotate3(int[] nums, int k) {
        int temp;
        for (int i = 0; i < k; i++) {


        }

    }


    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = ints.length;
        int k = 4 % n;

        int count = gcd(k, n);

        for (int start = 0; start < count; start++) {
            int current = start;
            int temp =
            current = ints[start];
            ints[(start + k) % n] =
        }

    }

    private static int gcd(int m, int n) {
        int i = n == 0 ? m : gcd(n, m % n);
        // int i;
        // if (n == 0) {
        //     i = m;
        // } else {
        //     int j = m % n;
        //     i = gcd(n, j);
        // }
        return i;
    }


}
