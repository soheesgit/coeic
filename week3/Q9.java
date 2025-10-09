package org.example.week2_5;

import java.util.*;
import java.io.*;

public class Q9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        HashMap<Integer, Integer> hash = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            hash.put(num, hash.getOrDefault(num, 0) + 1); // 빈도수 저장
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int third_num = k - arr[i] - arr[j];

                if (hash.containsKey(third_num)) {
                    int third_num_count = hash.get(third_num);

                    // 3번째 수가 arr[i]라면 카운트 1개 제외
                    if (third_num == arr[i]) {
                        third_num_count--;
                    }
                    // 3번째 수가 arr[j]라면 카운트 1개 제외
                    if (third_num == arr[j]) {
                        third_num_count--;
                    }

                    // 남아있는 세 번째 숫자의 개수만큼 더한다.
                    if (third_num_count > 0) count += third_num_count;
                }
            }
        }

        System.out.println(count / 3);
    }
}