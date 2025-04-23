package calculator.one;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result;


        while (true) {
            int num1 = 0;
            boolean First = false;
            while (!First) {
                System.out.print("첫번째 숫자 입력: ");
                try {
                    num1 = scanner.nextInt();
                    First = true;
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력하세요.");
                    scanner.nextLine();
                }
            }

            char operator = ' ';
            boolean Operator = false;
            while (!Operator) {
                System.out.print("연산자 입력 (+, -, *, /): ");
                operator = scanner.next().charAt(0);

                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    Operator = true;
                } else {
                    System.out.println("잘못된 연산자입니다. 다시 입력하세요.");
                }
            }

            int num2 = 0;
            boolean Second = false;
            while (!Second) {
                System.out.print("두번째 숫자 입력: ");
                try {
                    num2 = scanner.nextInt();
                    if (operator == '/' && num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요.");
                        continue;
                    }
                    Second = true;
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력하세요.");
                    scanner.nextLine();
                }
            }

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = (double) num1 / num2;
                    break;
                default:
                    System.out.println("잘못된 연산자입니다.");
                    continue;
            }


            if (operator == '/') {
                System.out.println("결과: " + result);
            } else {
                System.out.println("결과: " + (int) result);
            }

            System.out.print("계속 하시겠습니까? (exit 입력 시 종료): ");
            String exit = scanner.next();

            if (exit.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }

        scanner.close();
    }
}
