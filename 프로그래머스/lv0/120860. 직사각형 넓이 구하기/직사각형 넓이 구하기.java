class Solution {
    public int solution(int[][] dots) {
        int xLength = 0;
        int yLength = 0;
        
        for (int i=0;i<3;i++) {
            for (int j=i+1;j<4;j++) {
                if (Math.abs(dots[i][0]-dots[j][0])!=0){
                    xLength = Math.abs(dots[i][0]-dots[j][0]);
                }
                 
                if (Math.abs(dots[i][1]-dots[j][1])!=0){
                    yLength = Math.abs(dots[i][1]-dots[j][1]);
                }
                
                if (xLength!=0 && yLength!=0) break;
            }
        }
        
        return xLength * yLength;
    }
}