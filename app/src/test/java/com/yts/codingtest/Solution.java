package com.yts.codingtest;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Solution {

    @Test
    public void test() {
        // int[] one = {3333, 3333, 3333, 3333, 3333};
        //  int[] two = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 3333};

        int[] one = {2, 3};
        int[] two = {2, 1, 1, 3};

        assertEquals(
                2,
                solution(
                        one, two
                )
        );

    }


    int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        for (int k = 0; k < n; k++) {
            while (i < m - 1 && B[i] < A[k])
                i += 1;
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }
}
