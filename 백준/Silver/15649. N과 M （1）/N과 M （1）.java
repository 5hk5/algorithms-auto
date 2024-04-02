import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* N과 M => 1~N까지 자연수 중 M개(길이) 고른 수열 (중복x, 순서 오름차순)
* 입력 : N M
* 출력 : 각 수열들
* ex. 3 2 - 12, 13, 21, 23, 31, 32
* */
public class Main {

    private static int[] arr; // 출력할 수열들 (입력할 때마다 덮어씌우기)
    private static boolean[] visited; // 노드 방문여부 확인 (반복문 마지막에 초기화)
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];

        dfs(N, M, 0);

        System.out.println(sb);
    }

    /*
    * 백트래킹 - DFS
    * */
    private static void dfs(int N, int M, int depth) {
        // depth 도달 시 sb.append (길이 M인 수열 구할 때마다)
        if (depth == M) {
            for (int num : arr){
                sb.append(num).append(' ');
            }

            sb.append('\n');

            return; // 재귀에서 return
        }

        // 1~N 탐색 (depth마다 순회)
        for (int i=0;i<N;i++){
            if (!visited[i]){
                visited[i] = true;
                arr[depth]= i+1; // 재귀 return 마다 해당 depth 위치에 증가한 i값 덮어씌우기
                dfs(N, M, depth+1);

                visited[i] = false; // return 시 다른 가지 탐색 위해 방문노드 초기화
            }
        }
    }

}
