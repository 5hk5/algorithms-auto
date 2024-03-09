import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 서쪽 사이트 - 동쪽 사이트 잇는 다리 지을 때 경우의 수 (0<w<=e<30)
 * 한 사이트당 하나의 다리만 지음, 서쪽 사이트 수만큼 다리 지음, 다리끼리 겹쳐질 수 없음
 * => 조합 (eCw)
 * 입력 1 : 테스트케이스 개수
 * 입력 2 : w e (w: 서쪽 사이트 수)
 */
public class Main {

    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /* 조합 공식 활용 (eCw)
         * eC0 = eCe = 1
         * e+1Cw+1 = eCw + eCw+1
         * */
        for (int i=0;i<30;i++){
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for (int i=2;i<30;i++){
            for (int j=1;j<30;j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine(), " ");

            int w = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            System.out.println(dp[e][w]);
        }
    }

/*    private static int countBridgesWithRecursion(int e, int w) {
        if (dp[e][w] > 0) return dp[e][w]; // 배열에 저장된 값은 바로 반환

        if (w == 0 || w == e) return dp[e][w] = 1; // 공식 1 활용

        return dp[e][w] = countBridgesWithRecursion(e-1, w-1) + countBridgesWithRecursion(e-1, w); // 공식 2 활용
    }*/

}
