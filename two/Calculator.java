package calculator.two;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private final Scanner scanner;

    public Calculator() {
        this.scanner = new Scanner(System.in); 
    }

    public void start() {
        double result;

        while (true) {
            int num1 = getFirst();
            char operator = getOperator();
            int num2 = getSecond(operator);

            result = calculate(num1, num2, operator);


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

        scanner.close();  // 종료 시 Scanner 객체 닫기
    }


    private int getFirst() {
        while (true) {
            System.out.print("첫번째 숫자 입력: ");
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                scanner.nextLine();
            }
        }
    }


    private char getOperator() {
        while (true) {
            System.out.print("연산자 입력 (+, -, *, /): ");
            char operator = scanner.next().charAt(0);
            if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                return operator;
            } else {
                System.out.println("잘못된 연산자입니다. 다시 입력하세요.");
            }
        }
    }


    private int getSecond(char operator) {
        while (true) {
            System.out.print("두번째 숫자 입력: ");
            try {
                int num2 = scanner.nextInt();
                if (operator == '/' && num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요.");
                    continue;
                }
                return num2;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                scanner.nextLine();
            }
        }
    }

    private double calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return (double) num1 / num2;
            default:
                return 0;
        }
    }
}
