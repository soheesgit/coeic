package org.example.week2_1;


import java.util.*;
import java.io.*;

public class Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] top = new int[n];
        int[] bottom = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            top[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bottom[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < t; i++) {
            int tempTop = top[n - 1]; //맨위벨트??마�?막값
            int tempBottom = bottom[n - 1]; //맨아?�벨?�의 첫값

            // ??벨트: ?�른쪽으�???칸씩 ?�동
            for (int j = n - 1; j > 0; j--) {
                top[j] = top[j - 1];
            }

            // ?�래 벨트: ?�쪽?�로 ??칸씩 ?�동
            for (int j = n - 1; j > 0; j--) {
                bottom[j] = bottom[j-1];
            }

            top[0] = tempBottom;
            bottom[0] = tempTop;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(top[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(bottom[i] + " ");
        }
    }
}
