package A_230711;

import java.util.PriorityQueue;

public class PRG_더맵게_정승혜 {
    public static int solution (int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++)
            que.add(scoville[i]);
        while(que.peek() < K) {
            if (que.size() == 1) return -1;
            que.add(que.poll() + que.poll() * 2);
            answer++;
        }
        return answer;
    }
}
