class Solution {
    public int solution(int n) {
        int num1 = 0;
        int num2 = 1;
        int pivo = 0;
        for (int i=2;i<=n;i++){
            pivo = (num1 + num2) % 1234567;

            num1 = num2;
            num2 = pivo;
        }
        
        return pivo % 1234567;
    }
    
}