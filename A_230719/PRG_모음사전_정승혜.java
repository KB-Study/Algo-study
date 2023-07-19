package A_230719;
import java.util.*;
public class PRG_모음사전_정승혜 {
    public int solution(String word) {
        int answer = 0;

        Map<Character, Integer> index = new HashMap<>();
        index.put('A',0);
        index.put('E',1);
        index.put('I',2);
        index.put('O',3);
        index.put('U',4);
        int[] weight = {781, 156, 31, 6, 1};

        for(int i = 0; i < word.length(); i++)
            answer += index.get(word.charAt(i)) * weight[i] + 1;

        return answer;
    }
}
