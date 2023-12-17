
/*
* 문제
*

연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력하는 프로그램을 작성하시오.
윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.
예를 들어, 2012년은 4의 배수이면서 100의 배수가 아니라서 윤년이다.
* 1900년은 100의 배수이고 400의 배수는 아니기 때문에 윤년이 아니다.
* 하지만, 2000년은 400의 배수이기 때문에 윤년이다.
* */
import java.util.Scanner;

public class num3_year {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        in.close();  //Scanner 객체의 리소스를 해제하는 메서드

        if (year % 4 == 0) {
            //: 4의 배수이면서 400의 배수일 경우
            if (year % 400 == 0) System.out.println("1");
            //4의 배수이면서 100의 배수일 경우
            else if (year % 100 == 0) System.out.println("0");
            // 나머지 경우
            else System.out.println("1");
        }
        else System.out.println("0");
    }
}
// 다른 풀이 삼항연산자를 이용한 풀이
// System.out.print((year% 4 == 0) ? ((year % 400 == 0 ? "1": ( year % 100 == 0 ? "0":"1"))) : "0");
