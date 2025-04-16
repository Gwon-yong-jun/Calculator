package Calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, Calculator!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("첫번째 숫자 입력 exit 입력시 종료); ");
            String input = scanner.next();

            if (input.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            int num1 = Integer.parseInt(input);

            System.out.println("연산자 입력하세요.");
            char operator = scanner.next().charAt(0);

            System.out.print("두번째 숫자 입력하세요.");
            int num2 = scanner.nextInt();

            switch (operator) {
                case '+':
                    System.out.println("결과: " + (num1 + num2));
                    break;
                case '-':
                    System.out.println("결과: " + (num1 - num2));
                    break;
                case '*':
                    System.out.println("결과: " + (num1 * num2));
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                    } else {
                        System.out.println("결과: " + ((double) num1 / num2));
                    }
                    break;
                default:
                    System.out.println("올바른 연산자를 입력하세요.");
            }
        }
        scanner.close();
    }
}
