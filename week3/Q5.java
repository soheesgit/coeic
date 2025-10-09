package org.example.week2_5;

import java.util.*;
import java.io.*;

public class Q5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        HashMap<String,Integer> hash = new HashMap<>();

        int maxCnt = -1;
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (!hash.containsKey(word)) hash.put(word, 1);
            else hash.put(word, hash.get(word) + 1);

            maxCnt = Math.max(maxCnt, hash.get(word));
        }
        System.out.print(maxCnt);


    }
}