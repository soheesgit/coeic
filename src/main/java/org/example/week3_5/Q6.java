package org.example.week3_5;

import java.util.*;
import java.io.*;

public class Q6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set1 = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set1.add(Integer.parseInt(st.nextToken()));
        }
        System.out.print(set1.size());

    }
}
