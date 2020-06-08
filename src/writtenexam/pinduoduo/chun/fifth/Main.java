package writtenexam.pinduoduo.chun.fifth;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int[] array = new int[n * m];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                array[index++] = i * j;
            }
        }
        Arrays.sort(array);
        for (int e : array) {
            System.out.print(e + "-");
        }
        //System.out.println(array[array.length - k]);
    }
}
