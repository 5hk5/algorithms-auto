class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        // k진수로 변환
        String newNum = Integer.toString(n, k);

        // 소수 찾기 (0 기준)
        String[] numArr = newNum.split("0+"); 
                
        for (String num : numArr){
            if (isPrime(Long.parseLong(num))) answer++;
        }
        
        return answer;
    }
    
    private static boolean isPrime(long num){
        if (num == 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (long i=3;i*i<=num;i+=2){
            if (num % i == 0) return false;
        }
        
        return true;
    }
    
}