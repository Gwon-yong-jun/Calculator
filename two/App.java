package calculator.two;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int num1 = 0;
            int num2 = 0;
            char operator = ' ';
            double result;

            System.out.print("첫번째 숫자 입력: ");
            try {
                num1 = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력하세요.");
                scanner.nextLine();
                continue;
            }

            boolean validOperator = false;
            while (!validOperator) {
                System.out.print("연산자 입력 (+, -, *, /): ");
                operator = scanner.next().charAt(0);
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    validOperator = true;
                } else {
                    System.out.println("잘못된 연산자입니다. 다시 입력하세요.");
                }
            }

            boolean validSecond = false;
            while (!validSecond) {
                System.out.print("두번째 숫자 입력: ");
                try {
                    num2 = scanner.nextInt();
                    if (operator == '/' && num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요.");
                    } else {
                        validSecond = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력하세요.");
                    scanner.nextLine();
                }
            }

            try {
                result = Calculator.calculate(num1, num2, operator);
                if (result % 1 == 0) {
                    System.out.println("결과: " + (int) result);
                } else {
                    System.out.printf("결과: %.2f\n", result);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("[계산 기록]");
            for (String record : Calculator.getHistory()) {
                System.out.println(record);
            }

            System.out.print("가장 먼저 저장된 데이터를 삭제할까요? (yes / no): ");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("yes")) {
                Calculator.removeOldest();
                System.out.println("삭제 완료.");
            }

            System.out.print("계속 하시겠습니까? (exit 입력 시 종료): ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            System.out.println();
        }

        scanner.close();
    }
}
