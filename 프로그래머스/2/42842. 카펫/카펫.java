class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2]; // 카펫 가로, 세로
        int total = brown + yellow; // 전체 면적
        
        for (int i=1;i<=total;i++){
            if(total % i == 0){
                int width = i;
                int height = total / width;
                
                if (width < height) continue;
                
                int yellowTotal = (width-2) * (height-2);
                
                if (yellow == yellowTotal){
                    answer[0] = width;
                    answer[1] = height;
                }
            }
        }        
        
        return answer;
    }
}