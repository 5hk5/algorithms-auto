import java.util.*;

class Solution {
    public long solution(long n) {
        String[] newS = String.valueOf(n).split("");
        Arrays.sort(newS, Collections.reverseOrder());
                
        String answer = "";
        for (String s : newS){
            answer += s;
        }
        
        return Long.parseLong(answer);
    }
}