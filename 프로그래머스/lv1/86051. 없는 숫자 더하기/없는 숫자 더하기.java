import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        
        for (int i=0;i<numbers.length;i++){
            list.set(numbers[i], 0);
        }        
        
        return list.stream().mapToInt(Integer::intValue).sum();
    }
}