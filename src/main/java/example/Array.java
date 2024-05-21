package example;

import java.util.Scanner;

public class Array {

        private int n;
        private int[] arr;

        public Array(int size) {
            this.n = size;
            this.arr = new int[size];
        }

        public int at(int index) {
            if (index >= 0 && index < n) {
                return arr[index];
            } else {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
        }

        public void set(int idx, int x) {
            if (idx >= 0 && idx < n) {
                arr[idx] = x;
            } else {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
        }

        public void add(int idx, int num) {
            if (idx >= 0 && idx < n) {
                arr[idx] += num;
            } else {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
        }


    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = 10000;       // 배열 사이즈
            Array arr = new Array(N);

            int line;	        // 명령어의 수
            line = sc.nextInt();
            sc.nextLine();       // 개행 문자 처리

            while (line-- > 0) {
                String str;	    // 입력받는 문자열
                int index, num;	// 입력받는 매개변수

                str = sc.next();
                if (str.equals("at")) {
                    index = sc.nextInt();
                    try {
                        int value = arr.at(index);
                        System.out.println(value);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else if (str.equals("set")) {
                    index = sc.nextInt();
                    num = sc.nextInt();
                    try {
                        arr.set(index, num);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else if (str.equals("add")) {
                    index = sc.nextInt();
                    num = sc.nextInt();
                    try {
                        arr.add(index, num);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                sc.nextLine(); // 다음 명령어 입력을 위해 개행 문자 처리
            }

            sc.close();
        }
    }

}
