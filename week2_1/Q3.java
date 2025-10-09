package org.example.week2_1;

import java.io.*;
import java.util.StringTokenizer;

public class Q3 {
    public static final int MAX_N = 100;

    public static int n;
    public static int[] numbers = new int[MAX_N];
    public static int endOfArray;

    // ?…ë ¥ ë°°ì—´?ì„œ ì§€?°ê³ ???˜ëŠ” ë¶€ë¶??˜ì—´???? œ?©ë‹ˆ??
    public static void cutArray(int startIdx, int endIdx) {
        int[] tempArr = new int[MAX_N];
        int endOfTempArray = 0;

        // êµ¬ê°„ ?¸ì˜ ë¶€ë¶„ë§Œ temp ë°°ì—´???œì„œ?€ë¡??€?¥í•©?ˆë‹¤.
        for (int i = 0; i < endOfArray; i++) {
            if (i < startIdx || i > endIdx) {
                tempArr[endOfTempArray++] = numbers[i];
            }
        }

        // temp ë°°ì—´???¤ì‹œ numbers ë°°ì—´ë¡???²¨ì¤ë‹ˆ??
        for (int i = 0; i < endOfTempArray; i++) {
            numbers[i] = tempArr[i];
        }

        endOfArray = endOfTempArray;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ?…ë ¥: n
        n = Integer.parseInt(br.readLine());

        // ë¸”ë¡ ê°??…ë ¥
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        endOfArray = n;

        // ??ë²ˆì— ê±¸ì³ ì§€?°ëŠ” ê³¼ì •
        for (int k = 0; k < 2; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            s--; e--;  // 0-index ë³€??
            cutArray(s, e);
        }

        // ì¶œë ¥
        System.out.println(endOfArray);
        for (int i = 0; i < endOfArray; i++) {
            System.out.println(numbers[i]);
        }
    }
}
