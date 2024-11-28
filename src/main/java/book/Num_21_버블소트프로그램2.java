package book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_21_버블소트프로그램2 {

    static long swapCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(A, 0, A.length - 1);

        System.out.println(swapCount);
    }

    public static void mergeSort(int[] A,
                                 int leftStart,
                                 int rightEnd){
        if(leftStart < rightEnd){
            int middle = (leftStart + rightEnd) / 2;
            mergeSort(A, leftStart, middle);
            mergeSort(A, middle + 1, rightEnd);
            merge(A, leftStart, middle, rightEnd);
        }
    }

        public static void merge(int[] A,
                                 int leftStart,
                                 int middle,
                                 int rightEnd
        ){
            int number = rightEnd - leftStart + 1;
            int[] temp = new int[number];

            int i = leftStart;
            int j = middle + 1;
            int k = 0;

            while(i <= middle && j <= rightEnd){
                if(A[i] <= A[j]){
                    temp[k] = A[i];
                    i++;

                }else{
                    temp[k] = A[j];
                    j++;
                    swapCount += (middle - i + 1);  // 왼쪽 배열의 남은 원소 개수만큼 swap 발생
                }
                k++;
            }

            // 왼쪽 배열 남은 요소 삽입
            while(i  <= middle){
                temp[k] = A[i];
                i++;
                k++;
            }

            while(j <= rightEnd){
                temp[k] = A[j];
                j++;
                k++;
            }

            // 정렬된 배열을 원본 배열에 복사
            for (int t = 0; t < temp.length; t++) {
                A[leftStart + t] = temp[t];
            }
        }
}
