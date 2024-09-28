import java.util.*;

/*
* 컴퓨터 네트워크망 개수 세기
*/
class Solution {
    public static int answer = 0;
    public static boolean[] visited;
        
    // 연결되는 노드 덩어리(네트워크망) + 미방문 노드 개수 세기
    public int solution(int n, int[][] computers) { // n=컴퓨터 수
        visited = new boolean[n];
        
        for (int i=0;i<n;i++){
            if (!visited[i]) {
                dfs(computers, i);
                answer++;
            } 
        }
        
        return answer;
    }
    
    private static void dfs(int[][] computers, int index){
        visited[index] = true;
        
        for (int i=0;i<computers.length;i++){
            if (!visited[i] && computers[index][i] == 1) dfs(computers, i);
        }
    }
}