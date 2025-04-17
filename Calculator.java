package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Hello, Calculator!");
        int result = 0;

        while (true) {
            int num1 = getFirst("첫번째 숫자 입력: ");
            char operator = getOperator();
            int num2 = getSecond(operator);

            result = calculate(num1, num2, operator);
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

    private int getFirst(String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력하세요.");
                scanner.nextLine();
            }
        }
    }

    private char getOperator() {
        while (true) {
            System.out.print("연산자 입력 (+, -, *, /): ");
            char op = scanner.next().charAt(0);
            if (op == '+' || op == '-' || op == '*' || op == '/') {
                return op;
            } else {
                System.out.println("잘못된 연산자입니다. 다시 입력하세요.");
            }
        }
    }

    private int getSecond(char operator) {
        while (true) {
            int num = getFirst("두번째 숫자 입력: ");
            if (operator == '/' && num == 0) {
                System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요.");
            } else {
                return num;
            }
        }
    }

    private int calculate(int num1, int num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0;
        };
    }
}