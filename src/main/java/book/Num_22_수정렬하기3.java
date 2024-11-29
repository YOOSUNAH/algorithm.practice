package book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num_22_수정렬하기3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];


        // 런타임 에러 안나게 할려면 아래 주석으로 풀어야 함.
//        for (int i = 0; i < N; i++) {
//            A[i] =Integer.parseInt(br.readLine());
//        }
//
//        // 배열을 정렬
//        Arrays.sort(A);
//
//        // 결과 출력
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < N; i++) {
//            sb.append(A[i]).append("\n");
//        }
//
//        // 한 번에 출력
//        System.out.print(sb.toString());

        // 기수 정렬 이용해서 풀기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] =Integer.parseInt(st.nextToken()); //[ 5, 2, 3, 1, 4, 2, 3, 5, 1, 7]
        }
        radixSort(A, 5); // N <= 10,000이니깐, 1의자리 10의자리 ...10000자리 최대 5번 진행하면 됨.

        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

    public static void radixSort(int[] A , int maxSize){
        // A = [ 5, 2, 3, 1, 4, 2, 3, 5, 1, 7]
        // 0, 1은 2개, 2는 2개, 3은 2개, 4는 1개, 5는 2개, 6은 0개, 7은 1개, 8은 0개 , 9는 0개
        int[] output = new int[A.length];
        int jarisu = 1; // (현재 자릿수를 표현하는 수)
        int count = 0;

        // 최대 자릿수만큼 반복하기
        while(count != maxSize){

            int[] bucket = new int[10]; // 0 ~ 9

            // 현재 자릿수를 기준으로 A 배열 데이터를  bucket에 count
            for (int i = 0; i < A.length; i++) {
                int firstJarisu = (A[i] / jarisu) % 10;
                bucket[firstJarisu]++;  // 일의 자리부터 시작하기  // 0 ,2, 2, 2, 1, 2, 0, 1, 0, 0
            }
            // 합 배열을 이용해 index 계산하기
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1]; // 0, 2, 4, 6, 7, 9, 9, 10, 10, 10,
            }

            // 현재 자릿수 기준으로 정렬하기
            for (int i = A.length - 1; i >= 0; i--) { // 역순으로 조회
                int firstJarisu = (A[i] / jarisu) % 10;
                int index =  bucket[firstJarisu] -1 ;
                output[index] = A[i];

                bucket [ firstJarisu ]--;
            }

            // 다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장하기
            for (int i = 0; i < A.length; i++) {
                A[i] = output[i];
            }

            jarisu = jarisu * 10; // 자릿수 증가시키기
            count++;
        }
    }

}
