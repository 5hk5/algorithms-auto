import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * N*M (2<=N,M<=100) 배열의 미로 => 1: 이동 가능한 칸, 0: 이동 불가능한 칸
 * (1,1)에서 출발해 (n,m)으로 이동할 때 최소 칸수
 *
 * 입력 1 : N M
 * 입력 2 : N*M의 배열 (공백 없이)
 * 출력 : 최소 이동 칸수
 * */
public class Main {

    static int[][] maze;
    static int[][] visited;
    static int N;
    static int M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // maze 배열 생성
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new int[N][M];

        // 배열에 값 넣기
        for (int i = 0; i < N; i++) {
            String nums = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = nums.charAt(j) - '0';
            }
        }

        // 완성된 maze 배열에 bfs 적용
        System.out.println(bfs(0, 0));
    }

    /*
     * 최단 경로 찾기 - BFS
     * Queue 활용
     * */
    private static int bfs(int n, int m) {
        Deque<Loc> queue = new LinkedList<>();
        queue.offer(new Loc(n, m));
        visited[n][m] = 1;

        // bfs 시작
        while (!queue.isEmpty()) {
            Loc location = queue.poll();

            // 상하좌우
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + location.x;
                int ny = dy[i] + location.y;

                // 배열 범위 안인지 확인
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                // 원 배열, 방문 여부 확인
                if (maze[nx][ny]==0 || visited[nx][ny]>0) {
                    continue;
                }

                // queue 추가
                queue.offer(new Loc(nx, ny));
                visited[nx][ny] = visited[location.x][location.y] + 1;

                if (nx == N-1 && ny == M-1) return visited[N-1][M-1];
            }
        }

        return 0;
    }


    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

}
