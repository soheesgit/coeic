package week2_6;

import java.util.*;
import java.io.*;

public class Q2 {
    public static int n, m;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int exit = 0;

    public static boolean canGo(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }

        if (grid[x][y] == 0 || visited[x][y]) {
            return false;
        }

        return true;
    }
    public static void DFS(int x, int y) {
        int[] dx = new int[]{1, 0};
        int[] dy = new int[]{0, 1};

        if (x == n - 1 && y == m - 1) {
            exit = 1;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (canGo(newX, newY)) {
                visited[newX][newY] = true;
                DFS(newX, newY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }

        visited[0][0] = true;
        DFS(0, 0);

        System.out.print(exit);
    }
}