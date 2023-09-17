import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        
        while (n>0){
            list.add(n%3);
            n /= 3;
        }
        
        int square = list.size() - 1;
        for (int num : list) {
            answer += num * Math.pow(3, square--);
        }
        
        return answer;
    }
}