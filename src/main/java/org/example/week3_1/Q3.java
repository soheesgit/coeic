package org.example.week3_1;

import java.io.*;
import java.util.StringTokenizer;

public class Q3 {
    public static final int MAX_N = 100;

    public static int n;
    public static int[] numbers = new int[MAX_N];
    public static int endOfArray;

    // 입력 배열에서 지우고자 하는 부분 수열을 삭제합니다.
    public static void cutArray(int startIdx, int endIdx) {
        int[] tempArr = new int[MAX_N];
        int endOfTempArray = 0;

        // 구간 외의 부분만 temp 배열에 순서대로 저장합니다.
        for (int i = 0; i < endOfArray; i++) {
            if (i < startIdx || i > endIdx) {
                tempArr[endOfTempArray++] = numbers[i];
            }
        }

        // temp 배열을 다시 numbers 배열로 옮겨줍니다.
        for (int i = 0; i < endOfTempArray; i++) {
            numbers[i] = tempArr[i];
        }

        endOfArray = endOfTempArray;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력: n
        n = Integer.parseInt(br.readLine());

        // 블록 값 입력
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        endOfArray = n;

        // 두 번에 걸쳐 지우는 과정
        for (int k = 0; k < 2; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            s--; e--;  // 0-index 변환
            cutArray(s, e);
        }

        // 출력
        System.out.println(endOfArray);
        for (int i = 0; i < endOfArray; i++) {
            System.out.println(numbers[i]);
        }
    }
}
