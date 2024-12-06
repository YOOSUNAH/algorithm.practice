package book.dfs;

import java.util.Scanner;

public class Num_24_신기한소수 {

    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //  N  자릿수
        // DFS 실행하기 (숫자 2, 3, 5, 7 로 탐색 시작)
        N = sc.nextInt();
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }
    // DFS 구현하기
    private static void DFS(int number, int jarisu) {
        if(jarisu == N){
            if(isPrime(number)){ // 소수면
                System.out.println(number); // 출력
            }
            return; // 아니면 탐색 종료
        }

        for (int i = 1; i < 10; i++) { // 1 ~ 9
            if(i %  2 == 0){
                continue; // 짝수면 더이상 탐색할 필요 없음.
            }
            if(isPrime(number * 10 + i)){ // 소수라면 자릿수 늘리기
                DFS(number * 10 + i , jarisu + 1); // 자릿수 늘려  DFS 실행
            }
        }
    }

    // 소수 구하기
    // 소수 : 1과 자기 자신 외에는 나누어떨어지지 않는 정수
    private static boolean isPrime(int num) {
        // 1이나 0은 소수가 아님
        if(num < 2){
            return false;
        }

        int half = num / 2;  // 약수는 대칭으로 짝을 이룸. 절반만 해도 됨.

        for (int i = 2; i <= half; i++) {
            if (num % i == 0) {
                return false; // 약수가 존재하면(나머지 0이면) 소수 아님
            }
        }
        return true; // 반복문이 끝날 때까지 나누어 떨어지는 수가 없다면, 소수
    }
}
