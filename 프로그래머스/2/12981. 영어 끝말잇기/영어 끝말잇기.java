import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> wordsList = new ArrayList<String>();
        wordsList.add(words[0]);
        
        for (int i=1;i<words.length;i++){            
            // 단어 중복 체크
            if (wordsList.contains(words[i])) {
                return new int[] {i % n + 1, i / n + 1}; // 번호, 실패한 차례
            }
            
            // 끝말잇기 실패 체크
            if (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                return new int[] {i % n + 1, i / n + 1};
            }

            wordsList.add(words[i]);
        }
        
        return answer;
    }
}