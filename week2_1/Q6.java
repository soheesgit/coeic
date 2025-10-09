package org.example.week2_1;

import java.util.*;
import java.io.*;

public class Q6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxCnt = 0;

        // 모든 좌표 (i, j)�??�회?�니??
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // --- 1�?블록 (L 모양) 체크 ---
                // (i, j)�?좌상?�으�??�는 2x2 공간??격자 ?�에 ?�을 ?�만 ?�인
                if (i <= n - 2 && j <= m - 2) {
                    int squareSum = grid[i][j] + grid[i][j + 1] + grid[i + 1][j] + grid[i + 1][j + 1];
                    int[] sums = new int[4];
                    sums[0] = squareSum - grid[i][j];
                    sums[1] = squareSum - grid[i][j + 1];
                    sums[2] = squareSum - grid[i + 1][j];
                    sums[3] = squareSum - grid[i + 1][j + 1];
                    for (int sum : sums) {
                        maxCnt = Math.max(maxCnt, sum);
                    }
                }

                // --- 2�?블록 (I 모양) 체크 ---
                // 가로로 �?모양 (1x3)
                if (j <= m - 3) {
                    int sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                    maxCnt = Math.max(maxCnt, sum);
                }

                // ?�로�?�?모양 (3x1)
                if (i <= n - 3) {
                    int sum = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
                    maxCnt = Math.max(maxCnt, sum);
                }
            }
        }

        System.out.println(maxCnt);
    }
}
