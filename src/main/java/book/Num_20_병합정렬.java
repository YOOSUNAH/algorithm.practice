package book;

public class Num_20_병합정렬 {

    public static void main(String[] args) {
        int[] array = {7, 6, 5, 8, 3, 5, 9, 1};
        mergeSort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void mergeSort(int[] a, int leftStart, int rightEnd) {
        if (leftStart < rightEnd) {
            int middle = (leftStart + rightEnd) / 2;

            // 왼쪽 부분 정렬
            mergeSort(a, leftStart, middle);
            // 오른쪽 부분 정렬
            mergeSort(a, middle + 1, rightEnd);

            // 병합
            merge(a, leftStart, middle, rightEnd);
        }
    }

    public static void merge(int[] a, int leftStart, int middle, int rightEnd) {
        int number = rightEnd - leftStart + 1;
        int[] sorted = new int[number];

        int i = leftStart;
        int j = middle + 1;
        int k = 0;

        // 작은 순서대로 배열에 삽입
        while (i <= middle && j <= rightEnd) {
            if (a[i] <= a[j]) {
                sorted[k] = a[i];
                i++;
            } else {
                sorted[k] = a[j];
                j++;
            }
            k++;
        }

        // 왼쪽 배열에 남은 요소 삽입
        while (i <= middle) {
            sorted[k] = a[i];
            i++;
            k++;
        }

        // 오른쪽 배열에 남은 요소 삽입
        while (j <= rightEnd) {
            sorted[k] = a[j];
            j++;
            k++;
        }

        // 정렬된 배열을 원본 배열에 복사
        for (int t = 0; t < sorted.length; t++) {
            a[leftStart + t] = sorted[t];
        }
    }
}
