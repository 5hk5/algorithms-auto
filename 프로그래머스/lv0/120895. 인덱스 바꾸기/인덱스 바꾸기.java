class Solution {
    public String solution(String s, int num1, int num2) {
        String newS = "";
        
        String[] sArray = s.split("");
        
        for (int i=0;i<sArray.length;i++){
            if (num1 > num2) {
                if (i == num1){
                    newS += sArray[num2];
                    continue;
                } else if (i == num2) {
                    newS += sArray[num1];
                    continue;
                }
            }
            
            if (num1 < num2) {
                if (i == num2){
                    newS += sArray[num1];
                    continue;
                } else if (i == num1) {
                    newS += sArray[num2];
                    continue;
                }
            }
            
            newS += sArray[i];
        }
        
        return newS;
        
    }
}