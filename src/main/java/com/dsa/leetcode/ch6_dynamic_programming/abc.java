package com.dsa.leetcode.ch6_dynamic_programming;

import java.util.Arrays;

public class abc {
    public static int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] f = new int[n + 1][m + 1];
        int[] sub = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                    System.out.print(f[i][j] + "\t");
                }
            }
            System.out.println("");
        }

        //System.out.println(Arrays.deepToString(f));
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(f[i][j] + "\t");
            }
            System.out.println("");
        }
        return f[n][m];
    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7,2,5,10,8},2));
    }
}
