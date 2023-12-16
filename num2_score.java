
/*
* 문제
*

시험 점수를 입력받아
* 90 ~ 100점은 A,
* 80 ~ 89점은 B,
* 70 ~ 79점은 C,
* 60 ~ 69점은 D,
* 나머지 점수는 F를 출력하는 프로그램을 작성하시오.

* */
import java.util.Scanner;

public class num2_score {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int score = in.nextInt();
        in.close();  //Scanner 객체의 리소스를 해제하는 메서드

        if (score >= 90 & score <= 100)
            System.out.println("A");
        else if (score >= 80 & score <= 89)
            System.out.println("B");
        else if (score >= 70 & score <= 79)
            System.out.println("C");
        else if (score >= 60 & score <= 69)
            System.out.println("D");
        else System.out.println("F");
    }
}
// 다른 풀이 삼항연산자를 이용한 풀이
// System.out.print((score>=90)?"A": (score>=80)? "B": (score>=70)? "C": (score>=60)? "D": "F");