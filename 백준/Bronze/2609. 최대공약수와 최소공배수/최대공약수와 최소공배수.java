
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int gcd = gcd(num1, num2);
        System.out.println(gcd);
        System.out.println(lcm(num1, num2, gcd));
    }

    private static int lcm(int num1, int num2, int gcd) {
        return num1 * num2 / gcd;
    }

    private static int gcd(int num1, int num2) {
        while(num2 != 0) {
            int r = num1 % num2; // num1>=num2 전제

            num1 = num2;
            num2 = r;
        }
        
        return num1;
    }

    /*private static int gcd(int num1, int num2) {
        while(num1!=0 && num2!=0){
            if (num1>num2){
                num1 %= num2;
            } else {
                num2 %= num1;
            }
        }

        return num1==0?num2:num1;
    }*/

}
