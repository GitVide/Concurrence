package writtenexam.pinduoduo.chun_3.first;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            int N = sc.nextInt();
            int K = sc.nextInt();
            int i = 0;
            while(K > 0){
                i++;
                if(i % N != 0)
                    K--;

            }
            System.out.println(i);
        }
    }
}
