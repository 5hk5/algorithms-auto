class Solution {
    public int solution(int n) {
        int num = 0;
        
        for (int i=1;i<=n;i++){    
            num++;
            
            while (num%3==0 || num%10==3 || num/10==3 || (num/10)%10==3){
                num++;
            }    
            
        }
        
        return num;
    }
}