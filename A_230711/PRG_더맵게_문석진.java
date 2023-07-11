package A_230711;

import java.util.PriorityQueue;

public class PRG_더맵게_문석진 {
    public static int solution (int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            que.offer(scoville[i]);
        }

        while(que.peek() < K) {
            if (que.size() < 2) return -1;
            int food1 = que.poll();
            int food2 = que.poll();

            int newFood = food1 + (food2 * 2);
            que.offer(newFood);
            answer++;
        }
        return answer;
    }
}
