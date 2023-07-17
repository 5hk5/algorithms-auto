class Solution {
    public int solution(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
        
        int count = 0;
        int mltp = 1;
        for (int i=1;i<n;i++){
            if (mltp>n) break;
            mltp *= (i+1);
            count++;
        }
        
        return count;
    }
}