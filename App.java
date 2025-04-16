package Calculator.one;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result;

        while (true) {
            int num1 = 0;
            boolean validOperator = false;
            char operator = ' ';
            System.out.print("첫번째 숫자 입력: ");
            try {
                num1 = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력하세요.");
                scanner.nextLine();
                continue;
            }


            while (!validOperator) {
                System.out.print("연산자 입력 (+, -, *, /): ");
                operator = scanner.next().charAt(0);

                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    validOperator = true;
                } else {
                    System.out.println("잘못된 연산자입니다. 다시 입력하세요.");
                }
            }


            int num2 = 0;
            System.out.print("두번째 숫자 입력: ");
            try {
                num2 = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력하세요.");
                scanner.nextLine();
                continue;  //
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
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    }
                    break;
                default:
                    System.out.println("잘못된 연산자입니다.");
                    continue;
            }

            System.out.println("결과: " + result);

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
