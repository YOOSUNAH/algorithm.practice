package book;

import java.io.*;

public class Num_20_수정렬하기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(A, 0, N - 1);

        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();

    }

    private static void mergeSort(int[] A, int start, int end){

        if(start < end){
            int middle = (start + end)/ 2;

            // 왼쪽 부분 정렬
            mergeSort(A, start, middle);
            // 오른쪽 부분 정렬
            mergeSort(A, middle + 1, end);

            // 병합
            merge(A, start, middle, end);
        }
    }

    private static void merge(int[] A, int start, int middle, int end){
        int number = end - start + 1;
        int[] sorted = new int[number];

        int i = start;
        int j = middle + 1;
        int k = 0;

        // 작은 순서대로 배열에 삽입
        while(i <= middle && j <= end){
            if(A[i] <= A[j]){
                sorted[k] =A[i];
                i++;
            }else{
                sorted[k] = A[j];
                j++;
            }
            k++;
        }

        //왼쪽 배열에 남은 요소 삽입
        while(i <= middle) {
            sorted[k] = A[i];
            i++;
            k++;
        }

        while(j <= end){
            sorted[k] = A[j];
            j++;
            k++;
        }

        // 정렬된 배열을 원본 배열에 복사
        for (int t = 0; t < sorted.length; t++) {
            A[start + t] = sorted[t];

        }

    }
}



















