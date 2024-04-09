import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* N^2 까지 자연수를 달팽이 모양으로 표에 채우기 (N은 홀수, 3 ≤ N ≤ 999)
* ex)
* 9 2 3
* 8 1 4
* 7 6 5
*
* 입력 1 : N
* 입력 2 : N^2 이하 자연수
* 출력 1 : 달팽이 행렬
* 출력 2 : 입력값의 좌표
* */
public class Main {

    // 상 (행--) 우 (열++) 하 (행++) 좌 (열--)
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    // 달팽이 배열
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 입력 1 : N
        int input = Integer.parseInt(br.readLine()); // 입력 2 : 좌표 찾을 자연수

        arr = new int[N][N];

        drawSnail(N);

        findNumInSnail(input);
    }

    private static void drawSnail(int N) {
        int nx = N / 2;
        int ny = N / 2;
        int direction = 0; // 방향 (0~3)
        int length = 1; // 1,1,2,2,3,3,..
        int num = 1;

        // 상우하좌
        while (num <= N * N) {
            for (int i = 0; i < length; i++) { // length만큼 이동
                arr[nx][ny] = num++;

                nx += dx[direction];
                ny += dy[direction];
            }

            direction = (direction + 1) % 4; // 새 direction 인덱스
            if (direction % 2 == 0) length++; // direction 짝수일때마다 length++ (=2회 방향 바꿈)
        }

    }

    private static void findNumInSnail(int input) {
        StringBuilder sb = new StringBuilder();

        int row = 0;
        int col = 0;

        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                sb.append(arr[i][j]).append(" ");

                if (arr[i][j] == input) {
                    row = i+1;
                    col = j+1;
                }
            }
            sb.deleteCharAt(sb.length()-1).append("\n");
        }

        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb);
        System.out.println(row + " " + col);
    }

}
