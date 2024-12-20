package book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num_21_버블소트프로그램2 {

    static long swapCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];


        // 이렇게 해야 런타임 에러가 안남!
        StringTokenizer st  = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
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
                    i++; // 그대로 i만 이동
                }else{
                    temp[k] = A[j];
                    j++;
                    // 앞에 자신보다 큰 수 있는 경우 swap이 일어남
                    swapCount += (middle - i + 1);
                }
                k++;
            }

            // 왼쪽 배열 남은 요소들 다 순차적으로 삽입
            while(i  <= middle){
                temp[k] = A[i];
                i++;
                k++;
            }
            // 오른쪽 배열 남은 요소들 다 순차적으로 삽입
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
