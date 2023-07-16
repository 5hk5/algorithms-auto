import java.util.*;

class Solution {
    public int solution(String before, String after) {
        String[] newBefore = before.split("");
        String[] newAfter = after.split("");
        
        Arrays.sort(newBefore);
        Arrays.sort(newAfter);
        
        for (int i=0;i<newBefore.length;i++){
            if (!newBefore[i].equals(newAfter[i])){
                return 0;
            }
        }
        
        return 1;
    }
}