import java.util.*;

// 논문 배열 중 h번 이상 인용된 논문이 h편 이상일 때 h 최대값 구하기 
// [3, 0, 6, 1, 5]
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations); // 오름차순 정렬 [0, 1, 3, 5, 6]
                
        for (int i=0;i<citations.length;i++){
            int count = citations.length - i; // 전체 논문 수 --
        
            if (citations[i] >= count){
                answer = count;
                break;
            }
        }
        
        return answer;
    }
}