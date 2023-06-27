package A_230628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563_색종이_문석진 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] whitePaper = new boolean[100][100];

        int papers = Integer.parseInt(br.readLine()); // 색종이의 수
        for (int i = 0; i < papers; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()); // x 좌표 : 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리
            int y = Integer.parseInt(st.nextToken()); // y 좌표 : 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리

            for (int j = x; j < (x + 10); j++) {
                for (int k = y; k < (y + 10); k++) {
                    whitePaper[j][k] = true;
                }
            }
        }

        int result = 0;
        for (boolean[] arr : whitePaper) {
            for (boolean check : arr) {
                if (check) result++;
            }
        }

        System.out.println(result);
    }
}
