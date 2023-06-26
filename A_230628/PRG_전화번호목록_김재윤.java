package A_230628;
import java.util.*;

public class PRG_전화번호목록_김재윤 {
    class Solution {
        public boolean solution(String[] phone_book) {

            Set<String> set = new HashSet<>();

            for (String phone : phone_book) {
                set.add(phone);
            }

            for (String phone : phone_book) {
                for (int i = 1; i < phone.length(); i++) {
                    if (set.contains(phone.substring(0, i))) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
