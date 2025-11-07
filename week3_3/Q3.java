package week3_3;

import java.util.*;
import java.io.*;

public class Q3 {
    public static int n, k;
    public static String[] arr;
    public static boolean[] visited;
    public static HashSet<String> hash = new HashSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new String[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        permutation(0, "");

        System.out.print(hash.size());

    }

    //백트래킹
    public static void permutation(int count, String currentNum) {

        if (count == k) {
            hash.add(currentNum);
            return;
        }

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                visited[i] = true;
                permutation(count + 1, currentNum + arr[i]);
                visited[i] = false;
            }
        }
    }
}