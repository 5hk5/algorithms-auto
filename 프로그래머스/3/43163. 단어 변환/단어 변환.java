import java.util.*;

/*
* begin-> target으로 하나의 알파벳씩 변환하기 
* => 변환 과정, 결과의 단어는 모두 words에 있어야 함
* 가장 짧은 변환 과정 구하기 => bfs
*/
class Solution {
    
    public int solution(String begin, String target, String[] words) {
        // words 배열 -> 리스트
        List<String> wordList = Arrays.asList(words);
        
        if (!wordList.contains(target)) return 0; 

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // BFS
        queue.offer(begin);
        visited.add(begin);
        int count = 0; // 변환 횟수

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++; // 한 단계가 끝날 때마다 변환 횟수 증가

            // 현재 큐에 있는 모든 단어들에 대해 한 글자 차이 나는 단어로 변환
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                // words 리스트에서 아직 방문하지 않은 단어들 중 한 글자 차이 나는 단어 탐색
                for (String word : wordList) {
                    if (!visited.contains(word) && canTransform(currentWord, word)) {
                        if (word.equals(target)) return count; 
                        
                        queue.offer(word);
                        visited.add(word);
                    }
                }
            }
        }

        return 0;
    }
    
    public static boolean canTransform(String word1, String word2) {
        int diffCount = 0;
        
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
            
            if (diffCount > 1) return false;
        }
        
        return diffCount == 1;
    }

}