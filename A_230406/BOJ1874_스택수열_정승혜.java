package A_230406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874_스택수열_정승혜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        int num = 1;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            while (num <= arr[i]) {
                stack.push(num++);
                sb.append("+\n");
            }
            if (arr[i] == stack.pop())
                sb.append("-\n");
            else {
                System.out.println("NO");
                return;
            }
        }
        System.out.print(sb.toString());
    }
}
