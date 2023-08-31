class Solution {
    public int solution(int n) {
        n = n-1;
        
        int count = 2;
        while (count <= n){
            if (n % count == 0) break;
            count++;
        }
        
        return count;
    }
}