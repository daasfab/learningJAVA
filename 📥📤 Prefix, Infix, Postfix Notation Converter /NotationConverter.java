public class NotationConverter {

    public static void main(String[] args) {
        // Test infix expressions
        String infixExpression1 = "A + B * C";
        String infixExpression2 = "(A + B) * C";
        String infixExpression3 = "A * (B + C) - D / E";

        // Convert and print postfix expressions
        System.out.println("Infix expression: " + infixExpression1);
        System.out.println("Postfix expression: " + Converter(infixExpression1));

        System.out.println("Infix expression: " + infixExpression2);
        System.out.println("Postfix expression: " + Converter(infixExpression2));

        System.out.println("Infix expression: " + infixExpression3);
        System.out.println("Postfix expression: " + Converter(infixExpression3));
    }

    public static ArrayList Converter(String mathExpression) {

        // stores operators passed in from L to R from infix notation expression
        Stack<Character> operatorStack = new Stack<Character>();

        // stores all elem from inputted expression in 1 multi data type array
        char[] inputArray = mathExpression.toCharArray();

        // contains inputted expression in postfix notation
        ArrayList<Character> outputArray = new ArrayList<>();

        // arrays, containing operators of 1 of 3 priority levels
        char[] highestPriority = { '^' };
        char[] mediumPriority = { '/', '*' };
        char[] lowestPriority = { '-', '+' };
        char[] brackets = { '(', ')' };

        for (int i = 0; i < inputArray.length; i++) {
            // 1st check if char is letter
            if (Character.isLetter(inputArray[i]) == true) {
                outputArray.add(inputArray[i]); // if letter then add to output array straight away
            }
            // if char is not a letter
            else {
                // if top of stack is of HIGHEST priority, and current elem isn't a bracket
                if (!operatorStack.isEmpty() && whatPriority(operatorStack.peek(), highestPriority)) {
                    if (!whatPriority(inputArray[i], brackets)) {
                        outputArray.add(operatorStack.peek()); // add top elem to outputArray
                        operatorStack.pop(); // remove top elem from stack
                        operatorStack.push(inputArray[i]); // add current elem to stack
                    } else { // (if current elem is a bracket)
                        operatorStack.push(inputArray[i]);
                    }
                }
                // if top of stack is of MEDIUM priority
                if (!operatorStack.isEmpty() && whatPriority(operatorStack.peek(), mediumPriority)) {
                    // if current elem is lowest priority
                    if (whatPriority(inputArray[i], lowestPriority)) {
                        // do same thing as in if statement above
                        outputArray.add(operatorStack.peek());
                        operatorStack.pop();
                        operatorStack.push(inputArray[i]);
                    } else { // (meaning its either a higher priority or a bracket)
                        operatorStack.push(inputArray[i]);
                    }
                }
                // if current elem is a closing bracket
                if (inputArray[i] == ')') {
                    // pop all operators from stack and add them to outputArray until '(' is found
                    while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                        outputArray.add(operatorStack.pop());
                    }
                    // now remove the opening bracket
                    if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                        operatorStack.pop();
                    }
                }
                // if its an opening bracket or operator of lowest priority
                else {
                    operatorStack.push(inputArray[i]);
                }

            }
        }

        return outputArray;
    }

    public static boolean whatPriority(char charToCheck, char[] arrayInQuestion) {
        boolean isHP = false;

        for (int i = 0; i < arrayInQuestion.length; i++) {
            if (arrayInQuestion[i] == charToCheck) {
                isHP = true;
                break; // breaks the loop when the elem is found in the array
            }
        }

        return isHP;
    }

}
