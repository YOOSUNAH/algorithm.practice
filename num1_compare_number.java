
/*
* 문제
* 첫째 줄에 다음 세 가지 중 하나를 출력한다.

A가 B보다 큰 경우에는 '>'를 출력한다.
A가 B보다 작은 경우에는 '<'를 출력한다.
A와 B가 같은 경우에는 '=='를 출력한다.
* */
import java.util.Scanner;

public class num1_compare_number {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();

        in.close();  //Scanner 객체의 리소스를 해제하는 메서드

        if (A > B)
            System.out.println(">");
        else if (A < B)
            System.out.println("<");
        else
            System.out.println("==");
    }

}
// 다른 풀이 _ 삼항연산자를 사용한 풀이
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int A = in.nextInt();
//        int B = in.nextInt();
//
//        in.close();
//
//        String str = (A>B) ? ">" : ((A<B) ? "<" : "==" );
//        System.out.println(str);
//    }
//}