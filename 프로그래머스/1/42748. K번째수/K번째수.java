import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // array : 원본 배열
        // commands : 문제 배열 (2차원)
        // 문제 : [i,j,k] => 인덱스 i-1 ~ 인덱스 j-1 까지 자른 배열 정렬 후 인덱스 k-1의 수 리턴
        int[] answer = new int[commands.length];
        
        for (int i=0;i<commands.length;i++){
            int[] arrayCopy = Arrays.copyOfRange(array,commands[i][0]-1, commands[i][1]);
            Arrays.sort(arrayCopy);
            answer[i] = arrayCopy[commands[i][2]-1];
        }
        
        return answer;
    }
}