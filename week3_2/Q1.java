package week3_2;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.io.*;

public class Q1 {
    public static int n;
    public static String t;
    public static int[] tChar = new int[26]; //t의 각 문자 개수
    public static int[] selectedChar = new int[26];
    public static SimpleEntry<Integer, String>[] book = new SimpleEntry[16];

    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = br.readLine();
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < t.length(); i++) tChar[t.charAt(i) - 'A']++;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            book[i] = new SimpleEntry<>(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        combination(0, 0);

        if (result == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(result);
        }
    }

    public static boolean check() {
        for (int i = 0; i < 26; i++) {
            // t의 문자에서 필요로하는게 이번 배열에 없다면 false 리턴
            if (tChar[i] > selectedChar[i]) return false;
        }
        return true;
    }

    public static void combination(int cnt, int priceSum) {
        // cnt가 n에 도달했을 때 조건을 만족하면 결과 업데이트
        if (cnt == n) {
            if (check()) {
                result = Math.min(result, priceSum);
            }
            return;
        }

        //이번 문자의 char 세기
        for (int i = 0; i < book[cnt].getValue().length(); i++) {
            selectedChar[book[cnt].getValue().charAt(i) - 'A']++;
        }

        combination(cnt + 1, priceSum + book[cnt].getKey());

        for (int i = 0; i < book[cnt].getValue().length(); i++) {
            selectedChar[book[cnt].getValue().charAt(i) - 'A']--;
        }

        combination(cnt + 1, priceSum);
    }
}