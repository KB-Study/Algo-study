package A_230711;

import java.util.ArrayList;
import java.util.HashSet;

public class PRG_불량사용자_정승혜 {
    static HashSet<HashSet<Integer>> result;
    public static int solution(String[] user_id, String[] banned_id) {
        result = new HashSet<>();
        ArrayList<Integer>[] matchIdx = new ArrayList[banned_id.length]; // banned_id와 일치하는 index
        for (int i = 0; i < banned_id.length; i++) {
            matchIdx[i] = new ArrayList<>();
            for (int j = 0; j < user_id.length; j++)
                if(match(banned_id[i], user_id[j])) matchIdx[i].add(j);
        }
        dfs(0, new HashSet<>(),matchIdx);
        return result.size();
    }
    public static void dfs(int idx, HashSet<Integer> set, ArrayList<Integer>[] matchIdx){
        if(idx == matchIdx.length){
            result.add(set);
            return;
        }
        ArrayList<Integer> arr = matchIdx[idx];
        for (int i = 0; i < arr.size(); i++) {
            if(!set.contains(arr.get(i))){
                set.add(arr.get(i));
                dfs(idx + 1, new HashSet<>(set), matchIdx);
                set.remove(arr.get(i));
            }
        }
    }
    public static boolean match(String banned, String user_id){
        if(banned.length() != user_id.length()) return false;
        for (int i = 0; i < banned.length(); i++)
            if(banned.charAt(i) != '*' && banned.charAt(i) != user_id.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }
}
