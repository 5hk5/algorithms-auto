class Solution {
    public int[] solution(int[][] score) {
        //평균 구하기
        double[] answer = new double[score.length];
        
        for (int i=0;i<score.length;i++) {
            answer[i] = (double) (score[i][0] + score[i][1]) / 2;
        }
        
        //평균 기반 등수 구하기
        int[] count = new int[answer.length];
        
        for (int i=0;i<answer.length;i++) {
            count[i]++;
            for (int j=0;j<answer.length;j++){
                if (answer[i] < answer[j]) {
                    count[i]++;
                }   
            }
        }
        
        return count;
    }
}