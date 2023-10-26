class Solution {
    public int solution(int num) {
        if (num == 1) return 0;
        
        long newN = (long) num;
        int count = 0;
        while (count <= 500){
            
            if (newN == 1) return count;
                
            if (newN % 2 == 0) {
                newN /= 2;
            } else {
                newN = newN * 3 + 1;
            }
            
            count++;
        }
        
        return -1;
    }
}