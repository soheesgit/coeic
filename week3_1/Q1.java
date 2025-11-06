package week3_1;

import java.util.*;
import java.io.*;

class Edge {
    int u, v;
    Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }
}

public class Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N + 1][N + 1];

        Edge[] edges = new Edge[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            graph[u][v] = 1;
            graph[v][u] = 1;

            edges[i] = new Edge(u, v);
        }

        int cnt = 0;
        for (Edge edge : edges) {
            int s = edge.u;
            int e = edge.v;
            for (int v = 0; v < N; v++) {
                if (graph[s][e] == 1 && graph[s][v] == 1 && graph[v][e] == 1) {
                    cnt++;
                }
            }
        }

        if (cnt >= 6) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
