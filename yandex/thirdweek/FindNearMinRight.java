package thirdweek;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class FindNearMinRight {
    public static void findNearMinRight() {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            int countOfCities = Integer.parseInt(reader.readLine());
            ArrayDeque<int[]> citiesInSearch = new ArrayDeque<>();
            int[] resultsOfRelocation = new int[countOfCities];
            String[] costs = reader.readLine().split(" ");
            for (int i = 0; i < countOfCities; ++i) {
                int[] pair = new int[2];
                pair[0] = Integer.parseInt(costs[i]);
                pair[1] = i;
                while (!(citiesInSearch.isEmpty()) && citiesInSearch.peek()[0] > pair[0]) {
                    resultsOfRelocation[citiesInSearch.peek()[1]] = i;
                    citiesInSearch.pop();
                }
                citiesInSearch.push(pair);
            }
            for (int i = 0; i < resultsOfRelocation.length; ++i) {
                if (resultsOfRelocation[i] == 0) {
                    System.out.print("-1 ");
                } else {
                    System.out.print(resultsOfRelocation[i] + " ");
                }
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
