import java.util.*;

class Solution {
    public String solution(String letter) {
        
        String[] letters = letter.split(" ");

        String[] morse = {".-","-...","-.-.","-..",".","..-.",
                "--.","....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-","...-",
                ".--","-..-","-.--","--.."};
        
        String answer = "";
        
        for (String s : letters) {
            for (int i=0;i<morse.length;i++){
                if (s.equals(morse[i])){
                    answer += (char) (i + 'a');
                }
            }
        }
        
        return answer;
        
    }
}