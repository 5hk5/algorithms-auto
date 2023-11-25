import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> wordsSet = new HashSet<>();
        wordsSet.add(words[0]);
        
        for (int i=1;i<words.length;i++){            
            if (wordsSet.contains(words[i]) || 
               words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                return new int[] {i % n + 1, i / n + 1}; // 번호, 실패한 차례
            }
            
            wordsSet.add(words[i]);
        }
        
        return answer;
    }
}