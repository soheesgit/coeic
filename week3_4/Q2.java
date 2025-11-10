package week3_4;

import java.util.*;
import java.io.*;
//DP가 안되면 그리디
// 자르는 행위를 어디에 투자할건지 잘 생각하기
public class Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numSticks = Integer.parseInt(st.nextToken());
        int maxCuts = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> other = new ArrayList<>();
        int result_cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numSticks; i++) {
            int sticks = Integer.parseInt(st.nextToken());

            if (sticks < 10) continue; // 1. 10보다 작은 막대는 무조건 버림
            else if (sticks == 10) result_cnt++; //10이면 바로 카운트
            else if (sticks % 10 == 0) { // 2. 10의 배수가 좋음
                arr.add(sticks);
            } else {
                other.add(sticks); //3. 나머지 저장하는 리스트에 넣기
            }
        }

        Collections.sort(arr); // 3. 더 작은 길이가 좋음 작은 거부터 시도하게 정렬
        Collections.sort(other);

        for (int stick : arr) {
            if (maxCuts == 0) break; //자를 수 있는 잔여 횟수 XX

            int slice_piece_num = stick / 10; //몇조각 나오는지
            int slice_try = slice_piece_num - 1; //몇번 잘라봐야하는지

            if (slice_try <= maxCuts) { //잔여 횟수가 남으면 자르기
                result_cnt += slice_piece_num;
                maxCuts -= slice_try;
            } else {
                result_cnt += maxCuts; //자르는대로 10cm가 나오니까 남은 횟수 다 자르기
                maxCuts = 0;
            }
        }

        for (int stick : other) {
            if (maxCuts == 0) break; //자를 수 있는 잔여 횟수 XX

            int slice_piece_num = stick / 10; //몇조각 나오는지
            if (slice_piece_num <= maxCuts) { //잔여 횟수가 남으면 자르기
                result_cnt += slice_piece_num;
                maxCuts -= slice_piece_num;
            } else {
                result_cnt += maxCuts; //자르는대로 10cm가 나오니까 남은 횟수 다 자르기
                maxCuts = 0;
            }
        }

        System.out.print(result_cnt);

    }
}