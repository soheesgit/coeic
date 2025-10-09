package org.example.week2_1;

import java.io.*;
import java.util.StringTokenizer;

public class Q3 {
    public static final int MAX_N = 100;

    public static int n;
    public static int[] numbers = new int[MAX_N];
    public static int endOfArray;

    // ?�력 배열?�서 지?�고???�는 부�??�열????��?�니??
    public static void cutArray(int startIdx, int endIdx) {
        int[] tempArr = new int[MAX_N];
        int endOfTempArray = 0;

        // 구간 ?�의 부분만 temp 배열???�서?��??�?�합?�다.
        for (int i = 0; i < endOfArray; i++) {
            if (i < startIdx || i > endIdx) {
                tempArr[endOfTempArray++] = numbers[i];
            }
        }

        // temp 배열???�시 numbers 배열�???��줍니??
        for (int i = 0; i < endOfTempArray; i++) {
            numbers[i] = tempArr[i];
        }

        endOfArray = endOfTempArray;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ?�력: n
        n = Integer.parseInt(br.readLine());

        // 블록 �??�력
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        endOfArray = n;

        // ??번에 걸쳐 지?�는 과정
        for (int k = 0; k < 2; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            s--; e--;  // 0-index 변??
            cutArray(s, e);
        }

        // 출력
        System.out.println(endOfArray);
        for (int i = 0; i < endOfArray; i++) {
            System.out.println(numbers[i]);
        }
    }
}
