import java.util.Scanner;

// 인덱스가 3으로 나눈 나머지가 0인 금고 : 한국
// 인덱스가 3으로 나눈 나머지가 1인 금고 : 일본
// 인덱스가 3으로 나눈 나머지가 2인 금고 : 중국

//첫 번째 줄에 명령어 조합의 수 M(1 ≤ M ≤ 10,000)이 주어진다.
// 그리고 두 번째 줄부터는 두 줄씩
// 각각 싱가폴 은행의 금고의 크기 N(1 ≤ N ≤ 100 ),
// 0번부터 N − 1번까지 금고에 들어있는 돈의 액수 X (0 ≤ X ≤ 10,000)가 차례로 주어진다.
// 0으로 주어진 금고는 아무도 해당 금고에 돈을 저금하지 않았다는 뜻이다.
public class Array2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine(); // 줄바꿈 문자 제거

        for (int m = 0; m < M ; m++) {
            int N = sc.nextInt();
            sc.nextLine(); // 줄바꿈 문자 제거
            int[] array = new int[N];

            for (int i = 0; i < N; i++) {
                array[i] = sc.nextInt();
            }

            int[] totalAmount = total(array);
            for (int i = 0; i < totalAmount.length; i++) {
                System.out.print(totalAmount[i] + " ");
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
}
