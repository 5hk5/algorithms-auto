import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 2*n 직사각형을 1x2, 2x1, 2x2 타일로 채우는 경우의 수 (1 ≤ n ≤ 1,000)
* 입력 : n
* 출력 : 경우의수 % 10007
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(dp(n));
    }

    /*
    * dp - n 범위 크므로 bottom-up (반복문)
    * memoization 배열 생성 -> 규칙 찾기 -> 초기값, 점화식 설정
    *
    * n=1 : |                                                 => 1
    * n=2 : || 二 口                                           => 3
    * n=3 : ||| 二| |二  |口 口|                                => 5
    * n=4 : |||| 二二 ||二 |二| 二|| 口口 口|| ||口 |口| 二口 口二  => 11
    * ..
    * */
    private static int dp(int n) {
        // 메모이제이션 배열
        int[] memo = new int[1000];

        // 초기값
        memo[0] = 1;
        memo[1] = 3;

        // 점화식
        for (int i=2;i<n;i++){
            memo[i] = (memo[i-1] + memo[i-2] * 2) % 10007;
        }

        return memo[n-1];
    }

}
