import java.util.*;

public class PolishNotation {

    // Method that parses a string containing polish notation and returns the result of the String notation as a double.
    public double polishNotation(String expression) {
        // parse the String using spaces as splits
        String[] expressionArray = expression.split("\\s+");
        // Initialise the deque that the numbers will be held in and initialise the result variable.
        Deque<Double> notationDeque = new ArrayDeque<>();
        double result = 1.0;

        // Check to see if input is only one number and return that number if true.
        if (expressionArray.length == 1) {
            result = Double.parseDouble(expressionArray[0]);
        // Start looping through the array adding numbers to the deque, if an operator appears then it is run through a
        // switch statement in order to operate on the corresponding numbers, then the result is added back into the deque.
        // The operators are caught by failing to parse as a double in the try catch block.
        } else {
            for (int i = expressionArray.length - 1; i >= 0; i--) {
                try {
                    double num = Double.parseDouble(expressionArray[i]);
                    notationDeque.addFirst(Double.parseDouble(expressionArray[i]));
                } catch (NumberFormatException e) {
                    switch (expressionArray[i]) {
                        case "+":
                            result = notationDeque.removeFirst() + notationDeque.removeFirst();
                            notationDeque.addFirst(result);
                            break;
                        case "-":
                            result = notationDeque.removeFirst() - notationDeque.removeFirst();
                            notationDeque.addFirst(result);
                            break;
                        case "*":
                            result = notationDeque.removeFirst() * notationDeque.removeFirst();
                            notationDeque.addFirst(result);
                            break;
                        case "/":
                            result = notationDeque.removeFirst() / notationDeque.removeFirst();
                            notationDeque.addFirst(result);
                            break;
                    }
                }
            }
        }
        return Math.round(result * 100.00) / 100.00;
    };

        public static void main (String[]args){
            PolishNotation t = new PolishNotation();
        }
}
