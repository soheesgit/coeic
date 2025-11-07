package week3_3;

import java.util.*;
import java.io.*;

public class Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // D[i][j] = (i, j)까지 오는데 먹을 수 있는 최대 1의 개수
        int[][] D = new int[n][m];

        // 초기에 있는 배열 저장
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        D[0][0] = arr[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // 범위 조절하기
                int num1 = 0;
                int num2 = 0;

                if (i > 0) num1 = D[i-1][j];
                if (j > 0) num2 = D[i][j-1];

                // D[i][j] = max(D[i-1][j], D[i][j-1]) + arr[i][j]
                D[i][j] = Math.max(num1, num2) + arr[i][j];
            }
        }

        int answer = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(answer, D[i][j]);
            }
        }

        System.out.print(answer);
    }
}