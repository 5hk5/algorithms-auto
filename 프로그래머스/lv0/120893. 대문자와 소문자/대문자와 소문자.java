class Solution {
    public String solution(String s) {
        String newS = "";
        
        for (int i=0;i<s.length();i++){
            if (Character.isUpperCase(s.charAt(i))) {
                newS += String.valueOf(s.charAt(i)).toLowerCase();
            } else {
                newS += String.valueOf(s.charAt(i)).toUpperCase();
            }
        }
        
        return newS;
        
    }
}