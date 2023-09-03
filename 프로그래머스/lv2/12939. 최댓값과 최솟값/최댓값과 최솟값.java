class Solution {
    public String solution(String s) {
        //공백으로 구분된 문자열 (숫자들) => 최소값, 최대값 구하기 ("최솟값 최대값")     
        String[] sArray = s.split(" ");
        
        int max = Integer.parseInt(sArray[0]);
        int min = Integer.parseInt(sArray[0]);
        for (String string : sArray){
            int num = Integer.parseInt(string);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        return min + " " + max;
    }
}