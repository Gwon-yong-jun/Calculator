package Calculator;

public class Calculator {

   public double calculate(String operator, int firstNumber, int secondNumber) {


            double result = 0.0;
            try {
                switch (operator) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        if (secondNumber == 0) {
                            throw new ArithmeticException("Cannot divide by zero");
                        }
                        result = (double) firstNumber / secondNumber;
                        break;
                    default:
                        System.out.println("Invalid operator");
                        break;
                }
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero");
            }

            return result;
        }


    }
