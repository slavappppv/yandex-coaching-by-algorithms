package thirdweek;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class CountPostfix {
    public static void countPostfix() {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String[] elements = reader.readLine().split(" ");
            ArrayDeque<Integer> stackOfOperands = new ArrayDeque<>();
            for (String elem : elements) {
                if (isNumeric(elem)) {
                    stackOfOperands.push(Integer.parseInt(elem));
                } else {
                    int rightOperand = stackOfOperands.pop();
                    int leftOperand = stackOfOperands.pop();
                    switch (elem) {
                        case "+":
                            stackOfOperands.push(leftOperand + rightOperand);
                            break;
                        case "-":
                            stackOfOperands.push(leftOperand - rightOperand);
                            break;
                        case "*":
                            stackOfOperands.push(leftOperand * rightOperand);
                            break;
                    }
                }
            }
            System.out.println(stackOfOperands.pop());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
