package org.example.week2_5;

import java.util.*;
import java.io.*;

public class Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashSet<Integer> arr1 = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());

        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());

            if(arr1.contains(arr2[i])) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }



    }
}