package A_230503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class BOJ17952_과제는끝나지않아_정승혜 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<int[]> stack = new LinkedList<>(); // int[] : {score, restTime}
        int result = 0;
        int[] tmp;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 0) {
                if(stack.isEmpty()) continue;
                tmp = stack.pop();
                tmp[1]--;
                if (tmp[1] == 0) result += tmp[0];
                else stack.push(tmp);
            } else {
                int score = Integer.parseInt(st.nextToken());
                int rest = Integer.parseInt(st.nextToken()) - 1;
                if(rest == 0) result += score;
                else stack.push(new int[]{score, rest});
            }
        }
        System.out.println(result);
    }
}
