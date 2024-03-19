import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static String[][] tiles;
    private static int[][] visited;

    /*
     * 판자 개수 세기
     * - 같은 행 => 같은 판자
     * | 같은 열 => 같은 판자
     * 입력 1 : N M (N: 세로 크기, M: 가로 크기) (0 < N,M <= 50)
     * 입력 2 : N개의 줄에 M개의 문자
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        tiles = new String[row][col];
        visited = new int[row][col];

        // 입력값 -> 배열
        for (int i=0;i<row;i++){
            String input = br.readLine();
            for (int j=0;j<col;j++){
                tiles[i][j] = String.valueOf(input.charAt(j));
            }
        }

        // 배열 값 탐색
        int count = 0;
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (visited[i][j] == 1) continue;

                if (tiles[i][j].equals("-")) {
                    dfs(i, j, "-");
                } else {
                    dfs(i, j, "|");
                }

                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int row, int col, String str){
        if (row>=tiles.length || col>=tiles[0].length) return;

        visited[row][col] = 1;

        if (str.equals("-")){
            if (col<tiles[0].length-1 && tiles[row][col+1].equals("-")) {
                dfs(row, col + 1, "-");
            }
        } else if (row<tiles.length-1 &&tiles[row+1][col].equals("|")){
            dfs(row+1, col, "|");
        }
    }

}
