package org.example.week2_1;
import java.util.*;
import java.io.*;

public class Q5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // ê²©ì???¬ê¸°
        int m = Integer.parseInt(st.nextToken()); // ì´ˆê¸° êµ¬ìŠ¬??ê°œìˆ˜
        int t = Integer.parseInt(st.nextToken()); // ?œê°„

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // ì´ˆê¸° êµ¬ìŠ¬ ?„ì¹˜ë¥??€?¥í•˜??2ì°¨ì› ë°°ì—´
        int[][] marbles = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            marbles[i][0] = Integer.parseInt(st.nextToken()) - 1;
            marbles[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        int[] dr = {-1, 1, 0, 0}; // ?? ?? ì¢? ??
        int[] dc = {0, 0, -1, 1};

        // ?„ì¬ êµ¬ìŠ¬??ê°œìˆ˜
        int currentMarbleCount = m;

        // tì´??™ì•ˆ ?œë??ˆì´??
        for (int i = 0; i < t; i++) {
            // êµ¬ìŠ¬???˜ë‚˜???†ìœ¼ë©??œë??ˆì´??ì¢…ë£Œ
            if (currentMarbleCount == 0) break;

            // --- 1?¨ê³„: ëª¨ë“  êµ¬ìŠ¬???¤ìŒ ?„ì¹˜ 'ê³„ì‚°' ---

            // ê°?êµ¬ìŠ¬???¤ìŒ ?„ì¹˜ë¥??„ì‹œ ?€?¥í•  ë°°ì—´
            int[][] nextMarbles = new int[currentMarbleCount][2];
            // ê°?ì¹¸ì— êµ¬ìŠ¬??ëª?ê°??„ì°©? ì? ì¹´ìš´?¸í•˜??ë°°ì—´
            int[][] count = new int[n][n];

            // ?„ì¬ ?´ì•„?ˆëŠ” êµ¬ìŠ¬ë§Œí¼ë§?ë°˜ë³µ
            for (int j = 0; j < currentMarbleCount; j++) {
                int r = marbles[j][0];
                int c = marbles[j][1];
                int maxNum = 0;
                int nextR = r; // ?€ì§ì´ì§€ ?Šì„ ê²½ìš°ë¥??€ë¹„í•´ ?„ì¬ ?„ì¹˜ë¡?ì´ˆê¸°??
                int nextC = c;

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        if (grid[nr][nc] > maxNum) {
                            maxNum = grid[nr][nc];
                            nextR = nr;
                            nextC = nc;
                        }
                    }
                }
                // ê³„ì‚°???¤ìŒ ?„ì¹˜ë¥??„ì‹œ ë°°ì—´???€??
                nextMarbles[j][0] = nextR;
                nextMarbles[j][1] = nextC;
                // ?´ë‹¹ ?„ì¹˜???„ì°©??êµ¬ìŠ¬ ê°œìˆ˜ 1 ì¦ê?
                count[nextR][nextC]++;
            }

            // --- 2?¨ê³„: ì¶©ëŒ ?•ì¸ ??'?íƒœ ?…ë°?´íŠ¸' ---

            // ?´ì•„?¨ì? êµ¬ìŠ¬?¤ì„ ?€?¥í•  ?„ì‹œ ë°°ì—´ (ìµœë? ?„ì¬ êµ¬ìŠ¬ ê°œìˆ˜ë§Œí¼ ?ì„±)
            int[][] survivedMarbles = new int[currentMarbleCount][2];
            int survivorCount = 0; // ?´ì•„?¨ì? êµ¬ìŠ¬???˜ë? ?€ ë³€??

            // ?´ë™??êµ¬ìŠ¬?¤ì„ ?˜ë‚˜???•ì¸
            for (int j = 0; j < currentMarbleCount; j++) {
                int r = nextMarbles[j][0];
                int c = nextMarbles[j][1];

                // ?´ë‹¹ ?„ì¹˜???„ì°©??êµ¬ìŠ¬??1ê°œì¼ ê²½ìš°?ë§Œ ?´ì•„?¨ìŒ
                if (count[r][c] == 1) {
                    survivedMarbles[survivorCount][0] = r;
                    survivedMarbles[survivorCount][1] = c;
                    survivorCount++; // ?ì¡´????ì¦ê?
                }
            }

            marbles = survivedMarbles;
            currentMarbleCount = survivorCount;
        }

        System.out.println(currentMarbleCount);
    }
}
