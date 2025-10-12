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

public class Q6 {
    public static int[][] grid;
    public static boolean[][] visited;
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];

        int maxValue = 0; // K가 최대로 될 수 있는 값 구하기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (maxValue < grid[i][j]) {
                    maxValue = grid[i][j];
                }
            }
        }

        int maxAreaCount = 0; // 안전 영역의 최대 개수 저장
        int answer_k = 1; //그때의 K값


        for (int k = 1; k < maxValue; k++) {
            visited = new boolean[n][m]; // k가 바뀔 때마다 visited 배열 초기화
            int currentAreaCount = 0;    // 현재 k 높이에서의 안전 영역 개수

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 핵심 로직: 물에 잠기지 않았고(> k) 아직 방문하지 않은 곳을 발견했다면
                    if (grid[i][j] > k && !visited[i][j]) {
                        currentAreaCount++; // 새로운 안전 영역을 찾았으므로 개수 +1
                        bfs(i, j, k);       // 이 지점과 연결된 모든 안전 영역을 방문 처리
                    }
                }
            }

            // 현재 k에서 찾은 영역의 개수가 지금까지의 최대 개수보다 많으면 갱신
            if (currentAreaCount > maxAreaCount) {
                maxAreaCount = currentAreaCount;
                answer_k = k;
            }
        }

        System.out.print(answer_k + " " + maxAreaCount);
    }

    public static void bfs(int startX, int startY, int k) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startX, startY));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nowX = curr.x + dx[i];
                int nowY = curr.y + dy[i];

                if (nowX < 0 || nowX >= n || nowY < 0 || nowY >= m) continue;
                if (visited[nowX][nowY] || grid[nowX][nowY] <= k) continue;

                visited[nowX][nowY] = true;
                q.add(new Pair(nowX, nowY));
            }
        }
    }
}