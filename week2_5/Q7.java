package org.example.week2_5;

import java.util.*;
import java.io.*;

public class Q7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[k];
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer>[] visited = new HashSet[n + 1];
        int[] arr = new int[n + 10];
        int[] cnt = new int[n + 10];
        for (int i = 1; i <= n; i++) { // 처음???�리???�람 채우�?
            visited[i] = new HashSet<Integer>();
            arr[i] = i;
            visited[i].add(i);
            cnt[i] = 1;
        }

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < k; i++) {

                // 변??로직
                int temp = arr[a[i]];
                arr[a[i]] = arr[b[i]];
                arr[b[i]] = temp;

                if (!visited[arr[a[i]]].contains(a[i])) {
                    visited[arr[a[i]]].add(a[i]);
                    cnt[arr[a[i]]]++;
                }
                if (!visited[arr[b[i]]].contains(b[i])) {
                    visited[arr[b[i]]].add(b[i]);
                    cnt[arr[b[i]]]++;
                }

            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(cnt[i]);
        }


    }
}
