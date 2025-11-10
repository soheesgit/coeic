package week3_4;

import java.util.*;
import java.io.*;

public class Q1 {
    static int N;
    static char[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<N; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int regionsNormal = countRegions(false);

        int regionsColorblind = countRegions(true);

        System.out.println(regionsNormal + " " + regionsColorblind);
    }

    static int countRegions(boolean isColorblind) {
        visited = new boolean[N][N];
        int regions = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, isColorblind, grid[i][j]);
                    regions++;
                }
            }
        }
        return regions;
    }


    static void dfs(int row, int col, boolean isColorblind, char currentColor) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});
        visited[row][col] = true;

        while(!stack.isEmpty()) {
            int[] pos = stack.pop();
            int r = pos[0];
            int c = pos[1];

            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >=0 && nr < N && nc >=0 && nc < N && !visited[nr][nc]) {
                    char neighborColor = grid[nr][nc];
                    if(isColorblind) { //색약의 경우
                        if( ( (currentColor == 'R' || currentColor == 'G') && (neighborColor == 'R' || neighborColor == 'G') )
                                || (currentColor == neighborColor)) {
                            visited[nr][nc] = true;
                            stack.push(new int[]{nr, nc});
                        }
                    }
                    else { //보통의 경우
                        if(neighborColor == currentColor) {
                            visited[nr][nc] = true;
                            stack.push(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
    }
}
