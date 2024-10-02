import java.util.*;

public class Point {
        public int x,y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

/*
* (n,m) 까지의 최단 거리
* bfs
*/
class Solution {
    
    private static int[][] visited, maps;
    private static int m, n;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
        
    public int solution(int[][] maps) {           
        m = maps.length;
        n = maps[0].length;
        visited = new int[m][n];
        this.maps = maps;
        
        bfs();
        
        if (visited[m-1][n-1] == 0) return -1;
        
        return visited[m-1][n-1];
    }
    
    private static void bfs(){
        Queue<Point> queue = new LinkedList<>();
        
        visited[0][0] = 1;
        queue.add(new Point(0,0));
        
        while (!queue.isEmpty()){
            Point p = queue.poll();
            
            for (int i=0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                if (visited[nx][ny] > 0 || maps[nx][ny] == 0) continue;

                visited[nx][ny] = visited[p.x][p.y] + 1;
                queue.add(new Point(nx, ny));
            }
        }
    }
}