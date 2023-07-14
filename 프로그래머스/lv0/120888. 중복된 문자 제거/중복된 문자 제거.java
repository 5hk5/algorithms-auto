class Solution {
    public String solution(String s) {
        
        String newS = "";
        
        for (int i=0;i<s.length();i++){
            if (!newS.contains(String.valueOf(s.charAt(i)))) {
                newS += String.valueOf(s.charAt(i));
            }
        }
        
        return newS;
        
    }
}