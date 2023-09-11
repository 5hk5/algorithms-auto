import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> intArr = new ArrayList<>();
        
        for (int i=0;i<arr.length;i++){
            if (arr[i] % divisor == 0){
                intArr.add(arr[i]);
            }
        }
        
        if (intArr.size() == 0) return new int[] {-1};
        
        Collections.sort(intArr);
        
        return intArr.stream().mapToInt(a->a).toArray();
    }
}