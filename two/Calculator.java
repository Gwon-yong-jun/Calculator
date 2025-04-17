package calculator.two;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static List<String> history = new ArrayList<>();

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


        String formattedResult = (result % 1 == 0)
                ? String.valueOf((int) result)
                : String.format("%.2f", result);


        String record = num1 + " " + operator + " " + num2 + " = " + formattedResult;
        history.add(record);

        return result;
    }

    public static List<String> getHistory() {
        return new ArrayList<>(history); // 외부에서 변경 못하도록 복사본 반환
    }

    public static void removeOldest() {
        if (!history.isEmpty()) {
            history.remove(0);
        }
    }

    public static void clearHistory() {
        history.clear();
    }
}
