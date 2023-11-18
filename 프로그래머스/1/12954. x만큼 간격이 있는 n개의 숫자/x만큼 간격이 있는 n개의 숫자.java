class Solution {
    public long[] solution(int x, int n) {
        // x부터 x씩 증가하는 n개 정수 배열 반환
        long[] answer = new long[n];
        
        long arr = x;
        for (int i=0;i<n;i++){
            answer[i] = arr;
            arr += x;
        }
        
        return answer;
    }
}