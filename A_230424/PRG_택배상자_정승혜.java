package A_230424;

import java.util.Stack;

public class PRG_택배상자_정승혜 {
    public static int solution(int[] order) {
        int[] main = new int[order.length + 1];
        Stack<Integer> sub = new Stack<>();
        int answer = 0;
        int idx = 1;
        for (int o : order)
            main[o] = idx++;
        idx = 1;
        for (int i = 1; i < order.length + 1; i++) {
            if (main[i] == idx) {
                idx++;
                answer++;
            }
            else if(sub.isEmpty() || sub.peek()!=idx){
                sub.add(main[i]);
            }
            if(sub.isEmpty()) continue;
            int pk = sub.peek();
            while(pk == idx){
                idx++;
                answer++;
                sub.pop();
                if(sub.isEmpty()) break;
                pk = sub.peek();
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 1, 2, 5}));
        System.out.println(solution(new int[]{5, 4, 3, 2, 1}));
    }
}
