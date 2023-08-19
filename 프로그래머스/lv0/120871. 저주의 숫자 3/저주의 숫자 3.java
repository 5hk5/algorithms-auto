class Solution {
    public int solution(int n) {
        int num = 0;
        
        for (int i=1;i<=n;i++){    
            num++;
            
            if (num%3==0 || String.valueOf(num).contains("3")){
                i--;
            }    
            
        }
        
        return num;
    }
}