import java.util.*;

class Solution {
    public String solution(String s) {
        String[] sArray = s.split("");
        Arrays.sort(sArray);
        
        String newS = "";
        
        for (int i=0;i<sArray.length;i++){
            int count = 0;
            
            for (int j=0;j<sArray.length;j++){
                if(sArray[i].equals(sArray[j])){
                    count++;
                }
            }
            
            if (count==1) newS += sArray[i];
        }
        
        return newS;
    }
}