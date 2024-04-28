import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* N*N 정사각형 종이 내부에서 색깔별 정사각형(다양한 크기) 개수 구하기
* 종이 한변 길이 N = 2, 4, 8, 16, 32, 64, 128 중 하나
* 0 = 흰 칸, 1 = 파란 칸
* 입력값 1 : N
* 입력값 2 : 행렬 (공백 띄우기)
* 출력값 1 : 흰칸 정사각형 수
* 출력값 2 : 파란 칸 정사각형 수
* */
public class Main {

    public static int white = 0;
    public static int blue = 0;
    public static int [][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0;j<N;j++){
               arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countSquare(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    /*
    * 정사각형 검사 및 분할 (4분면)
    * */
    private static void countSquare(int row, int col, int N){
        // 내부 색 동일한지 확인
        if (checkColor(row, col, N)){
            if (arr[row][col] == 0){
                white++;
            } else {
                blue++;
            }

            return;
        }

        // 4분할
        int half = N / 2;

        countSquare(row, col, half);
        countSquare(row, col+half, half);
        countSquare(row+half, col, half);
        countSquare(row+half, col+half, half);
    }

    /*
    * 같은 색깔 여부 확인
    * */
    private static boolean checkColor(int row, int col, int size){
        int color = arr[row][col];

        for (int i=row;i<row+size;i++){
            for (int j=col;j<col+size;j++){
                if (arr[i][j] != color) return false;
            }
        }

        return true;
    }

}
