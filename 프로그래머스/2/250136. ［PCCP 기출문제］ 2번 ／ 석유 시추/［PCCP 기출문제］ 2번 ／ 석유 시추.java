import java.util.*;

/*
* land[m][n] => 0: 빈 땅, 1: 석유
* 선택한 열의 값들 중 1 있으면 1로 이루어진 덩어리 값들 합산 => 최대값 return 
*/
class Solution {
    static int[] oilCount;
    static int n, m;
    static boolean[][] visited;
    
    public int solution(int[][] land) {
        n = land.length; // 행 길이
        m = land[0].length; // 열 길이
        
        visited = new boolean[n][m];
        oilCount = new int[m]; // 열(인덱스)별 덩어리 합산값
            
        // 그래프 탐색
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (land[i][j] == 1 && !visited[i][j]) bfs(land, i,j);
            }            
        }
        
        // oilCount max 값
        int max = 0;
        for (int oil : oilCount){
            if (oil > max) max = oil;
        }
        
        return max;
    }
    
    public void bfs(int[][] land, int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        Set<Integer> cols = new HashSet<>(); // 덩어리 합산값 count 누적할 열들
        int[] nx = {1,-1,0,0};
        int[] ny = {0,0,1,-1};
        
        q.add(new int[]{x,y});
        cols.add(y);
        
        int count = 1;
        // bfs 탐색
        while (!q.isEmpty()){
            int[] oil = q.poll();
            
            // 주변 탐색
            for (int i=0;i<4;i++){
                int dx = oil[0] + nx[i];
                int dy = oil[1] + ny[i];
                
                if (dx<0 || dy<0 || dx>=n || dy>=m) continue;
                
                if (land[dx][dy] == 1 && !visited[dx][dy]){
                    q.add(new int[]{dx, dy});
                    cols.add(dy);
                    visited[dx][dy] = true;
                    count++;
                }
            }
        }

        // oilCount[cols]에 합산값 추가
        for (int col : cols) {
            oilCount[col] += count;
        }
    }
}