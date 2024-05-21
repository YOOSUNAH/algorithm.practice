package algorithm;

import java.util.Scanner;

public class Array2_hard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine(); // 줄바꿈 문자 제거

        for (int m = 0; m < M; m++) {
            int N = sc.nextInt();
            sc.nextLine(); // 줄바꿈 문자 제거
            int[] array = new int[N];

            for (int i = 0; i < N; i++) {
                array[i] = sc.nextInt();
            }

            int[] totalAmount = total(array);
            int[] averageList = average(array, totalAmount);
            for (int i = 0; i < totalAmount.length; i++) {
                System.out.print(totalAmount[i] + " ");
            }

            System.out.println();

            for (int i = 0; i < averageList.length; i++) {
                System.out.print(averageList[i] + " ");
            }

        }
        sc.close();
    }

    private static int[] total(int[] array) {
        int[] answer = new int[3];
        for (int i = 0; i < array.length; i++) {
            if (i % 3 == 0) {
                answer[0] += array[i];
            } else if (i % 3 == 1) {
                answer[1] += array[i];
            } else if (i % 3 == 2) {
                answer[2] += array[i];
            }
        }
        return answer;
    }

    private static int[] average(int[] array, int[] total) {
        int[] answer = new int[3];
        int[] count = {0, 0, 0};

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                if (i % 3 == 0) {
                    count[0]++;
                } else if (i % 3 == 1) {
                    count[1]++;
                } else if (i % 3 == 2) {
                    count[2]++;
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
         if(count[i] != 0){
             answer[i] = total[i] / count[i];
         }
        }
        return answer;
    }
}


