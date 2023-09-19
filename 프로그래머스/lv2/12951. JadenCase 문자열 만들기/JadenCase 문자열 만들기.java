import java.util.*;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        
        String[] words = s.split(" ");
        for (int i=0;i<words.length;i++){
            if (words[i].length() == 0) {
                words[i] = " ";
                continue;
            }
            
            String first = words[i].substring(0,1).toUpperCase();
            String last = words[i].substring(1);
            
            words[i] = first + last;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<words.length;i++){
            sb.append(words[i]).append(" ");
            
            if (words[i].equals(" ")) sb.deleteCharAt(sb.length() - 1);
            
            if (i == words.length - 1 && s.charAt(s.length()-1) != ' ') sb.deleteCharAt(sb.length() - 1);
        }
        
        return sb.toString();
    }
}