package week2_6;

import java.util.*;
import java.io.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q3 {
    public static int n, m;
    public static int[][] grid = new int[100][100];
    public static boolean[][] visited = new boolean[100][100];
    public static Queue<Pair> q = new LinkedList<>();

    public static boolean canGo(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        if (grid[x][y] == 0 || visited[x][y]) {
            return false;
        }
        return true;
    }

    public static void BFS() {
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            //                   ↓  →  ↑   ←
            int[] dx = new int[]{0, 1, 0, -1};
            int[] dy = new int[]{1, 0, -1, 0};

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (canGo(newX, newY)) {
                    q.add(new Pair(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }

        q.add(new Pair(0, 0));
        visited[0][0] = true;

        BFS();

        int answer = 0;
        if (visited[n - 1][m - 1]) answer = 1;

        System.out.print(answer);

    }
}