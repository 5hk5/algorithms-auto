import java.util.*;

/*
* 가장 많이 받을 선물 수 구하기
* 1. 선물 주고받은 기록 있으면 => 더 많이 준 사람이 하나 받음
* 2. 선물 주고받은 기록 없거나 동일 => 선물 지수 더 큰 사람이 받음 (동일하면 pass)
* (선물 지수 = 준 선물 수 - 받은 선물 수)
* 필요한 변수 => 주고 받은 선물 기록, 선물 지수, 다음달 예상 선물 수
*/
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int friendsLength = friends.length;
        
        // friendsIndex 친구 이름-인덱스 매핑
        Map<String, Integer> friendsIndex = new HashMap<>(); 
        for (int i=0;i<friendsLength;i++){
            friendsIndex.put(friends[i], i);
        }
        
        // gifts 탐색 => 선물 지수+-, 기록+ 
        int giftsLength = gifts.length;
        int[] giftIndex = new int[giftsLength]; // 선물 지수
        int[][] totalRecord = new int[friendsLength][friendsLength]; // 전체 주고받은 선물 기록       
        StringTokenizer st; 
        for (int i=0;i<giftsLength;i++){
            st = new StringTokenizer(gifts[i], " ");
            String friend1 = st.nextToken();
            String friend2 = st.nextToken();
            
            giftIndex[friendsIndex.get(friend1)]++;
            giftIndex[friendsIndex.get(friend2)]--;
            
            totalRecord[friendsIndex.get(friend1)][friendsIndex.get(friend2)]++;
        }
        
        // totalRecord 탐색 -> 다음달 받을 선물 수++
        // totalRecord[a][b]-totalRecord[b][a] 값 비교 - 0이면 giftsIndex 비교 / giftIndex 동일 시 pass
        int answer = 0;
        for (int i=0;i<friendsLength;i++){
            int num = 0; // 다음달 받을 선물 수
            
            for (int j=0;j<friendsLength;j++){
                if (i==j) continue;
                
                if (totalRecord[i][j] > totalRecord[j][i]) num++;
                
                if (totalRecord[i][j] == totalRecord[j][i] && giftIndex[i] > giftIndex[j]) num++;
            }
            
            if (num > answer) answer = num;
        }
        
        return answer;
    }
    
}