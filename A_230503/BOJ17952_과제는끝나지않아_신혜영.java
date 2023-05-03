import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BOJ17952_과제는끝나지않아_신혜영 {
	static class Score {
        int score, time;

        public Score(int score, int time) {
            this.score = score;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Score{" +
                "score=" + score +
                ", time=" + time +
                '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine()); // 총 학기

        List<Score> table = new ArrayList<>();

        // 데이터 포맷
        for (int i = 0; i < total; i++) {
            String temp = br.readLine();

            if (!temp.equals("0")) {
                String[] tempArr = temp.split(" ");

                table.add(new Score(Integer.parseInt(tempArr[1]), Integer.parseInt(tempArr[2])));
            } else {
                table.add(new Score(0, 0));
            }

        }
        int answer = 0; // 총 점수
//        Score beforeScore = new Score(0, 0);
        Deque<Score> beforeScore = new ArrayDeque<>();
        int nowTime = -1; // 지금 하는 과제
        int nowScore = -1; // 지금 하는 과제 점수

        for (Score now : table) {
            if (now.score != 0) {
                // 기억해두기
//                beforeScore = new Score(nowScore, nowTime);
                beforeScore.add(new Score(nowScore, nowTime));
                nowTime = now.time;
                nowScore = now.score;
            } else {
                if (nowTime == 0) {
                    // 이전 과제 실행
                	if (!beforeScore.isEmpty()) {
                		Score temp = beforeScore.pollLast();
                		nowTime = temp.time;
                        nowScore = temp.score;
                	}
                    
                }
            }
            nowTime--;
            if (nowTime == 0) {
                answer += nowScore;
            }
        }
        System.out.println(answer);
    }
}
