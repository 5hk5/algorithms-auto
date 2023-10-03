import java.util.*;

class Solution {
    public String solution(String s) {
        int sLength = s.length();
        
        StringBuilder sb = new StringBuilder();
        
        if (sLength % 2 == 0) {
            sb.append(s.charAt(sLength/2-1));
            sb.append(s.charAt(sLength/2));
        } else {
            sb.append(s.charAt(sLength/2));
        }
        
        return sb.toString();
    }
}