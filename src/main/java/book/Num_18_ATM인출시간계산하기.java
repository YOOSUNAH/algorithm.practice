package book;

import java.util.Scanner;

public class Num_18_ATM인출시간계산하기 {
    /*
     * 
     * 배열 저장하기
     * 
     * for (i: N 만큼 반복)
     *   for(j: i - 1~0까지 뒤에서 반복){
     *   현재 범위에서 삽입 위치 찾기
     *   }
     *   for(j: i ~ insert_point + 1까지 뒤에서 반복){
     *    삽입을 위해 삽입 위치에서 i까지 데이터를 한칸씩 뒤로 밀기
     *   }
     *   삽입 위치에 현재 데이터 삽입하기
     * }
     *     
     *  S 합 배열 만들기 
     *  S[i] = S[i - 1] + A[i]      
     *    
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] S = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 1; i < N; i++) { // 삽입 정렬
            int insert_point = i;
            int insert_value = A[i];
            // 현재 범위에서 삽입 위치 찾기
            for (int j = i - 1; j >= 0; j--) {
                if(A[j] < A[i]){
                    insert_point = j + 1;
                    break;
                }
                if(j == 0){
                    insert_point = 0;
                }
            }
            // 삽입을 위해 삽입 위치에서 i까지 데이터를 한칸씩 뒤로 밀기
            for (int j = i; j > insert_point; j--) {
                A[j] = A[j - 1];
            }
            // 삽입 위치에 현재 데이터 삽입하기
            A[insert_point] = insert_value;
        }

        S[0] = A[0]; // 합 배열 만들기 
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + A[i];
        }
        
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = sum + S[i];
        }

        System.out.println(sum);
    }
}
