package thirdweek;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TimeWaiting {
    public static void checkTimeWaiting() {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String[] param = reader.readLine().split(" ");
            String[] nums = reader.readLine().split(" ");
            long waiters = 0;
            long res = 0;
            for (int i = 0; i < Integer.parseInt(param[0]); ++i) {
                waiters += Long.parseLong(nums[i]);
                res += waiters;
                waiters -= Integer.parseInt(param[1]);
                if (waiters < 0) {
                    waiters = 0;
                }
            }
            res += waiters;
            System.out.println(res);

        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
