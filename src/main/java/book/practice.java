package book;

import java.util.*;

public class practice { // Num_17_내림차순으로자릿수정렬하기
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String str = sc.next();
       int[] A = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i , i + 1));
        }

        // 최댓값 찾기
        for (int i = 0; i < str.length(); i++) {
            int Max = i;
            for (int j = i + 1; j < str.length(); j++) {
                if(A[j] > A[Max]) {
                    Max = j;
                }
            }

            if(A[i] < A[Max]){
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
           }
        }

        //출력
        Arrays.stream(A).forEach(System.out::print);

    }
}
