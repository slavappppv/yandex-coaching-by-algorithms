package third;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String filePath = "input.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line = reader.readLine();
            boolean check = true;
            Stack<Character> openBrackets = new Stack<>();
            for (int i = 0; i < line.length(); ++i) {
                char bracket = line.charAt(i);
                if (bracket == '{' || bracket == '(' || bracket == '[') {
                    openBrackets.push(bracket);
                } else if (openBrackets.isEmpty()) {
                    check = false;
                    break;
                } else {
                    if (bracket == ')' && openBrackets.peek() == '(') {
                        openBrackets.pop();
                    } else if (bracket == ']' && openBrackets.peek() == '[') {
                        openBrackets.pop();
                    } else if (bracket == '}' && openBrackets.peek() == '{') {
                        openBrackets.pop();
                    } else {
                        check = false;
                        break;
                    }
                }
            }
            if (openBrackets.isEmpty() == false) {
                check = false;
            }
            if (check) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
