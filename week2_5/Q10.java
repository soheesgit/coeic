package org.example.week2_5;

import java.util.*;
import java.io.*;


public class Q10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        HashMap<Integer, Integer> hash = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int num = A[j] + B[i];
                hash.put(num, hash.getOrDefault(num, 0) + 1); // 빈도???�??
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            C[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            D[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int target = - (C[j] + D[i]);

                if (hash.containsKey(target)) cnt += hash.get(target);
            }
        }

        System.out.println(cnt);


    }
}
