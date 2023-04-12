package A_230412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17070_파이프옮기기1_정승혜 {
    static int n;
    static int[][] matrix;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }
        if (matrix[n - 1][n - 1] == 1) {
            System.out.println(0);
            return;
        }
        /*goRight(0, 2);
        goCross(1, 2);*/
        dfs(0, 1, 0);
        System.out.println(count);
    }

    static void dfs(int r, int c, int dir) {
        if (r == n - 1 && c == n - 1) {
            count++;
            return;
        }
        switch (dir) {
            case 0:
                if (c + 1 < n && matrix[r][c + 1] == 0)
                    dfs(r, c + 1, 0);
                break;
            case 1:
                if (r + 1 < n && matrix[r + 1][c] == 0)
                    dfs(r + 1, c, 1);
                break;
            case 2:
                if (c + 1 < n && matrix[r][c + 1] == 0)
                    dfs(r, c + 1, 0);
                if (r + 1 < n && matrix[r + 1][c] == 0)
                    dfs(r + 1, c, 1);
                break;
        }
        if (c + 1 < n && r + 1 < n && matrix[r][c + 1] == 0 && matrix[r + 1][c] == 0 && matrix[r + 1][c + 1] == 0)
            dfs(r + 1, c + 1, 2);
    }
/*
    static void goRight(int r, int c) {
        if (r == n - 1 && c == n - 1) {
            count++;
            return;
        }
        if (c >= n || matrix[r][c] == 1) return;
        goRight(r, c + 1);
        goCross(r + 1, c + 1);
    }

    static void goDown(int r, int c) {
        if (r == n - 1 && c == n - 1) {
            count++;
            return;
        }
        if (r >= n || matrix[r][c] == 1) return;
        goDown(r + 1, c);
        goCross(r + 1, c + 1);
    }

    static void goCross(int r, int c) {
        if (r == n - 1 && c == n - 1) {
            count++;
            return;
        }
        if (c >= n || r >= n || matrix[r][c - 1] == 1 || matrix[r - 1][c] == 1 || matrix[r][c] == 1)
            return;
        goRight(r, c + 1);
        goCross(r + 1, c + 1);
        goDown(r + 1, c);
    }*/
}
