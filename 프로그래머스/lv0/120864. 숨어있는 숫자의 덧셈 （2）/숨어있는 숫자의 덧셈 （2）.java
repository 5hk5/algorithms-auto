class Solution {
    public int solution(String s) {
        String sArray[] = s.split("[a-zA-Z]+");
        
        int sum = 0;
        for (int i=0;i<sArray.length;i++){
            if (sArray[i].matches("[0-9]+")){
                sum += Integer.parseInt(sArray[i]);
            }
        }
        
        return sum;
    }
}