package org.example.week2_1;
import java.util.*;
import java.io.*;

public class Q5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 격자???�기
        int m = Integer.parseInt(st.nextToken()); // 초기 구슬??개수
        int t = Integer.parseInt(st.nextToken()); // ?�간

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 구슬 ?�치�??�?�하??2차원 배열
        int[][] marbles = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            marbles[i][0] = Integer.parseInt(st.nextToken()) - 1;
            marbles[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        int[] dr = {-1, 1, 0, 0}; // ?? ?? �? ??
        int[] dc = {0, 0, -1, 1};

        // ?�재 구슬??개수
        int currentMarbleCount = m;

        // t�??�안 ?��??�이??
        for (int i = 0; i < t; i++) {
            // 구슬???�나???�으�??��??�이??종료
            if (currentMarbleCount == 0) break;

            // --- 1?�계: 모든 구슬???�음 ?�치 '계산' ---

            // �?구슬???�음 ?�치�??�시 ?�?�할 배열
            int[][] nextMarbles = new int[currentMarbleCount][2];
            // �?칸에 구슬??�?�??�착?��? 카운?�하??배열
            int[][] count = new int[n][n];

            // ?�재 ?�아?�는 구슬만큼�?반복
            for (int j = 0; j < currentMarbleCount; j++) {
                int r = marbles[j][0];
                int c = marbles[j][1];
                int maxNum = 0;
                int nextR = r; // ?�직이지 ?�을 경우�??�비해 ?�재 ?�치�?초기??
                int nextC = c;

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        if (grid[nr][nc] > maxNum) {
                            maxNum = grid[nr][nc];
                            nextR = nr;
                            nextC = nc;
                        }
                    }
                }
                // 계산???�음 ?�치�??�시 배열???�??
                nextMarbles[j][0] = nextR;
                nextMarbles[j][1] = nextC;
                // ?�당 ?�치???�착??구슬 개수 1 증�?
                count[nextR][nextC]++;
            }

            // --- 2?�계: 충돌 ?�인 ??'?�태 ?�데?�트' ---

            // ?�아?��? 구슬?�을 ?�?�할 ?�시 배열 (최�? ?�재 구슬 개수만큼 ?�성)
            int[][] survivedMarbles = new int[currentMarbleCount][2];
            int survivorCount = 0; // ?�아?��? 구슬???��? ?� 변??

            // ?�동??구슬?�을 ?�나???�인
            for (int j = 0; j < currentMarbleCount; j++) {
                int r = nextMarbles[j][0];
                int c = nextMarbles[j][1];

                // ?�당 ?�치???�착??구슬??1개일 경우?�만 ?�아?�음
                if (count[r][c] == 1) {
                    survivedMarbles[survivorCount][0] = r;
                    survivedMarbles[survivorCount][1] = c;
                    survivorCount++; // ?�존????증�?
                }
            }

            marbles = survivedMarbles;
            currentMarbleCount = survivorCount;
        }

        System.out.println(currentMarbleCount);
    }
}
