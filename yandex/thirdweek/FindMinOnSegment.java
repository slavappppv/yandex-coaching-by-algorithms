package thirdweek;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class FindMinOnSegment {
    public static void findMinOnSegment() {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String[] lens = reader.readLine().split(" ");
            ArrayDeque<Integer> dequeOfNums = new ArrayDeque<>();
            String[] nums = reader.readLine().split(" ");
            for (int i = 0; i < Integer.parseInt(lens[0]); ++i) {
                if (dequeOfNums.isEmpty()) {
                    dequeOfNums.addFirst(Integer.parseInt(nums[i]));
                }
                else {
                    while (!(dequeOfNums.isEmpty()) && (Integer.parseInt(nums[i]) < dequeOfNums.getFirst())) {
                        dequeOfNums.pop();
                    }
                    dequeOfNums.addFirst(Integer.parseInt(nums[i]));
                }
                if (i >= (Integer.parseInt(lens[1]) - 1)) {
                    System.out.println(dequeOfNums.getLast());
                    if (dequeOfNums.getLast() == Integer.parseInt(nums[i - (Integer.parseInt(lens[1]) - 1)])) {
                        dequeOfNums.removeLast();
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
