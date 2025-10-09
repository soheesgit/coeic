package org.example.week2_1;

import java.util.*;
import java.io.*;

public class Q4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] directionX = {-1, 1, 0, 0};  // 상, 하, 좌, 우
        int[] directionY = {0, 0, -1, 1};
        StringBuilder sb = new StringBuilder();

        int nowX = r;
        int nowY = c;

        sb.append(grid[nowX][nowY]).append(" ");

        while (true) {
            boolean moved = false;

            for (int i = 0; i < 4; i++) {
                int nx = nowX + directionX[i];
                int ny = nowY + directionY[i];

                if (nx < 1 || nx > n || ny < 1 || ny > n) continue;

                if (grid[nowX][nowY] < grid[nx][ny]) {
                    nowX = nx;
                    nowY = ny;
                    sb.append(grid[nx][ny]).append(" ");
                    moved = true;
                    break;
                }
            }

            if (!moved) break;
        }

        System.out.print(sb.toString().trim());
    }
}
