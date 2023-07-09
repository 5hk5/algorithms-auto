class Solution {
    public String solution(int age) {
        String ageToString = Integer.toString(age);
        
        String s = "";
        
        for (int i=0;i<ageToString.length();i++){
            s += (char) (ageToString.charAt(i) + 49);
        }
        
        return s;
    }
}