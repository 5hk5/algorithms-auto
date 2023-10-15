class Solution {
    public static int transformCount = 0;
    public static int deletedZeros = 0;
        
    public int[] solution(String s) {
        recur(s);
                
        return new int[] {transformCount, deletedZeros};
    }
    
    public String recur(String s){
        if (s.equals("1")) return "";
        
        int sLength = s.length();
        int oneCount = 0;
        for (int i=0;i<sLength;i++){
            if (s.charAt(i) == '0'){
                deletedZeros++;
            } else {
                oneCount++;
            }           
        }
        
        String newS = Integer.toBinaryString(oneCount);
        
        transformCount++;
        
        return recur(newS);
    }
}