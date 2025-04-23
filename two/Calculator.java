package calculator.sss;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
     List<String> s = new ArrayList<>();

    public double calculator(int num1, int num2, char operator) {
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
        s.add(record);

        return result;
    }

    public List<String> record() {
        return new ArrayList<>(s);
    }

    public void remove() {
        if (!s.isEmpty()) {
            s.remove(0);
        }
    }
}
