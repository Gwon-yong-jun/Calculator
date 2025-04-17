package calculator.two;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static List history = new ArrayList();

    public static double calculate(int num1, int num2, char operator) {
        double result;

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
                if (num2 == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                result = (double) num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산자입니다.");
        }

        // Format the result to either an integer or a decimal with two places
        String formatted = (result % 1 == 0)
                ? String.valueOf((int) result)
                : String.format("%.2f", result);

        // Record the calculation in history
        history.add(num1 + " " + operator + " " + num2 + " = " + formatted);
        return result;
    }

    public static List getHistory() {
        return history;
    }

    public static void removeOldest() {
        if (!history.isEmpty()) {
            history.remove(0);
        }
    }
}

