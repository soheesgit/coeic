package org.example.week2_5;

import java.util.*;
import java.io.*;

public class Q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int first_num = Integer.parseInt(st.nextToken());
            if (command.equals("add")) {
                hash.put(first_num, Integer.parseInt(st.nextToken()));
            } else if (command.equals("find")) {
                if (hash.containsKey(first_num)) System.out.println(hash.get(first_num));
                else System.out.println("None");
            } else {
                hash.remove(first_num);
            }
        }

    }
}
