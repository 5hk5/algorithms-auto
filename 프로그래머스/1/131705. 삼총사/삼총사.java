class Solution {
    public int solution(int[] number) {
        // 배열 내 원소 3개의 합이 0인 경우의 수
        
        int count = 0;
        for (int i=0;i<number.length-2;i++){
            for (int j=i+1;j<number.length-1;j++){
                for (int k=j+1;k<number.length;k++){
                    if (number[i] + number[j] + number[k] == 0) count++;
                }
            }
        }
        
        return count;
    }
}