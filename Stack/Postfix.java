/**
 * POSTFIX EVALUATION
 */

public class Postfix {

    public static double evaluate(String postfix) {
        Stack<Double> stack = new Stack<>();

        String[] pf = postfix.split(" ");

        for (String token : pf) {
            if (isNumeric(token))
                stack.push(Double.parseDouble(token));
            else if (isOperator(token)) {
                double result = compute(stack.pop(), stack.pop(), token);
                stack.push(result);
            }
        }

        return stack.peek();
    }

    private static boolean isOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("^");
    }

    private static boolean isNumeric(String num) {
        try {
            Double.parseDouble(num);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static double compute(double num1, double num2, String sym) {
        double result;

        switch (sym) {
        case "+" -> result = num1 + num2;
        case "-" -> result = num1 - num2;
        case "*" -> result = num1 * num2;
        case "/" -> result = num1 / num2;
        case "^" -> result = Math.pow(num1, num2);
        default -> result = 0;
        }
        return result;
    }
}
