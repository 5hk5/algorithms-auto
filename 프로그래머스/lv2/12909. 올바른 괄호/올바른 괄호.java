import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] array = s.toCharArray();
        
        if (array[0] == ')' || array[array.length-1] == '(') return false;
        
        int num = 0;
        for (char a : array){
            if (a == '(') {
                num++;
            } else {
                num--;
            }
            
            if (num < 0) return false;
        }
        
        return num == 0;
    }
}