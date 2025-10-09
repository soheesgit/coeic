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
        HashMap<Integer, Integer> hash = new HashMap<>(); //?�자. 빈도???�??

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            hash.put(num, hash.getOrDefault(num, 0) + 1); // 빈도???�??
        }

        int count = 0;

        for (int i = 0; i < n; i++) { //배열 ?��? ?�인
            int num = arr[i];
            int target = k - num;

            // 짝꿍(target)??HashMap???�는지 ?�인
            if (hash.containsKey(target)) {
                int targetCount = hash.get(target);

                // 만약 짝꿍???�기 ?�신?�라�? (?? k=8, num=4, target=4)
                if (num == target) {
                    // ?�체 개수?�서 ?�기 ?�신(1�???뺀 만큼??짝꿍????
                    count += (targetCount - 1);
                } else {
                    // 짝꿍???�른 ?�자?�면, �??�자??개수만큼 ?�함
                    count += targetCount;
                }
            }
        }

        // 3. 모든 ?�이 (a,b), (b,a) ?�렇�???번씩 ?�어졌으므�?2�??�눔
        System.out.println(count / 2);
    }
}
