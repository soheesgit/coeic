package week3_1;

import java.util.*;
import java.io.*;

class Pit {
    int x, y;
    int boom; //0이면 안뚫림, 1이면 뚫림

    Pit(int x, int y, int boom) {
        this.x = x;
        this.y = y;
        this.boom = boom;
    }

}

public class Q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][m];
        int[][][] visited = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Pit> q = new LinkedList<>();

        q.add(new Pit(0, 0, grid[0][0]));
        visited[0][0][grid[0][0]] = 1;

        while (!q.isEmpty()) {
            Pit current = q.poll();
            int x = current.x;
            int y = current.y;
            int boom = current.boom;

            for (int i = 0; i < 4; i++) {
                int nowX = x + dx[i];
                int nowY = y + dy[i];

                // 범위체크
                if (nowX < 0 || nowY < 0 || nowX >= n || nowY >= m) continue;

                // 다음 방문하려는 곳이 0이라면
                if (grid[nowX][nowY] == 0 && visited[nowX][nowY][boom] == 0) {
                    q.add(new Pit(nowX, nowY, boom));
                    visited[nowX][nowY][boom] = visited[x][y][boom] + 1;
                } //다음 방문하려는 곳이 1이고, 아직 벽을 안뚫고, 방문 안했다면
                else if (grid[nowX][nowY] == 1 && boom == 0 && visited[nowX][nowY][boom] == 0) {
                    q.add(new Pit(nowX, nowY, 1));
                    visited[nowX][nowY][1] = visited[x][y][0] + 1;
                }
            }
        }

        int ans = -1;
        // 벽을 안 부수고 도착
        if (visited[n-1][m-1][0] != 0) {
            ans = visited[n-1][m-1][0];
        }
        // 벽을 부수고 도착
        if (visited[n-1][m-1][1] != 0) {
            // 'ans'에 이미 안 부순 경로가 있다면, 둘 중 최소값을 선택
            if (ans == -1 || ans > visited[n-1][m-1][1]) {
                ans = visited[n-1][m-1][1];
            }
        }

        // (n,m)이 1x1 예외 처리)
        if (n == 1 && m == 1) ans = 1;

        System.out.println(ans);

    }
}