class Solution {
    public int solution(String A, String B) {
        if (A.equals(B)) return 0;
        
        int count = 0;
        for (int i=0;i<A.length();i++){
            count++;
            
            String newS = A.substring(A.length()-1) + A.substring(0,A.length()-1);
            
            if (B.equals(newS)) { 
                return count;
            } 
            
            A = newS;
        }
        
        return -1;
    }
}