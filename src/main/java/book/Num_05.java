//package book;
//
//import java.io.IOException;
//import java.util.Scanner;
//
//public class Num_05 {
//
//    public static void main(String[] args) throws IOException {
//        // N = 5
//        // M = 3
//        // S = 1 2 3 1 2
//        // 나머지 = 1 0 0 1 0
//        //
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        long[] S = new long[N];
//
//        long[] C = new long[M]; // 나머지 배열 C
//        // 배열 C는 나머지 값을 인덱스로 사용하여, 해당 나머지를 가지는 부분 구간의 합의 개수를 기록합니다.
//        // 예를 들어, C[0]은 나머지가 0인 부분 구간의 합의 개수를 나타냅니다.
//
//        long answer = 0;
//
//        // 부분 합 배열 S 구하기
//        S[0] = sc.nextLong();
//        for (int i = 1; i < N; i++) {
//            S[i] = S[i - 1] + sc.nextLong();
//        }
//
//        // 부분 합 배열 S를 M으로 나눈 나머지를 나머지 배열 C에 저장하고, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 경우 count
//        for (int i = 0; i < N; i++) {
//            int remainder = (int) (S[i] % M);
//            if (remainder == 0) { // 현재 부분 구간의 합이 M으로 나누어 떨어지는 경우
//                answer++; // 단일 원소인 경우
//            }
//            // remainder 가 0일때도 같이 실행, 아닐때는 이것만 실행
//            //
//            answer += C[remainder];
//            C[remainder]++; // 나머지 배열 C 업데이트
//        }
//
//        System.out.println(answer);
//    }
//}
//
//public static void main(String[] args) {
//        public static void main(String[] args) throws IOException {
//            Scanner sc = new Scanner(System.in);
//            int N = sc.nextInt();
//            int M = sc.nextInt();
//            long answer = 0;
//            long[] C = new long[M];
//            C[0] = 1; // 나머지가 0인 경우를 위해 초기값 설정
//            long sum = 0;
//
//            for (int i = 0; i < N; i++) {
//                sum += sc.nextInt();
//                int remainder = (int) (sum % M);
//                C[remainder]++;
//            }
//
//            for (int i = 0; i < M; i++) {
//                if (C[i] > 1) {
//                    answer += C[i] * (C[i] - 1) / 2;
//                }
//            }
//
//            System.out.println(answer);
//        }
//    }
//}
////런타임 에러
////public static void main(String[] args) {
////    public static void main(String[] args) throws IOException {
////        Scanner sc = new Scanner(System.in);
////        int N = sc.nextInt();
////        int M = sc.nextInt();
////        long[] S = new long[N];
////        long[] C = new long[M];
////        long answer = 0;
////
////        S[0] = sc.nextLong();
////
////        for (int i = 1; i < N; i++) {
////            S[i] = S[i - 1] + sc.nextLong();
////        }
////
////        for (int i = 0; i < N; i++) {
////            int remainder = (int) S[i] % M;
////            if (remainder == 0) {
////                answer++;
////            }
////            C[remainder]++;
////        }
////
////        for (int i = 0; i < M; i++) {
////            if (C[i] > 1) {
////                answer = answer + (C[i] * (C[i] - 1) / 2);
////            }
////        }
////        System.out.println(answer);
////    }
//
////}
