package org.example.week3_3;

import java.util.*;
import java.io.*;

public class Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = matrix[0][0];

        for (int i = 1; i < n; i++) { //대각선, 오른쪽, 왼쪽 더해주기
            dp[i][i] = dp[i - 1][i - 1] + matrix[i][i];
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}