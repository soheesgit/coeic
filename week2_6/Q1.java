package week2_6;

import java.util.*;
import java.io.*;

public class Q1 {
    public static int n;
    public static int m;
    public static int[][] graph;
    public static boolean[] visited;
    public static int cnt = 0;

    public static void DFS(int vertex) {
        for (int currV = 1; currV <= n; currV++) {
            if (graph[vertex][currV] == 1 && !visited[currV]) {
                visited[currV] = true;
                cnt++;
                DFS(currV);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n + 5][n + 5];
        visited = new boolean[n + 5];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        visited[1] = true;
        DFS(1);
        System.out.print(cnt);
    }
}