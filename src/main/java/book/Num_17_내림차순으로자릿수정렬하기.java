package book;

import java.util.Scanner;

public class Num_17_내림차순으로자릿수정렬하기 {

    /*
     * str(정렬할 수)
     * A(자릿수별로 구분해 저장한 배열)
     * for(str의 길이만큼 반복하기){
     *  A 배열 저장 -> str.substring 사용하기
     * }
     * 
     * for(i: 0 ~ str의 길이만큼 반복하기){
     *   for(j : 1 ~ str의 길이만큼 반복하기){
     *     현재 범위에서 Max 값 찾기
     *  }
     *   현재 i의 값과 Max값 중 Max 값이 더 크면 swap 수행하기 
     * }
     * A 배열 출력하기 
     */
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] A = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        for (int i = 0; i < str.length(); i++) {
            int Max = i;
            for (int j = i + 1; j < str.length(); j++) {
                if(A[j] > A[Max]){ // 내림차순이므로 최댓값을 찾음
                    Max = j;
                } 
                
                if(A[i] < A[Max]){
                    int temp = A[i];
                    A[i] = A[Max];
                    A[Max] = temp;
                }    
            }
        }
        for (int i = 0; i < str.length(); i++) {
            System.out.print(A[i]);
        }
    }   
}
