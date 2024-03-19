import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 안전영역 최대 개수 구하기
* 안전영역 : 강수량 높이 위의 값(상하좌우로 인접할 시 하나의 영역으로 봄)
* 강수량 높이별 dfs 탐색 -> visited=true, 개수 count
* 입력 1 : N (2차원 배열 행, 열 수)
* 입력 2~ : 강수 높이 배열 (한 칸씩 띄우기)
* */
public class Main {

    private static int[] nx = {-1,0,1,0};
    private static int[] ny = {0,-1,0,1};
    private static int[][] arr;
    private static int[][] visited;
    private static int maxHeight = 0;
    private static int maxZone = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        // 입력값 -> 배열
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0;j<N;j++){
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp > maxHeight) maxHeight = tmp;
                arr[i][j] = tmp;
            }
        }

        // 높이별 dfs 탐색
        searchByHeight(N);

        System.out.println(maxZone);
    }

    private static void searchByHeight(int N) {
        for (int i=0;i<=maxHeight;i++){ // 높이별
            visited = new int[N][N];
            int count = 0;

            for (int j=0;j<N*N;j++){ // 전체 배열값 탐색
                int row = j / N;
                int col = j % N;

                if (arr[row][col] > i && visited[row][col] == 0){
                    dfs(i, row, col);
                    count++;
                }
            }

            maxZone = Math.max(count, maxZone);
        }
    }

    private static void dfs(int height, int row, int col) {
        visited[row][col] = 1;

        for (int i=0;i<4;i++){
            int newX = row + nx[i];
            int newY = col + ny[i];

            if (newX < 0 || newY < 0 || newX >= visited.length || newY >= visited.length) continue;

            if (visited[newX][newY] == 1) continue;

            if (arr[newX][newY] > height) dfs(height, newX, newY);
        }
    }

}
