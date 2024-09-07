package com.codebook.interview.microsoft;

import java.time.chrono.MinguoDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem {

    public static void main(String[] args) {
        //System.out.println(solution(new int[]{10, -10, -1, -1, 10}));
        //System.out.println(solution(new int[]{-1, -1, -1, 1, 1, 1, 1}));
        //System.out.println(solution(new int[]{5, -2, -3, 1}));
        System.out.println(solution(2));

    }

   static int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p < 1 + l; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }


}
