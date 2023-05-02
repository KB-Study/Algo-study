package A_230503;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9935_문자열폭발_정승혜 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String del = br.readLine();
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result.append(ch);
            if (result.length() >= del.length()) {
                boolean flag = true;
                for (int j = 0; j < del.length(); j++) {
                    if(result.charAt(result.length()- del.length() + j) != del.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    result.delete(result.length()-del.length(),result.length());
            }
        }
        if (result.length() == 0) System.out.println("FRULA");
        else System.out.println(result);
    }
}
