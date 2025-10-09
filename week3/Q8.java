package org.example.week2_5;

import java.util.*;
import java.io.*;

public class Q8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        HashMap<Integer, Integer> hash = new HashMap<>(); //숫자. 빈도수 저장

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            hash.put(num, hash.getOrDefault(num, 0) + 1); // 빈도수 저장
        }

        int count = 0;

        for (int i = 0; i < n; i++) { //배열 전부 확인
            int num = arr[i];
            int target = k - num;

            // 짝꿍(target)이 HashMap에 있는지 확인
            if (hash.containsKey(target)) {
                int targetCount = hash.get(target);

                // 만약 짝꿍이 자기 자신이라면? (예: k=8, num=4, target=4)
                if (num == target) {
                    // 전체 개수에서 자기 자신(1개)을 뺀 만큼이 짝꿍의 수
                    count += (targetCount - 1);
                } else {
                    // 짝꿍이 다른 숫자라면, 그 숫자의 개수만큼 더함
                    count += targetCount;
                }
            }
        }

        // 3. 모든 쌍이 (a,b), (b,a) 이렇게 두 번씩 세어졌으므로 2로 나눔
        System.out.println(count / 2);
    }
}