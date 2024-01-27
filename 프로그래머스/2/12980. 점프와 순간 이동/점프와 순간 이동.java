import java.util.*;

public class Solution {
    public int solution(int n) { 
        // 0에서 출발해 n으로 이동
        // 순간이동 = 현재까지온거리 * 2  
        // 점프 = K칸 직접 이동 (K만큼의 건전지 사용됨)
        
        int energy = 0;
        
        // top - down, 순간이동 최대로
        while (n != 0) {
            if (n % 2 == 0){
                n /= 2;
            } else {
                n--;
                energy++;
            }
        }
        
        return energy;
    }
}