package A_230424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503_로봇청소기_정승혜 {
    static int n, m;
    static int[][] mat; //0:청소안됨  1:벽
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                mat[i][j] = Integer.parseInt(st.nextToken());
        }
        clean(r, c, d);
        System.out.println(count);
    }
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static void clean(int r, int c, int d) {
        if (mat[r][c] == 0) {
            count++;
            mat[r][c] = -1; // 청소 한 칸은 -1
        }
        for (int i = d - 1; i > d - 5; i--) {
            int dir = (i + 4) % 4;
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (nr >= 0 && nc >= 0 && nr < n && nc < m && mat[nr][nc] == 0) {
                clean(nr, nc, dir);
                return;
            }
        }
        int i = (d + 2) % 4;
        if (r + dr[i] >= 0 && r + dr[i] < n && c + dc[i] >= 0 && c + dc[i] < m && mat[r + dr[i]][c + dc[i]] != 1)
            clean(r + dr[i], c + dc[i], d);
    }
}
