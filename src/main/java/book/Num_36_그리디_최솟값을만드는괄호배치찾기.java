package book;

import java.util.Scanner;
/*
     * 
     * answer(정답 변수)
     * 들어온 데이터를 "-" 기호를 기준으로 split() 수행하기 
     * 
     * for(나눠진 데이터 개수만큼 반복하기 ){
     *   결과값 = mySum() 함수 수행하기 
     *    if( 가장 앞 데이터 일때) answer에 결과값 더하기 
     *    else answer 에 결과값 빼기
     * }
     * 
     * answer 출력하기
     * mySum() 함수 구현하기 {
     *   현재 들어온 String 값을 "+" 기호 기준으로 split() 수행하기
     *   for(나눠진 데이터 개수만큼 반복하기){
     *    String 값을 Integer 형으로 변환해 리턴 값에 더하기
     *  } 
     *  전체 합 리턴하기 
     * }
     */
public class Num_36_그리디_최솟값을만드는괄호배치찾기 {
  
  // v1
  // static int answer = 0;
  // public static void main(String[] args) {
    //   Scanner sc = new Scanner(System.in);
    //   String example = sc.nextLine(); // 100-40+50+74-30+29-45+43+11
    //   String[] str = example.split("-"); 
    //   // 100
    //   // 40+50+74
    //   // 30+29
    //   // 45+43+11 

    //   for (int i = 0; i < str.length; i++) {
        
    //     int temp = mySum(str[i]); // 164
        
    //     if(i == 0){
    //       answer += temp; // 가장 앞에 있는 것 더하기 100
    //     }
    //     else answer -= temp; // 빼기 100 - 164
    //   }

    //   System.out.println(answer);
    // }

    // static int mySum(String a){ //  40+50+74
    //   int sum = 0;
    //   String temp[] = a.split("[+]");  // 40, 50, 74
    //   for (int i = 0; i < temp.length; i++) {
    //     sum += Integer.parseInt(temp[i]);// 40 + 50 + 74
    //   }
    //   return sum;
    // }


  // v2
   static int answer = 0;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String example = sc.nextLine(); // 100-40+50+74-30+29-45+43+11
    String[] str = example.split("-"); 
    // int answer = 0;

    for (int i = 0; i < str.length; i++) {
        int temp = 0;
        String[] tempArr = str[i].split("\\+"); // "+" 기호로 분리
        
        // 각 그룹의 합을 계산
        for (String num : tempArr) {
            temp += Integer.parseInt(num); // 합산
        }

        // 첫 번째 그룹은 더하고, 나머지는 빼기
        if (i == 0) {
            answer += temp; // 가장 앞에 있는 것 더하기
        } else {
            answer -= temp; // 빼기
        }
    }

    System.out.println(answer);
  }
}
