package org.example.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo003LengthOfLongestSubstring {
    public static void main(String[] args) {
        int abcabcbb = lengthOfLongestSubstring1("abcabcbb");
    }

    public static int lengthOfLongestSubstring1(String s) {
        int sl = s.length();
        if (0 == sl) {
            return 0;
        }
        int length = 0;
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while (right < sl) {
            char c = s.charAt(right);
            if (set.contains(c)) {
                char c1 = s.charAt(right);
                while (set.contains(c1)) {
                    char c2 = s.charAt(left);
                    set.remove(c2);
                    length--;
                    left++;
                }
            } else {
                char c1 = s.charAt(right);
                set.add(s.charAt(c1));
                length++;
                if (length > maxLength) maxLength = length;
                right++;
            }
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring(String s) {
        int sl = s.length();
        if (0 == sl) {
            return 0;
        }
        int[] ints = new int[128];

        int res = 0;
        int start = 0;
        for (int i = 0; i < sl; i++) {
            int index = s.charAt(i);
            start = Math.max(start, ints[index] + 1);
            res = Math.max(res, i - start + 1);
            ints[index] = i;
        }
        return res;


    }


}
