package week3_3;

import java.util.*;
import java.io.*;

public class Q2 {
    public static final int MAX_SIZE = 100001;
    public static int n, k;
    public static int[] visited = new int[MAX_SIZE];

    // 최단 거리를 찾는 bfs 함수입니다.
    public static int bfs() {
        LinkedList<Integer> dq = new LinkedList<>();
        dq.add(n);
        visited[n] = 1;

        while (!dq.isEmpty()) {
            int cur = dq.poll();

            // k에 도달한 경우 해당 거리를 반환합니다.
            if(cur == k) return visited[k] - 1;

            // 2번 연산의 경우, 2 * cur의 위치로 이동 가능합니다.
            // 2번 연산은 몇번을 해도 상관 없으므로 덱의 앞쪽에 추가합니다.
            if (cur * 2 < MAX_SIZE && visited[cur * 2] == 0) {
                dq.addFirst(cur * 2);
                visited[cur * 2] = visited[cur];
            }

            // 1번 연산은 cur + 1 또는 cur - 1로 이동합니다.
            // 1번 연산은 덱의 뒤쪽에 추가합니다.
            if (cur + 1 < MAX_SIZE && visited[cur + 1] == 0) {
                dq.add(cur + 1);
                visited[cur + 1] = visited[cur] + 1;
            }

            if (cur - 1 >= 0 && visited[cur - 1] == 0) {
                dq.add(cur - 1);
                visited[cur - 1] = visited[cur] + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 시작점과 도착점을 입력받습니다.
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // bfs 함수를 호출한 결과를 출력합니다.
        System.out.println(bfs());
    }
}
