package book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Num_03 {

    public static void main(String[] args) throws IOException {
//
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());
        long[] S = new long[suNo + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < suNo ; i++) {
            S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int k = 0; k < quizNo; k++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
           int i =  Integer.parseInt(stringTokenizer.nextToken());
           int j =  Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i -1]);
        }


//        Scanner sc = new Scanner(System.in);
//        int suNo = sc.nextInt();
//        int quizNo = sc.nextInt();
//
//        int[] A = new int[suNo];
//        int[] S = new int[suNo + 1]; // 누적 합을 저장할 배열
//
//        for (int i = 0; i <suNo  ; i++) {
//            A[i] = sc.nextInt();
//        }
//
//        for (int i = 1; i <= suNo; i++) {
//            S[i] = S[i - 1] + A[i];
//        }
//        int sum = 0;
//        for (int k = 0; k < quizNo; k++) {
//           int i = sc.nextInt();
//           int j = sc.nextInt();
//           sum = S[j] - S[i -1];
//            System.out.println(sum);
//        }
    }
}
