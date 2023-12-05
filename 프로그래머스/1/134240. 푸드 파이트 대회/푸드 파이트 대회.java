import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        
        String first = "";
        for (int i=1;i<food.length;i++){
            int num = food[i] / 2;
            
            for (int j=0;j<num;j++){
                first += i;
            }
        }
        
        return first + "0" + new StringBuilder(first).reverse().toString();
    }
}