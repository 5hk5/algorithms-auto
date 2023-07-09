import java.util.*;

class Solution {
    public int[] solution(String s) {      
        List<Integer> list = new ArrayList<Integer>(); //리스트
        
        for (int i=0;i<s.length();i++){
            if (String.valueOf(s.charAt(i)-'0').matches("[0-9]")){ //각 원소 파악
                list.add((int) (s.charAt(i)-'0'));
            }
        }
        
        return list.stream().sorted().mapToInt(a -> a).toArray(); 
    }
}