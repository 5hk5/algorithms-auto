class Solution {
    public int solution(int n) {        
        int count = 1;
        while (count <= n){
            if (n % count == 1) break;
            count++;
        }
        
        return count;
    }
}