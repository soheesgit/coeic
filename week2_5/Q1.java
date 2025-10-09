package org.example.week2_5;

import java.util.*;
import java.io.*;
public class Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> s = new HashSet<>();


        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x = Integer.parseInt(st.nextToken());

            if (command.equals("find")) {
                if (s.contains(x))  System.out.println("true");
                else System.out.println("false");
            }
            else if (command.equals("add")) {
                s.add(x);
            } else {
                s.remove(x);
            }
        }



    }
}
