package A_230510;

import java.util.Arrays;

public class PRG_단속카메라_정승혜 {
    static int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];});
        int prev = routes[0][1];
        int count = 1;
        for (int i = 1; i < routes.length; i++) {
            if (prev <= routes[i][1] && prev >= routes[i][0])
                continue;
            count++;
            prev = routes[i][1];
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}));
    }
}
