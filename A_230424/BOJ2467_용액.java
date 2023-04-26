package A_230424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2467_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int s = 0;
        int e = N - 1;
        int min = Math.abs(arr[s] + arr[e]);
        int resultS = arr[s];
        int resultE = arr[e];
        while (s < e) {
            if (min == 0) break;
            if (Math.abs(arr[s] + arr[e]) <= min) {
                min = Math.abs(arr[e] + arr[s]);
                resultS = arr[s];
                resultE = arr[e];
            }
            if (Math.abs(arr[s + 1] + arr[e]) < Math.abs(arr[s] + arr[e - 1])) s++;
            else e--;
        }
        System.out.println(resultS + " " + resultE);
    }
}
