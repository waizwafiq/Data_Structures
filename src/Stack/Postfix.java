package Stack;
/**
 * POSTFIX EVALUATION
 */

public class Postfix {

    public static String toPostfix(String infix) {
        Stack<String> operators = new Stack<String>();
        Stack<String> postfix = new Stack<String>(); //the type is String to build the postfix string easier.
        String[] expressions = infix.split(" ");

        for (String exp : expressions) {

            if (exp.equals("("))
                operators.push(exp);
            else if (isNumeric(exp) || isAlphabet(exp.charAt(0)))
                postfix.push(" " + exp + " ");
            else if (exp.equals(")")) {
                while (!operators.peek().equals("(")) {
                    //LOOP WHILE THERE'S NO "(" FOUND
                    String op = operators.pop();

                    String first = postfix.pop();
                    String second = postfix.pop(); //getting the operands (two only)
                    String new_postfix = second + first + op;   //add the two operands in reverse order

                    postfix.push(new_postfix);
                }
                operators.pop();  //to remove "(" from the stack
            } else if (isOperator(exp)) {
                while (operators.size() > 0 && !exp.equals("(") && precedence(exp.charAt(0)) <= precedence(operators.peek().charAt(0))) {
                    String op = operators.pop();

                    String first = postfix.pop(), second = postfix.pop(); //getting the operands (two only)
                    String new_postfix = second + first + op;   //add the two operands in reverse order

                    postfix.push(new_postfix);
                }
                operators.push(exp + " ");
            }
        }

        while (operators.size() > 0) {
            String op = operators.pop();

            String first = postfix.pop(), second = postfix.pop(); //getting the operands (two only)
            String new_postfix = second + first + op;   //add the two operands in reverse order

            postfix.push(new_postfix);
        }
        return postfix.pop().trim().replaceAll("\\s", " ");
    }

    public static double evaluate(String postfix) {
        Stack<Double> stack = new Stack<Double>();

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

    private static int precedence(char c) {
        //2 is more significant than 1
        if (c == '+' || c == '-')
            return 1;
        else if (c == '*' || c == '/')
            return 2;
        else
            return 0;
    }

    private static boolean isNumeric(String num) {
        try {
            Double.parseDouble(num);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static boolean isAlphabet(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static boolean isOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("^");
    }

    private static double compute(double num1, double num2, String sym) {
        double result;

        switch (sym) {
            case "+" -> result = num2 + num1;
            case "-" -> result = num2 - num1;
            case "*" -> result = num2 * num1;
            case "/" -> result = num2 / num1;
            case "^" -> result = Math.pow(num2, num1);
            default -> result = 0;
        }
        return result;
    }
}
