package Calculator.one;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;

        while (true) {
            int num1 = 0;
            while (true) {
                System.out.print("첫번째 숫자 입력: ");
                try {
                    num1 = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력하세요.");
                    scanner.nextLine(); // 입력 버퍼 비우기
                }
            }

            char operator;
            while (true) {
                System.out.print("연산자 입력 (+, -, *, /): ");
                operator = scanner.next().charAt(0);
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    break;
                } else {
                    System.out.println("잘못된 연산자입니다. 다시 입력하세요.");
                }
            }

            int num2 = 0;
            while (true) {
                System.out.print("두번째 숫자 입력: ");
                try {
                    num2 = scanner.nextInt();
                    if (operator == '/' && num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력하세요.");
                    scanner.nextLine(); // 입력 버퍼 비우기
                }
            }

            switch (operator) {
                case '+': result = num1 + num2;
                break;
                case '-': result = num1 - num2;
                break;
                case '*': result = num1 * num2;
                break;
                case '/': result = num1 / num2;
                break;
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
