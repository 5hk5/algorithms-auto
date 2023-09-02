import java.util.*;

class Solution {
    public String solution(String s) {
        char[] sArray = s.toCharArray();
        
        Arrays.sort(sArray);
        
        StringBuilder sb = new StringBuilder(new String(sArray,0,sArray.length));
        
        return sb.reverse().toString();
    }
}