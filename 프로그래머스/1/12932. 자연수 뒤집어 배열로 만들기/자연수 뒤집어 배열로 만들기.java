import java.util.*;

class Solution {
    public int[] solution(long n) {
        String[] numbers = Long.toString(n).split("");
                
        int[] answer = new int[numbers.length];
        
        for (int i=0;i<answer.length;i++){
            answer[i] = Integer.parseInt(numbers[answer.length-i-1]);
        }
        
        return answer;
    }
}