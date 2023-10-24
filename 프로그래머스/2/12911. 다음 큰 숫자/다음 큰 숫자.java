import java.util.*;

class Solution {
    public int solution(int n) {
        int count = Integer.bitCount(n);
        
        int compareCount = 0;
        while (true){
            n++;
            
            compareCount = Integer.bitCount(n);
            
            if (count == compareCount) break;
        }
        
        return n;
    }
    
}