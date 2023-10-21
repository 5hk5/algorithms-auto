import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split("");
        
        int index = 0;
        for (int i=0;i<words.length;i++){
            if (words[i].equals(" ")){
                index = 0;
            } else if (index % 2 == 0){ // 짝수 인덱스
                words[i] = words[i].toUpperCase();
                index++;
            } else if (index % 2 == 1){ // 홀수 인덱스
                words[i] = words[i].toLowerCase();
                index++;
            }
            
            answer += words[i];
        }
        
        return answer;    
    }
}