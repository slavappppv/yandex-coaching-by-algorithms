package third;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String filePath = "data.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Обрабатываем возможные ошибки
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
