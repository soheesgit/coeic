package org.example.week2_1;
import java.util.*;
import java.io.*;

public class Q5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 격자판 크기
        int m = Integer.parseInt(st.nextToken()); // 초기 구슬의 개수
        int t = Integer.parseInt(st.nextToken()); // 시간

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 구슬 위치를 저장하는 2차원 배열
        int[][] marbles = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            marbles[i][0] = Integer.parseInt(st.nextToken()) - 1;
            marbles[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
        int[] dc = {0, 0, -1, 1};

        // 현재 구슬의 개수
        int currentMarbleCount = m;

        // t초 동안 시뮬레이션
        for (int i = 0; i < t; i++) {
            // 구슬이 하나도 없으면 시뮬레이션 종료
            if (currentMarbleCount == 0) break;

            // --- 1단계: 모든 구슬의 다음 위치 '계산' ---

            // 각 구슬의 다음 위치를 임시 저장할 배열
            int[][] nextMarbles = new int[currentMarbleCount][2];
            // 각 칸에 구슬이 몇 개 도착할지 카운트하는 배열
            int[][] count = new int[n][n];

            // 현재 살아있는 구슬만큼만 반복
            for (int j = 0; j < currentMarbleCount; j++) {
                int r = marbles[j][0];
                int c = marbles[j][1];
                int maxNum = 0;
                int nextR = r; // 움직이지 않을 경우를 대비해 현재 위치로 초기화
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
                // 계산된 다음 위치를 임시 배열에 저장
                nextMarbles[j][0] = nextR;
                nextMarbles[j][1] = nextC;
                // 해당 위치에 도착할 구슬 개수 1 증가
                count[nextR][nextC]++;
            }

            // --- 2단계: 충돌 확인 후 '상태 업데이트' ---

            // 살아남은 구슬들을 저장할 임시 배열 (최대 현재 구슬 개수만큼 생성)
            int[][] survivedMarbles = new int[currentMarbleCount][2];
            int survivorCount = 0; // 살아남은 구슬의 수를 셀 변수

            // 이동할 구슬들을 하나씩 확인
            for (int j = 0; j < currentMarbleCount; j++) {
                int r = nextMarbles[j][0];
                int c = nextMarbles[j][1];

                // 해당 위치에 도착한 구슬이 1개일 경우에만 살아남음
                if (count[r][c] == 1) {
                    survivedMarbles[survivorCount][0] = r;
                    survivedMarbles[survivorCount][1] = c;
                    survivorCount++; // 생존자 수 증가
                }
            }

            marbles = survivedMarbles;
            currentMarbleCount = survivorCount;
        }

        System.out.println(currentMarbleCount);
    }
}