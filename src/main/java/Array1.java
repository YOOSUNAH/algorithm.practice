import java.util.Scanner;

// at(i) : 배열의 인덱스 i에 저장된 양의 정수를 출력. 만약 원소가 없는 인덱스 i값이 주어지면 0을 출력
// set(i, X) : 배열의 인덱스 i에 저장된 양의 정수를 X값으로 덮어씌운다. 만약 원소가 없는 인덱스 i값이 주어지면 0을 출력
// add(i, X) : 배열의 인덱스 i보다 크거나 같은 곳에 저장된 값을 +1 칸씩 이동시키고, 인덱스 i에 양의 정수 X를 삽입.
// 만약 원소가 없는 인덱스 i값이 주어지면, 마지막 원소가 있는 바로 다음 인덱스에 양의 정수 X를 삽입 (원소가 없을 경우 첫 번째 인덱스에 삽입)

public class Array1 {
    private static final int SIZE = 10000;
    private static int[] array = new int[SIZE];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine(); // 줄바꿈 문자 제거

        for (int j = 0; j < SIZE; j++) {
            String command = sc.nextLine();
            String[] parts = command.split(" ");
            String operation = parts[0];

            if (operation.equals("at")) {
                int i = Integer.parseInt(parts[1]);
                System.out.println(at(i));
            } else if (operation.equals("set")) {
                int i = Integer.parseInt(parts[1]);
                int X = Integer.parseInt(parts[2]);
                set(i, X);
            } else if (operation.equals("add")) {
                int i = Integer.parseInt(parts[1]);
                int X = Integer.parseInt(parts[2]);
                add(i, X);
            }
        }
        sc.close();
    }

    private static int at(int i) {
        if (i < 0 || i >= SIZE || array[i] == 0) {
            return 0;
        }
        return array[i];
    }

    private static void set(int i, int X) {
        if (i < 0 || i >= SIZE) {
            return;
        }
        array[i] = X;
    }

    private static void add(int i, int X) {
        // 유효한 인덱스 범위를 벗어난 경우 못함.
        if (i < 0 || i >= SIZE) {
            return;
        }

        // 배열의 끝 찾기
        int j = 0;
        while (j < SIZE && array[j] != 0) {
            j++;
        }
        // 배열이 가득 찬 경우 못함.
        if (j == SIZE) {
            return;
        }

        // 원소가 없을 경우 첫 번째 인덱스에 삽입
        if (i >= j) {
            array[j] = X;
            return;
        }

        // i보다 크거나 같은 인덱스를 뒤로 이동
        for (int idx = j; idx > i; idx--) {
            array[idx] = array[idx - 1];
        }
        array[i] = X;
    }

}



