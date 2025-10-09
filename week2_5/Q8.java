package org.example.week2_5;

import java.util.*;
import java.io.*;

public class Q8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        HashMap<Integer, Integer> hash = new HashMap<>(); //?«ì. ë¹ˆë„???€??

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            hash.put(num, hash.getOrDefault(num, 0) + 1); // ë¹ˆë„???€??
        }

        int count = 0;

        for (int i = 0; i < n; i++) { //ë°°ì—´ ?„ë? ?•ì¸
            int num = arr[i];
            int target = k - num;

            // ì§ê¿(target)??HashMap???ˆëŠ”ì§€ ?•ì¸
            if (hash.containsKey(target)) {
                int targetCount = hash.get(target);

                // ë§Œì•½ ì§ê¿???ê¸° ?ì‹ ?´ë¼ë©? (?? k=8, num=4, target=4)
                if (num == target) {
                    // ?„ì²´ ê°œìˆ˜?ì„œ ?ê¸° ?ì‹ (1ê°???ëº€ ë§Œí¼??ì§ê¿????
                    count += (targetCount - 1);
                } else {
                    // ì§ê¿???¤ë¥¸ ?«ì?¼ë©´, ê·??«ì??ê°œìˆ˜ë§Œí¼ ?”í•¨
                    count += targetCount;
                }
            }
        }

        // 3. ëª¨ë“  ?ì´ (a,b), (b,a) ?´ë ‡ê²???ë²ˆì”© ?¸ì–´ì¡Œìœ¼ë¯€ë¡?2ë¡??˜ëˆ”
        System.out.println(count / 2);
    }
}
