package A_230424;

import java.util.Stack;

public class PRG_택배상자_김재윤 {

    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stk = new Stack<>();
        int num = 1;
        int cnt = 0;
        while (num != order[0]) {
            stk.push(num++);
        }
        boolean flag = true;
        int idx = 0;
        while (flag) {
            //  System.out.println(stk);
            if (idx == order.length) break;
            if (num <= order[idx]) {
                stk.push(num++);
            } else {
                if (!stk.isEmpty()) {
                    if (order[idx] == stk.peek()) {
                        idx++;
                        cnt++;
                        stk.pop();
                    } else
                        flag = false;
                } else
                    break;

            }
        }
        return cnt;
    }

}
