package week2_6;

import java.util.*;
import java.io.*;

final class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q5 {
    public static Queue<Pair> q = new LinkedList<>();
    public static int[][] grid;
    public static ArrayList<Integer> number = new ArrayList<>();
    public static boolean[][] visited;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                    bfs();
                }
            }
        }

        Collections.sort(number);

        System.out.println(number.size());

        for (int i = 0; i < number.size(); i++) {
            System.out.println(number.get(i));
        }

    }

    public static void bfs() {
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int cnt = 1;
        while (!q.isEmpty()) {
            Pair curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nowX = curr.x + dx[i];
                int nowY = curr.y + dy[i];

                if (nowX < 0 || nowX >= n || nowY < 0 || nowY >= n) continue;
                if (visited[nowX][nowY] || grid[nowX][nowY] == 0) continue;


                q.add(new Pair(nowX, nowY));
                cnt++;
                visited[nowX][nowY] = true;
            }
        }

        number.add(cnt);
    }

}