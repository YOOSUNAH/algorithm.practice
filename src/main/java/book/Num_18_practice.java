package book;

import java.util.*;

public class Num_18_practice { // ATM 인출시간 계산하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < A.length; i++) {
            int j = i;
            while ( j > 0 && A[j] < A[j - 1]) {
                int temp = A[j];
                A[j] = A[j - 1];
                A[j - 1] = temp;
                j--;
            }
        }

        int sumArr[] = new int[N];
        sumArr[0] = A[0];
        for (int i = 1; i < sumArr.length; i++) {
            sumArr[i] = sumArr[i - 1] + A[i];
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += sumArr[i];
        }

        System.out.println(sum);
    }
}
