class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        
        if (s.contains("p") == false && s.contains("y") == false) return true;
        
        int countP = 0;
        int countY = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == 'p') countP++;
            if (s.charAt(i) == 'y') countY++;
        }
        
        if (countP == countY) {
            return true;
        } else {
            return false;
        }
    }
}