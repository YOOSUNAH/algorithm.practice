package book;

public class Num_19_quick정렬 {

    public static void main(String[] args) {
        int number = 10;
        int[] data = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        quickSort(data, 0, number -1);

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }

    }
    public static void quickSort(int[] data,  int start, int end){
        if(start >= end){// 원소가 1개인 경우
            return;
        }

        int pivot = start;
        int i = start + 1;
        int j = end;
        int temp;

        while( i <= j) { // 엇갈릴때까지 반복
            while(i <= end && data[i] <= data[pivot]){ //키값보다 큰 값을 만날 때까지 반복
                i++;
            }
            while(j > start && data[j] >= data[pivot]){  // 왼쪽 끝에서 더 넘어가지 않도록 > start 조건 추가
                // 키 값보다 작은 값을 만날 때까지 반복
                j--;
            }

            if( i > j){ // 현재 엇갈린 상태면, 피벗과 교체
                temp = data[j];
                data[j] = data[pivot];
                data[pivot] = temp;
            }else{ // 엇갈리지 않았다면, j와 i 두값을 (큰값과 작은값을) 교체
                temp = data[j];
                data[j] = data[i];
                data[i] = temp;
            }
        }
        // 분할된 이후, 왼쪽과 오른쪽에서 각각 quick 정렬을 수행 (재귀적함수 이용)
        quickSort(data, start, j - 1 );
        quickSort(data, j + 1, end);
    }
}
