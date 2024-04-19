
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
* n을 1,2,3의 합으로 나타내기
* */
public class Main {

    public static void main(String[] args) throws IOException {
        int[] array = new int[10];
        array[0] = 1; // n=1
        array[1] = 2; // n=2
        array[2] = 4; // n=3

        for (int i=3;i<10;i++){
            array[i] = array[i-1] + array[i-2] + array[i-3];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());
        for (int i=0;i<times;i++){
            System.out.println(array[Integer.parseInt(br.readLine())-1]);            
        }
    }

}
