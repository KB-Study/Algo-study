package A_230711;

public class PRG_징검다리건너기_정승혜 {
    // 구글링
    public static int solution(int[] stones, int k) {
        int low = 1;
        int high = 200000000;
        int mid = 0;
        int answer = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(!cross(stones, k, mid))  high = mid - 1;
            else {
                low = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        return answer;
    }

    public static boolean cross(int[] stones, int k, int mid) {
        int cnt = 0;
        for (int stone : stones) {
            if (stone - mid < 0)  cnt++;
            else   cnt = 0;
            if (cnt == k) return false;
        }
        return true;
    }

    /*
    public static int solution(int[] stones, int k) {
        int answer = stones.length;
        int index = 0;
        while(index < stones.length){
            int tmpMax = 0;
            int tmpIdx = index;
            if(stones.length - index < k) break;
            for(int i = index; i < index + k; i++){
                if(tmpMax <= stones[i]){
                    tmpMax = stones[i];
                    tmpIdx = i;
                }
            }
            index = tmpIdx + 1;
            answer = Math.min(answer, tmpMax);
        }
        return answer;
    }*/
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1},3));
    }
}
