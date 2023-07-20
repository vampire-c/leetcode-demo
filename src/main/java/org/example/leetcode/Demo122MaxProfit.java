package org.example.leetcode;

public class Demo122MaxProfit {
    public static void main(String[] args) {
        // int[] prices = new int[]{7, 6, 4, 3, 1};
        int[] prices = new int[]{1, 2, 3, 4, 2, 2, 3, 4};
        int i = maxProfit2(prices);
        System.out.println(i);
    }

    public static int maxProfit1(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int s = prices[i] - prices[i - 1];
            if (s > 0) {
                sum += s;
            }
        }
        return sum;
    }

    public static int maxProfit2(int[] prices) {
        int sum = 0;
        int small = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] < 0) {
                // if (small > prices[i - 1]) {
                //     small = prices[i - 1];
                // }
                sum += (prices[i - 1] - small);
                small = prices[i];
            }
        }
        if (prices[prices.length - 1] > small) {
            sum += (prices[prices.length - 1] - small);
        }
        return sum;
    }
}
