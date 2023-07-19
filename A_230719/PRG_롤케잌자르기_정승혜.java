package A_230719;
import java.util.*;
public class PRG_롤케잌자르기_정승혜 {
    public int solution(int[] topping) {
        int answer = 0;
        int[] arr1 = new int[10001];
        int[] arr2 = new int[10001];
        int cnt1 = 0;
        int cnt2 = 0;
        for(int t : topping) {
            if(arr1[t] == 0) cnt1++;
            arr1[t]++;
        }
        for(int t : topping) {
            arr1[t]--;
            if(arr1[t] == 0) cnt1--;
            if(arr2[t] == 0) cnt2++;
            arr2[t]++;
            if(cnt1 == cnt2) answer++;
        }
        return answer;
    }
}
